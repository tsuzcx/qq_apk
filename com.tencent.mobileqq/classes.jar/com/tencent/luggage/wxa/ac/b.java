package com.tencent.luggage.wxa.ac;

import java.util.Collections;
import java.util.List;

public final class b
  extends c
{
  public final int a;
  public final long b;
  public final long c;
  public final boolean d;
  public final int e;
  public final int f;
  public final int g;
  public final long h;
  public final boolean i;
  public final boolean j;
  public final boolean k;
  public final b.a l;
  public final List<b.a> m;
  public final long n;
  
  public b(int paramInt1, String paramString, List<String> paramList, long paramLong1, long paramLong2, boolean paramBoolean1, int paramInt2, int paramInt3, int paramInt4, long paramLong3, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, b.a parama, List<b.a> paramList1)
  {
    super(paramString, paramList);
    this.a = paramInt1;
    this.c = paramLong2;
    this.d = paramBoolean1;
    this.e = paramInt2;
    this.f = paramInt3;
    this.g = paramInt4;
    this.h = paramLong3;
    this.i = paramBoolean2;
    this.j = paramBoolean3;
    this.k = paramBoolean4;
    this.l = parama;
    this.m = Collections.unmodifiableList(paramList1);
    if (!paramList1.isEmpty())
    {
      paramString = (b.a)paramList1.get(paramList1.size() - 1);
      this.n = (paramString.d + paramString.b);
    }
    else
    {
      this.n = 0L;
    }
    if (paramLong1 == -9223372036854775807L) {
      paramLong1 = -9223372036854775807L;
    } else if (paramLong1 < 0L) {
      paramLong1 = this.n + paramLong1;
    }
    this.b = paramLong1;
  }
  
  public long a()
  {
    return this.c + this.n;
  }
  
  public b a(long paramLong, int paramInt)
  {
    return new b(this.a, this.o, this.p, this.b, paramLong, true, paramInt, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m);
  }
  
  public boolean a(b paramb)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramb != null)
    {
      int i1 = this.f;
      int i2 = paramb.f;
      if (i1 > i2) {
        return true;
      }
      if (i1 < i2) {
        return false;
      }
      i1 = this.m.size();
      i2 = paramb.m.size();
      bool1 = bool2;
      if (i1 <= i2)
      {
        if ((i1 == i2) && (this.j) && (!paramb.j)) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public b b()
  {
    if (this.j) {
      return this;
    }
    return new b(this.a, this.o, this.p, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, true, this.k, this.l, this.m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ac.b
 * JD-Core Version:    0.7.0.1
 */