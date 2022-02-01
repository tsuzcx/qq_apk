package com.tencent.android.gldrawable.api.base;

import android.os.HandlerThread;

public class AutoReleaseThreadHandler
{
  protected static final long FIRST_TIMEOUT = 2000L;
  protected static final long SECOND_TIMEOUT = 1000L;
  private static final String TAG = "AutoReleaseHandler";
  private volatile AutoReleaseThreadHandler.AutoReleasHandler decodingThreadHandler;
  
  public void post(Runnable paramRunnable)
  {
    try
    {
      if ((this.decodingThreadHandler == null) || (!AutoReleaseThreadHandler.AutoReleasHandler.access$000(this.decodingThreadHandler)))
      {
        HandlerThread localHandlerThread = new HandlerThread("Auto-Release ThreadHandler", 10);
        localHandlerThread.start();
        this.decodingThreadHandler = new AutoReleaseThreadHandler.AutoReleasHandler(localHandlerThread);
      }
      this.decodingThreadHandler.waitQuit();
      this.decodingThreadHandler.post(paramRunnable);
      return;
    }
    catch (OutOfMemoryError paramRunnable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.base.AutoReleaseThreadHandler
 * JD-Core Version:    0.7.0.1
 */