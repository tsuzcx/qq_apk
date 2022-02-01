package com.tencent.mobileqq.activity.aio.core;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;

class TroopChatPie$24
  implements Animation.AnimationListener
{
  TroopChatPie$24(TroopChatPie paramTroopChatPie) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.d.setBackgroundResource(2130843878);
    this.a.a.setBackgroundResource(2130843884);
    this.a.o.setVisibility(8);
    this.a.p.setVisibility(8);
    this.a.m.setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.o.setVisibility(0);
    this.a.p.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.24
 * JD-Core Version:    0.7.0.1
 */