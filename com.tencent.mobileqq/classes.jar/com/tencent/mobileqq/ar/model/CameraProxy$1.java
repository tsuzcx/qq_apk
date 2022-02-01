package com.tencent.mobileqq.ar.model;

import com.tencent.mobileqq.ar.arengine.ARCamera;
import com.tencent.qphone.base.util.QLog;

class CameraProxy$1
  implements Runnable
{
  CameraProxy$1(CameraProxy paramCameraProxy, int paramInt) {}
  
  public void run()
  {
    if ((CameraProxy.a(this.this$0) == 1) && (CameraProxy.b(this.this$0) != null)) {}
    for (;;)
    {
      try
      {
        QLog.i("CameraProxy", 2, "openCameraAync.");
        i = -3;
        if (CameraProxy.c(this.this$0) < 10)
        {
          CameraProxy.d(this.this$0);
          System.currentTimeMillis();
          if (CameraProxy.c(this.this$0) == 1) {
            i = CameraProxy.b(this.this$0).a(this.a);
          } else {
            i = CameraProxy.b(this.this$0).e();
          }
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("try to open camera. mCurOpenCameraTryTimes = ");
          localStringBuilder1.append(CameraProxy.c(this.this$0));
          localStringBuilder1.append(", MAX_OPEN_CAMERA_TRY_TIMES = ");
          localStringBuilder1.append(10);
          QLog.i("CameraProxy", 2, localStringBuilder1.toString());
          if (CameraProxy.b(this.this$0) == null) {
            break label536;
          }
          if (CameraProxy.a(this.this$0) == 1) {
            break label542;
          }
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("cancel to open camera. next mCurCameraState = ");
          localStringBuilder1.append(CameraProxy.a(this.this$0));
          QLog.i("CameraProxy", 2, localStringBuilder1.toString());
          return;
          Thread.currentThread();
          Thread.sleep(CameraProxy.e(this.this$0));
          if (CameraProxy.a(this.this$0) == 1) {
            continue;
          }
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("cancel to open camera. next mCurCameraState = ");
          localStringBuilder1.append(CameraProxy.a(this.this$0));
          QLog.i("CameraProxy", 2, localStringBuilder1.toString());
          return;
        }
        if (i == 0)
        {
          CameraProxy.a(this.this$0, 2);
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("openCameraAync successfully. mCurCameraState = ");
          localStringBuilder1.append(CameraProxy.a(this.this$0));
          QLog.i("CameraProxy", 2, localStringBuilder1.toString());
          return;
        }
        CameraProxy.a(this.this$0, 0);
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("openCameraAync failed. retCode = ");
        localStringBuilder1.append(i);
        localStringBuilder1.append(", mCurCameraState = ");
        localStringBuilder1.append(CameraProxy.a(this.this$0));
        QLog.i("CameraProxy", 2, localStringBuilder1.toString());
        if (i != -1) {
          break label549;
        }
        CameraProxy.a(this.this$0, false, 0, 1);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        StringBuilder localStringBuilder3 = new StringBuilder();
        localStringBuilder3.append("InterruptedException = ");
        localStringBuilder3.append(localInterruptedException.getMessage());
        QLog.i("CameraProxy", 1, localStringBuilder3.toString());
        CameraProxy.a(this.this$0, 0);
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("openCameraAync failed. mCurCameraState = ");
        localStringBuilder2.append(CameraProxy.a(this.this$0));
        QLog.i("CameraProxy", 2, localStringBuilder2.toString());
        return;
      }
      CameraProxy.a(this.this$0, false, 0, 2);
      return;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("cancel to open camera. next mCurCameraState = ");
      localStringBuilder2.append(CameraProxy.a(this.this$0));
      QLog.i("CameraProxy", 2, localStringBuilder2.toString());
      return;
      label536:
      int i = -3;
      continue;
      label542:
      if (i == 0)
      {
        continue;
        label549:
        if (i != -2) {
          if (i != -3) {}
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.CameraProxy.1
 * JD-Core Version:    0.7.0.1
 */