package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class FabTransformationScrimBehavior$1
  extends AnimatorListenerAdapter
{
  FabTransformationScrimBehavior$1(FabTransformationScrimBehavior paramFabTransformationScrimBehavior, boolean paramBoolean, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!this.a) {
      this.b.setVisibility(4);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.a) {
      this.b.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.transformation.FabTransformationScrimBehavior.1
 * JD-Core Version:    0.7.0.1
 */