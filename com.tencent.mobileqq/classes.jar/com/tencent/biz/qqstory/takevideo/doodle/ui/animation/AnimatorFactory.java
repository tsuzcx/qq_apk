package com.tencent.biz.qqstory.takevideo.doodle.ui.animation;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.view.animation.AccelerateDecelerateInterpolator;
import oje;
import ojf;

@TargetApi(11)
public class AnimatorFactory
{
  public static ValueAnimator a(long paramLong, float paramFloat1, float paramFloat2, AnimatorFactory.AnimatorListener paramAnimatorListener)
  {
    float f = (paramFloat2 - paramFloat1) / 5.0F;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2, paramFloat2 - 3.0F * f, paramFloat2, paramFloat2 - f, paramFloat2 });
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    localValueAnimator.addUpdateListener(new oje(paramAnimatorListener));
    localValueAnimator.addListener(new ojf(paramAnimatorListener, localValueAnimator));
    localValueAnimator.setDuration(paramLong);
    return localValueAnimator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.animation.AnimatorFactory
 * JD-Core Version:    0.7.0.1
 */