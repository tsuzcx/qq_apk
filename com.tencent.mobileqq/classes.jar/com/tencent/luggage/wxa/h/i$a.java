package com.tencent.luggage.wxa.h;

import android.util.Log;
import com.tencent.luggage.wxa.al.f;
import com.tencent.luggage.wxa.ao.a;
import com.tencent.luggage.wxa.z.c;
import com.tencent.luggage.wxa.z.k;

final class i$a
{
  public final com.tencent.luggage.wxa.z.g a;
  public final Object b;
  public final int c;
  public final k[] d;
  public final boolean[] e;
  public final long f;
  public o.a g;
  public boolean h;
  public boolean i;
  public a j;
  public com.tencent.luggage.wxa.al.h k;
  private final s[] l;
  private final t[] m;
  private final com.tencent.luggage.wxa.al.g n;
  private final n o;
  private final com.tencent.luggage.wxa.z.h p;
  private com.tencent.luggage.wxa.al.h q;
  
  public i$a(s[] paramArrayOfs, t[] paramArrayOft, long paramLong, com.tencent.luggage.wxa.al.g paramg, n paramn, com.tencent.luggage.wxa.z.h paramh, Object paramObject, int paramInt, o.a parama)
  {
    this.l = paramArrayOfs;
    this.m = paramArrayOft;
    this.f = paramLong;
    this.n = paramg;
    this.o = paramn;
    this.p = paramh;
    this.b = a.a(paramObject);
    this.c = paramInt;
    this.g = parama;
    this.d = new k[paramArrayOfs.length];
    this.e = new boolean[paramArrayOfs.length];
    paramArrayOft = paramh.a(parama.a, paramn.d());
    paramArrayOfs = paramArrayOft;
    if (parama.c != -9223372036854775808L)
    {
      paramArrayOfs = new c(paramArrayOft, true);
      paramArrayOfs.a(0L, parama.c);
    }
    this.a = paramArrayOfs;
  }
  
  public long a()
  {
    if (this.c == 0) {
      return this.f;
    }
    return this.f - this.g.b;
  }
  
  public long a(long paramLong)
  {
    return paramLong + a();
  }
  
  public long a(long paramLong, boolean paramBoolean)
  {
    return a(paramLong, paramBoolean, new boolean[this.l.length]);
  }
  
  public long a(long paramLong, boolean paramBoolean, boolean[] paramArrayOfBoolean)
  {
    f localf = this.k.b;
    int i1 = 0;
    for (;;)
    {
      int i2 = localf.a;
      int i3 = 1;
      if (i1 >= i2) {
        break;
      }
      boolean[] arrayOfBoolean = this.e;
      if ((paramBoolean) || (!this.k.a(this.q, i1))) {
        i3 = 0;
      }
      arrayOfBoolean[i1] = i3;
      i1 += 1;
    }
    paramLong = this.a.a(localf.a(), this.e, this.d, paramArrayOfBoolean, paramLong);
    this.q = this.k;
    this.i = false;
    i1 = 0;
    for (;;)
    {
      paramArrayOfBoolean = this.d;
      if (i1 >= paramArrayOfBoolean.length) {
        break;
      }
      if (paramArrayOfBoolean[i1] != null)
      {
        if (localf.a(i1) != null) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        a.b(paramBoolean);
        this.i = true;
      }
      else
      {
        if (localf.a(i1) == null) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        a.b(paramBoolean);
      }
      i1 += 1;
    }
    this.o.a(this.l, this.k.a, localf);
    return paramLong;
  }
  
  public boolean a(boolean paramBoolean, long paramLong)
  {
    long l1;
    if (!this.h) {
      l1 = this.g.b;
    } else {
      l1 = this.a.d();
    }
    long l2 = l1;
    if (l1 == -9223372036854775808L)
    {
      if (this.g.g) {
        return true;
      }
      l2 = this.g.e;
    }
    return this.o.a(l2 - b(paramLong), paramBoolean);
  }
  
  public long b(long paramLong)
  {
    return paramLong - a();
  }
  
  public boolean b()
  {
    return (this.h) && ((!this.i) || (this.a.d() == -9223372036854775808L));
  }
  
  public void c()
  {
    this.h = true;
    d();
    long l1 = a(this.g.b, false);
    this.g = this.g.a(l1);
  }
  
  public boolean c(long paramLong)
  {
    long l1;
    if (!this.h) {
      l1 = 0L;
    } else {
      l1 = this.a.e();
    }
    if (l1 == -9223372036854775808L) {
      return false;
    }
    paramLong = b(paramLong);
    return this.o.a(l1 - paramLong);
  }
  
  public void d(long paramLong)
  {
    paramLong = b(paramLong);
    this.a.c(paramLong);
  }
  
  public boolean d()
  {
    com.tencent.luggage.wxa.al.h localh = this.n.a(this.m, this.a.b());
    if (localh.a(this.q)) {
      return false;
    }
    this.k = localh;
    return true;
  }
  
  public void e()
  {
    try
    {
      if (this.g.c != -9223372036854775808L)
      {
        this.p.a(((c)this.a).a);
        return;
      }
      this.p.a(this.a);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.e("ExoPlayerImplInternal", "Period release failed.", localRuntimeException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.h.i.a
 * JD-Core Version:    0.7.0.1
 */