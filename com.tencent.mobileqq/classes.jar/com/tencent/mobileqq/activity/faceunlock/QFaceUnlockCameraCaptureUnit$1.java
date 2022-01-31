package com.tencent.mobileqq.activity.faceunlock;

import afvs;
import android.os.Handler;

public class QFaceUnlockCameraCaptureUnit$1
  implements Runnable
{
  public QFaceUnlockCameraCaptureUnit$1(afvs paramafvs) {}
  
  public void run()
  {
    if (afvs.a(this.this$0) != 1) {
      return;
    }
    afvs.b(this.this$0);
    afvs.a(this.this$0).postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.faceunlock.QFaceUnlockCameraCaptureUnit.1
 * JD-Core Version:    0.7.0.1
 */