package com.tencent.luggage.wxa.r;

import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.h.k;
import com.tencent.luggage.wxa.i.a;
import com.tencent.luggage.wxa.i.a.a;
import com.tencent.luggage.wxa.l.f;

public final class b
  implements h
{
  private final com.tencent.luggage.wxa.ao.l a = new com.tencent.luggage.wxa.ao.l(new byte[8]);
  private final m b = new m(this.a.a);
  private final String c;
  private String d;
  private com.tencent.luggage.wxa.l.l e;
  private int f = 0;
  private int g;
  private boolean h;
  private long i;
  private k j;
  private int k;
  private long l;
  
  public b()
  {
    this(null);
  }
  
  public b(String paramString)
  {
    this.c = paramString;
  }
  
  private boolean a(m paramm, byte[] paramArrayOfByte, int paramInt)
  {
    int m = Math.min(paramm.b(), paramInt - this.g);
    paramm.a(paramArrayOfByte, this.g, m);
    this.g += m;
    return this.g == paramInt;
  }
  
  private boolean b(m paramm)
  {
    for (;;)
    {
      int m = paramm.b();
      boolean bool2 = false;
      boolean bool1 = false;
      if (m <= 0) {
        break;
      }
      if (!this.h)
      {
        if (paramm.g() == 11) {
          bool1 = true;
        }
        this.h = bool1;
      }
      else
      {
        m = paramm.g();
        if (m == 119)
        {
          this.h = false;
          return true;
        }
        bool1 = bool2;
        if (m == 11) {
          bool1 = true;
        }
        this.h = bool1;
      }
    }
    return false;
  }
  
  private void c()
  {
    this.a.a(0);
    a.a locala = a.a(this.a);
    if ((this.j == null) || (locala.c != this.j.r) || (locala.b != this.j.s) || (locala.a != this.j.f))
    {
      this.j = k.a(this.d, locala.a, null, -1, -1, locala.c, locala.b, null, null, 0, this.c);
      this.e.a(this.j);
    }
    this.k = locala.d;
    this.i = (locala.e * 1000000L / this.j.s);
  }
  
  public void a()
  {
    this.f = 0;
    this.g = 0;
    this.h = false;
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    this.l = paramLong;
  }
  
  public void a(m paramm)
  {
    while (paramm.b() > 0)
    {
      int m = this.f;
      if (m != 0)
      {
        if (m != 1)
        {
          if (m == 2)
          {
            m = Math.min(paramm.b(), this.k - this.g);
            this.e.a(paramm, m);
            this.g += m;
            m = this.g;
            int n = this.k;
            if (m == n)
            {
              this.e.a(this.l, 1, n, 0, null);
              this.l += this.i;
              this.f = 0;
            }
          }
        }
        else if (a(paramm, this.b.a, 8))
        {
          c();
          this.b.c(0);
          this.e.a(this.b, 8);
          this.f = 2;
        }
      }
      else if (b(paramm))
      {
        this.f = 1;
        this.b.a[0] = 11;
        this.b.a[1] = 119;
        this.g = 2;
      }
    }
  }
  
  public void a(f paramf, v.d paramd)
  {
    paramd.a();
    this.d = paramd.c();
    this.e = paramf.a(paramd.b(), 1);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.r.b
 * JD-Core Version:    0.7.0.1
 */