package com.tencent.av.camera;

import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import ljd;
import ljp;

class CameraUtils$NoPreviewRunnable
  implements Runnable
{
  public long a;
  
  CameraUtils$NoPreviewRunnable(CameraUtils paramCameraUtils) {}
  
  public void run()
  {
    boolean bool = false;
    if (CameraUtils.a(this.this$0) != null) {
      bool = CameraUtils.a(this.this$0).d();
    }
    if (AudioHelper.f()) {
      QLog.w("CameraUtils", 1, "NoPreviewRunnable.run, seq[" + this.a + "], isCameraOpened[" + bool + "], seq[" + this.a + "]");
    }
    if (CameraUtils.a(this.this$0) != null) {
      CameraUtils.a(this.this$0).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.camera.CameraUtils.NoPreviewRunnable
 * JD-Core Version:    0.7.0.1
 */