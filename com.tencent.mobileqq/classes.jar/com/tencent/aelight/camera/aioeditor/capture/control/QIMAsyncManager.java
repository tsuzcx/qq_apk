package com.tencent.aelight.camera.aioeditor.capture.control;

import android.os.Looper;
import com.tencent.aelight.camera.aioeditor.capture.IQIMManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public abstract class QIMAsyncManager
  extends IQIMManager
{
  private volatile boolean a = false;
  
  public void a()
  {
    for (;;)
    {
      try
      {
        bool1 = this.a;
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
          QIMAsyncManager.1 local1 = new QIMAsyncManager.1(this);
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
  
  public void b() {}
  
  public void c()
  {
    try
    {
      boolean bool = this.a;
      if (bool) {
        return;
      }
      d();
      this.a = true;
      return;
    }
    finally {}
  }
  
  protected abstract void d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.control.QIMAsyncManager
 * JD-Core Version:    0.7.0.1
 */