package com.tencent.luggage.wxa.rb;

public class g
{
  public String a;
  public int b;
  public e c;
  public Object d;
  
  public g()
  {
    this.a = null;
    this.c = null;
    this.b = -1;
    this.d = null;
  }
  
  public g(String paramString)
  {
    this.a = paramString;
    this.c = null;
    this.b = -1;
    this.d = null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MStorageEventData [event=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", eventId=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", stg=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", obj=");
    localStringBuilder.append(this.d);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rb.g
 * JD-Core Version:    0.7.0.1
 */