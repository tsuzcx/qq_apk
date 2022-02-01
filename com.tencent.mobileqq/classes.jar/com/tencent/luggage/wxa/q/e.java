package com.tencent.luggage.wxa.q;

import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.h.p;
import java.io.EOFException;

final class e
{
  private static final int k = x.f("OggS");
  public int a;
  public int b;
  public long c;
  public long d;
  public long e;
  public long f;
  public int g;
  public int h;
  public int i;
  public final int[] j = new int['ÿ'];
  private final m l = new m(255);
  
  public void a()
  {
    this.a = 0;
    this.b = 0;
    this.c = 0L;
    this.d = 0L;
    this.e = 0L;
    this.f = 0L;
    this.g = 0;
    this.h = 0;
    this.i = 0;
  }
  
  public boolean a(com.tencent.luggage.wxa.l.e parame, boolean paramBoolean)
  {
    this.l.a();
    a();
    long l1 = parame.d();
    int n = 0;
    int m;
    if ((l1 != -1L) && (parame.d() - parame.b() < 27L)) {
      m = 0;
    } else {
      m = 1;
    }
    if ((m != 0) && (parame.b(this.l.a, 0, 27, true)))
    {
      if (this.l.l() != k)
      {
        if (paramBoolean) {
          return false;
        }
        throw new p("expected OggS capture pattern at begin of page");
      }
      this.a = this.l.g();
      if (this.a != 0)
      {
        if (paramBoolean) {
          return false;
        }
        throw new p("unsupported bit stream revision");
      }
      this.b = this.l.g();
      this.c = this.l.q();
      this.d = this.l.m();
      this.e = this.l.m();
      this.f = this.l.m();
      this.g = this.l.g();
      this.h = (this.g + 27);
      this.l.a();
      parame.c(this.l.a, 0, this.g);
      m = n;
      while (m < this.g)
      {
        this.j[m] = this.l.g();
        this.i += this.j[m];
        m += 1;
      }
      return true;
    }
    if (paramBoolean) {
      return false;
    }
    parame = new EOFException();
    for (;;)
    {
      throw parame;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.q.e
 * JD-Core Version:    0.7.0.1
 */