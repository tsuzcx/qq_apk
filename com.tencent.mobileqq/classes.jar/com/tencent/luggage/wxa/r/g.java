package com.tencent.luggage.wxa.r;

import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.h.k;
import com.tencent.luggage.wxa.l.f;
import com.tencent.luggage.wxa.l.l;
import java.util.Collections;
import java.util.List;

public final class g
  implements h
{
  private final List<v.a> a;
  private final l[] b;
  private boolean c;
  private int d;
  private int e;
  private long f;
  
  public g(List<v.a> paramList)
  {
    this.a = paramList;
    this.b = new l[paramList.size()];
  }
  
  private boolean a(m paramm, int paramInt)
  {
    if (paramm.b() == 0) {
      return false;
    }
    if (paramm.g() != paramInt) {
      this.c = false;
    }
    this.d -= 1;
    return this.c;
  }
  
  public void a()
  {
    this.c = false;
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.c = true;
    this.f = paramLong;
    this.e = 0;
    this.d = 2;
  }
  
  public void a(m paramm)
  {
    if (this.c)
    {
      if ((this.d == 2) && (!a(paramm, 32))) {
        return;
      }
      int j = this.d;
      int i = 0;
      if ((j == 1) && (!a(paramm, 0))) {
        return;
      }
      j = paramm.d();
      int k = paramm.b();
      l[] arrayOfl = this.b;
      int m = arrayOfl.length;
      while (i < m)
      {
        l locall = arrayOfl[i];
        paramm.c(j);
        locall.a(paramm, k);
        i += 1;
      }
      this.e += k;
    }
  }
  
  public void a(f paramf, v.d paramd)
  {
    int i = 0;
    while (i < this.b.length)
    {
      v.a locala = (v.a)this.a.get(i);
      paramd.a();
      l locall = paramf.a(paramd.b(), 3);
      locall.a(k.a(paramd.c(), "application/dvbsubs", null, -1, Collections.singletonList(locala.c), locala.a, null));
      this.b[i] = locall;
      i += 1;
    }
  }
  
  public void b()
  {
    if (this.c)
    {
      l[] arrayOfl = this.b;
      int j = arrayOfl.length;
      int i = 0;
      while (i < j)
      {
        arrayOfl[i].a(this.f, 1, this.e, 0, null);
        i += 1;
      }
      this.c = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.r.g
 * JD-Core Version:    0.7.0.1
 */