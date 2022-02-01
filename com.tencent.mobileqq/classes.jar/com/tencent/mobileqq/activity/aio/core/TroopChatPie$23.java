package com.tencent.mobileqq.activity.aio.core;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;

class TroopChatPie$23
  implements Animation.AnimationListener
{
  TroopChatPie$23(TroopChatPie paramTroopChatPie) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.d.setBackgroundResource(2130843798);
    this.a.a.setBackgroundResource(2130843804);
    this.a.i.setVisibility(8);
    this.a.j.setVisibility(8);
    this.a.g.setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.i.setVisibility(0);
    this.a.j.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.23
 * JD-Core Version:    0.7.0.1
 */