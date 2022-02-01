package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LimitChatPie$23
  implements View.OnClickListener
{
  LimitChatPie$23(LimitChatPie paramLimitChatPie) {}
  
  public void onClick(View paramView)
  {
    if ((!this.a.t()) && (LimitChatPie.a(this.a) != 5))
    {
      LimitChatPie.c(this.a);
    }
    else
    {
      com.tencent.mobileqq.activity.aio.AIOUtils.o = true;
      LimitChatPie.d(this.a);
      PlusPanelUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, null, null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.23
 * JD-Core Version:    0.7.0.1
 */