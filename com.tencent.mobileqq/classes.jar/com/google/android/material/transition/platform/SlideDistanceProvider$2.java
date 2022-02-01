package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class SlideDistanceProvider$2
  extends AnimatorListenerAdapter
{
  SlideDistanceProvider$2(View paramView, float paramFloat) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.setTranslationY(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.transition.platform.SlideDistanceProvider.2
 * JD-Core Version:    0.7.0.1
 */