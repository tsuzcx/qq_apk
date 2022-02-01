package com.tencent.mobileqq.activity.aio.core;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FriendChatPie$6
  implements View.OnClickListener
{
  FriendChatPie$6(FriendChatPie paramFriendChatPie) {}
  
  public void onClick(View paramView)
  {
    if (this.a.i.getVisibility() == 0) {
      ThreadManager.post(new FriendChatPie.6.1(this), 5, null, false);
    }
    com.tencent.mobileqq.activity.aio.AIOUtils.o = true;
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Clk_aio_right", 0, 0, String.valueOf(0), "", "", "");
    PlusPanelUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, null, this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.6
 * JD-Core Version:    0.7.0.1
 */