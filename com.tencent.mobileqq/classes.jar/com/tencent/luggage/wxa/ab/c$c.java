package com.tencent.luggage.wxa.ab;

import android.os.SystemClock;
import com.tencent.luggage.wxa.al.a;
import com.tencent.luggage.wxa.z.n;

final class c$c
  extends a
{
  private int d = a(paramn.a(0));
  
  public c$c(n paramn, int[] paramArrayOfInt)
  {
    super(paramn, paramArrayOfInt);
  }
  
  public int a()
  {
    return this.d;
  }
  
  public void a(long paramLong)
  {
    paramLong = SystemClock.elapsedRealtime();
    if (!b(this.d, paramLong)) {
      return;
    }
    int i = this.b - 1;
    while (i >= 0)
    {
      if (!b(i, paramLong))
      {
        this.d = i;
        return;
      }
      i -= 1;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException();
    for (;;)
    {
      throw localIllegalStateException;
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  public Object c()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ab.c.c
 * JD-Core Version:    0.7.0.1
 */