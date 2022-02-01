package com.tencent.luggage.wxa.q;

import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.h.k;
import com.tencent.luggage.wxa.l.j;
import com.tencent.luggage.wxa.l.l;

abstract class h
{
  private final d a = new d();
  private l b;
  private com.tencent.luggage.wxa.l.f c;
  private f d;
  private long e;
  private long f;
  private long g;
  private int h;
  private int i;
  private h.a j;
  private long k;
  private boolean l;
  private boolean m;
  
  private int a(com.tencent.luggage.wxa.l.e parame)
  {
    int n = 1;
    while (n != 0)
    {
      if (!this.a.a(parame))
      {
        this.h = 3;
        return -1;
      }
      this.k = (parame.c() - this.f);
      boolean bool = a(this.a.c(), this.f, this.j);
      n = bool;
      if (bool)
      {
        this.f = parame.c();
        n = bool;
      }
    }
    this.i = this.j.a.s;
    if (!this.m)
    {
      this.b.a(this.j.a);
      this.m = true;
    }
    if (this.j.b != null)
    {
      this.d = this.j.b;
    }
    else if (parame.d() == -1L)
    {
      this.d = new h.b(null);
    }
    else
    {
      e locale = this.a.b();
      this.d = new a(this.f, parame.d(), this, locale.h + locale.i, locale.c);
    }
    this.j = null;
    this.h = 2;
    this.a.d();
    return 0;
  }
  
  private int b(com.tencent.luggage.wxa.l.e parame, j paramj)
  {
    long l1 = this.d.a(parame);
    if (l1 >= 0L)
    {
      paramj.a = l1;
      return 1;
    }
    if (l1 < -1L) {
      c(-(l1 + 2L));
    }
    if (!this.l)
    {
      paramj = this.d.c();
      this.c.a(paramj);
      this.l = true;
    }
    if ((this.k <= 0L) && (!this.a.a(parame)))
    {
      this.h = 3;
      return -1;
    }
    this.k = 0L;
    parame = this.a.c();
    l1 = b(parame);
    if (l1 >= 0L)
    {
      long l2 = this.g;
      if (l2 + l1 >= this.e)
      {
        l2 = a(l2);
        this.b.a(parame, parame.c());
        this.b.a(l2, 1, parame.c(), 0, null);
        this.e = -1L;
      }
    }
    this.g += l1;
    return 0;
  }
  
  final int a(com.tencent.luggage.wxa.l.e parame, j paramj)
  {
    int n = this.h;
    if (n != 0)
    {
      if (n != 1)
      {
        if (n == 2) {
          return b(parame, paramj);
        }
        throw new IllegalStateException();
      }
      parame.b((int)this.f);
      this.h = 2;
      return 0;
    }
    return a(parame);
  }
  
  protected long a(long paramLong)
  {
    return paramLong * 1000000L / this.i;
  }
  
  final void a(long paramLong1, long paramLong2)
  {
    this.a.a();
    if (paramLong1 == 0L)
    {
      a(this.l ^ true);
      return;
    }
    if (this.h != 0)
    {
      this.e = this.d.a(paramLong2);
      this.h = 2;
    }
  }
  
  void a(com.tencent.luggage.wxa.l.f paramf, l paraml)
  {
    this.c = paramf;
    this.b = paraml;
    a(true);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.j = new h.a();
      this.f = 0L;
      this.h = 0;
    }
    else
    {
      this.h = 1;
    }
    this.e = -1L;
    this.g = 0L;
  }
  
  protected abstract boolean a(m paramm, long paramLong, h.a parama);
  
  protected long b(long paramLong)
  {
    return this.i * paramLong / 1000000L;
  }
  
  protected abstract long b(m paramm);
  
  protected void c(long paramLong)
  {
    this.g = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.q.h
 * JD-Core Version:    0.7.0.1
 */