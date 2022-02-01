package com.tencent.luggage.wxa.z;

import com.tencent.luggage.wxa.h.l;
import com.tencent.luggage.wxa.j.e;

final class c$a
  implements k
{
  private final g a;
  private final k b;
  private final long c;
  private final long d;
  private boolean e;
  private boolean f;
  
  public c$a(g paramg, k paramk, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.a = paramg;
    this.b = paramk;
    this.c = paramLong1;
    this.d = paramLong2;
    this.e = paramBoolean;
  }
  
  public int a(l paraml, e parame, boolean paramBoolean)
  {
    if (this.e) {
      return -3;
    }
    if (this.f)
    {
      parame.a_(4);
      return -4;
    }
    int i = this.b.a(paraml, parame, paramBoolean);
    if ((this.d != -9223372036854775808L) && (((i == -4) && (parame.c >= this.d)) || ((i == -3) && (this.a.d() == -9223372036854775808L))))
    {
      parame.a();
      parame.a_(4);
      this.f = true;
      return -4;
    }
    if ((i == -4) && (!parame.c())) {
      parame.c -= this.c;
    }
    return i;
  }
  
  public void a()
  {
    this.e = false;
  }
  
  public void a(long paramLong)
  {
    this.b.a(this.c + paramLong);
  }
  
  public void b()
  {
    this.f = false;
  }
  
  public boolean c()
  {
    return this.b.c();
  }
  
  public void d()
  {
    this.b.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.z.c.a
 * JD-Core Version:    0.7.0.1
 */