package com.tencent.mobileqq.activity.aio.core;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;

class TroopChatPie$23
  implements Animation.AnimationListener
{
  TroopChatPie$23(TroopChatPie paramTroopChatPie) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.bw.setVisibility(8);
    this.a.bx.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.ba.setBackgroundDrawable(this.a.ah.H.c);
    if (!this.a.aL)
    {
      this.a.p.setNotDefaultThemeBackground();
      this.a.aM.setVisibility(8);
      paramAnimation = this.a.e.getResources().getColorStateList(2131167990);
      this.a.C.setTextColor(paramAnimation);
    }
    else
    {
      this.a.p.setBackgroundResource(2130852229);
      this.a.aM.setVisibility(8);
      paramAnimation = this.a.e.getResources().getColorStateList(2131167991);
      this.a.C.setTextColor(paramAnimation);
    }
    if (QQTheme.isNowSimpleUI())
    {
      AIOUtils.a(this.a.X, 0);
      return;
    }
    AIOUtils.a(this.a.X, 2130851968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.23
 * JD-Core Version:    0.7.0.1
 */