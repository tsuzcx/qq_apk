package com.tencent.luggage.wxa.ac;

import androidx.annotation.NonNull;

public final class b$a
  implements Comparable<Long>
{
  public final String a;
  public final long b;
  public final int c;
  public final long d;
  public final boolean e;
  public final String f;
  public final String g;
  public final long h;
  public final long i;
  
  public b$a(String paramString1, long paramLong1, int paramInt, long paramLong2, boolean paramBoolean, String paramString2, String paramString3, long paramLong3, long paramLong4)
  {
    this.a = paramString1;
    this.b = paramLong1;
    this.c = paramInt;
    this.d = paramLong2;
    this.e = paramBoolean;
    this.f = paramString2;
    this.g = paramString3;
    this.h = paramLong3;
    this.i = paramLong4;
  }
  
  public b$a(String paramString, long paramLong1, long paramLong2)
  {
    this(paramString, 0L, -1, -9223372036854775807L, false, null, null, paramLong1, paramLong2);
  }
  
  public int a(@NonNull Long paramLong)
  {
    if (this.d > paramLong.longValue()) {
      return 1;
    }
    if (this.d < paramLong.longValue()) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ac.b.a
 * JD-Core Version:    0.7.0.1
 */