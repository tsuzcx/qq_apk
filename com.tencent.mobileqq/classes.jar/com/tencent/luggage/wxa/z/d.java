package com.tencent.luggage.wxa.z;

public final class d
  implements l
{
  private final l[] a;
  
  public d(l[] paramArrayOfl)
  {
    this.a = paramArrayOfl;
  }
  
  public final boolean c(long paramLong)
  {
    boolean bool3 = false;
    boolean bool1;
    boolean bool4;
    do
    {
      long l = e();
      if (l == -9223372036854775808L) {
        return bool3;
      }
      l[] arrayOfl = this.a;
      int j = arrayOfl.length;
      int i = 0;
      boolean bool2;
      for (bool1 = false; i < j; bool1 = bool2)
      {
        l locall = arrayOfl[i];
        bool2 = bool1;
        if (locall.e() == l) {
          bool2 = bool1 | locall.c(paramLong);
        }
        i += 1;
      }
      bool4 = bool3 | bool1;
      bool3 = bool4;
    } while (bool1);
    return bool4;
  }
  
  public final long d()
  {
    l[] arrayOfl = this.a;
    int j = arrayOfl.length;
    int i = 0;
    for (long l1 = 9223372036854775807L; i < j; l1 = l2)
    {
      long l3 = arrayOfl[i].d();
      l2 = l1;
      if (l3 != -9223372036854775808L) {
        l2 = Math.min(l1, l3);
      }
      i += 1;
    }
    long l2 = l1;
    if (l1 == 9223372036854775807L) {
      l2 = -9223372036854775808L;
    }
    return l2;
  }
  
  public final long e()
  {
    l[] arrayOfl = this.a;
    int j = arrayOfl.length;
    int i = 0;
    for (long l1 = 9223372036854775807L; i < j; l1 = l2)
    {
      long l3 = arrayOfl[i].e();
      l2 = l1;
      if (l3 != -9223372036854775808L) {
        l2 = Math.min(l1, l3);
      }
      i += 1;
    }
    long l2 = l1;
    if (l1 == 9223372036854775807L) {
      l2 = -9223372036854775808L;
    }
    return l2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.z.d
 * JD-Core Version:    0.7.0.1
 */