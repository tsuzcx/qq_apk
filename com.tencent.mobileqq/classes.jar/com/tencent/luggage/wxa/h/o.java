package com.tencent.luggage.wxa.h;

import android.util.Pair;
import com.tencent.luggage.wxa.z.h.b;

final class o
{
  private final x.a a = new x.a();
  private final x.b b = new x.b();
  private x c;
  private int d;
  
  private o.a a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    h.b localb = new h.b(paramInt1, paramInt2, paramInt3);
    boolean bool1 = a(localb, -9223372036854775808L);
    boolean bool2 = a(localb, bool1);
    long l2 = this.c.a(localb.b, this.a).b(localb.c, localb.d);
    long l1;
    if (paramInt3 == this.a.b(paramInt2)) {
      l1 = this.a.d();
    } else {
      l1 = 0L;
    }
    return new o.a(localb, l1, -9223372036854775808L, paramLong, l2, bool1, bool2, null);
  }
  
  private o.a a(int paramInt, long paramLong1, long paramLong2)
  {
    h.b localb = new h.b(paramInt);
    boolean bool1 = a(localb, paramLong2);
    boolean bool2 = a(localb, bool1);
    this.c.a(localb.b, this.a);
    long l;
    if (paramLong2 == -9223372036854775808L) {
      l = this.a.a();
    } else {
      l = paramLong2;
    }
    return new o.a(localb, paramLong1, paramLong2, -9223372036854775807L, l, bool1, bool2, null);
  }
  
  private o.a a(o.a parama, h.b paramb)
  {
    long l3 = parama.b;
    long l2 = parama.c;
    boolean bool1 = a(paramb, l2);
    boolean bool2 = a(paramb, bool1);
    this.c.a(paramb.b, this.a);
    long l1;
    if (paramb.a()) {
      l1 = this.a.b(paramb.c, paramb.d);
    }
    for (;;)
    {
      break;
      if (l2 == -9223372036854775808L) {
        l1 = this.a.a();
      } else {
        l1 = l2;
      }
    }
    return new o.a(paramb, l3, l2, parama.d, l1, bool1, bool2, null);
  }
  
  private o.a a(h.b paramb, long paramLong1, long paramLong2)
  {
    this.c.a(paramb.b, this.a);
    if (paramb.a())
    {
      if (!this.a.a(paramb.c, paramb.d)) {
        return null;
      }
      return a(paramb.b, paramb.c, paramb.d, paramLong1);
    }
    int i = this.a.b(paramLong2);
    if (i == -1) {
      paramLong1 = -9223372036854775808L;
    } else {
      paramLong1 = this.a.a(i);
    }
    return a(paramb.b, paramLong2, paramLong1);
  }
  
  private boolean a(h.b paramb, long paramLong)
  {
    int i = this.c.a(paramb.b, this.a).c();
    boolean bool1 = true;
    if (i == 0) {
      return true;
    }
    int j = i - 1;
    boolean bool2 = paramb.a();
    if (this.a.a(j) != -9223372036854775808L) {
      return (!bool2) && (paramLong == -9223372036854775808L);
    }
    int k = this.a.d(j);
    if (k == -1) {
      return false;
    }
    if ((bool2) && (paramb.c == j) && (paramb.d == k - 1)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      if ((!bool2) && (this.a.b(j) == k)) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  private boolean a(h.b paramb, boolean paramBoolean)
  {
    int i = this.c.a(paramb.b, this.a).c;
    return (!this.c.a(i, this.b).e) && (this.c.b(paramb.b, this.a, this.b, this.d)) && (paramBoolean);
  }
  
  public o.a a(i.b paramb)
  {
    return a(paramb.a, paramb.c, paramb.b);
  }
  
  public o.a a(o.a parama)
  {
    return a(parama, parama.a);
  }
  
  public o.a a(o.a parama, int paramInt)
  {
    return a(parama, parama.a.a(paramInt));
  }
  
  public o.a a(o.a parama, long paramLong1, long paramLong2)
  {
    int j;
    int k;
    if (parama.f)
    {
      j = this.c.a(parama.a.b, this.a, this.b, this.d);
      if (j == -1) {
        return null;
      }
      k = this.c.a(j, this.a).c;
      int m = this.c.a(k, this.b).f;
      long l = 0L;
      i = j;
      if (m == j)
      {
        l = parama.e;
        parama = this.c.a(this.b, this.a, k, -9223372036854775807L, Math.max(0L, paramLong1 + l - paramLong2));
        if (parama == null) {
          return null;
        }
        i = ((Integer)parama.first).intValue();
        l = ((Long)parama.second).longValue();
      }
      return a(a(i, l), l, l);
    }
    h.b localb = parama.a;
    if (localb.a())
    {
      i = localb.c;
      this.c.a(localb.b, this.a);
      j = this.a.d(i);
      if (j == -1) {
        return null;
      }
      k = localb.d + 1;
      if (k < j)
      {
        if (!this.a.a(i, k)) {
          return null;
        }
        return a(localb.b, i, k, parama.d);
      }
      i = this.a.b(parama.d);
      if (i == -1) {
        paramLong1 = -9223372036854775808L;
      } else {
        paramLong1 = this.a.a(i);
      }
      return a(localb.b, parama.d, paramLong1);
    }
    if (parama.c != -9223372036854775808L)
    {
      i = this.a.a(parama.c);
      if (!this.a.a(i, 0)) {
        return null;
      }
      return a(localb.b, i, 0, parama.c);
    }
    int i = this.a.c();
    if (i != 0)
    {
      parama = this.a;
      i -= 1;
      if ((parama.a(i) == -9223372036854775808L) && (!this.a.c(i)))
      {
        if (!this.a.a(i, 0)) {
          return null;
        }
        paramLong1 = this.a.a();
        return a(localb.b, i, 0, paramLong1);
      }
    }
    return null;
  }
  
  public h.b a(int paramInt, long paramLong)
  {
    this.c.a(paramInt, this.a);
    int i = this.a.a(paramLong);
    if (i == -1) {
      return new h.b(paramInt);
    }
    return new h.b(paramInt, i, this.a.b(i));
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(x paramx)
  {
    this.c = paramx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.h.o
 * JD-Core Version:    0.7.0.1
 */