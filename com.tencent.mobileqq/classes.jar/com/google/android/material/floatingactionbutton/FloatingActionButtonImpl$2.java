package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class FloatingActionButtonImpl$2
  extends AnimatorListenerAdapter
{
  FloatingActionButtonImpl$2(FloatingActionButtonImpl paramFloatingActionButtonImpl, boolean paramBoolean, FloatingActionButtonImpl.InternalVisibilityChangedListener paramInternalVisibilityChangedListener) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    FloatingActionButtonImpl.a(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButtonImpl, 0);
    FloatingActionButtonImpl.a(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButtonImpl, null);
    paramAnimator = this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButtonImpl$InternalVisibilityChangedListener;
    if (paramAnimator != null) {
      paramAnimator.a();
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButtonImpl.a.a(0, this.jdField_a_of_type_Boolean);
    FloatingActionButtonImpl.a(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButtonImpl, 2);
    FloatingActionButtonImpl.a(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButtonImpl, paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.2
 * JD-Core Version:    0.7.0.1
 */