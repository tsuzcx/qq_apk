package com.tencent.av.video.effect.process;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class OffscreenGLContext
{
  private Handler mHandler;
  private OffscreenSurface mOffscreenSurface;
  
  public OffscreenGLContext()
  {
    HandlerThread localHandlerThread = new HandlerThread("MyOffscreenGLThread" + (int)(Math.random() * 100.0D));
    localHandlerThread.start();
    this.mHandler = new Handler(localHandlerThread.getLooper());
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        OffscreenGLContext.access$002(OffscreenGLContext.this, new OffscreenSurface());
      }
    });
  }
  
  public void destroy()
  {
    if (this.mHandler != null)
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          OffscreenGLContext.this.mOffscreenSurface.release();
          OffscreenGLContext.this.mHandler.getLooper().quit();
          OffscreenGLContext.access$102(OffscreenGLContext.this, null);
        }
      });
    }
  }
  
  public void post(Runnable paramRunnable)
  {
    if ((this.mHandler != null) && (paramRunnable != null)) {
      this.mHandler.post(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.video.effect.process.OffscreenGLContext
 * JD-Core Version:    0.7.0.1
 */