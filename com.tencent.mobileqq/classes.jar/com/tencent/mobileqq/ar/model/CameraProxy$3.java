package com.tencent.mobileqq.ar.model;

import com.tencent.mobileqq.ar.arengine.ARCamera;
import com.tencent.qphone.base.util.QLog;

class CameraProxy$3
  implements Runnable
{
  CameraProxy$3(CameraProxy paramCameraProxy) {}
  
  public void run()
  {
    if ((CameraProxy.a(this.this$0) == 3) && (CameraProxy.a(this.this$0) != null))
    {
      if (CameraProxy.a(this.this$0)) {
        CameraProxy.a(this.this$0).a();
      }
      CameraProxy.a(this.this$0, false);
      CameraProxy.a(this.this$0).a();
      if (CameraProxy.a(this.this$0) != 3)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("cancel to close camera. next mCurCameraState = ");
        localStringBuilder.append(CameraProxy.a(this.this$0));
        QLog.i("CameraProxy", 2, localStringBuilder.toString());
        return;
      }
      CameraProxy.a(this.this$0, 0);
      CameraProxy.a(this.this$0, null);
      CameraProxy.e(this.this$0, 0);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("closeCamera successfully. mCurCameraState = ");
      localStringBuilder.append(CameraProxy.a(this.this$0));
      QLog.i("CameraProxy", 2, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancel to close camera. next mCurCameraState = ");
    localStringBuilder.append(CameraProxy.a(this.this$0));
    QLog.i("CameraProxy", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.CameraProxy.3
 * JD-Core Version:    0.7.0.1
 */