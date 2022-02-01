package com.tencent.biz.qqcircle.immersive.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import java.util.concurrent.Executor;

public class QFSThreadUtils
{
  private static volatile Handler a;
  private static volatile Handler b;
  private static volatile Executor c;
  
  public static Handler a()
  {
    return new Handler(Looper.getMainLooper());
  }
  
  public static Handler a(String paramString)
  {
    paramString = ThreadManager.newFreeHandlerThread(paramString, 5);
    paramString.start();
    return new Handler(paramString.getLooper());
  }
  
  public static void a(Runnable paramRunnable)
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = a("FSThreadUtils");
        }
      }
      finally {}
    }
    a.post(paramRunnable);
  }
  
  public static void b(Runnable paramRunnable)
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = a();
        }
      }
      finally {}
    }
    b.post(paramRunnable);
  }
  
  public static boolean b()
  {
    return Looper.getMainLooper() == Looper.myLooper();
  }
  
  public static void c(Runnable paramRunnable)
  {
    if (c == null) {
      try
      {
        if (c == null)
        {
          int i = Runtime.getRuntime().availableProcessors();
          ThreadPoolParams localThreadPoolParams = new ThreadPoolParams();
          localThreadPoolParams.poolThreadName = "FSThreadUtils";
          localThreadPoolParams.corePoolsize = (i + 1);
          localThreadPoolParams.maxPooolSize = (i * 2 + 1);
          c = ThreadManager.newFreeThreadPool(localThreadPoolParams);
        }
      }
      finally {}
    }
    c.execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.utils.QFSThreadUtils
 * JD-Core Version:    0.7.0.1
 */