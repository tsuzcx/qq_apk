package com.tencent.map.sdk.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ol
{
  private static ScheduledExecutorService a = Executors.newScheduledThreadPool(10);
  private static ExecutorService b = new ThreadPoolExecutor(1, 2147483647, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
  private static final ol.b c = new ol.b("dispatch_default");
  private static final Handler d = new Handler(Looper.getMainLooper());
  
  static
  {
    os.b("DispatchUtil");
  }
  
  public static <T> ol.b a(ol.e<T> parame)
  {
    os.a("DispatchUtil").a();
    c.a(parame);
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.ol
 * JD-Core Version:    0.7.0.1
 */