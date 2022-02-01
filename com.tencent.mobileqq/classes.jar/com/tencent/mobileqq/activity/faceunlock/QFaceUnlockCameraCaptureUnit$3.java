package com.tencent.mobileqq.activity.faceunlock;

import ajzw;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.media.MediaRecorder;
import android.os.Handler;
import bday;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.List;

public class QFaceUnlockCameraCaptureUnit$3
  implements Runnable
{
  public QFaceUnlockCameraCaptureUnit$3(ajzw paramajzw) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("QFaceUnlockCameraCaptureUnit", 0, "startRecord begin");
      }
      if (ajzw.a(this.this$0) == null) {
        ajzw.a(this.this$0, new MediaRecorder());
      }
      if (bday.a().a != null)
      {
        Object localObject2 = bday.a().a.getParameters();
        Object localObject1 = ((Camera.Parameters)localObject2).getSupportedPreviewSizes();
        localObject2 = ((Camera.Parameters)localObject2).getSupportedVideoSizes();
        localObject1 = ajzw.a(this.this$0, (List)localObject1, (List)localObject2);
        bday.a().a.unlock();
        ajzw.a(this.this$0).setOrientationHint(270);
        ajzw.a(this.this$0).reset();
        ajzw.a(this.this$0).setCamera(bday.a().a);
        ajzw.a(this.this$0).setAudioSource(0);
        ajzw.a(this.this$0).setVideoSource(1);
        ajzw.a(this.this$0).setOutputFormat(2);
        ajzw.a(this.this$0).setVideoSize(((Camera.Size)localObject1).width, ((Camera.Size)localObject1).height);
        ajzw.a(this.this$0).setVideoEncoder(2);
        ajzw.a(this.this$0).setAudioEncoder(3);
        ajzw.a(this.this$0).setVideoEncodingBitRate(5242880);
        ajzw.a(this.this$0, ShortVideoUtils.c());
        ajzw.a(this.this$0).setOutputFile(ajzw.a(this.this$0));
        ajzw.a(this.this$0).prepare();
        ajzw.a(this.this$0).start();
        ajzw.a(this.this$0).postDelayed(ajzw.a(this.this$0), 1000L);
        if (QLog.isColorLevel()) {
          QLog.i("QFaceUnlockCameraCaptureUnit", 0, "startRecord end");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QFaceUnlockCameraCaptureUnit", 1, "startRecord fail, Exception:" + localException.getMessage());
      ajzw.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.faceunlock.QFaceUnlockCameraCaptureUnit.3
 * JD-Core Version:    0.7.0.1
 */