package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class o$19
  extends AnimatorListenerAdapter
{
  o$19(o paramo, m paramm, Runnable paramRunnable) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.setTag(o.e, null);
    paramAnimator = this.b;
    if (paramAnimator != null)
    {
      this.c.removeCallbacks(paramAnimator);
      if (!o.j(this.c)) {
        this.b.run();
      }
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.setTag(o.e, null);
    if (this.b != null) {
      this.c.post(new o.19.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.o.19
 * JD-Core Version:    0.7.0.1
 */