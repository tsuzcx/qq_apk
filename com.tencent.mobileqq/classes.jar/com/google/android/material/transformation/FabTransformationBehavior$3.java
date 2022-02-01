package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import com.google.android.material.circularreveal.CircularRevealWidget;

class FabTransformationBehavior$3
  extends AnimatorListenerAdapter
{
  FabTransformationBehavior$3(FabTransformationBehavior paramFabTransformationBehavior, CircularRevealWidget paramCircularRevealWidget, Drawable paramDrawable) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.setCircularRevealOverlayDrawable(null);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.setCircularRevealOverlayDrawable(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.transformation.FabTransformationBehavior.3
 * JD-Core Version:    0.7.0.1
 */