package com.tencent.mobileqq.activity.faceunlock;

import ahtk;
import android.os.Handler;

public class QFaceUnlockCameraCaptureUnit$1
  implements Runnable
{
  public QFaceUnlockCameraCaptureUnit$1(ahtk paramahtk) {}
  
  public void run()
  {
    if (ahtk.a(this.this$0) != 1) {
      return;
    }
    ahtk.b(this.this$0);
    ahtk.a(this.this$0).postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.faceunlock.QFaceUnlockCameraCaptureUnit.1
 * JD-Core Version:    0.7.0.1
 */