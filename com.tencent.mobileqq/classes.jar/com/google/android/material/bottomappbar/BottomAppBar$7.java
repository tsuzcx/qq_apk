package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;

class BottomAppBar$7
  extends AnimatorListenerAdapter
{
  public boolean a;
  
  BottomAppBar$7(BottomAppBar paramBottomAppBar, ActionMenuView paramActionMenuView, int paramInt, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a = true;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!this.a)
    {
      boolean bool;
      if (BottomAppBar.p(this.e) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramAnimator = this.e;
      paramAnimator.a(BottomAppBar.p(paramAnimator));
      BottomAppBar.a(this.e, this.b, this.c, this.d, bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.bottomappbar.BottomAppBar.7
 * JD-Core Version:    0.7.0.1
 */