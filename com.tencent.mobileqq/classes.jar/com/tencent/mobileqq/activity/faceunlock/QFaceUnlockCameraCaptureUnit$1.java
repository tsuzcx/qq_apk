package com.tencent.mobileqq.activity.faceunlock;

import ahxz;
import android.os.Handler;

public class QFaceUnlockCameraCaptureUnit$1
  implements Runnable
{
  public QFaceUnlockCameraCaptureUnit$1(ahxz paramahxz) {}
  
  public void run()
  {
    if (ahxz.a(this.this$0) != 1) {
      return;
    }
    ahxz.b(this.this$0);
    ahxz.a(this.this$0).postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.faceunlock.QFaceUnlockCameraCaptureUnit.1
 * JD-Core Version:    0.7.0.1
 */