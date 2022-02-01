package com.tencent.aelight.camera.ae.camera.ui.aiscene;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.widget.TextView;

class VideoStoryAIScenePart$20
  implements Runnable
{
  VideoStoryAIScenePart$20(VideoStoryAIScenePart paramVideoStoryAIScenePart) {}
  
  public void run()
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(VideoStoryAIScenePart.f(this.this$0), "translationY", new float[] { 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(VideoStoryAIScenePart.e(this.this$0), "translationY", new float[] { 0.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(VideoStoryAIScenePart.j(this.this$0), "translationY", new float[] { 0.0F });
    Object localObject = new int[2];
    VideoStoryAIScenePart.f(this.this$0).getLocationInWindow((int[])localObject);
    localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3);
    ((AnimatorSet)localObject).setDuration(300L).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart.20
 * JD-Core Version:    0.7.0.1
 */