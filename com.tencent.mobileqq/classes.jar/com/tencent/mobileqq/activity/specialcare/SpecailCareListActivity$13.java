package com.tencent.mobileqq.activity.specialcare;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

class SpecailCareListActivity$13
  implements Animation.AnimationListener
{
  SpecailCareListActivity$13(SpecailCareListActivity paramSpecailCareListActivity, SpecailCareListActivity.ViewHolder paramViewHolder, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.c.clearAnimation();
    paramAnimation = new RelativeLayout.LayoutParams(-2, -2);
    paramAnimation.addRule(10);
    paramAnimation.addRule(1, 2131435219);
    paramAnimation.setMargins(0, (int)(SpecailCareListActivity.g(this.c) * 22.0F), (int)(SpecailCareListActivity.h(this.c) * 23.0F + this.b), 0);
    this.a.c.setLayoutParams(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.13
 * JD-Core Version:    0.7.0.1
 */