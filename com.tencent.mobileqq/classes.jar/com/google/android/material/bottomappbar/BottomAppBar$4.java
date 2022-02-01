package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class BottomAppBar$4
  extends AnimatorListenerAdapter
{
  BottomAppBar$4(BottomAppBar paramBottomAppBar) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    BottomAppBar.e(this.a);
    BottomAppBar.a(this.a, null);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    BottomAppBar.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.bottomappbar.BottomAppBar.4
 * JD-Core Version:    0.7.0.1
 */