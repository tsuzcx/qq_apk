package com.tencent.luggage.wxa.sb;

import androidx.annotation.NonNull;

public class a$b
{
  public String a;
  long b;
  long c;
  String d;
  long e;
  float f;
  
  public a$b(@NonNull String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    this.a = paramString1;
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = paramString2;
    float f1 = 1.0F;
    if (paramLong2 > 1L) {
      f1 = (float)paramLong1 * 1.0F / (float)paramLong2;
    }
    this.f = f1;
    this.e = System.currentTimeMillis();
  }
  
  public boolean equals(Object paramObject)
  {
    return this.a.equals(paramObject);
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sb.a.b
 * JD-Core Version:    0.7.0.1
 */