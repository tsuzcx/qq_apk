package com.tencent.biz.qqcircle.publish.outbox.banner;

import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class BasePushBanner$2
  implements Animation.AnimationListener
{
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.b.getHandler().postDelayed(new BasePushBanner.2.1(this), this.a);
    this.b.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.outbox.banner.BasePushBanner.2
 * JD-Core Version:    0.7.0.1
 */