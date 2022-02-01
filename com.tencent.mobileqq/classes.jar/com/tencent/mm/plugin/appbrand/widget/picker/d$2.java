package com.tencent.mm.plugin.appbrand.widget.picker;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class d$2
  implements Animation.AnimationListener
{
  d$2(d paramd) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setBackgroundResource(2131168376);
    this.a.clearAnimation();
    d.a(this.a, 8);
    this.a.requestLayout();
    d.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.d.2
 * JD-Core Version:    0.7.0.1
 */