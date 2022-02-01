package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class FloatingActionButtonImpl$1
  extends AnimatorListenerAdapter
{
  private boolean b;
  
  FloatingActionButtonImpl$1(FloatingActionButtonImpl paramFloatingActionButtonImpl, boolean paramBoolean, FloatingActionButtonImpl.InternalVisibilityChangedListener paramInternalVisibilityChangedListener) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.b = true;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    FloatingActionButtonImpl.a(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButtonImpl, 0);
    FloatingActionButtonImpl.a(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButtonImpl, null);
    if (!this.b)
    {
      paramAnimator = this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButtonImpl.a;
      int i;
      if (this.jdField_a_of_type_Boolean) {
        i = 8;
      } else {
        i = 4;
      }
      paramAnimator.a(i, this.jdField_a_of_type_Boolean);
      paramAnimator = this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButtonImpl$InternalVisibilityChangedListener;
      if (paramAnimator != null) {
        paramAnimator.b();
      }
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButtonImpl.a.a(0, this.jdField_a_of_type_Boolean);
    FloatingActionButtonImpl.a(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButtonImpl, 1);
    FloatingActionButtonImpl.a(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButtonImpl, paramAnimator);
    this.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.1
 * JD-Core Version:    0.7.0.1
 */