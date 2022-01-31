package com.tencent.mobileqq.activity.faceunlock;

import afvq;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.media.MediaRecorder;
import android.os.Handler;
import axhr;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.List;

public class QFaceUnlockCameraCaptureUnit$3
  implements Runnable
{
  public QFaceUnlockCameraCaptureUnit$3(afvq paramafvq) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("QFaceUnlockCameraCaptureUnit", 0, "startRecord begin");
      }
      if (afvq.a(this.this$0) == null) {
        afvq.a(this.this$0, new MediaRecorder());
      }
      if (axhr.a().a != null)
      {
        Object localObject2 = axhr.a().a.getParameters();
        Object localObject1 = ((Camera.Parameters)localObject2).getSupportedPreviewSizes();
        localObject2 = ((Camera.Parameters)localObject2).getSupportedVideoSizes();
        localObject1 = afvq.a(this.this$0, (List)localObject1, (List)localObject2);
        axhr.a().a.unlock();
        afvq.a(this.this$0).setOrientationHint(270);
        afvq.a(this.this$0).reset();
        afvq.a(this.this$0).setCamera(axhr.a().a);
        afvq.a(this.this$0).setAudioSource(0);
        afvq.a(this.this$0).setVideoSource(1);
        afvq.a(this.this$0).setOutputFormat(2);
        afvq.a(this.this$0).setVideoSize(((Camera.Size)localObject1).width, ((Camera.Size)localObject1).height);
        afvq.a(this.this$0).setVideoEncoder(2);
        afvq.a(this.this$0).setAudioEncoder(3);
        afvq.a(this.this$0).setVideoEncodingBitRate(5242880);
        afvq.a(this.this$0, ShortVideoUtils.c());
        afvq.a(this.this$0).setOutputFile(afvq.a(this.this$0));
        afvq.a(this.this$0).prepare();
        afvq.a(this.this$0).start();
        afvq.a(this.this$0).postDelayed(afvq.a(this.this$0), 1000L);
        if (QLog.isColorLevel()) {
          QLog.i("QFaceUnlockCameraCaptureUnit", 0, "startRecord end");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QFaceUnlockCameraCaptureUnit", 1, "startRecord fail, Exception:" + localException.getMessage());
      afvq.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.faceunlock.QFaceUnlockCameraCaptureUnit.3
 * JD-Core Version:    0.7.0.1
 */