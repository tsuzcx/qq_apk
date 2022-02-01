package com.tencent.mobileqq.activity.aio.doodle;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;

class DoodleDrawer$DrawThread
{
  private Handler b;
  
  DoodleDrawer$DrawThread(DoodleDrawer paramDoodleDrawer) {}
  
  public void a()
  {
    if (this.b == null)
    {
      HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("DoodleDrawerThread", 0);
      localHandlerThread.start();
      this.b = new Handler(localHandlerThread.getLooper());
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    if (paramRunnable != null)
    {
      Handler localHandler = this.b;
      if (localHandler == null) {
        return;
      }
      localHandler.post(paramRunnable);
    }
  }
  
  public void b()
  {
    Handler localHandler = this.b;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.b.getLooper().quit();
      this.b = null;
    }
  }
  
  public void c()
  {
    Handler localHandler = this.b;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleDrawer.DrawThread
 * JD-Core Version:    0.7.0.1
 */