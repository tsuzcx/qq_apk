package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.circularreveal.CircularRevealWidget;

class FabTransformationBehavior$4
  extends AnimatorListenerAdapter
{
  FabTransformationBehavior$4(FabTransformationBehavior paramFabTransformationBehavior, CircularRevealWidget paramCircularRevealWidget) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.a.getRevealInfo();
    paramAnimator.c = 3.4028235E+38F;
    this.a.setRevealInfo(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.transformation.FabTransformationBehavior.4
 * JD-Core Version:    0.7.0.1
 */