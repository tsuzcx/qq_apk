package com.tencent.luggage.wxa.p;

import com.tencent.luggage.wxa.ao.a;
import com.tencent.luggage.wxa.ao.m;

final class b$a
{
  public final int a;
  public int b;
  public int c;
  public long d;
  private final boolean e;
  private final m f;
  private final m g;
  private int h;
  private int i;
  
  public b$a(m paramm1, m paramm2, boolean paramBoolean)
  {
    this.g = paramm1;
    this.f = paramm2;
    this.e = paramBoolean;
    paramm2.c(12);
    this.a = paramm2.t();
    paramm1.c(12);
    this.i = paramm1.t();
    int j = paramm1.n();
    paramBoolean = true;
    if (j != 1) {
      paramBoolean = false;
    }
    a.b(paramBoolean, "first_chunk must be 1");
    this.b = -1;
  }
  
  public boolean a()
  {
    int j = this.b + 1;
    this.b = j;
    if (j == this.a) {
      return false;
    }
    long l;
    if (this.e) {
      l = this.f.v();
    } else {
      l = this.f.l();
    }
    this.d = l;
    if (this.b == this.h)
    {
      this.c = this.g.t();
      this.g.d(4);
      j = this.i - 1;
      this.i = j;
      if (j > 0) {
        j = this.g.t() - 1;
      } else {
        j = -1;
      }
      this.h = j;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.p.b.a
 * JD-Core Version:    0.7.0.1
 */