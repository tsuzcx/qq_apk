package com.google.android.material.transition.platform;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

final class FadeThroughProvider$1
  implements ValueAnimator.AnimatorUpdateListener
{
  FadeThroughProvider$1(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.setAlpha(TransitionUtils.a(this.b, this.c, this.d, this.e, f));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.transition.platform.FadeThroughProvider.1
 * JD-Core Version:    0.7.0.1
 */