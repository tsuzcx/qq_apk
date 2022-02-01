package com.tencent.luggage.wxa.sb;

import java.util.concurrent.ConcurrentLinkedQueue;

public class a$a
{
  String a;
  long b = 0L;
  long c = 0L;
  private float d = 0.0F;
  private float e = 0.0F;
  private float f = 0.0F;
  private float g = 0.0F;
  private float h = 1.0F;
  private float i = 0.0F;
  private ConcurrentLinkedQueue<a.b> j = new ConcurrentLinkedQueue();
  
  public a$a(String paramString)
  {
    this.a = paramString;
  }
  
  public a$a(String paramString, float paramFloat, long paramLong)
  {
    this.a = paramString;
    this.e = paramFloat;
    this.b = paramLong;
  }
  
  private int c()
  {
    return this.j.size();
  }
  
  public String a()
  {
    return this.a;
  }
  
  void a(a.b paramb)
  {
    this.j.add(paramb);
    this.f += (float)paramb.b;
    this.g += (float)paramb.c;
    int n = c();
    float f1 = this.h;
    float f2 = paramb.f;
    int m = 0;
    int k;
    if (f1 > f2)
    {
      if (n <= 5000) {
        k = 1;
      } else {
        k = 0;
      }
      if (k == 0) {
        this.d += this.h;
      }
      this.h = paramb.f;
    }
    else
    {
      k = 1;
    }
    if (this.i < paramb.f)
    {
      if (n <= 5000) {
        k = 1;
      } else {
        k = 0;
      }
      if (k == 0) {
        this.d += this.i;
      }
      this.i = paramb.f;
    }
    if (k != 0) {
      this.d += paramb.f;
    }
    if (n <= 5000) {
      k = m;
    } else {
      k = 2;
    }
    this.e = (this.d / (n - k));
    f1 = this.f;
    f2 = n;
    this.b = ((f1 * 1.0F / f2));
    this.c = ((this.g * 1.0F / f2));
  }
  
  boolean b()
  {
    return (this.b >= 5000L) || (this.e >= 0.5F);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" ");
    localStringBuilder.append(b());
    localStringBuilder.append(" ");
    localStringBuilder.append(c());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sb.a.a
 * JD-Core Version:    0.7.0.1
 */