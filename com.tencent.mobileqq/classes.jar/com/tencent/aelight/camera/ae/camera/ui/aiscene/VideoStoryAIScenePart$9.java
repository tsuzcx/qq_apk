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
    VideoStoryAIScenePart.j(this.b).postDelayed(new VideoStoryAIScenePart.9.1(this), 1000L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    VideoStoryAIScenePart.j(this.b).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart.9
 * JD-Core Version:    0.7.0.1
 */