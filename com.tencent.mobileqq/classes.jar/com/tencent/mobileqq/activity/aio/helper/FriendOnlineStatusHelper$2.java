package com.tencent.mobileqq.activity.aio.helper;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FriendOnlineStatusHelper$2
  implements View.OnClickListener
{
  FriendOnlineStatusHelper$2(FriendOnlineStatusHelper paramFriendOnlineStatusHelper) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mQimStatusOnClickListener.onClick: invoked. info: v = ");
      localStringBuilder.append(paramView);
      QLog.i("FriendOnlineStatusHelper", 2, localStringBuilder.toString());
    }
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80087E6", "0X80087E6", 0, 0, "", "", "", "");
    QIMUserManager.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FriendOnlineStatusHelper.2
 * JD-Core Version:    0.7.0.1
 */