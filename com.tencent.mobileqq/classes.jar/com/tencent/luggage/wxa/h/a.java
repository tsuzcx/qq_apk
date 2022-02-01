package com.tencent.luggage.wxa.h;

import com.tencent.luggage.wxa.ao.i;
import com.tencent.luggage.wxa.j.e;

public abstract class a
  implements s, t
{
  private final int a;
  private u b;
  private int c;
  private int d;
  private com.tencent.luggage.wxa.z.k e;
  private long f;
  private boolean g;
  private boolean h;
  
  public a(int paramInt)
  {
    this.a = paramInt;
    this.g = true;
  }
  
  public final int a()
  {
    return this.a;
  }
  
  protected final int a(l paraml, e parame, boolean paramBoolean)
  {
    int i = this.e.a(paraml, parame, paramBoolean);
    if (i == -4)
    {
      if (parame.c())
      {
        this.g = true;
        if (this.h) {
          return -4;
        }
        return -3;
      }
      parame.c += this.f;
      return i;
    }
    if (i == -5)
    {
      parame = paraml.a;
      if (parame.w != 9223372036854775807L) {
        paraml.a = parame.a(parame.w + this.f);
      }
    }
    return i;
  }
  
  public final void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(int paramInt, Object paramObject) {}
  
  public final void a(long paramLong)
  {
    this.h = false;
    this.g = false;
    a(paramLong, false);
  }
  
  protected void a(long paramLong, boolean paramBoolean) {}
  
  public final void a(u paramu, k[] paramArrayOfk, com.tencent.luggage.wxa.z.k paramk, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    boolean bool;
    if (this.d == 0) {
      bool = true;
    } else {
      bool = false;
    }
    com.tencent.luggage.wxa.ao.a.b(bool);
    this.b = paramu;
    this.d = 1;
    a(paramBoolean);
    a(paramArrayOfk, paramk, paramLong2);
    a(paramLong1, paramBoolean);
  }
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(k[] paramArrayOfk, long paramLong) {}
  
  public final void a(k[] paramArrayOfk, com.tencent.luggage.wxa.z.k paramk, long paramLong)
  {
    com.tencent.luggage.wxa.ao.a.b(this.h ^ true);
    this.e = paramk;
    this.g = false;
    this.f = paramLong;
    a(paramArrayOfk, paramLong);
  }
  
  public final t b()
  {
    return this;
  }
  
  protected void b(long paramLong)
  {
    this.e.a(paramLong - this.f);
  }
  
  public i c()
  {
    return null;
  }
  
  public final int d()
  {
    return this.d;
  }
  
  public final void e()
  {
    int i = this.d;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    com.tencent.luggage.wxa.ao.a.b(bool);
    this.d = 2;
    n();
  }
  
  public final com.tencent.luggage.wxa.z.k f()
  {
    return this.e;
  }
  
  public final boolean g()
  {
    return this.g;
  }
  
  public final void h()
  {
    this.h = true;
  }
  
  public final boolean i()
  {
    return this.h;
  }
  
  public final void j()
  {
    this.e.d();
  }
  
  public final void k()
  {
    boolean bool;
    if (this.d == 2) {
      bool = true;
    } else {
      bool = false;
    }
    com.tencent.luggage.wxa.ao.a.b(bool);
    this.d = 1;
    o();
  }
  
  public final void l()
  {
    int i = this.d;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    com.tencent.luggage.wxa.ao.a.b(bool);
    this.d = 0;
    this.e = null;
    this.h = false;
    p();
  }
  
  public int m()
  {
    return 0;
  }
  
  protected void n() {}
  
  protected void o() {}
  
  protected void p() {}
  
  protected final u q()
  {
    return this.b;
  }
  
  protected final int r()
  {
    return this.c;
  }
  
  protected final boolean s()
  {
    if (this.g) {
      return this.h;
    }
    return this.e.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.h.a
 * JD-Core Version:    0.7.0.1
 */