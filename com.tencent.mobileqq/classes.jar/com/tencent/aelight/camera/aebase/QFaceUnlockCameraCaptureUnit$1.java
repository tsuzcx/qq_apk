package com.tencent.aelight.camera.aebase;

import android.os.Handler;

class QFaceUnlockCameraCaptureUnit$1
  implements Runnable
{
  QFaceUnlockCameraCaptureUnit$1(QFaceUnlockCameraCaptureUnit paramQFaceUnlockCameraCaptureUnit) {}
  
  public void run()
  {
    if (QFaceUnlockCameraCaptureUnit.a(this.this$0) != 1) {
      return;
    }
    QFaceUnlockCameraCaptureUnit.b(this.this$0);
    QFaceUnlockCameraCaptureUnit.c(this.this$0).postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.QFaceUnlockCameraCaptureUnit.1
 * JD-Core Version:    0.7.0.1
 */