package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class ExtendedFloatingActionButton$3
  extends AnimatorListenerAdapter
{
  private boolean jdField_a_of_type_Boolean;
  
  ExtendedFloatingActionButton$3(ExtendedFloatingActionButton paramExtendedFloatingActionButton, MotionStrategy paramMotionStrategy, ExtendedFloatingActionButton.OnChangedCallback paramOnChangedCallback) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonMotionStrategy.b();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonMotionStrategy.a();
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonMotionStrategy.a(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton$OnChangedCallback);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonMotionStrategy.a(paramAnimator);
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.3
 * JD-Core Version:    0.7.0.1
 */