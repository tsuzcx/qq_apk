package com.tencent.luggage.wxa.r;

import com.tencent.luggage.wxa.ao.l;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.l.e;
import com.tencent.luggage.wxa.l.f;
import com.tencent.luggage.wxa.l.g;
import com.tencent.luggage.wxa.l.j;
import com.tencent.luggage.wxa.l.k.a;

public final class c
  implements com.tencent.luggage.wxa.l.d
{
  public static final g a = new c.1();
  private static final int b = x.f("ID3");
  private final long c;
  private final d d;
  private final m e;
  private boolean f;
  
  public c()
  {
    this(0L);
  }
  
  public c(long paramLong)
  {
    this.c = paramLong;
    this.d = new d(true);
    this.e = new m(200);
  }
  
  public int a(e parame, j paramj)
  {
    int i = parame.a(this.e.a, 0, 200);
    if (i == -1) {
      return -1;
    }
    this.e.c(0);
    this.e.b(i);
    if (!this.f)
    {
      this.d.a(this.c, true);
      this.f = true;
    }
    this.d.a(this.e);
    return 0;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.f = false;
    this.d.a();
  }
  
  public void a(f paramf)
  {
    this.d.a(paramf, new v.d(0, 1));
    paramf.a();
    paramf.a(new k.a(-9223372036854775807L));
  }
  
  public boolean a(e parame)
  {
    m localm = new m(10);
    l locall = new l(localm.a);
    int i = 0;
    for (;;)
    {
      parame.c(localm.a, 0, 10);
      localm.c(0);
      if (localm.k() != b)
      {
        parame.a();
        parame.c(i);
        j = i;
        int m = 0;
        int k = 0;
        for (;;)
        {
          parame.c(localm.a, 0, 2);
          localm.c(0);
          if ((localm.h() & 0xFFF6) != 65520)
          {
            parame.a();
            j += 1;
            if (j - i >= 8192) {
              return false;
            }
            parame.c(j);
            break;
          }
          m += 1;
          if ((m >= 4) && (k > 188)) {
            return true;
          }
          parame.c(localm.a, 0, 4);
          locall.a(14);
          int n = locall.c(13);
          if (n <= 6) {
            return false;
          }
          parame.c(n - 6);
          k += n;
        }
      }
      localm.d(3);
      int j = localm.s();
      i += j + 10;
      parame.c(j);
    }
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.r.c
 * JD-Core Version:    0.7.0.1
 */