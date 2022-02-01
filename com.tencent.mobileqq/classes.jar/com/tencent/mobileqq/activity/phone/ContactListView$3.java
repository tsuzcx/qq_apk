package com.tencent.mobileqq.activity.phone;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import cooperation.qqpim.QQPimGetTipsInfoIPC;
import cooperation.qqpim.QQPimTipsInfoHelper;

class ContactListView$3
  implements View.OnClickListener
{
  ContactListView$3(ContactListView paramContactListView) {}
  
  public void onClick(View paramView)
  {
    ContactListView.f(this.a).removeHeaderView(ContactListView.e(this.a));
    ContactListView.a(this.a, null);
    QQPimTipsInfoHelper.a(this.a.getContext(), QQPimGetTipsInfoIPC.a().a);
    QQPimGetTipsInfoIPC.a().d();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.ContactListView.3
 * JD-Core Version:    0.7.0.1
 */