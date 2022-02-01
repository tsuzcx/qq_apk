package com.tencent.mobileqq.activity.faceunlock;

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
    QFaceUnlockCameraCaptureUnit.a(this.this$0).postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.faceunlock.QFaceUnlockCameraCaptureUnit.1
 * JD-Core Version:    0.7.0.1
 */