package com.tencent.aelight.camera.ae.camera.ui.capture;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AECaptureModeChangingEvent;
import com.tencent.aelight.camera.log.AEQLog;

class VideoStoryCapturePart$6
  implements Observer<AECaptureModeChangingEvent>
{
  VideoStoryCapturePart$6(VideoStoryCapturePart paramVideoStoryCapturePart) {}
  
  public void a(@Nullable AECaptureModeChangingEvent paramAECaptureModeChangingEvent)
  {
    if (paramAECaptureModeChangingEvent == null)
    {
      AEQLog.d("VideoStoryCapturePart", "modeChangingEvent is null, return");
      return;
    }
    paramAECaptureModeChangingEvent = paramAECaptureModeChangingEvent.b;
    VideoStoryCapturePart.a(this.a, paramAECaptureModeChangingEvent);
    Boolean localBoolean = (Boolean)VideoStoryCapturePart.a(this.a).b().getValue();
    Object localObject = AECaptureMode.GIF;
    boolean bool2 = false;
    if (paramAECaptureModeChangingEvent == localObject)
    {
      VideoStoryCapturePart.a(this.a);
      VideoStoryCapturePart.a(this.a).setVisibility(0);
      localObject = VideoStoryCapturePart.a(this.a);
      boolean bool1 = bool2;
      if (localBoolean != null)
      {
        bool1 = bool2;
        if (localBoolean.booleanValue()) {
          bool1 = true;
        }
      }
      ((AECameraGLSurfaceView)localObject).switchSegment(bool1);
      VideoStoryCapturePart.a(this.a).switchSegmentFollowFace(true);
    }
    else
    {
      if (VideoStoryCapturePart.a(this.a)) {
        VideoStoryCapturePart.a(this.a).setVisibility(8);
      }
      VideoStoryCapturePart.a(this.a).switchSegment(true);
      VideoStoryCapturePart.a(this.a).switchSegmentFollowFace(false);
    }
    VideoStoryCapturePart.a(this.a, paramAECaptureModeChangingEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.capture.VideoStoryCapturePart.6
 * JD-Core Version:    0.7.0.1
 */