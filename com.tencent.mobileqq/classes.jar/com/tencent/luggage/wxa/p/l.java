package com.tencent.luggage.wxa.p;

import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.l.e;

final class l
{
  public c a;
  public long b;
  public long c;
  public long d;
  public int e;
  public int f;
  public long[] g;
  public int[] h;
  public int[] i;
  public int[] j;
  public long[] k;
  public boolean[] l;
  public boolean m;
  public boolean[] n;
  public k o;
  public int p;
  public m q;
  public boolean r;
  public long s;
  
  public void a()
  {
    this.e = 0;
    this.s = 0L;
    this.m = false;
    this.r = false;
    this.o = null;
  }
  
  public void a(int paramInt)
  {
    m localm = this.q;
    if ((localm == null) || (localm.c() < paramInt)) {
      this.q = new m(paramInt);
    }
    this.p = paramInt;
    this.m = true;
    this.r = true;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    int[] arrayOfInt = this.h;
    if ((arrayOfInt == null) || (arrayOfInt.length < paramInt1))
    {
      this.g = new long[paramInt1];
      this.h = new int[paramInt1];
    }
    arrayOfInt = this.i;
    if ((arrayOfInt == null) || (arrayOfInt.length < paramInt2))
    {
      paramInt1 = paramInt2 * 125 / 100;
      this.i = new int[paramInt1];
      this.j = new int[paramInt1];
      this.k = new long[paramInt1];
      this.l = new boolean[paramInt1];
      this.n = new boolean[paramInt1];
    }
  }
  
  public void a(m paramm)
  {
    paramm.a(this.q.a, 0, this.p);
    this.q.c(0);
    this.r = false;
  }
  
  public void a(e parame)
  {
    parame.b(this.q.a, 0, this.p);
    this.q.c(0);
    this.r = false;
  }
  
  public long b(int paramInt)
  {
    return this.k[paramInt] + this.j[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.p.l
 * JD-Core Version:    0.7.0.1
 */