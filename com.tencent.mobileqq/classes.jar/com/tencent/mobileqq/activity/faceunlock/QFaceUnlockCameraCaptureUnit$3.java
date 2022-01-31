package com.tencent.mobileqq.activity.faceunlock;

import ahtk;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.media.MediaRecorder;
import android.os.Handler;
import azcx;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.List;

public class QFaceUnlockCameraCaptureUnit$3
  implements Runnable
{
  public QFaceUnlockCameraCaptureUnit$3(ahtk paramahtk) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("QFaceUnlockCameraCaptureUnit", 0, "startRecord begin");
      }
      if (ahtk.a(this.this$0) == null) {
        ahtk.a(this.this$0, new MediaRecorder());
      }
      if (azcx.a().a != null)
      {
        Object localObject2 = azcx.a().a.getParameters();
        Object localObject1 = ((Camera.Parameters)localObject2).getSupportedPreviewSizes();
        localObject2 = ((Camera.Parameters)localObject2).getSupportedVideoSizes();
        localObject1 = ahtk.a(this.this$0, (List)localObject1, (List)localObject2);
        azcx.a().a.unlock();
        ahtk.a(this.this$0).setOrientationHint(270);
        ahtk.a(this.this$0).reset();
        ahtk.a(this.this$0).setCamera(azcx.a().a);
        ahtk.a(this.this$0).setAudioSource(0);
        ahtk.a(this.this$0).setVideoSource(1);
        ahtk.a(this.this$0).setOutputFormat(2);
        ahtk.a(this.this$0).setVideoSize(((Camera.Size)localObject1).width, ((Camera.Size)localObject1).height);
        ahtk.a(this.this$0).setVideoEncoder(2);
        ahtk.a(this.this$0).setAudioEncoder(3);
        ahtk.a(this.this$0).setVideoEncodingBitRate(5242880);
        ahtk.a(this.this$0, ShortVideoUtils.c());
        ahtk.a(this.this$0).setOutputFile(ahtk.a(this.this$0));
        ahtk.a(this.this$0).prepare();
        ahtk.a(this.this$0).start();
        ahtk.a(this.this$0).postDelayed(ahtk.a(this.this$0), 1000L);
        if (QLog.isColorLevel()) {
          QLog.i("QFaceUnlockCameraCaptureUnit", 0, "startRecord end");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QFaceUnlockCameraCaptureUnit", 1, "startRecord fail, Exception:" + localException.getMessage());
      ahtk.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.faceunlock.QFaceUnlockCameraCaptureUnit.3
 * JD-Core Version:    0.7.0.1
 */