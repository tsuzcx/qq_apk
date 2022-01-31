package com.tencent.mobileqq.activity.faceunlock;

import afvq;
import android.media.MediaRecorder;
import com.tencent.TMG.utils.QLog;

public class QFaceUnlockCameraCaptureUnit$4
  implements Runnable
{
  public QFaceUnlockCameraCaptureUnit$4(afvq paramafvq, boolean paramBoolean) {}
  
  public void run()
  {
    if (afvq.a(this.this$0) != null) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("QFaceUnlockCameraCaptureUnit", 0, "stopRecord begin");
      }
      afvq.a(this.this$0).stop();
      afvq.a(this.this$0).reset();
      if (QLog.isColorLevel()) {
        QLog.i("QFaceUnlockCameraCaptureUnit", 0, "stopRecord end");
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        QLog.e("QFaceUnlockCameraCaptureUnit", 1, "stopRecord failed, IllegalStateException: " + localIllegalStateException.getMessage());
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        QLog.e("QFaceUnlockCameraCaptureUnit", 1, "stopRecord failed, RuntimeException: " + localRuntimeException.getMessage());
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("QFaceUnlockCameraCaptureUnit", 1, "stopRecord failed, Exception: " + localException.getMessage());
      }
    }
    afvq.a(this.this$0, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.faceunlock.QFaceUnlockCameraCaptureUnit.4
 * JD-Core Version:    0.7.0.1
 */