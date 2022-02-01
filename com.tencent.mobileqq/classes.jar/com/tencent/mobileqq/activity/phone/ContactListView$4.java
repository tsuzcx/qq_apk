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
    ReportController.b(this.a.a, "CliOper", "", "", "0X8006710", "0X8006710", 0, 0, "", "", "", "");
    ContactListView.f(this.a).removeHeaderView(ContactListView.e(this.a));
    ContactListView.a(this.a, null);
    QQPimTipsInfoHelper.a(this.a.getContext(), QQPimGetTipsInfoIPC.a().a);
    QQPimGetTipsInfoIPC.a().d();
    String str = ContactListView.b(this.a).getAccount();
    Bundle localBundle = new Bundle();
    localBundle.putString(QQPimDefineList.p, QQPimDefineList.k);
    localBundle.putInt(QQPimDefineList.q, QQPimGetTipsInfoIPC.a().a.d);
    localBundle.putString(QQPimDefineList.m, str);
    new QQPimJumpHelper().a(ContactListView.b(this.a), this.a.b, localBundle);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.ContactListView.4
 * JD-Core Version:    0.7.0.1
 */