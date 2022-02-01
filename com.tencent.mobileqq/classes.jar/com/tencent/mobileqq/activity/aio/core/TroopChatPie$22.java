package com.tencent.mobileqq.activity.aio.core;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;

class TroopChatPie$22
  implements Animation.AnimationListener
{
  TroopChatPie$22(TroopChatPie paramTroopChatPie) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.ba.setBackgroundResource(2130844752);
    this.a.p.setBackgroundResource(2130844758);
    this.a.bw.setVisibility(8);
    this.a.bx.setVisibility(8);
    this.a.bu.setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.bw.setVisibility(0);
    this.a.bx.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.22
 * JD-Core Version:    0.7.0.1
 */