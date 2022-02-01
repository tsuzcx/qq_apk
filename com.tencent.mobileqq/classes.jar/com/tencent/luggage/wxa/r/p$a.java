package com.tencent.luggage.wxa.r;

import com.tencent.luggage.wxa.ao.l;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.ao.u;

final class p$a
{
  private final h a;
  private final u b;
  private final l c;
  private boolean d;
  private boolean e;
  private boolean f;
  private int g;
  private long h;
  
  public p$a(h paramh, u paramu)
  {
    this.a = paramh;
    this.b = paramu;
    this.c = new l(new byte[64]);
  }
  
  private void b()
  {
    this.c.b(8);
    this.d = this.c.e();
    this.e = this.c.e();
    this.c.b(6);
    this.g = this.c.c(8);
  }
  
  private void c()
  {
    this.h = 0L;
    if (this.d)
    {
      this.c.b(4);
      long l1 = this.c.c(3);
      this.c.b(1);
      long l2 = this.c.c(15) << 15;
      this.c.b(1);
      long l3 = this.c.c(15);
      this.c.b(1);
      if ((!this.f) && (this.e))
      {
        this.c.b(4);
        long l4 = this.c.c(3);
        this.c.b(1);
        long l5 = this.c.c(15) << 15;
        this.c.b(1);
        long l6 = this.c.c(15);
        this.c.b(1);
        this.b.b(l4 << 30 | l5 | l6);
        this.f = true;
      }
      this.h = this.b.b(l1 << 30 | l2 | l3);
    }
  }
  
  public void a()
  {
    this.f = false;
    this.a.a();
  }
  
  public void a(m paramm)
  {
    paramm.a(this.c.a, 0, 3);
    this.c.a(0);
    b();
    paramm.a(this.c.a, 0, this.g);
    this.c.a(0);
    c();
    this.a.a(this.h, true);
    this.a.a(paramm);
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.r.p.a
 * JD-Core Version:    0.7.0.1
 */