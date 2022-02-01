package com.tencent.luggage.wxa.h;

import com.tencent.luggage.wxa.ao.x;
import java.util.UUID;

public final class b
{
  public static final int a;
  public static final UUID b = new UUID(0L, 0L);
  public static final UUID c = new UUID(1186680826959645954L, -5988876978535335093L);
  public static final UUID d = new UUID(-1301668207276963122L, -6645017420763422227L);
  public static final UUID e = new UUID(-7348484286925749626L, -6083546864340672619L);
  
  static
  {
    int i;
    if (x.a < 23) {
      i = 1020;
    } else {
      i = 6396;
    }
    a = i;
  }
  
  public static long a(long paramLong)
  {
    long l = paramLong;
    if (paramLong != -9223372036854775807L)
    {
      if (paramLong == -9223372036854775808L) {
        return paramLong;
      }
      l = paramLong / 1000L;
    }
    return l;
  }
  
  public static long b(long paramLong)
  {
    long l = paramLong;
    if (paramLong != -9223372036854775807L)
    {
      if (paramLong == -9223372036854775808L) {
        return paramLong;
      }
      l = paramLong * 1000L;
    }
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.h.b
 * JD-Core Version:    0.7.0.1
 */