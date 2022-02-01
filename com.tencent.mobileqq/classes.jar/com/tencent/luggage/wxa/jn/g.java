package com.tencent.luggage.wxa.jn;

public class g
  extends e
{
  public g(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    paramString1 = new StringBuilder();
    paramString1.append("\"");
    paramString1.append(paramString2);
    paramString1.append("#");
    paramString1.append(this.b);
    paramString1.append("\"");
    a("SOAPACTION", paramString1.toString());
    c();
  }
  
  private String b(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<u:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" xmlns:u=\"");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\">\n <InstanceID>");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("</InstanceID>\n <Speed>");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("</Speed>\n</u:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(">\n");
    return localStringBuilder.toString();
  }
  
  public String a()
  {
    return "Play";
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><s:Envelope s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body>");
    localStringBuilder.append(b(paramInt1, paramInt2));
    localStringBuilder.append("</s:Body></s:Envelope>");
    return localStringBuilder.toString();
  }
  
  public String b()
  {
    return a(0, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jn.g
 * JD-Core Version:    0.7.0.1
 */