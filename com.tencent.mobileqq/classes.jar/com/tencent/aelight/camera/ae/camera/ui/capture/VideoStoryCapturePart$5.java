package com.tencent.aelight.camera.ae.camera.ui.capture;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.log.AEQLog;

class VideoStoryCapturePart$5
  implements Observer<Boolean>
{
  VideoStoryCapturePart$5(VideoStoryCapturePart paramVideoStoryCapturePart) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return;
    }
    if ((VideoStoryCapturePart.a(this.a) != null) && (VideoStoryCapturePart.f(this.a) == AECaptureMode.GIF))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("【抠背开关】->observe:");
      localStringBuilder.append(paramBoolean);
      AEQLog.a("VideoStoryCapturePart", localStringBuilder.toString());
      VideoStoryCapturePart.a(this.a).switchSegment(paramBoolean.booleanValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.capture.VideoStoryCapturePart.5
 * JD-Core Version:    0.7.0.1
 */