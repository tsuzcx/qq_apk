package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class StrangerChatPie$1
  implements View.OnClickListener
{
  StrangerChatPie$1(StrangerChatPie paramStrangerChatPie) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.I) {
      ChatActivityFacade.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie.1
 * JD-Core Version:    0.7.0.1
 */