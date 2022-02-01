package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.animation;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.view.animation.AccelerateDecelerateInterpolator;

@TargetApi(11)
public class AnimatorFactory
{
  public static ValueAnimator a(long paramLong, float paramFloat1, float paramFloat2, AnimatorFactory.AnimatorListener paramAnimatorListener)
  {
    return a(ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 }), paramAnimatorListener, paramLong);
  }
  
  private static ValueAnimator a(ValueAnimator paramValueAnimator, AnimatorFactory.AnimatorListener paramAnimatorListener, long paramLong)
  {
    paramValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    paramValueAnimator.addUpdateListener(new AnimatorFactory.1(paramAnimatorListener));
    paramValueAnimator.addListener(new AnimatorFactory.2(paramAnimatorListener, paramValueAnimator));
    paramValueAnimator.setDuration(paramLong);
    return paramValueAnimator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.animation.AnimatorFactory
 * JD-Core Version:    0.7.0.1
 */