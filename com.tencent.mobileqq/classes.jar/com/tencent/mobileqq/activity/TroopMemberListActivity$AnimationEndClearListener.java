package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class TroopMemberListActivity$AnimationEndClearListener
  implements Animation.AnimationListener
{
  View a;
  int b = -1;
  
  public TroopMemberListActivity$AnimationEndClearListener(TroopMemberListActivity paramTroopMemberListActivity, View paramView, int paramInt)
  {
    this.a = paramView;
    this.b = paramInt;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.c.mHandler.postDelayed(new TroopMemberListActivity.AnimationEndClearListener.1(this), 0L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    paramAnimation = (String)this.a.getTag();
    if ((this.b == 1) && (paramAnimation.equals("left")))
    {
      this.a.clearAnimation();
      this.b = 6;
    }
    if ((this.b == 0) && (paramAnimation.equals("right")))
    {
      this.a.clearAnimation();
      this.b = 6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.AnimationEndClearListener
 * JD-Core Version:    0.7.0.1
 */