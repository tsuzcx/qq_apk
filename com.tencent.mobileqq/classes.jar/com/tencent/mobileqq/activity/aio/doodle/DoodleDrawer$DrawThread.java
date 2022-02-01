package com.tencent.mobileqq.activity.aio.doodle;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;

class DoodleDrawer$DrawThread
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  
  DoodleDrawer$DrawThread(DoodleDrawer paramDoodleDrawer) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null)
    {
      HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("DoodleDrawerThread", 0);
      localHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper());
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    if (paramRunnable != null)
    {
      Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
      if (localHandler == null) {
        return;
      }
      localHandler.post(paramRunnable);
    }
  }
  
  public void b()
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.getLooper().quit();
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
  
  public void c()
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleDrawer.DrawThread
 * JD-Core Version:    0.7.0.1
 */