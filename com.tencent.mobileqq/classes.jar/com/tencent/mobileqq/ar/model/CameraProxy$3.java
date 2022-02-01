package com.tencent.mobileqq.ar.model;

import aoyz;
import apek;
import com.tencent.qphone.base.util.QLog;

public class CameraProxy$3
  implements Runnable
{
  public CameraProxy$3(apek paramapek) {}
  
  public void run()
  {
    if ((apek.a(this.this$0) != 3) || (apek.a(this.this$0) == null))
    {
      QLog.i("CameraProxy", 2, "cancel to close camera. next mCurCameraState = " + apek.a(this.this$0));
      return;
    }
    if (apek.a(this.this$0)) {
      apek.a(this.this$0).a();
    }
    apek.a(this.this$0, false);
    apek.a(this.this$0).a();
    if (apek.a(this.this$0) != 3)
    {
      QLog.i("CameraProxy", 2, "cancel to close camera. next mCurCameraState = " + apek.a(this.this$0));
      return;
    }
    apek.a(this.this$0, 0);
    apek.a(this.this$0, null);
    apek.e(this.this$0, 0);
    QLog.i("CameraProxy", 2, "closeCamera successfully. mCurCameraState = " + apek.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.CameraProxy.3
 * JD-Core Version:    0.7.0.1
 */