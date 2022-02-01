package com.tencent.liteav.basic.util;

import android.os.SystemClock;
import com.tencent.liteav.basic.log.TXCLog;
import java.util.concurrent.TimeUnit;

public class c
{
  private final String a;
  private final int b;
  private int c;
  private int d;
  private long e;
  
  public c(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = ((int)Math.max(paramInt, TimeUnit.SECONDS.toMillis(1L)));
    b();
  }
  
  public void a()
  {
    this.c += 1;
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.e;
    if (l2 == 0L)
    {
      this.e = SystemClock.elapsedRealtime();
      return;
    }
    if (l1 - l2 >= this.b)
    {
      float f = (this.c - this.d) * 1000.0F / (float)(l1 - l2);
      TXCLog.i("FPSMeter", "meter name: %s fps: %.2f", new Object[] { this.a, Float.valueOf(f) });
      this.e = l1;
      this.d = this.c;
    }
  }
  
  public void b()
  {
    this.c = 0;
    this.d = 0;
    this.e = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.util.c
 * JD-Core Version:    0.7.0.1
 */