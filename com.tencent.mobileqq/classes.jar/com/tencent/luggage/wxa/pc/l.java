package com.tencent.luggage.wxa.pc;

import android.os.Looper;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;

@Deprecated
public class l
{
  private static final Object a = new Object();
  private static volatile l.a b = null;
  
  public static l.a a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new l.a("Luggage.Common.ThreadUtil.WORKER_THREAD");
        }
      }
      finally {}
    }
    return b;
  }
  
  public static void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramRunnable.run();
      return;
    }
    f.a.a(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pc.l
 * JD-Core Version:    0.7.0.1
 */