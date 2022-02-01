package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class AccountManageActivity$AnimationEndClearListener
  implements Animation.AnimationListener
{
  View a;
  int b = -1;
  
  public AccountManageActivity$AnimationEndClearListener(AccountManageActivity paramAccountManageActivity, View paramView, int paramInt)
  {
    this.a = paramView;
    this.b = paramInt;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.a;
    if (paramAnimation == null) {
      return;
    }
    int i = this.b;
    if (i != 1)
    {
      if (i == 2) {
        paramAnimation.setVisibility(8);
      }
    }
    else
    {
      paramAnimation.setVisibility(0);
      if (this.a.getId() == 2131430661) {
        this.c.c();
      }
    }
    this.a.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.AnimationEndClearListener
 * JD-Core Version:    0.7.0.1
 */