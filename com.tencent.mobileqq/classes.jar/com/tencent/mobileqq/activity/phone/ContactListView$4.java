package com.tencent.mobileqq.activity.phone;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import cooperation.qqpim.QQPimDefineList;
import cooperation.qqpim.QQPimGetTipsInfoIPC;
import cooperation.qqpim.QQPimJumpHelper;
import cooperation.qqpim.QQPimTipsInfo;
import cooperation.qqpim.QQPimTipsInfoHelper;

class ContactListView$4
  implements View.OnClickListener
{
  ContactListView$4(ContactListView paramContactListView) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006710", "0X8006710", 0, 0, "", "", "", "");
    ContactListView.a(this.a).removeHeaderView(ContactListView.a(this.a));
    ContactListView.a(this.a, null);
    QQPimTipsInfoHelper.a(this.a.getContext(), QQPimGetTipsInfoIPC.a().a);
    QQPimGetTipsInfoIPC.a().c();
    String str = ContactListView.a(this.a).getAccount();
    Bundle localBundle = new Bundle();
    localBundle.putString(QQPimDefineList.o, QQPimDefineList.j);
    localBundle.putInt(QQPimDefineList.p, QQPimGetTipsInfoIPC.a().a.b);
    localBundle.putString(QQPimDefineList.l, str);
    new QQPimJumpHelper().a(ContactListView.a(this.a), this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localBundle);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.ContactListView.4
 * JD-Core Version:    0.7.0.1
 */