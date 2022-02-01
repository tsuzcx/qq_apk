package com.tencent.luggage.wxa.l;

import com.tencent.luggage.wxa.ao.x;

public final class a
  implements k
{
  public final int a;
  public final int[] b;
  public final long[] c;
  public final long[] d;
  public final long[] e;
  private final long f;
  
  public a(int[] paramArrayOfInt, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    this.b = paramArrayOfInt;
    this.c = paramArrayOfLong1;
    this.d = paramArrayOfLong2;
    this.e = paramArrayOfLong3;
    this.a = paramArrayOfInt.length;
    int i = this.a;
    if (i > 0)
    {
      this.f = (paramArrayOfLong2[(i - 1)] + paramArrayOfLong3[(i - 1)]);
      return;
    }
    this.f = 0L;
  }
  
  public int a(long paramLong)
  {
    return x.a(this.e, paramLong, true, true);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public long b()
  {
    return this.f;
  }
  
  public long b(long paramLong)
  {
    return this.c[a(paramLong)];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.l.a
 * JD-Core Version:    0.7.0.1
 */