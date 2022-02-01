package com.tencent.component.network.downloader;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class GlobalHandlerThread
{
  private static final byte[] INSTANCE_LOCK = new byte[0];
  private static volatile GlobalHandlerThread mInstance = null;
  private Handler mHandler;
  private HandlerThread mWorkThread;
  
  private GlobalHandlerThread(Context paramContext)
  {
    try
    {
      this.mWorkThread = new HandlerThread("download_async");
      this.mWorkThread.start();
      this.mHandler = new Handler(this.mWorkThread.getLooper());
      return;
    }
    catch (Exception paramContext)
    {
      this.mHandler = new Handler(Looper.getMainLooper());
    }
  }
  
  public static GlobalHandlerThread getInstance(Context paramContext)
  {
    if (mInstance == null) {}
    synchronized (INSTANCE_LOCK)
    {
      if (mInstance == null) {
        mInstance = new GlobalHandlerThread(paramContext);
      }
      return mInstance;
    }
  }
  
  public Handler getHandler()
  {
    return this.mHandler;
  }
  
  public Looper getLooper()
  {
    if (this.mWorkThread != null) {
      return this.mWorkThread.getLooper();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.downloader.GlobalHandlerThread
 * JD-Core Version:    0.7.0.1
 */