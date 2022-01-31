package com.tencent.mobileqq.activity.faceunlock;

import afjv;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.media.MediaRecorder;
import android.os.Handler;
import awij;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.List;

public class QFaceUnlockCameraCaptureUnit$3
  implements Runnable
{
  public QFaceUnlockCameraCaptureUnit$3(afjv paramafjv) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("QFaceUnlockCameraCaptureUnit", 0, "startRecord begin");
      }
      if (afjv.a(this.this$0) == null) {
        afjv.a(this.this$0, new MediaRecorder());
      }
      if (awij.a().a != null)
      {
        Object localObject2 = awij.a().a.getParameters();
        Object localObject1 = ((Camera.Parameters)localObject2).getSupportedPreviewSizes();
        localObject2 = ((Camera.Parameters)localObject2).getSupportedVideoSizes();
        localObject1 = afjv.a(this.this$0, (List)localObject1, (List)localObject2);
        awij.a().a.unlock();
        afjv.a(this.this$0).setOrientationHint(270);
        afjv.a(this.this$0).reset();
        afjv.a(this.this$0).setCamera(awij.a().a);
        afjv.a(this.this$0).setAudioSource(0);
        afjv.a(this.this$0).setVideoSource(1);
        afjv.a(this.this$0).setOutputFormat(2);
        afjv.a(this.this$0).setVideoSize(((Camera.Size)localObject1).width, ((Camera.Size)localObject1).height);
        afjv.a(this.this$0).setVideoEncoder(2);
        afjv.a(this.this$0).setAudioEncoder(3);
        afjv.a(this.this$0).setVideoEncodingBitRate(5242880);
        afjv.a(this.this$0, ShortVideoUtils.c());
        afjv.a(this.this$0).setOutputFile(afjv.a(this.this$0));
        afjv.a(this.this$0).prepare();
        afjv.a(this.this$0).start();
        afjv.a(this.this$0).postDelayed(afjv.a(this.this$0), 1000L);
        if (QLog.isColorLevel()) {
          QLog.i("QFaceUnlockCameraCaptureUnit", 0, "startRecord end");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QFaceUnlockCameraCaptureUnit", 1, "startRecord fail, Exception:" + localException.getMessage());
      afjv.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.faceunlock.QFaceUnlockCameraCaptureUnit.3
 * JD-Core Version:    0.7.0.1
 */