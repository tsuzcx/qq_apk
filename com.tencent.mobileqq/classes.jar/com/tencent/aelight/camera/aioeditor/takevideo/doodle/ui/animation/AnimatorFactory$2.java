package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.animation;

import android.animation.Animator;
import android.animation.ValueAnimator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

final class AnimatorFactory$2
  extends D8SafeAnimatorListener
{
  AnimatorFactory$2(AnimatorFactory.AnimatorListener paramAnimatorListener, ValueAnimator paramValueAnimator) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    paramAnimator = this.a;
    if (paramAnimator != null) {
      paramAnimator.d(this.b);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.a;
    if (paramAnimator != null) {
      paramAnimator.c(this.b);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    paramAnimator = this.a;
    if (paramAnimator != null) {
      paramAnimator.b(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.animation.AnimatorFactory.2
 * JD-Core Version:    0.7.0.1
 */