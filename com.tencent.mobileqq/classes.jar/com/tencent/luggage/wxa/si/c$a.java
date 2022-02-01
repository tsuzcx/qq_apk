package com.tencent.luggage.wxa.si;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.luggage.wxa.sj.i;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class c$a
  extends ThreadPoolExecutor
  implements a.a
{
  c$a(c paramc, int paramInt)
  {
    super(paramInt, paramInt, 2147483647L, TimeUnit.HOURS, new LinkedBlockingQueue(), new c.a.1(paramc), new c.a.2(paramc));
  }
  
  public void a(i<?> parami)
  {
    long l = parami.getDelay(TimeUnit.MILLISECONDS);
    if (l <= 0L)
    {
      execute(parami);
      return;
    }
    c.a(this.a).sendMessageAtTime(c.a(this.a).obtainMessage(0, parami), SystemClock.uptimeMillis() + l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.si.c.a
 * JD-Core Version:    0.7.0.1
 */