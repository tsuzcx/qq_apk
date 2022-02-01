package com.tencent.aelight.camera.ae.camera.ui.aiscene;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AECaptureModeChangingEvent;

class VideoStoryAIScenePart$3
  implements Observer<AECaptureModeChangingEvent>
{
  VideoStoryAIScenePart$3(VideoStoryAIScenePart paramVideoStoryAIScenePart) {}
  
  public void a(@Nullable AECaptureModeChangingEvent paramAECaptureModeChangingEvent)
  {
    if (paramAECaptureModeChangingEvent == null) {
      return;
    }
    if (paramAECaptureModeChangingEvent.b == AECaptureMode.PLAY) {
      VideoStoryAIScenePart.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart.3
 * JD-Core Version:    0.7.0.1
 */