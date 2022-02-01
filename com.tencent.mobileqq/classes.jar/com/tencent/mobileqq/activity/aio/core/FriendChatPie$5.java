package com.tencent.mobileqq.activity.aio.core;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.vas.CustomOnlineStatusManager.Utils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FriendChatPie$5
  implements View.OnClickListener
{
  FriendChatPie$5(FriendChatPie paramFriendChatPie) {}
  
  public void onClick(View paramView)
  {
    if (!OnLineStatusHelper.a().a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView)) {
      CustomOnlineStatusManager.Utils.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, "aio");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.5
 * JD-Core Version:    0.7.0.1
 */