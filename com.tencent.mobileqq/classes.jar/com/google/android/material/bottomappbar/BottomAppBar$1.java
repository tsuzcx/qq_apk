package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class BottomAppBar$1
  extends AnimatorListenerAdapter
{
  BottomAppBar$1(BottomAppBar paramBottomAppBar) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (!BottomAppBar.a(this.a))
    {
      paramAnimator = this.a;
      BottomAppBar.a(paramAnimator, BottomAppBar.b(paramAnimator), BottomAppBar.c(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.bottomappbar.BottomAppBar.1
 * JD-Core Version:    0.7.0.1
 */