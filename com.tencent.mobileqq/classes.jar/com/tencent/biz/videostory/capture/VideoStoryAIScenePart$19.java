package com.tencent.biz.videostory.capture;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.widget.TextView;
import wtw;

public class VideoStoryAIScenePart$19
  implements Runnable
{
  public VideoStoryAIScenePart$19(wtw paramwtw) {}
  
  public void run()
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(wtw.a(this.this$0), "translationY", new float[] { 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(wtw.b(this.this$0), "translationY", new float[] { 0.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(wtw.b(this.this$0), "translationY", new float[] { 0.0F });
    Object localObject = new int[2];
    wtw.a(this.this$0).getLocationInWindow((int[])localObject);
    localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3);
    ((AnimatorSet)localObject).setDuration(300L).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.VideoStoryAIScenePart.19
 * JD-Core Version:    0.7.0.1
 */