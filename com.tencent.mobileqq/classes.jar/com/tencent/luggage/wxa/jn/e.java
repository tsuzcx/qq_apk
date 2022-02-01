package com.tencent.luggage.wxa.jn;

import java.util.HashMap;
import java.util.Map;

public abstract class e
  implements d
{
  protected e.a a;
  protected String b;
  protected String c;
  protected String d;
  protected Map<String, String> e = new HashMap();
  
  public e(String paramString1, String paramString2)
  {
    this.c = paramString1;
    this.d = paramString2;
    this.b = a();
    a(e.a.b);
  }
  
  public abstract String a();
  
  protected void a(e.a parama)
  {
    this.a = parama;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.e.put(paramString1, paramString2);
  }
  
  protected void c()
  {
    a("Content-Type", "text/xml;charset=\"utf-8\"");
    a("Connection", "close");
  }
  
  public e.a d()
  {
    return this.a;
  }
  
  public Map<String, String> e()
  {
    return this.e;
  }
  
  public String f()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jn.e
 * JD-Core Version:    0.7.0.1
 */