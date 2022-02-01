package com.tencent.mm.plugin.appbrand.page;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class o$20
  implements Animation.AnimationListener
{
  o$20(o paramo, Runnable paramRunnable, m paramm) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a != null)
    {
      o.20.1 local1 = new o.20.1(this);
      if (paramAnimation.getStartTime() == -9223372036854775808L)
      {
        local1.run();
        return;
      }
      if (!o.j(this.c)) {
        this.c.post(local1);
      }
    }
    else
    {
      this.b.setTag(o.e, null);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.o.20
 * JD-Core Version:    0.7.0.1
 */