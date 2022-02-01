package com.tencent.luggage.wxa.s;

final class b
{
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  private final int f;
  private long g;
  private long h;
  
  public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.f = paramInt6;
  }
  
  public long a()
  {
    return this.h / this.d * 1000000L / this.b;
  }
  
  public long a(long paramLong)
  {
    paramLong = paramLong * this.c / 1000000L;
    int i = this.d;
    return Math.min(paramLong / i * i, this.h - i) + this.g;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.g = paramLong1;
    this.h = paramLong2;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public long b(long paramLong)
  {
    return paramLong * 1000000L / this.c;
  }
  
  public int c()
  {
    return this.b * this.e * this.a;
  }
  
  public int d()
  {
    return this.b;
  }
  
  public int e()
  {
    return this.a;
  }
  
  public boolean f()
  {
    return (this.g != 0L) && (this.h != 0L);
  }
  
  public int g()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.s.b
 * JD-Core Version:    0.7.0.1
 */