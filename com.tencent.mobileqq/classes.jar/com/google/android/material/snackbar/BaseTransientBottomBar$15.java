package com.google.android.material.snackbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class BaseTransientBottomBar$15
  extends AnimatorListenerAdapter
{
  BaseTransientBottomBar$15(BaseTransientBottomBar paramBaseTransientBottomBar) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.f();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    BaseTransientBottomBar.k(this.a).a(70, 180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar.15
 * JD-Core Version:    0.7.0.1
 */