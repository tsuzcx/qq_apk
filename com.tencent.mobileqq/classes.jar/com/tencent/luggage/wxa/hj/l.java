package com.tencent.luggage.wxa.hj;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.ExecutorService;

class l
{
  static l.d b = new l.d(null);
  private static volatile l c;
  private static com.tencent.luggage.wxa.hk.b d;
  private static final HandlerThread f = new HandlerThread("IPCThreadPool#WorkerThread");
  private static final Object g;
  ExecutorService a;
  private Handler e = new Handler(f.getLooper());
  
  static
  {
    f.start();
    g = new Object();
  }
  
  private l()
  {
    if (d == null) {
      d = new l.a();
    }
    this.a = d.a();
    com.tencent.luggage.wxa.hs.b.a("IPC.IPCThreadPool", "initialize IPCInvoker IPCThreadPool(hashCode : %s)", new Object[] { Integer.valueOf(hashCode()) });
  }
  
  public static Handler a()
  {
    return new Handler(f.getLooper());
  }
  
  public static boolean a(Runnable paramRunnable)
  {
    return a(paramRunnable, "unknown");
  }
  
  public static boolean a(Runnable paramRunnable, String paramString)
  {
    if (paramRunnable == null) {
      return false;
    }
    c().a.submit(paramRunnable);
    return true;
  }
  
  private static l c()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new l();
        }
      }
      finally {}
    }
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hj.l
 * JD-Core Version:    0.7.0.1
 */