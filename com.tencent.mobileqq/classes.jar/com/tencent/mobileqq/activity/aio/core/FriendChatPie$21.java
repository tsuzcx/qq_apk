package com.tencent.mobileqq.activity.aio.core;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FriendChatPie$21
  implements View.OnClickListener
{
  FriendChatPie$21(FriendChatPie paramFriendChatPie) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.I) {
      ChatActivityFacade.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.21
 * JD-Core Version:    0.7.0.1
 */