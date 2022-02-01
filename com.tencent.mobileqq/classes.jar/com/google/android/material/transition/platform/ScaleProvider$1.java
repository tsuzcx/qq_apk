package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class ScaleProvider$1
  extends AnimatorListenerAdapter
{
  ScaleProvider$1(View paramView, float paramFloat1, float paramFloat2) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.setScaleX(this.b);
    this.a.setScaleY(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.transition.platform.ScaleProvider.1
 * JD-Core Version:    0.7.0.1
 */