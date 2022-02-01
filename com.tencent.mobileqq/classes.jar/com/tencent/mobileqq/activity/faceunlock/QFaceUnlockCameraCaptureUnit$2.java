package com.tencent.mobileqq.activity.faceunlock;

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
      if (QFaceUnlockCameraCaptureUnit.a(this.this$0) == null) {
        QFaceUnlockCameraCaptureUnit.a(this.this$0, new MediaRecorder());
      }
      if (CameraControl.a().a != null)
      {
        Object localObject2 = CameraControl.a().a.getParameters();
        Object localObject1 = ((Camera.Parameters)localObject2).getSupportedPreviewSizes();
        localObject2 = ((Camera.Parameters)localObject2).getSupportedVideoSizes();
        localObject1 = QFaceUnlockCameraCaptureUnit.a(this.this$0, (List)localObject1, (List)localObject2);
        CameraControl.a().a.unlock();
        QFaceUnlockCameraCaptureUnit.a(this.this$0).setOrientationHint(270);
        QFaceUnlockCameraCaptureUnit.a(this.this$0).reset();
        QFaceUnlockCameraCaptureUnit.a(this.this$0).setCamera(CameraControl.a().a);
        QFaceUnlockCameraCaptureUnit.a(this.this$0).setAudioSource(0);
        QFaceUnlockCameraCaptureUnit.a(this.this$0).setVideoSource(1);
        QFaceUnlockCameraCaptureUnit.a(this.this$0).setOutputFormat(2);
        QFaceUnlockCameraCaptureUnit.a(this.this$0).setVideoSize(((Camera.Size)localObject1).width, ((Camera.Size)localObject1).height);
        QFaceUnlockCameraCaptureUnit.a(this.this$0).setVideoEncoder(2);
        QFaceUnlockCameraCaptureUnit.a(this.this$0).setAudioEncoder(3);
        QFaceUnlockCameraCaptureUnit.a(this.this$0).setVideoEncodingBitRate(5242880);
        QFaceUnlockCameraCaptureUnit.a(this.this$0, ShortVideoUtils.getLocalShortVideoPath());
        QFaceUnlockCameraCaptureUnit.a(this.this$0).setOutputFile(QFaceUnlockCameraCaptureUnit.a(this.this$0));
        QFaceUnlockCameraCaptureUnit.a(this.this$0).prepare();
        QFaceUnlockCameraCaptureUnit.a(this.this$0).start();
        QFaceUnlockCameraCaptureUnit.a(this.this$0).postDelayed(QFaceUnlockCameraCaptureUnit.a(this.this$0), 1000L);
        if (QLog.isColorLevel()) {
          QLog.i("QFaceUnlockCameraCaptureUnit", 0, "startRecord end");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QFaceUnlockCameraCaptureUnit", 1, "startRecord fail, Exception:" + localException.getMessage());
      QFaceUnlockCameraCaptureUnit.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.faceunlock.QFaceUnlockCameraCaptureUnit.2
 * JD-Core Version:    0.7.0.1
 */