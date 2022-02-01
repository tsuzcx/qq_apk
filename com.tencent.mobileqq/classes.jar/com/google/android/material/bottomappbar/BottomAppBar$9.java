package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

class BottomAppBar$9
  extends AnimatorListenerAdapter
{
  BottomAppBar$9(BottomAppBar paramBottomAppBar) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.a.onAnimationStart(paramAnimator);
    paramAnimator = BottomAppBar.q(this.a);
    if (paramAnimator != null) {
      paramAnimator.setTranslationX(BottomAppBar.r(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.bottomappbar.BottomAppBar.9
 * JD-Core Version:    0.7.0.1
 */