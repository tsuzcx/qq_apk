package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.animation;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class AnimatorFactory$1
  implements ValueAnimator.AnimatorUpdateListener
{
  AnimatorFactory$1(AnimatorFactory.AnimatorListener paramAnimatorListener) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AnimatorFactory.AnimatorListener localAnimatorListener = this.a;
    if (localAnimatorListener != null) {
      localAnimatorListener.a(paramValueAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.animation.AnimatorFactory.1
 * JD-Core Version:    0.7.0.1
 */