package com.tencent.mobileqq.activity.faceunlock;

import ajql;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.media.MediaRecorder;
import android.os.Handler;
import bdax;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.List;

public class QFaceUnlockCameraCaptureUnit$2
  implements Runnable
{
  public QFaceUnlockCameraCaptureUnit$2(ajql paramajql) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("QFaceUnlockCameraCaptureUnit", 0, "startRecord begin");
      }
      if (ajql.a(this.this$0) == null) {
        ajql.a(this.this$0, new MediaRecorder());
      }
      if (bdax.a().a != null)
      {
        Object localObject2 = bdax.a().a.getParameters();
        Object localObject1 = ((Camera.Parameters)localObject2).getSupportedPreviewSizes();
        localObject2 = ((Camera.Parameters)localObject2).getSupportedVideoSizes();
        localObject1 = ajql.a(this.this$0, (List)localObject1, (List)localObject2);
        bdax.a().a.unlock();
        ajql.a(this.this$0).setOrientationHint(270);
        ajql.a(this.this$0).reset();
        ajql.a(this.this$0).setCamera(bdax.a().a);
        ajql.a(this.this$0).setAudioSource(0);
        ajql.a(this.this$0).setVideoSource(1);
        ajql.a(this.this$0).setOutputFormat(2);
        ajql.a(this.this$0).setVideoSize(((Camera.Size)localObject1).width, ((Camera.Size)localObject1).height);
        ajql.a(this.this$0).setVideoEncoder(2);
        ajql.a(this.this$0).setAudioEncoder(3);
        ajql.a(this.this$0).setVideoEncodingBitRate(5242880);
        ajql.a(this.this$0, ShortVideoUtils.getLocalShortVideoPath());
        ajql.a(this.this$0).setOutputFile(ajql.a(this.this$0));
        ajql.a(this.this$0).prepare();
        ajql.a(this.this$0).start();
        ajql.a(this.this$0).postDelayed(ajql.a(this.this$0), 1000L);
        if (QLog.isColorLevel()) {
          QLog.i("QFaceUnlockCameraCaptureUnit", 0, "startRecord end");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QFaceUnlockCameraCaptureUnit", 1, "startRecord fail, Exception:" + localException.getMessage());
      ajql.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.faceunlock.QFaceUnlockCameraCaptureUnit.2
 * JD-Core Version:    0.7.0.1
 */