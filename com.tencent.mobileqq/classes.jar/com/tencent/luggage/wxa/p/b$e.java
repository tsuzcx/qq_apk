package com.tencent.luggage.wxa.p;

import com.tencent.luggage.wxa.ao.m;

final class b$e
  implements b.b
{
  private final m a;
  private final int b;
  private final int c;
  private int d;
  private int e;
  
  public b$e(a.b paramb)
  {
    this.a = paramb.aQ;
    this.a.c(12);
    this.c = (this.a.t() & 0xFF);
    this.b = this.a.t();
  }
  
  public int a()
  {
    return this.b;
  }
  
  public int b()
  {
    int i = this.c;
    if (i == 8) {
      return this.a.g();
    }
    if (i == 16) {
      return this.a.h();
    }
    i = this.d;
    this.d = (i + 1);
    if (i % 2 == 0)
    {
      this.e = this.a.g();
      return (this.e & 0xF0) >> 4;
    }
    return this.e & 0xF;
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.p.b.e
 * JD-Core Version:    0.7.0.1
 */