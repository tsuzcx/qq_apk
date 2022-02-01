package com.google.android.material.snackbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class BaseTransientBottomBar$17
  extends AnimatorListenerAdapter
{
  BaseTransientBottomBar$17(BaseTransientBottomBar paramBaseTransientBottomBar, int paramInt) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar.c(this.jdField_a_of_type_Int);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    BaseTransientBottomBar.a(this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar).b(0, 180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar.17
 * JD-Core Version:    0.7.0.1
 */