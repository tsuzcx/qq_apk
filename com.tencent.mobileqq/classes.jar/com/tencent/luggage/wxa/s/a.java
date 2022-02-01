package com.tencent.luggage.wxa.s;

import com.tencent.luggage.wxa.h.p;
import com.tencent.luggage.wxa.l.d;
import com.tencent.luggage.wxa.l.e;
import com.tencent.luggage.wxa.l.f;
import com.tencent.luggage.wxa.l.g;
import com.tencent.luggage.wxa.l.j;
import com.tencent.luggage.wxa.l.l;

public final class a
  implements d, com.tencent.luggage.wxa.l.k
{
  public static final g a = new a.1();
  private f b;
  private l c;
  private b d;
  private int e;
  private int f;
  
  public int a(e parame, j paramj)
  {
    if (this.d == null)
    {
      this.d = c.a(parame);
      paramj = this.d;
      if (paramj != null)
      {
        paramj = com.tencent.luggage.wxa.h.k.a(null, "audio/raw", null, paramj.c(), 32768, this.d.e(), this.d.d(), this.d.g(), null, null, 0, null);
        this.c.a(paramj);
        this.e = this.d.b();
      }
      else
      {
        throw new p("Unsupported or unrecognized wav header.");
      }
    }
    if (!this.d.f())
    {
      c.a(parame, this.d);
      this.b.a(this);
    }
    int i = this.c.a(parame, 32768 - this.f, true);
    if (i != -1) {
      this.f += i;
    }
    int j = this.f / this.e;
    if (j > 0)
    {
      long l = this.d.b(parame.c() - this.f);
      j *= this.e;
      this.f -= j;
      this.c.a(l, 1, j, this.f, null);
    }
    if (i == -1) {
      return -1;
    }
    return 0;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.f = 0;
  }
  
  public void a(f paramf)
  {
    this.b = paramf;
    this.c = paramf.a(0, 1);
    this.d = null;
    paramf.a();
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(e parame)
  {
    return c.a(parame) != null;
  }
  
  public long b()
  {
    return this.d.a();
  }
  
  public long b(long paramLong)
  {
    return this.d.a(paramLong);
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.s.a
 * JD-Core Version:    0.7.0.1
 */