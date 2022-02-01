package com.tencent.luggage.wxa.h;

import com.tencent.luggage.wxa.al.f;
import com.tencent.luggage.wxa.am.b;
import com.tencent.luggage.wxa.am.k;
import com.tencent.luggage.wxa.ao.p;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.z.o;

public final class c
  implements n
{
  private final k a;
  private final long b;
  private final long c;
  private final long d;
  private final long e;
  private final p f;
  private int g;
  private boolean h;
  
  public c()
  {
    this(new k(true, 65536));
  }
  
  public c(k paramk)
  {
    this(paramk, 15000, 30000, 2500L, 5000L);
  }
  
  public c(k paramk, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this(paramk, paramInt1, paramInt2, paramLong1, paramLong2, null);
  }
  
  public c(k paramk, int paramInt1, int paramInt2, long paramLong1, long paramLong2, p paramp)
  {
    this.a = paramk;
    this.b = (paramInt1 * 1000L);
    this.c = (paramInt2 * 1000L);
    this.d = (paramLong1 * 1000L);
    this.e = (paramLong2 * 1000L);
    this.f = paramp;
  }
  
  private void a(boolean paramBoolean)
  {
    this.g = 0;
    p localp = this.f;
    if ((localp != null) && (this.h)) {
      localp.b(0);
    }
    this.h = false;
    if (paramBoolean) {
      this.a.d();
    }
  }
  
  private int b(long paramLong)
  {
    if (paramLong > this.c) {
      return 0;
    }
    if (paramLong < this.b) {
      return 2;
    }
    return 1;
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(s[] paramArrayOfs, o paramo, f paramf)
  {
    int i = 0;
    this.g = 0;
    while (i < paramArrayOfs.length)
    {
      if (paramf.a(i) != null) {
        this.g += x.d(paramArrayOfs[i].a());
      }
      i += 1;
    }
    this.a.a(this.g);
  }
  
  public boolean a(long paramLong)
  {
    int j = b(paramLong);
    int i = this.a.e();
    int k = this.g;
    boolean bool2 = true;
    if (i >= k) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool3 = this.h;
    boolean bool1 = bool2;
    if (j != 2) {
      if ((j == 1) && (bool3) && (i == 0)) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    this.h = bool1;
    p localp = this.f;
    if (localp != null)
    {
      bool1 = this.h;
      if (bool1 != bool3) {
        if (bool1) {
          localp.a(0);
        } else {
          localp.b(0);
        }
      }
    }
    return this.h;
  }
  
  public boolean a(long paramLong, boolean paramBoolean)
  {
    long l;
    if (paramBoolean) {
      l = this.e;
    } else {
      l = this.d;
    }
    return (l <= 0L) || (paramLong >= l);
  }
  
  public void b()
  {
    a(true);
  }
  
  public void c()
  {
    a(true);
  }
  
  public b d()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.h.c
 * JD-Core Version:    0.7.0.1
 */