package com.tencent.av.camera;

import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import ljb;
import ljk;

class CameraUtils$NoPreviewRunnable
  implements Runnable
{
  public long a;
  
  CameraUtils$NoPreviewRunnable(CameraUtils paramCameraUtils) {}
  
  public void run()
  {
    boolean bool = false;
    if (this.this$0.jdField_a_of_type_Ljk != null) {
      bool = this.this$0.jdField_a_of_type_Ljk.d();
    }
    if (AudioHelper.f()) {
      QLog.w("CameraUtils", 1, "NoPreviewRunnable.run, seq[" + this.a + "], isCameraOpened[" + bool + "], seq[" + this.a + "]");
    }
    if (this.this$0.jdField_a_of_type_Ljb != null) {
      this.this$0.jdField_a_of_type_Ljb.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.camera.CameraUtils.NoPreviewRunnable
 * JD-Core Version:    0.7.0.1
 */