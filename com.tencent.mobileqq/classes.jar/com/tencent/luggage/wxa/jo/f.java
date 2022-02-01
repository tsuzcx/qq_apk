package com.tencent.luggage.wxa.jo;

public class f
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("serviceType=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\nserviceId=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\nSCPDUrl=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\ncontrolURl=");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\neventSubURl=");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jo.f
 * JD-Core Version:    0.7.0.1
 */