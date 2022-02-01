package com.tencent.luggage.wxa.jn;

public class i
  extends e
{
  private String f;
  
  public i(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString2);
    this.f = paramString3;
    paramString1 = new StringBuilder();
    paramString1.append("\"");
    paramString1.append(paramString2);
    paramString1.append("#");
    paramString1.append(this.b);
    paramString1.append("\"");
    a("SOAPACTION", paramString1.toString());
    c();
  }
  
  private String b(int paramInt, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<u:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" xmlns:u=\"");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\">\n <InstanceID>");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("</InstanceID>\n <Unit>");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("</Unit>\n <Target>");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("</Target>\n</u:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(">\n");
    return localStringBuilder.toString();
  }
  
  public String a()
  {
    return "Seek";
  }
  
  public String a(int paramInt, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><s:Envelope s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body>");
    localStringBuilder.append(b(paramInt, paramString1, paramString2));
    localStringBuilder.append("</s:Body></s:Envelope>");
    return localStringBuilder.toString();
  }
  
  public String b()
  {
    return a(0, "REL_TIME", this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jn.i
 * JD-Core Version:    0.7.0.1
 */