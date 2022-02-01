package com.tencent.mobileqq.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NewFriendMoreSysMsgAdapter$2
  implements View.OnClickListener
{
  NewFriendMoreSysMsgAdapter$2(NewFriendMoreSysMsgAdapter paramNewFriendMoreSysMsgAdapter, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A327", "0X800A327", 0, 0, "", "", "", "");
    NewFriendMoreSysMsgAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter.2
 * JD-Core Version:    0.7.0.1
 */