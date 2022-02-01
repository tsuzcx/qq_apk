package com.tencent.luggage.wxa.ku;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class e$a
{
  static final Map<String, e> a = new HashMap();
  
  static
  {
    a.put("ascii", new e.a.1());
    a.put("base64", new e.a.2());
    a.put("hex", new e.a.3());
    Object localObject = new e.a.4(Charset.forName("ISO-10646-UCS-2"));
    a.put("ucs2", localObject);
    a.put("ucs-2", localObject);
    localObject = new e.a.5(Charset.forName("UTF-16LE"));
    a.put("utf16le", localObject);
    a.put("utf-16le", localObject);
    localObject = new e.a.6();
    a.put("utf8", localObject);
    a.put("utf-8", localObject);
    localObject = new e.a.7();
    a.put("latin1", localObject);
    a.put("binary", localObject);
  }
  
  static void a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.e.a
 * JD-Core Version:    0.7.0.1
 */