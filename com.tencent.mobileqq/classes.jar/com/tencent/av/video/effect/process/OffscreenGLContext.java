package com.tencent.av.video.effect.process;

import android.os.Handler;
import android.os.HandlerThread;

public class OffscreenGLContext
{
  private Handler mHandler;
  private OffscreenSurface mOffscreenSurface;
  
  public OffscreenGLContext()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("MyOffscreenGLThread");
    ((StringBuilder)localObject).append((int)(Math.random() * 100.0D));
    localObject = new HandlerThread(((StringBuilder)localObject).toString());
    ((HandlerThread)localObject).start();
    this.mHandler = new Handler(((HandlerThread)localObject).getLooper());
    this.mHandler.post(new OffscreenGLContext.1(this));
  }
  
  public void destroy()
  {
    Handler localHandler = this.mHandler;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.mHandler.post(new OffscreenGLContext.2(this));
    }
  }
  
  public void post(Runnable paramRunnable)
  {
    Handler localHandler = this.mHandler;
    if ((localHandler != null) && (paramRunnable != null)) {
      localHandler.post(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.video.effect.process.OffscreenGLContext
 * JD-Core Version:    0.7.0.1
 */