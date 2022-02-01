package com.tencent.luggage.wxa.q;

import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.h.p;
import com.tencent.luggage.wxa.l.d;
import com.tencent.luggage.wxa.l.f;
import com.tencent.luggage.wxa.l.l;

public class c
  implements d
{
  public static final com.tencent.luggage.wxa.l.g a = new c.1();
  private f b;
  private h c;
  private boolean d;
  
  private static m a(m paramm)
  {
    paramm.c(0);
    return paramm;
  }
  
  private boolean b(com.tencent.luggage.wxa.l.e parame)
  {
    Object localObject = new e();
    if (((e)localObject).a(parame, true))
    {
      if ((((e)localObject).b & 0x2) != 2) {
        return false;
      }
      int i = Math.min(((e)localObject).i, 8);
      localObject = new m(i);
      parame.c(((m)localObject).a, 0, i);
      if (b.a(a((m)localObject)))
      {
        this.c = new b();
        return true;
      }
      if (j.a(a((m)localObject)))
      {
        this.c = new j();
        return true;
      }
      if (g.a(a((m)localObject)))
      {
        this.c = new g();
        return true;
      }
    }
    return false;
  }
  
  public int a(com.tencent.luggage.wxa.l.e parame, com.tencent.luggage.wxa.l.j paramj)
  {
    if (this.c == null) {
      if (b(parame)) {
        parame.a();
      } else {
        throw new p("Failed to determine bitstream type");
      }
    }
    if (!this.d)
    {
      l locall = this.b.a(0, 1);
      this.b.a();
      this.c.a(this.b, locall);
      this.d = true;
    }
    return this.c.a(parame, paramj);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    h localh = this.c;
    if (localh != null) {
      localh.a(paramLong1, paramLong2);
    }
  }
  
  public void a(f paramf)
  {
    this.b = paramf;
  }
  
  public boolean a(com.tencent.luggage.wxa.l.e parame)
  {
    try
    {
      boolean bool = b(parame);
      return bool;
    }
    catch (p parame)
    {
      label8:
      break label8;
    }
    return false;
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.q.c
 * JD-Core Version:    0.7.0.1
 */