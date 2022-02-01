package com.tencent.falco.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;

public class ThreadCenter$CoreHandler
{
  static final int MAX_LIFE = 300000;
  Handler handler;
  HandlerThread handlerThread;
  long lastPost = 0L;
  boolean needIdleCheck = true;
  
  public ThreadCenter$CoreHandler(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.handlerThread = new HandlerThread(paramString);
      this.handlerThread.start();
      this.handler = new Handler(this.handlerThread.getLooper());
      return;
    }
    throw new RuntimeException("Handle ID empty!");
  }
  
  public Handler getHandler()
  {
    this.needIdleCheck = false;
    return this.handler;
  }
  
  public boolean isIdle()
  {
    return (this.needIdleCheck) && (System.currentTimeMillis() - this.lastPost > 300000L);
  }
  
  public void post(Runnable paramRunnable, boolean paramBoolean)
  {
    this.lastPost = System.currentTimeMillis();
    if (paramBoolean)
    {
      this.handler.postAtFrontOfQueue(paramRunnable);
      return;
    }
    this.handler.post(paramRunnable);
  }
  
  public void postDelayed(Runnable paramRunnable, long paramLong)
  {
    this.lastPost = (System.currentTimeMillis() + paramLong);
    this.handler.postDelayed(paramRunnable, paramLong);
  }
  
  public void quitThread()
  {
    if (this.handlerThread.isAlive()) {
      this.handlerThread.quit();
    }
  }
  
  public void removeTask(Runnable paramRunnable)
  {
    this.handler.removeCallbacks(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.utils.ThreadCenter.CoreHandler
 * JD-Core Version:    0.7.0.1
 */