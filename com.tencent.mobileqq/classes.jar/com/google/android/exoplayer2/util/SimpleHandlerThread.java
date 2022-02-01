package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.HandlerThread;

public class SimpleHandlerThread
  extends HandlerThread
{
  private Handler mHandler;
  
  public SimpleHandlerThread(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  public void postJob(Runnable paramRunnable)
  {
    this.mHandler.post(paramRunnable);
  }
  
  public void start()
  {
    try
    {
      super.start();
      this.mHandler = new Handler(getLooper());
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.util.SimpleHandlerThread
 * JD-Core Version:    0.7.0.1
 */