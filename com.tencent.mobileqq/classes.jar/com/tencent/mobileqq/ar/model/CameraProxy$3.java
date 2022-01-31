package com.tencent.mobileqq.ar.model;

import alfk;
import alkv;
import com.tencent.qphone.base.util.QLog;

public class CameraProxy$3
  implements Runnable
{
  public CameraProxy$3(alkv paramalkv) {}
  
  public void run()
  {
    if ((alkv.a(this.this$0) != 3) || (alkv.a(this.this$0) == null))
    {
      QLog.i("CameraProxy", 2, "cancel to close camera. next mCurCameraState = " + alkv.a(this.this$0));
      return;
    }
    if (alkv.a(this.this$0)) {
      alkv.a(this.this$0).a();
    }
    alkv.a(this.this$0, false);
    alkv.a(this.this$0).a();
    if (alkv.a(this.this$0) != 3)
    {
      QLog.i("CameraProxy", 2, "cancel to close camera. next mCurCameraState = " + alkv.a(this.this$0));
      return;
    }
    alkv.a(this.this$0, 0);
    alkv.a(this.this$0, null);
    alkv.e(this.this$0, 0);
    QLog.i("CameraProxy", 2, "closeCamera successfully. mCurCameraState = " + alkv.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.CameraProxy.3
 * JD-Core Version:    0.7.0.1
 */