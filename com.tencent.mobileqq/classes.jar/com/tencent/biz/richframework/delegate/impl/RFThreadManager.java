package com.tencent.biz.richframework.delegate.impl;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.biz.richframework.delegate.IThreadManagerDelegate;

public class RFThreadManager
{
  public static int DB = dbType();
  public static int FILE = fileType();
  public static int Normal = ;
  private static Handler mSerialThreadHandler;
  private static IThreadManagerDelegate mThreadImpl;
  private static Handler mUIHandler;
  
  private static int dbType()
  {
    IThreadManagerDelegate localIThreadManagerDelegate = mThreadImpl;
    if (localIThreadManagerDelegate != null) {
      return localIThreadManagerDelegate.getDBType();
    }
    return 0;
  }
  
  public static void execute(Runnable paramRunnable)
  {
    execute(paramRunnable, Normal);
  }
  
  public static void execute(Runnable paramRunnable, int paramInt)
  {
    if (getThreadImpl() != null)
    {
      getThreadImpl().execute(paramRunnable, paramInt);
      return;
    }
    ThreadPoolUtil.addRunnable(paramRunnable);
  }
  
  private static int fileType()
  {
    IThreadManagerDelegate localIThreadManagerDelegate = mThreadImpl;
    if (localIThreadManagerDelegate != null) {
      return localIThreadManagerDelegate.getFileType();
    }
    return 0;
  }
  
  public static Handler getSerialThreadHandler()
  {
    if (mSerialThreadHandler == null)
    {
      HandlerThread localHandlerThread = new HandlerThread("RFSerialThread");
      localHandlerThread.start();
      mSerialThreadHandler = new Handler(localHandlerThread.getLooper());
    }
    return mSerialThreadHandler;
  }
  
  public static IThreadManagerDelegate getThreadImpl()
  {
    return mThreadImpl;
  }
  
  public static Handler getUIHandler()
  {
    if (mUIHandler == null) {
      mUIHandler = new Handler(Looper.getMainLooper());
    }
    return mUIHandler;
  }
  
  private static int networkType()
  {
    IThreadManagerDelegate localIThreadManagerDelegate = mThreadImpl;
    if (localIThreadManagerDelegate != null) {
      return localIThreadManagerDelegate.getNetWorkType();
    }
    return 0;
  }
  
  private static int normalType()
  {
    IThreadManagerDelegate localIThreadManagerDelegate = mThreadImpl;
    if (localIThreadManagerDelegate != null) {
      return localIThreadManagerDelegate.getNormalType();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.delegate.impl.RFThreadManager
 * JD-Core Version:    0.7.0.1
 */