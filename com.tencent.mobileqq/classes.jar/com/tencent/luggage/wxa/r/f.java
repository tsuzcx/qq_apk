package com.tencent.luggage.wxa.r;

import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.h.k;
import com.tencent.luggage.wxa.l.l;

public final class f
  implements h
{
  private final m a = new m(new byte[15]);
  private final String b;
  private String c;
  private l d;
  private int e;
  private int f;
  private int g;
  private long h;
  private k i;
  private int j;
  private long k;
  
  public f(String paramString)
  {
    this.a.a[0] = 127;
    this.a.a[1] = -2;
    this.a.a[2] = -128;
    this.a.a[3] = 1;
    this.e = 0;
    this.b = paramString;
  }
  
  private boolean a(m paramm, byte[] paramArrayOfByte, int paramInt)
  {
    int m = Math.min(paramm.b(), paramInt - this.f);
    paramm.a(paramArrayOfByte, this.f, m);
    this.f += m;
    return this.f == paramInt;
  }
  
  private boolean b(m paramm)
  {
    while (paramm.b() > 0)
    {
      this.g <<= 8;
      this.g |= paramm.g();
      if (this.g == 2147385345)
      {
        this.g = 0;
        return true;
      }
    }
    return false;
  }
  
  private void c()
  {
    byte[] arrayOfByte = this.a.a;
    if (this.i == null)
    {
      this.i = com.tencent.luggage.wxa.i.h.a(arrayOfByte, this.c, this.b, null);
      this.d.a(this.i);
    }
    this.j = com.tencent.luggage.wxa.i.h.b(arrayOfByte);
    this.h = ((int)(com.tencent.luggage.wxa.i.h.a(arrayOfByte) * 1000000L / this.i.s));
  }
  
  public void a()
  {
    this.e = 0;
    this.f = 0;
    this.g = 0;
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    this.k = paramLong;
  }
  
  public void a(m paramm)
  {
    while (paramm.b() > 0)
    {
      int m = this.e;
      if (m != 0)
      {
        if (m != 1)
        {
          if (m == 2)
          {
            m = Math.min(paramm.b(), this.j - this.f);
            this.d.a(paramm, m);
            this.f += m;
            m = this.f;
            int n = this.j;
            if (m == n)
            {
              this.d.a(this.k, 1, n, 0, null);
              this.k += this.h;
              this.e = 0;
            }
          }
        }
        else if (a(paramm, this.a.a, 15))
        {
          c();
          this.a.c(0);
          this.d.a(this.a, 15);
          this.e = 2;
        }
      }
      else if (b(paramm))
      {
        this.f = 4;
        this.e = 1;
      }
    }
  }
  
  public void a(com.tencent.luggage.wxa.l.f paramf, v.d paramd)
  {
    paramd.a();
    this.c = paramd.c();
    this.d = paramf.a(paramd.b(), 1);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.r.f
 * JD-Core Version:    0.7.0.1
 */