package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05401")
public class BenchmarkTest05401 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;
		
		
		// Chain a bunch of propagators in sequence
		String a24659 = param; //assign
		StringBuilder b24659 = new StringBuilder(a24659);  // stick in stringbuilder
		b24659.append(" SafeStuff"); // append some safe content
		b24659.replace(b24659.length()-"Chars".length(),b24659.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map24659 = new java.util.HashMap<String,Object>();
		map24659.put("key24659", b24659.toString()); // put in a collection
		String c24659 = (String)map24659.get("key24659"); // get it back out
		String d24659 = c24659.substring(0,c24659.length()-1); // extract most of it
		String e24659 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d24659.getBytes() ) )); // B64 encode and decode it
		String f24659 = e24659.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f24659); // reflection
		
		
		try {
			javax.naming.directory.DirContext dc = org.owasp.webgoat.benchmark.helpers.Utils.getDirContext();
			Object[] filterArgs = {"a","b"};
			dc.search("name", bar, filterArgs, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}
}