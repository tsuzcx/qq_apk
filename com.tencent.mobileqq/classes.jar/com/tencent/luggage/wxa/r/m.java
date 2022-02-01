package com.tencent.luggage.wxa.r;

import com.tencent.luggage.wxa.h.k;
import com.tencent.luggage.wxa.l.f;
import com.tencent.luggage.wxa.l.i;
import com.tencent.luggage.wxa.l.l;

public final class m
  implements h
{
  private final com.tencent.luggage.wxa.ao.m a = new com.tencent.luggage.wxa.ao.m(4);
  private final i b;
  private final String c;
  private String d;
  private l e;
  private int f = 0;
  private int g;
  private boolean h;
  private boolean i;
  private long j;
  private int k;
  private long l;
  
  public m()
  {
    this(null);
  }
  
  public m(String paramString)
  {
    this.a.a[0] = -1;
    this.b = new i();
    this.c = paramString;
  }
  
  private void b(com.tencent.luggage.wxa.ao.m paramm)
  {
    byte[] arrayOfByte = paramm.a;
    int m = paramm.d();
    int i1 = paramm.c();
    while (m < i1)
    {
      boolean bool;
      if ((arrayOfByte[m] & 0xFF) == 255) {
        bool = true;
      } else {
        bool = false;
      }
      int n;
      if ((this.i) && ((arrayOfByte[m] & 0xE0) == 224)) {
        n = 1;
      } else {
        n = 0;
      }
      this.i = bool;
      if (n != 0)
      {
        paramm.c(m + 1);
        this.i = false;
        this.a.a[1] = arrayOfByte[m];
        this.g = 2;
        this.f = 1;
        return;
      }
      m += 1;
    }
    paramm.c(i1);
  }
  
  private void c(com.tencent.luggage.wxa.ao.m paramm)
  {
    int m = Math.min(paramm.b(), 4 - this.g);
    paramm.a(this.a.a, this.g, m);
    this.g += m;
    if (this.g < 4) {
      return;
    }
    this.a.c(0);
    if (!i.a(this.a.n(), this.b))
    {
      this.g = 0;
      this.f = 1;
      return;
    }
    this.k = this.b.c;
    if (!this.h)
    {
      this.j = (this.b.g * 1000000L / this.b.d);
      paramm = k.a(this.d, this.b.b, null, -1, 4096, this.b.e, this.b.d, null, null, 0, this.c);
      this.e.a(paramm);
      this.h = true;
    }
    this.a.c(0);
    this.e.a(this.a, 4);
    this.f = 2;
  }
  
  private void d(com.tencent.luggage.wxa.ao.m paramm)
  {
    int m = Math.min(paramm.b(), this.k - this.g);
    this.e.a(paramm, m);
    this.g += m;
    m = this.g;
    int n = this.k;
    if (m < n) {
      return;
    }
    this.e.a(this.l, 1, n, 0, null);
    this.l += this.j;
    this.g = 0;
    this.f = 0;
  }
  
  public void a()
  {
    this.f = 0;
    this.g = 0;
    this.i = false;
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    this.l = paramLong;
  }
  
  public void a(com.tencent.luggage.wxa.ao.m paramm)
  {
    while (paramm.b() > 0)
    {
      int m = this.f;
      if (m != 0)
      {
        if (m != 1)
        {
          if (m == 2) {
            d(paramm);
          }
        }
        else {
          c(paramm);
        }
      }
      else {
        b(paramm);
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
 * Qualified Name:     com.tencent.luggage.wxa.r.m
 * JD-Core Version:    0.7.0.1
 */