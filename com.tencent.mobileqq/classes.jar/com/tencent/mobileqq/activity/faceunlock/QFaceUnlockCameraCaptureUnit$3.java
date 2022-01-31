package com.tencent.mobileqq.activity.faceunlock;

import afvs;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.media.MediaRecorder;
import android.os.Handler;
import axhp;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.List;

public class QFaceUnlockCameraCaptureUnit$3
  implements Runnable
{
  public QFaceUnlockCameraCaptureUnit$3(afvs paramafvs) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("QFaceUnlockCameraCaptureUnit", 0, "startRecord begin");
      }
      if (afvs.a(this.this$0) == null) {
        afvs.a(this.this$0, new MediaRecorder());
      }
      if (axhp.a().a != null)
      {
        Object localObject2 = axhp.a().a.getParameters();
        Object localObject1 = ((Camera.Parameters)localObject2).getSupportedPreviewSizes();
        localObject2 = ((Camera.Parameters)localObject2).getSupportedVideoSizes();
        localObject1 = afvs.a(this.this$0, (List)localObject1, (List)localObject2);
        axhp.a().a.unlock();
        afvs.a(this.this$0).setOrientationHint(270);
        afvs.a(this.this$0).reset();
        afvs.a(this.this$0).setCamera(axhp.a().a);
        afvs.a(this.this$0).setAudioSource(0);
        afvs.a(this.this$0).setVideoSource(1);
        afvs.a(this.this$0).setOutputFormat(2);
        afvs.a(this.this$0).setVideoSize(((Camera.Size)localObject1).width, ((Camera.Size)localObject1).height);
        afvs.a(this.this$0).setVideoEncoder(2);
        afvs.a(this.this$0).setAudioEncoder(3);
        afvs.a(this.this$0).setVideoEncodingBitRate(5242880);
        afvs.a(this.this$0, ShortVideoUtils.c());
        afvs.a(this.this$0).setOutputFile(afvs.a(this.this$0));
        afvs.a(this.this$0).prepare();
        afvs.a(this.this$0).start();
        afvs.a(this.this$0).postDelayed(afvs.a(this.this$0), 1000L);
        if (QLog.isColorLevel()) {
          QLog.i("QFaceUnlockCameraCaptureUnit", 0, "startRecord end");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QFaceUnlockCameraCaptureUnit", 1, "startRecord fail, Exception:" + localException.getMessage());
      afvs.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.faceunlock.QFaceUnlockCameraCaptureUnit.3
 * JD-Core Version:    0.7.0.1
 */