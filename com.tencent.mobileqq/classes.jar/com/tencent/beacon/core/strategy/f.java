package com.tencent.beacon.core.strategy;

import android.content.Context;
import com.tencent.beacon.core.a.a.c;
import com.tencent.beacon.core.e.b;
import java.util.Date;

class f
  implements Runnable
{
  f(g paramg, String paramString1, String paramString2, Context paramContext) {}
  
  public void run()
  {
    String str = this.a;
    try
    {
      Date localDate = b.d(this.b);
      if (localDate == null) {
        break label86;
      }
      l1 = localDate.getTime() / 1000L;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l2;
        long l1 = 0L;
      }
    }
    l2 = l1;
    if (l1 == 0L) {
      l2 = new Date().getTime() / 1000L + 86400L;
    }
    c.a(this.c, "sid", new Object[] { str, Long.valueOf(l2) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.strategy.f
 * JD-Core Version:    0.7.0.1
 */