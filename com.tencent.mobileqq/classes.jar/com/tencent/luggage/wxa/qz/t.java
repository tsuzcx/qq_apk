package com.tencent.luggage.wxa.qz;

import android.os.Looper;
import android.os.Process;

@Deprecated
public class t
{
  private static s a;
  
  public static void a(int paramInt)
  {
    try
    {
      Process.setThreadPriority(paramInt);
      o.d("MicroMsg.MMHandlerThread", "setCurrentPriority to %d ok", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception localException)
    {
      o.d("MicroMsg.MMHandlerThread", "setCurrentPriority to %d fail, %s", new Object[] { Integer.valueOf(paramInt), localException.getMessage() });
      o.a("MicroMsg.MMHandlerThread", localException, "", new Object[0]);
    }
  }
  
  public static void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    b().a(paramRunnable);
  }
  
  public static void a(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable == null) {
      return;
    }
    b().b(paramRunnable, paramLong);
  }
  
  public static boolean a()
  {
    return Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId();
  }
  
  private static s b()
  {
    if (a == null) {
      a = new s(Looper.getMainLooper());
    }
    return a;
  }
  
  public static void b(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    b().b(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.t
 * JD-Core Version:    0.7.0.1
 */