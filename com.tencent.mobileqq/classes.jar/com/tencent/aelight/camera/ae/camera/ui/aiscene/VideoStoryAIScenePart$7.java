package com.tencent.aelight.camera.ae.camera.ui.aiscene;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import java.util.concurrent.atomic.AtomicBoolean;

class VideoStoryAIScenePart$7
  implements Animation.AnimationListener
{
  VideoStoryAIScenePart$7(VideoStoryAIScenePart paramVideoStoryAIScenePart, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    VideoStoryAIScenePart.a(this.d, false);
    VideoStoryAIScenePart.e(this.d).setVisibility(8);
    VideoStoryAIScenePart.f(this.d).setVisibility(8);
    if ((this.a) && (!VideoStoryAIScenePart.g(this.d).get()))
    {
      VideoStoryAIScenePart.a(this.d, this.b, this.c);
      return;
    }
    VideoStoryAIScenePart.h(this.d).b(851971, new Object[0]);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    VideoStoryAIScenePart.a(this.d, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart.7
 * JD-Core Version:    0.7.0.1
 */