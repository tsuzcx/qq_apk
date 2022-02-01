package com.tencent.mobileqq.activity.specialcare;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;

class SpecailCareListActivity$15
  implements Animation.AnimationListener
{
  SpecailCareListActivity$15(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.leftView.clearAnimation();
    this.a.f.clearAnimation();
    this.a.leftView.setVisibility(4);
    this.a.f.setVisibility(8);
    this.a.rightViewText.setClickable(true);
    this.a.rightViewText.setText(SpecailCareListActivity.b);
    this.a.rightViewText.setContentDescription(HardCodeUtil.a(2131911644));
    this.a.z = true;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.15
 * JD-Core Version:    0.7.0.1
 */