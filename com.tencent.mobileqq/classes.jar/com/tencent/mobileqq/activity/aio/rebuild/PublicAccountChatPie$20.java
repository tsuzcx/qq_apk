package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublicAccountChatPie$20
  implements View.OnClickListener
{
  PublicAccountChatPie$20(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null)
    {
      QQAppInterface localQQAppInterface = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.a.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId);
      ReportController.b(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8004EFC", "0X8004EFC", 0, 0, "", "", localStringBuilder.toString(), "");
    }
    this.a.k();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.20
 * JD-Core Version:    0.7.0.1
 */