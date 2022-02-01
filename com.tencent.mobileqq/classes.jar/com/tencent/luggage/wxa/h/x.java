package com.tencent.luggage.wxa.h;

import android.util.Pair;
import com.tencent.luggage.wxa.ao.a;

public abstract class x
{
  public static final x a = new x.1();
  
  public int a(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 == 2)
        {
          if (paramInt1 == b() - 1) {
            return 0;
          }
          return paramInt1 + 1;
        }
        throw new IllegalStateException();
      }
      return paramInt1;
    }
    if (paramInt1 == b() - 1) {
      return -1;
    }
    return paramInt1 + 1;
  }
  
  public final int a(int paramInt1, x.a parama, x.b paramb, int paramInt2)
  {
    int i = a(paramInt1, parama).c;
    if (a(i, paramb).g == paramInt1)
    {
      paramInt1 = a(i, paramInt2);
      if (paramInt1 == -1) {
        return -1;
      }
      return a(paramInt1, paramb).f;
    }
    return paramInt1 + 1;
  }
  
  public abstract int a(Object paramObject);
  
  public final Pair<Integer, Long> a(x.b paramb, x.a parama, int paramInt, long paramLong)
  {
    return a(paramb, parama, paramInt, paramLong, 0L);
  }
  
  public final Pair<Integer, Long> a(x.b paramb, x.a parama, int paramInt, long paramLong1, long paramLong2)
  {
    a.a(paramInt, 0, b());
    a(paramInt, paramb, false, paramLong2);
    paramLong2 = paramLong1;
    if (paramLong1 == -9223372036854775807L)
    {
      paramLong1 = paramb.a();
      paramLong2 = paramLong1;
      if (paramLong1 == -9223372036854775807L) {
        return null;
      }
    }
    paramInt = paramb.f;
    paramLong1 = paramb.c() + paramLong2;
    for (paramLong2 = a(paramInt, parama).a(); (paramLong2 != -9223372036854775807L) && (paramLong1 >= paramLong2) && (paramInt < paramb.g); paramLong2 = a(paramInt, parama).a())
    {
      paramLong1 -= paramLong2;
      paramInt += 1;
    }
    return Pair.create(Integer.valueOf(paramInt), Long.valueOf(paramLong1));
  }
  
  public final x.a a(int paramInt, x.a parama)
  {
    return a(paramInt, parama, false);
  }
  
  public abstract x.a a(int paramInt, x.a parama, boolean paramBoolean);
  
  public final x.b a(int paramInt, x.b paramb)
  {
    return a(paramInt, paramb, false);
  }
  
  public x.b a(int paramInt, x.b paramb, boolean paramBoolean)
  {
    return a(paramInt, paramb, paramBoolean, 0L);
  }
  
  public abstract x.b a(int paramInt, x.b paramb, boolean paramBoolean, long paramLong);
  
  public final boolean a()
  {
    return b() == 0;
  }
  
  public abstract int b();
  
  public final boolean b(int paramInt1, x.a parama, x.b paramb, int paramInt2)
  {
    return a(paramInt1, parama, paramb, paramInt2) == -1;
  }
  
  public abstract int c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.h.x
 * JD-Core Version:    0.7.0.1
 */