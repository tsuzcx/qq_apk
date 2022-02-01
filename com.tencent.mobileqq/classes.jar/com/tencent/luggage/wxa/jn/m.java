package com.tencent.luggage.wxa.jn;

public class m
  extends e
{
  public m(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, 10800);
  }
  
  public m(String paramString1, String paramString2, int paramInt)
  {
    super(paramString1, "");
    a(e.a.e);
    a("Nt", "upnp:event");
    paramString1 = new StringBuilder();
    paramString1.append("Second-");
    paramString1.append(paramInt);
    a("Timeout", paramString1.toString());
    paramString1 = new StringBuilder();
    paramString1.append("<");
    paramString1.append(paramString2);
    paramString1.append(">");
    a("Callback", paramString1.toString());
  }
  
  public String a()
  {
    return "SUBSCRIBE";
  }
  
  public String b()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jn.m
 * JD-Core Version:    0.7.0.1
 */