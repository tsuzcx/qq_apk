package com.tencent.mobileqq.ar.model;

import apmp;
import apsa;
import com.tencent.qphone.base.util.QLog;

public class CameraProxy$3
  implements Runnable
{
  public CameraProxy$3(apsa paramapsa) {}
  
  public void run()
  {
    if ((apsa.a(this.this$0) != 3) || (apsa.a(this.this$0) == null))
    {
      QLog.i("CameraProxy", 2, "cancel to close camera. next mCurCameraState = " + apsa.a(this.this$0));
      return;
    }
    if (apsa.a(this.this$0)) {
      apsa.a(this.this$0).a();
    }
    apsa.a(this.this$0, false);
    apsa.a(this.this$0).a();
    if (apsa.a(this.this$0) != 3)
    {
      QLog.i("CameraProxy", 2, "cancel to close camera. next mCurCameraState = " + apsa.a(this.this$0));
      return;
    }
    apsa.a(this.this$0, 0);
    apsa.a(this.this$0, null);
    apsa.e(this.this$0, 0);
    QLog.i("CameraProxy", 2, "closeCamera successfully. mCurCameraState = " + apsa.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.CameraProxy.3
 * JD-Core Version:    0.7.0.1
 */