package com.tencent.luggage.wxa.gl;

public class h
  extends Number
{
  private int a = 0;
  
  public h(int paramInt)
  {
    this.a = paramInt;
  }
  
  public h(long paramLong)
  {
    this.a = ((int)(paramLong & 0xFFFFFFFF));
  }
  
  public static String a(int paramInt)
  {
    return new h(paramInt).toString();
  }
  
  public int a()
  {
    return this.a;
  }
  
  public double doubleValue()
  {
    double d = this.a | 0L;
    Double.isNaN(d);
    return d + 0.0D;
  }
  
  public float floatValue()
  {
    double d = this.a | 0L;
    Double.isNaN(d);
    return (float)(d + 0.0D);
  }
  
  public int intValue()
  {
    return this.a;
  }
  
  public long longValue()
  {
    return this.a & 0xFFFFFFFF;
  }
  
  public String toString()
  {
    long l = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(l & 0xFFFFFFFF);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gl.h
 * JD-Core Version:    0.7.0.1
 */