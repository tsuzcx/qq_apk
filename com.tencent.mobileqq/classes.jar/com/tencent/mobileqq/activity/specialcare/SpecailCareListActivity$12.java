package com.tencent.mobileqq.activity.specialcare;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;

class SpecailCareListActivity$12
  implements Animation.AnimationListener
{
  SpecailCareListActivity$12(SpecailCareListActivity paramSpecailCareListActivity, SpecailCareListActivity.ViewHolder paramViewHolder) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new RelativeLayout.LayoutParams(this.a.b.getLayoutParams());
    paramAnimation.addRule(15);
    paramAnimation.setMargins((int)(SpecailCareListActivity.e(this.b) * 46.0F), 0, (int)(SpecailCareListActivity.f(this.b) * 10.0F), 0);
    this.a.b.setLayoutParams(paramAnimation);
    this.a.b.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.12
 * JD-Core Version:    0.7.0.1
 */