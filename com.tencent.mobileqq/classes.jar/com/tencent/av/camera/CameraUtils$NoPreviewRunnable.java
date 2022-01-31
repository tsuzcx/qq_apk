package com.tencent.av.camera;

import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import lmn;

class CameraUtils$NoPreviewRunnable
  implements Runnable
{
  public long a;
  
  CameraUtils$NoPreviewRunnable(CameraUtils paramCameraUtils) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Lmn != null) {}
    for (boolean bool = this.this$0.jdField_a_of_type_Lmn.c();; bool = false)
    {
      if (AudioHelper.e()) {
        QLog.w("CameraUtils", 1, "NoPreviewRunnable.run, seq[" + this.a + "], isCameraOpened[" + bool + "], seq[" + this.a + "]");
      }
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().a(new Object[] { Integer.valueOf(38), Integer.valueOf(2), Long.valueOf(this.a) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.camera.CameraUtils.NoPreviewRunnable
 * JD-Core Version:    0.7.0.1
 */