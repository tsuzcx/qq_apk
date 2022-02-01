package com.tencent.mobileqq.activity.specialcare;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;

class SpecailCareListActivity$17
  implements Animation.AnimationListener
{
  SpecailCareListActivity$17(SpecailCareListActivity paramSpecailCareListActivity, SpecailCareListActivity.ViewHolder paramViewHolder) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new RelativeLayout.LayoutParams(this.a.b.getLayoutParams());
    paramAnimation.addRule(15);
    paramAnimation.setMargins((int)(SpecailCareListActivity.j(this.b) * 12.0F), 0, (int)(SpecailCareListActivity.k(this.b) * 10.0F), 0);
    this.a.b.setLayoutParams(paramAnimation);
    this.a.b.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.17
 * JD-Core Version:    0.7.0.1
 */