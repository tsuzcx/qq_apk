package com.tencent.mobileqq.activity.aio.core;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FriendChatPie$4
  implements View.OnClickListener
{
  FriendChatPie$4(FriendChatPie paramFriendChatPie) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.a.b, 2, "mQimStatusOnClickListener.onClick: invoked. info: v = " + paramView);
    }
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80087E6", "0X80087E6", 0, 0, "", "", "", "");
    QIMUserManager.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.4
 * JD-Core Version:    0.7.0.1
 */