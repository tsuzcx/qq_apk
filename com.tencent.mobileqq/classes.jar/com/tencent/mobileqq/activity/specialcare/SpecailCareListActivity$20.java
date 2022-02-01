package com.tencent.mobileqq.activity.specialcare;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;

class SpecailCareListActivity$20
  implements Animation.AnimationListener
{
  SpecailCareListActivity$20(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.leftView.clearAnimation();
    this.a.f.clearAnimation();
    this.a.leftView.setVisibility(0);
    this.a.f.setVisibility(0);
    this.a.rightViewText.setClickable(true);
    this.a.rightViewText.setText(SpecailCareListActivity.a);
    this.a.rightViewText.setContentDescription(HardCodeUtil.a(2131911639));
    this.a.z = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.20
 * JD-Core Version:    0.7.0.1
 */