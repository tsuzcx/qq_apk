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
    this.jdField_a_of_type_ComGoogleAndroidMaterialCircularrevealCircularRevealWidget.setCircularRevealOverlayDrawable(null);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialCircularrevealCircularRevealWidget.setCircularRevealOverlayDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.transformation.FabTransformationBehavior.3
 * JD-Core Version:    0.7.0.1
 */