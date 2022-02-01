package com.tencent.aelight.camera.aebase;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.media.MediaRecorder;
import android.os.Handler;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import java.util.List;

class QFaceUnlockCameraCaptureUnit$2
  implements Runnable
{
  QFaceUnlockCameraCaptureUnit$2(QFaceUnlockCameraCaptureUnit paramQFaceUnlockCameraCaptureUnit) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("QFaceUnlockCameraCaptureUnit", 0, "startRecord begin");
      }
      if (QFaceUnlockCameraCaptureUnit.d(this.this$0) == null) {
        QFaceUnlockCameraCaptureUnit.a(this.this$0, new MediaRecorder());
      }
      if (CameraControl.a().d != null)
      {
        localObject2 = CameraControl.a().d.getParameters();
        Object localObject1 = ((Camera.Parameters)localObject2).getSupportedPreviewSizes();
        localObject2 = ((Camera.Parameters)localObject2).getSupportedVideoSizes();
        localObject1 = QFaceUnlockCameraCaptureUnit.a(this.this$0, (List)localObject1, (List)localObject2);
        CameraControl.a().d.unlock();
        QFaceUnlockCameraCaptureUnit.d(this.this$0).setOrientationHint(270);
        QFaceUnlockCameraCaptureUnit.d(this.this$0).reset();
        QFaceUnlockCameraCaptureUnit.d(this.this$0).setCamera(CameraControl.a().d);
        QFaceUnlockCameraCaptureUnit.d(this.this$0).setAudioSource(0);
        QFaceUnlockCameraCaptureUnit.d(this.this$0).setVideoSource(1);
        QFaceUnlockCameraCaptureUnit.d(this.this$0).setOutputFormat(2);
        QFaceUnlockCameraCaptureUnit.d(this.this$0).setVideoSize(((Camera.Size)localObject1).width, ((Camera.Size)localObject1).height);
        QFaceUnlockCameraCaptureUnit.d(this.this$0).setVideoEncoder(2);
        QFaceUnlockCameraCaptureUnit.d(this.this$0).setAudioEncoder(3);
        QFaceUnlockCameraCaptureUnit.d(this.this$0).setVideoEncodingBitRate(5242880);
        QFaceUnlockCameraCaptureUnit.a(this.this$0, ShortVideoUtils.getLocalShortVideoPath());
        QFaceUnlockCameraCaptureUnit.d(this.this$0).setOutputFile(QFaceUnlockCameraCaptureUnit.e(this.this$0));
        QFaceUnlockCameraCaptureUnit.d(this.this$0).prepare();
        QFaceUnlockCameraCaptureUnit.d(this.this$0).start();
        QFaceUnlockCameraCaptureUnit.c(this.this$0).postDelayed(QFaceUnlockCameraCaptureUnit.f(this.this$0), 1000L);
        if (QLog.isColorLevel())
        {
          QLog.i("QFaceUnlockCameraCaptureUnit", 0, "startRecord end");
          return;
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("startRecord fail, Exception:");
      ((StringBuilder)localObject2).append(localException.getMessage());
      QLog.e("QFaceUnlockCameraCaptureUnit", 1, ((StringBuilder)localObject2).toString());
      QFaceUnlockCameraCaptureUnit.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.QFaceUnlockCameraCaptureUnit.2
 * JD-Core Version:    0.7.0.1
 */