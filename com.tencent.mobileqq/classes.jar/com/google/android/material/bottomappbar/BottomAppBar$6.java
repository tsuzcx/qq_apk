package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class BottomAppBar$6
  extends AnimatorListenerAdapter
{
  BottomAppBar$6(BottomAppBar paramBottomAppBar) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    BottomAppBar.o(this.a);
    BottomAppBar.a(this.a, false);
    BottomAppBar.b(this.a, null);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    BottomAppBar.n(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.bottomappbar.BottomAppBar.6
 * JD-Core Version:    0.7.0.1
 */