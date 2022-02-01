package com.tencent.luggage.wxa.z;

import com.tencent.luggage.wxa.ao.a;
import com.tencent.luggage.wxa.h.x;
import com.tencent.luggage.wxa.h.x.a;
import com.tencent.luggage.wxa.h.x.b;

public final class m
  extends x
{
  private static final Object b = new Object();
  private final long c;
  private final long d;
  private final long e;
  private final long f;
  private final long g;
  private final long h;
  private final boolean i;
  private final boolean j;
  
  public m(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.c = paramLong1;
    this.d = paramLong2;
    this.e = paramLong3;
    this.f = paramLong4;
    this.g = paramLong5;
    this.h = paramLong6;
    this.i = paramBoolean1;
    this.j = paramBoolean2;
  }
  
  public m(long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(-9223372036854775807L, -9223372036854775807L, paramLong1, paramLong2, paramLong3, paramLong4, paramBoolean1, paramBoolean2);
  }
  
  public m(long paramLong, boolean paramBoolean)
  {
    this(paramLong, paramLong, 0L, 0L, paramBoolean, false);
  }
  
  public int a(Object paramObject)
  {
    if (b.equals(paramObject)) {
      return 0;
    }
    return -1;
  }
  
  public x.a a(int paramInt, x.a parama, boolean paramBoolean)
  {
    a.a(paramInt, 0, 1);
    Object localObject;
    if (paramBoolean) {
      localObject = b;
    } else {
      localObject = null;
    }
    return parama.a(localObject, localObject, 0, this.e, -this.g);
  }
  
  public x.b a(int paramInt, x.b paramb, boolean paramBoolean, long paramLong)
  {
    a.a(paramInt, 0, 1);
    Object localObject;
    if (paramBoolean) {
      localObject = b;
    } else {
      localObject = null;
    }
    long l2 = this.h;
    long l1 = l2;
    if (this.j)
    {
      paramLong = l2 + paramLong;
      l1 = paramLong;
      if (paramLong > this.f) {
        l1 = -9223372036854775807L;
      }
    }
    return paramb.a(localObject, this.c, this.d, this.i, this.j, l1, this.f, 0, 0, this.g);
  }
  
  public int b()
  {
    return 1;
  }
  
  public int c()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.z.m
 * JD-Core Version:    0.7.0.1
 */