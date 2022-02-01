package com.tencent.luggage.sdk.customize.impl;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.rz.g;

final class a$2
  implements Animation.AnimationListener
{
  a$2(Runnable paramRunnable, d paramd) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a != null) {
      com.tencent.luggage.wxa.rz.f.a.a(this.a);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.b.ai().setWillNotDraw(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.customize.impl.a.2
 * JD-Core Version:    0.7.0.1
 */