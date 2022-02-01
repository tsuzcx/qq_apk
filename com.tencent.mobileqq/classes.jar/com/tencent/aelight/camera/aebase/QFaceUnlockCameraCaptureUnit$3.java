package com.tencent.aelight.camera.aebase;

import android.media.MediaRecorder;
import com.tencent.TMG.utils.QLog;

class QFaceUnlockCameraCaptureUnit$3
  implements Runnable
{
  QFaceUnlockCameraCaptureUnit$3(QFaceUnlockCameraCaptureUnit paramQFaceUnlockCameraCaptureUnit, boolean paramBoolean) {}
  
  public void run()
  {
    if (QFaceUnlockCameraCaptureUnit.a(this.this$0) != null) {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("QFaceUnlockCameraCaptureUnit", 0, "stopRecord begin");
        }
        QFaceUnlockCameraCaptureUnit.a(this.this$0).stop();
        QFaceUnlockCameraCaptureUnit.a(this.this$0).reset();
        if (QLog.isColorLevel()) {
          QLog.i("QFaceUnlockCameraCaptureUnit", 0, "stopRecord end");
        }
      }
      catch (Exception localException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("stopRecord failed, Exception: ");
        localStringBuilder.append(localException.getMessage());
        QLog.e("QFaceUnlockCameraCaptureUnit", 1, localStringBuilder.toString());
      }
      catch (RuntimeException localRuntimeException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("stopRecord failed, RuntimeException: ");
        localStringBuilder.append(localRuntimeException.getMessage());
        QLog.e("QFaceUnlockCameraCaptureUnit", 1, localStringBuilder.toString());
      }
      catch (IllegalStateException localIllegalStateException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("stopRecord failed, IllegalStateException: ");
        localStringBuilder.append(localIllegalStateException.getMessage());
        QLog.e("QFaceUnlockCameraCaptureUnit", 1, localStringBuilder.toString());
      }
    }
    QFaceUnlockCameraCaptureUnit.a(this.this$0, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.QFaceUnlockCameraCaptureUnit.3
 * JD-Core Version:    0.7.0.1
 */