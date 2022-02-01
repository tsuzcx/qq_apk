package com.tencent.mobileqq.activity.faceunlock;

import ajql;
import android.os.Handler;

public class QFaceUnlockCameraCaptureUnit$1
  implements Runnable
{
  public QFaceUnlockCameraCaptureUnit$1(ajql paramajql) {}
  
  public void run()
  {
    if (ajql.a(this.this$0) != 1) {
      return;
    }
    ajql.b(this.this$0);
    ajql.a(this.this$0).postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.faceunlock.QFaceUnlockCameraCaptureUnit.1
 * JD-Core Version:    0.7.0.1
 */