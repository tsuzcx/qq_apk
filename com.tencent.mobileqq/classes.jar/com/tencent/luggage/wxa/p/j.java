package com.tencent.luggage.wxa.p;

import androidx.annotation.Nullable;

public final class j
{
  public final int a;
  public final int b;
  public final long c;
  public final long d;
  public final long e;
  public final com.tencent.luggage.wxa.h.k f;
  public final int g;
  @Nullable
  public final long[] h;
  @Nullable
  public final long[] i;
  public final int j;
  @Nullable
  private final k[] k;
  
  public j(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, com.tencent.luggage.wxa.h.k paramk, int paramInt3, @Nullable k[] paramArrayOfk, int paramInt4, @Nullable long[] paramArrayOfLong1, @Nullable long[] paramArrayOfLong2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramLong1;
    this.d = paramLong2;
    this.e = paramLong3;
    this.f = paramk;
    this.g = paramInt3;
    this.k = paramArrayOfk;
    this.j = paramInt4;
    this.h = paramArrayOfLong1;
    this.i = paramArrayOfLong2;
  }
  
  public k a(int paramInt)
  {
    k[] arrayOfk = this.k;
    if (arrayOfk == null) {
      return null;
    }
    return arrayOfk[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.p.j
 * JD-Core Version:    0.7.0.1
 */