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
import com.tencent.mobileqq.widget.navbar.NavBarAIO;

class TroopChatPie$25
  implements Animation.AnimationListener
{
  TroopChatPie$25(TroopChatPie paramTroopChatPie) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.o.setVisibility(8);
    this.a.p.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.d.setBackgroundDrawable(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.a);
    if (!this.a.D)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130850507);
      this.a.k.setVisibility(8);
      paramAnimation = this.a.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167030);
      this.a.e.setTextColor(paramAnimation);
    }
    for (;;)
    {
      AIOUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, 2130850250);
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130850508);
      this.a.k.setVisibility(8);
      paramAnimation = this.a.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167031);
      this.a.e.setTextColor(paramAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.25
 * JD-Core Version:    0.7.0.1
 */