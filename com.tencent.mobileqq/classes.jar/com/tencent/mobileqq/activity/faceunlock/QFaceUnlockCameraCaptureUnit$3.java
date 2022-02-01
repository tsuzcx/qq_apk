package com.tencent.mobileqq.activity.faceunlock;

import aiuw;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.media.MediaRecorder;
import android.os.Handler;
import bbuc;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.List;

public class QFaceUnlockCameraCaptureUnit$3
  implements Runnable
{
  public QFaceUnlockCameraCaptureUnit$3(aiuw paramaiuw) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("QFaceUnlockCameraCaptureUnit", 0, "startRecord begin");
      }
      if (aiuw.a(this.this$0) == null) {
        aiuw.a(this.this$0, new MediaRecorder());
      }
      if (bbuc.a().a != null)
      {
        Object localObject2 = bbuc.a().a.getParameters();
        Object localObject1 = ((Camera.Parameters)localObject2).getSupportedPreviewSizes();
        localObject2 = ((Camera.Parameters)localObject2).getSupportedVideoSizes();
        localObject1 = aiuw.a(this.this$0, (List)localObject1, (List)localObject2);
        bbuc.a().a.unlock();
        aiuw.a(this.this$0).setOrientationHint(270);
        aiuw.a(this.this$0).reset();
        aiuw.a(this.this$0).setCamera(bbuc.a().a);
        aiuw.a(this.this$0).setAudioSource(0);
        aiuw.a(this.this$0).setVideoSource(1);
        aiuw.a(this.this$0).setOutputFormat(2);
        aiuw.a(this.this$0).setVideoSize(((Camera.Size)localObject1).width, ((Camera.Size)localObject1).height);
        aiuw.a(this.this$0).setVideoEncoder(2);
        aiuw.a(this.this$0).setAudioEncoder(3);
        aiuw.a(this.this$0).setVideoEncodingBitRate(5242880);
        aiuw.a(this.this$0, ShortVideoUtils.getLocalShortVideoPath());
        aiuw.a(this.this$0).setOutputFile(aiuw.a(this.this$0));
        aiuw.a(this.this$0).prepare();
        aiuw.a(this.this$0).start();
        aiuw.a(this.this$0).postDelayed(aiuw.a(this.this$0), 1000L);
        if (QLog.isColorLevel()) {
          QLog.i("QFaceUnlockCameraCaptureUnit", 0, "startRecord end");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QFaceUnlockCameraCaptureUnit", 1, "startRecord fail, Exception:" + localException.getMessage());
      aiuw.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.faceunlock.QFaceUnlockCameraCaptureUnit.3
 * JD-Core Version:    0.7.0.1
 */