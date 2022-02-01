package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class o$21
  extends AnimatorListenerAdapter
{
  o$21(o paramo, bg parambg, m paramm1, m paramm2) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    o.k(this.d).c(this.a, this.b, this.c);
    o.a(this.d, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    o.a(this.d, this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.o.21
 * JD-Core Version:    0.7.0.1
 */