package com.tencent.mobileqq.ar.model;

import apje;
import apoo;
import com.tencent.qphone.base.util.QLog;

public class CameraProxy$3
  implements Runnable
{
  public CameraProxy$3(apoo paramapoo) {}
  
  public void run()
  {
    if ((apoo.a(this.this$0) != 3) || (apoo.a(this.this$0) == null))
    {
      QLog.i("CameraProxy", 2, "cancel to close camera. next mCurCameraState = " + apoo.a(this.this$0));
      return;
    }
    if (apoo.a(this.this$0)) {
      apoo.a(this.this$0).a();
    }
    apoo.a(this.this$0, false);
    apoo.a(this.this$0).a();
    if (apoo.a(this.this$0) != 3)
    {
      QLog.i("CameraProxy", 2, "cancel to close camera. next mCurCameraState = " + apoo.a(this.this$0));
      return;
    }
    apoo.a(this.this$0, 0);
    apoo.a(this.this$0, null);
    apoo.e(this.this$0, 0);
    QLog.i("CameraProxy", 2, "closeCamera successfully. mCurCameraState = " + apoo.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.CameraProxy.3
 * JD-Core Version:    0.7.0.1
 */