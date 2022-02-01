package com.tencent.luggage.wxa.jn;

public class h
  implements d
{
  private boolean a;
  
  public h(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public String a(String paramString)
  {
    return a(paramString, "239.255.255.250");
  }
  
  public String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("M-SEARCH * HTTP/1.1\r\nST:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("\r\nHOST: ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(":1900\r\nMX: 3\r\nMAN: \"ssdp:discover\"\r\n\r\n");
    return localStringBuilder.toString();
  }
  
  public String b()
  {
    if (this.a) {
      return b("ssdp:all");
    }
    return a("ssdp:all");
  }
  
  public String b(String paramString)
  {
    return a(paramString, "[FF0x::C]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jn.h
 * JD-Core Version:    0.7.0.1
 */