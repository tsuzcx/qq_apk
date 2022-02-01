package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.qphone.base.util.QLog;

class CameraRendererable$1
  implements Runnable
{
  CameraRendererable$1(CameraRendererable paramCameraRendererable) {}
  
  public void run()
  {
    if (CameraRendererable.a(this.this$0) != null) {
      try
      {
        CameraRendererable.a(this.this$0).b();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d(CameraRendererable.j(), 2, "requestRender", localException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.CameraRendererable.1
 * JD-Core Version:    0.7.0.1
 */