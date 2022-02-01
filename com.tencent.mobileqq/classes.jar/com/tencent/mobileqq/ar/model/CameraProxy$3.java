package com.tencent.mobileqq.ar.model;

import com.tencent.mobileqq.ar.arengine.ARCamera;
import com.tencent.qphone.base.util.QLog;

class CameraProxy$3
  implements Runnable
{
  CameraProxy$3(CameraProxy paramCameraProxy) {}
  
  public void run()
  {
    if ((CameraProxy.a(this.this$0) != 3) || (CameraProxy.a(this.this$0) == null))
    {
      QLog.i("CameraProxy", 2, "cancel to close camera. next mCurCameraState = " + CameraProxy.a(this.this$0));
      return;
    }
    if (CameraProxy.a(this.this$0)) {
      CameraProxy.a(this.this$0).a();
    }
    CameraProxy.a(this.this$0, false);
    CameraProxy.a(this.this$0).a();
    if (CameraProxy.a(this.this$0) != 3)
    {
      QLog.i("CameraProxy", 2, "cancel to close camera. next mCurCameraState = " + CameraProxy.a(this.this$0));
      return;
    }
    CameraProxy.a(this.this$0, 0);
    CameraProxy.a(this.this$0, null);
    CameraProxy.e(this.this$0, 0);
    QLog.i("CameraProxy", 2, "closeCamera successfully. mCurCameraState = " + CameraProxy.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.CameraProxy.3
 * JD-Core Version:    0.7.0.1
 */