package com.tencent.mobileqq.activity.faceunlock;

import ajzw;
import android.os.Handler;

public class QFaceUnlockCameraCaptureUnit$1
  implements Runnable
{
  public QFaceUnlockCameraCaptureUnit$1(ajzw paramajzw) {}
  
  public void run()
  {
    if (ajzw.a(this.this$0) != 1) {
      return;
    }
    ajzw.b(this.this$0);
    ajzw.a(this.this$0).postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.faceunlock.QFaceUnlockCameraCaptureUnit.1
 * JD-Core Version:    0.7.0.1
 */