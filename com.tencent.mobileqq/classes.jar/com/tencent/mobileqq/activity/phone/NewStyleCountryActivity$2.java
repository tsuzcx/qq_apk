package com.tencent.mobileqq.activity.phone;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class NewStyleCountryActivity$2
  implements Animation.AnimationListener
{
  NewStyleCountryActivity$2(NewStyleCountryActivity paramNewStyleCountryActivity, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.b.e.setAnimation(null);
    this.b.e.offsetTopAndBottom(this.a);
    this.b.e.requestLayout();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.NewStyleCountryActivity.2
 * JD-Core Version:    0.7.0.1
 */