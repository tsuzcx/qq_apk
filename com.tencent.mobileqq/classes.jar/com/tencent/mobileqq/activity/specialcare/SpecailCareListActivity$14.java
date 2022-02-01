package com.tencent.mobileqq.activity.specialcare;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;

class SpecailCareListActivity$14
  implements Animation.AnimationListener
{
  SpecailCareListActivity$14(SpecailCareListActivity paramSpecailCareListActivity, SpecailCareListActivity.ViewHolder paramViewHolder) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.m.clearAnimation();
    paramAnimation = new RelativeLayout.LayoutParams(-2, -2);
    paramAnimation.addRule(1, 2131435219);
    paramAnimation.setMargins(0, (int)(SpecailCareListActivity.i(this.b) * 24.0F), 0, 0);
    this.a.m.setLayoutParams(paramAnimation);
    this.a.m.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.14
 * JD-Core Version:    0.7.0.1
 */