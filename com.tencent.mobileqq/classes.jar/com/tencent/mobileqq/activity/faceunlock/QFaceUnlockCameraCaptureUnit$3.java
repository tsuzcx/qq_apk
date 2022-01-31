package com.tencent.mobileqq.activity.faceunlock;

import ahxz;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.media.MediaRecorder;
import android.os.Handler;
import azhg;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.List;

public class QFaceUnlockCameraCaptureUnit$3
  implements Runnable
{
  public QFaceUnlockCameraCaptureUnit$3(ahxz paramahxz) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("QFaceUnlockCameraCaptureUnit", 0, "startRecord begin");
      }
      if (ahxz.a(this.this$0) == null) {
        ahxz.a(this.this$0, new MediaRecorder());
      }
      if (azhg.a().a != null)
      {
        Object localObject2 = azhg.a().a.getParameters();
        Object localObject1 = ((Camera.Parameters)localObject2).getSupportedPreviewSizes();
        localObject2 = ((Camera.Parameters)localObject2).getSupportedVideoSizes();
        localObject1 = ahxz.a(this.this$0, (List)localObject1, (List)localObject2);
        azhg.a().a.unlock();
        ahxz.a(this.this$0).setOrientationHint(270);
        ahxz.a(this.this$0).reset();
        ahxz.a(this.this$0).setCamera(azhg.a().a);
        ahxz.a(this.this$0).setAudioSource(0);
        ahxz.a(this.this$0).setVideoSource(1);
        ahxz.a(this.this$0).setOutputFormat(2);
        ahxz.a(this.this$0).setVideoSize(((Camera.Size)localObject1).width, ((Camera.Size)localObject1).height);
        ahxz.a(this.this$0).setVideoEncoder(2);
        ahxz.a(this.this$0).setAudioEncoder(3);
        ahxz.a(this.this$0).setVideoEncodingBitRate(5242880);
        ahxz.a(this.this$0, ShortVideoUtils.c());
        ahxz.a(this.this$0).setOutputFile(ahxz.a(this.this$0));
        ahxz.a(this.this$0).prepare();
        ahxz.a(this.this$0).start();
        ahxz.a(this.this$0).postDelayed(ahxz.a(this.this$0), 1000L);
        if (QLog.isColorLevel()) {
          QLog.i("QFaceUnlockCameraCaptureUnit", 0, "startRecord end");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QFaceUnlockCameraCaptureUnit", 1, "startRecord fail, Exception:" + localException.getMessage());
      ahxz.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.faceunlock.QFaceUnlockCameraCaptureUnit.3
 * JD-Core Version:    0.7.0.1
 */