package com.tencent.biz;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout.LayoutParams;

class PoiMapActivity$16
  implements Animation.AnimationListener
{
  PoiMapActivity$16(PoiMapActivity paramPoiMapActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (FrameLayout.LayoutParams)PoiMapActivity.q(this.a).getLayoutParams();
    paramAnimation.bottomMargin = (this.a.O + this.a.P);
    PoiMapActivity.q(this.a).setLayoutParams(paramAnimation);
    if ((this.a.M != null) && (this.a.M.getVisibility() != 8)) {
      this.a.M.setVisibility(8);
    }
    PoiMapActivity.r(this.a).clearAnimation();
    this.a.s = true;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.16
 * JD-Core Version:    0.7.0.1
 */