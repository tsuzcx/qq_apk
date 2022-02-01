package com.tencent.luggage.wxa.si;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.luggage.wxa.rz.c;
import com.tencent.luggage.wxa.rz.c.a;
import com.tencent.luggage.wxa.sj.i;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class b$a
  extends ThreadPoolExecutor
  implements a.a
{
  private int b;
  private int c;
  private int d = 1;
  
  b$a(b paramb, int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2, 10L, TimeUnit.MINUTES, new LinkedBlockingQueue(), new b.a.1(paramb), new b.a.2(paramb));
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public void a(i<?> parami)
  {
    long l = parami.getDelay(TimeUnit.MILLISECONDS);
    if (l <= 0L)
    {
      execute(parami);
      return;
    }
    b.a(this.a).sendMessageAtTime(b.a(this.a).obtainMessage(0, parami), SystemClock.uptimeMillis() + l);
  }
  
  protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    super.afterExecute(paramRunnable, paramThrowable);
    if (getQueue().isEmpty())
    {
      int i = getCorePoolSize();
      int j = this.b;
      if (i > j)
      {
        setCorePoolSize(j);
        this.d = 1;
        c.c.b("ColdPool", "reset to corePoolSize(%s)", new Object[] { Integer.valueOf(this.b) });
      }
    }
  }
  
  public void execute(Runnable paramRunnable)
  {
    int i = getCorePoolSize();
    if (getQueue().size() >= this.d * 10)
    {
      int j = i + 1;
      if (j <= this.c)
      {
        setCorePoolSize(j);
        c.c.b("ColdPool", "increment to expand cold pool; queue size=%s currentCoreSize=%s bufferSizeFactor=%s", new Object[] { Integer.valueOf(getQueue().size()), Integer.valueOf(i), Integer.valueOf(this.d) });
        this.d += 1;
      }
    }
    super.execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.si.b.a
 * JD-Core Version:    0.7.0.1
 */