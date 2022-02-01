package com.tencent.mobileqq.activity.phone;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqpim.QQPimDefineList;
import cooperation.qqpim.QQPimGetTipsInfoIPC;
import cooperation.qqpim.QQPimJumpHelper;
import cooperation.qqpim.QQPimTipsInfoHelper;
import mqq.app.TicketManagerImpl;

class ContactListView$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80066FF", "0X80066FF", 0, 0, "", "", "", "");
    ContactListView.a(this.a).setVisibility(4);
    QQPimTipsInfoHelper.a(this.a.getContext(), QQPimGetTipsInfoIPC.a().a);
    String str = ContactListView.a(this.a).getAccount();
    Object localObject1 = (TicketManagerImpl)ContactListView.a(this.a).getManager(2);
    if (localObject1 != null)
    {
      localObject1 = ((TicketManagerImpl)localObject1).getA2(str);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("a2 = ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.i("ContactListView", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putString(QQPimDefineList.o, QQPimDefineList.i);
      ((Bundle)localObject2).putString(QQPimDefineList.l, str);
      ((Bundle)localObject2).putString(QQPimDefineList.m, (String)localObject1);
      new QQPimJumpHelper().a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (Bundle)localObject2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.ContactListView.2
 * JD-Core Version:    0.7.0.1
 */