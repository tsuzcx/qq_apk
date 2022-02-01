package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class FloatingActionButtonImpl$1
  extends AnimatorListenerAdapter
{
  private boolean d;
  
  FloatingActionButtonImpl$1(FloatingActionButtonImpl paramFloatingActionButtonImpl, boolean paramBoolean, FloatingActionButtonImpl.InternalVisibilityChangedListener paramInternalVisibilityChangedListener) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.d = true;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    FloatingActionButtonImpl.a(this.c, 0);
    FloatingActionButtonImpl.a(this.c, null);
    if (!this.d)
    {
      paramAnimator = this.c.s;
      int i;
      if (this.a) {
        i = 8;
      } else {
        i = 4;
      }
      paramAnimator.a(i, this.a);
      paramAnimator = this.b;
      if (paramAnimator != null) {
        paramAnimator.b();
      }
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.c.s.a(0, this.a);
    FloatingActionButtonImpl.a(this.c, 1);
    FloatingActionButtonImpl.a(this.c, paramAnimator);
    this.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.1
 * JD-Core Version:    0.7.0.1
 */