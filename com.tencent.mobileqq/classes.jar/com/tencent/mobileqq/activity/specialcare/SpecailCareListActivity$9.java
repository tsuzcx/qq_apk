package com.tencent.mobileqq.activity.specialcare;

import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid;

class SpecailCareListActivity$9
  implements Animation.AnimationListener
{
  SpecailCareListActivity$9(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.m.clearAnimation();
    ((FrameLayout)this.a.getWindow().getDecorView()).removeView(this.a.m);
    paramAnimation = this.a;
    paramAnimation.m = null;
    if (paramAnimation.s != null)
    {
      this.a.s.b();
      this.a.s = null;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.9
 * JD-Core Version:    0.7.0.1
 */