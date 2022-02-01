package com.tencent.aelight.camera.ae.control;

import android.os.Looper;
import com.tencent.aelight.camera.aioeditor.capture.control.CaptureAsyncControl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public abstract class AEQIMAsyncManager
  extends IAEQIMManager
{
  private static final String TAG = "QIMAsyncManager";
  private volatile boolean inited = false;
  
  public void forceInit()
  {
    try
    {
      boolean bool = this.inited;
      if (bool) {
        return;
      }
      initIndeed();
      this.inited = true;
      return;
    }
    finally {}
  }
  
  protected abstract void initIndeed();
  
  public void onDestroy() {}
  
  public void onInit()
  {
    for (;;)
    {
      try
      {
        bool1 = this.inited;
        if (bool1) {
          return;
        }
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          bool1 = true;
          boolean bool2 = CaptureAsyncControl.a(bool1);
          if (bool2) {
            return;
          }
          AEQIMAsyncManager.1 local1 = new AEQIMAsyncManager.1(this);
          if (QLog.isDevelopLevel()) {
            QLog.d("QIMAsyncManager", 4, new Object[] { "onInit, async:", Boolean.valueOf(bool1) });
          }
          if (bool1) {
            ThreadManager.excute(local1, 64, null, false);
          } else {
            local1.run();
          }
          return;
        }
      }
      finally {}
      boolean bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.control.AEQIMAsyncManager
 * JD-Core Version:    0.7.0.1
 */