package com.tencent.beacon.core.strategy;

import android.content.Context;
import com.tencent.beacon.core.a.a.c;
import com.tencent.beacon.core.d.i;
import java.util.Date;

final class a$1
  implements Runnable
{
  a$1(String paramString1, String paramString2, Context paramContext) {}
  
  public final void run()
  {
    String str = this.a;
    try
    {
      l1 = i.a(this.b).getTime() / 1000L;
      long l2 = l1;
      if (l1 == 0L) {
        l2 = new Date().getTime() / 1000L + 86400L;
      }
      c.a(this.c, "sid", new Object[] { str, Long.valueOf(l2) });
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1 = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.beacon.core.strategy.a.1
 * JD-Core Version:    0.7.0.1
 */