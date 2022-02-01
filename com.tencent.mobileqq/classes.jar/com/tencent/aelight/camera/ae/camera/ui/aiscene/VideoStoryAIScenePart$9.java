package com.tencent.aelight.camera.ae.camera.ui.aiscene;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

class VideoStoryAIScenePart$9
  implements Animation.AnimationListener
{
  VideoStoryAIScenePart$9(VideoStoryAIScenePart paramVideoStoryAIScenePart, AlphaAnimation paramAlphaAnimation) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    VideoStoryAIScenePart.b(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAisceneVideoStoryAIScenePart).postDelayed(new VideoStoryAIScenePart.9.1(this), 1000L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    VideoStoryAIScenePart.b(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAisceneVideoStoryAIScenePart).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart.9
 * JD-Core Version:    0.7.0.1
 */