package com.tencent.mobileqq.ar.model;

import alfk;
import alkv;
import com.tencent.qphone.base.util.QLog;

public class CameraProxy$1
  implements Runnable
{
  public CameraProxy$1(alkv paramalkv, int paramInt) {}
  
  public void run()
  {
    if ((alkv.a(this.this$0) != 1) || (alkv.a(this.this$0) == null))
    {
      QLog.i("CameraProxy", 2, "cancel to open camera. next mCurCameraState = " + alkv.a(this.this$0));
      return;
    }
    int i;
    label165:
    label296:
    label341:
    do
    {
      for (;;)
      {
        try
        {
          QLog.i("CameraProxy", 2, "openCameraAync.");
          i = -3;
          if (alkv.b(this.this$0) >= 10) {
            break;
          }
          alkv.c(this.this$0);
          System.currentTimeMillis();
          if (alkv.b(this.this$0) == 1)
          {
            i = alkv.a(this.this$0).a(this.a);
            QLog.i("CameraProxy", 2, "try to open camera. mCurOpenCameraTryTimes = " + alkv.b(this.this$0) + ", MAX_OPEN_CAMERA_TRY_TIMES = " + 10);
            if (alkv.a(this.this$0) == null) {
              break label474;
            }
            if (alkv.a(this.this$0) == 1) {
              break label480;
            }
            QLog.i("CameraProxy", 2, "cancel to open camera. next mCurCameraState = " + alkv.a(this.this$0));
            return;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
          QLog.i("CameraProxy", 1, "InterruptedException = " + localInterruptedException.getMessage());
          alkv.a(this.this$0, 0);
          QLog.i("CameraProxy", 2, "openCameraAync failed. mCurCameraState = " + alkv.a(this.this$0));
          return;
        }
        i = alkv.a(this.this$0).e();
      }
      if (i != 0) {
        break;
      }
      alkv.a(this.this$0, 2);
      QLog.i("CameraProxy", 2, "openCameraAync successfully. mCurCameraState = " + alkv.a(this.this$0));
      return;
      Thread.currentThread();
      Thread.sleep(alkv.a(this.this$0));
    } while (alkv.a(this.this$0) == 1);
    QLog.i("CameraProxy", 2, "cancel to open camera. next mCurCameraState = " + alkv.a(this.this$0));
    return;
    alkv.a(this.this$0, 0);
    QLog.i("CameraProxy", 2, "openCameraAync failed. retCode = " + i + ", mCurCameraState = " + alkv.a(this.this$0));
    if (i == -1)
    {
      alkv.a(this.this$0, false, 0, 1);
      return;
    }
    for (;;)
    {
      alkv.a(this.this$0, false, 0, 2);
      return;
      label474:
      i = -3;
      break label165;
      label480:
      if (i != 0) {
        break label341;
      }
      break label296;
      if (i != -2) {
        if (i != -3) {
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.CameraProxy.1
 * JD-Core Version:    0.7.0.1
 */