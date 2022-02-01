package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class DrawableWithAnimatedVisibilityChange$2
  extends AnimatorListenerAdapter
{
  DrawableWithAnimatedVisibilityChange$2(DrawableWithAnimatedVisibilityChange paramDrawableWithAnimatedVisibilityChange) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    DrawableWithAnimatedVisibilityChange.a(this.a, false, false);
    DrawableWithAnimatedVisibilityChange.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange.2
 * JD-Core Version:    0.7.0.1
 */