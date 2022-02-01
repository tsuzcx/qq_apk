package com.tencent.aelight.camera.ae.camera.ui.aiscene;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;

class VideoStoryAIScenePart$4
  implements Observer<AEVideoStoryTopBarViewModel.Ratio>
{
  VideoStoryAIScenePart$4(VideoStoryAIScenePart paramVideoStoryAIScenePart) {}
  
  public void a(@Nullable AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    if (paramRatio == null) {
      return;
    }
    VideoStoryAIScenePart.a(this.a, paramRatio);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart.4
 * JD-Core Version:    0.7.0.1
 */