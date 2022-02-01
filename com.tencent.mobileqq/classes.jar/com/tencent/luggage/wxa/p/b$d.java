package com.tencent.luggage.wxa.p;

import com.tencent.luggage.wxa.ao.m;

final class b$d
  implements b.b
{
  private final int a;
  private final int b;
  private final m c;
  
  public b$d(a.b paramb)
  {
    this.c = paramb.aQ;
    this.c.c(12);
    this.a = this.c.t();
    this.b = this.c.t();
  }
  
  public int a()
  {
    return this.b;
  }
  
  public int b()
  {
    int j = this.a;
    int i = j;
    if (j == 0) {
      i = this.c.t();
    }
    return i;
  }
  
  public boolean c()
  {
    return this.a != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.p.b.d
 * JD-Core Version:    0.7.0.1
 */