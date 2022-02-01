package com.tencent.luggage.wxa.jn;

public class k
  extends e
{
  private int f;
  
  public k(String paramString1, String paramString2, int paramInt)
  {
    super(paramString1, paramString2);
    this.f = paramInt;
    paramString1 = new StringBuilder();
    paramString1.append("\"");
    paramString1.append(paramString2);
    paramString1.append("#");
    paramString1.append(this.b);
    paramString1.append("\"");
    a("SOAPACTION", paramString1.toString());
  }
  
  private String b(int paramInt1, String paramString, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<u:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" xmlns:u=\"");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\">\n<InstanceID>");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("</InstanceID>\n<Channel>");
    localStringBuilder.append(paramString);
    localStringBuilder.append("</Channel>\n<DesiredVolume>");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("</DesiredVolume>\n</u:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(">\n");
    return localStringBuilder.toString();
  }
  
  public String a()
  {
    return "SetVolume";
  }
  
  public String a(int paramInt1, String paramString, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><s:Envelope s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body>");
    localStringBuilder.append(b(paramInt1, paramString, paramInt2));
    localStringBuilder.append("</s:Body></s:Envelope>");
    return localStringBuilder.toString();
  }
  
  public String b()
  {
    return a(0, "Master", this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jn.k
 * JD-Core Version:    0.7.0.1
 */