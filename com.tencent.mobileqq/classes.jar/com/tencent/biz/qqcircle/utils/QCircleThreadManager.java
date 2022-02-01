package com.tencent.biz.qqcircle.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.ThreadFactory;

public class QCircleThreadManager
{
  private static volatile QCircleThreadManager a;
  private static final ThreadFactory d = new QCircleThreadManager.1();
  private Handler b;
  private Handler c;
  
  private QCircleThreadManager()
  {
    HandlerThread localHandlerThread = new HandlerThread("ReportHandler");
    localHandlerThread.start();
    this.c = new Handler(localHandlerThread.getLooper());
    this.b = new Handler(Looper.getMainLooper());
  }
  
  public static QCircleThreadManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QCircleThreadManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(Runnable paramRunnable)
  {
    Handler localHandler = b();
    if (localHandler != null)
    {
      if (paramRunnable == null) {
        return;
      }
      localHandler.post(paramRunnable);
    }
  }
  
  public Handler b()
  {
    return this.c;
  }
  
  public Handler c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleThreadManager
 * JD-Core Version:    0.7.0.1
 */