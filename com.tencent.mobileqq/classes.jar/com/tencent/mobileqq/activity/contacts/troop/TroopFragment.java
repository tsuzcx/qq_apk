package com.tencent.mobileqq.activity.contacts.troop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.widget.TroopUsingTimeReport;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;

public class TroopFragment
  extends ContactsBaseFragment
  implements View.OnClickListener
{
  protected ContactsTroopAdapter a;
  protected TroopFragment.MyAvatarObserver a;
  protected TroopFragment.MyFriendListObserver a;
  protected TroopFragment.MyMessageObserver a;
  protected TroopFragment.MyTroopBusinessObserver a;
  protected TroopFragment.MyTroopObserver a;
  private AutomatorObserver a;
  protected BizTroopObserver a;
  protected TroopUsingTimeReport a;
  protected SwipPinnedHeaderExpandableListView a;
  protected boolean d;
  protected boolean e;
  
  public TroopFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new TroopFragment.2(this);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver = new TroopFragment.3(this);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.b();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter = new ContactsTroopAdapter(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setOnGroupClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter);
    }
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView;
  }
  
  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.TroopFragment", 2, "getView");
    }
    if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView = new TroopFragment.ContactsPinnedHeaderExpandableListView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setId(2131374317);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setSelector(2131167305);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setNeedCheckSpringback(true);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setGroupIndicator(null);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setPadding(0, 0, 0, AIOUtils.a(54.0F, getResources()));
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setClipToPadding(false);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setScrollBarStyle(33554432);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.mForContacts = true;
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setOnScrollListener(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport = new TroopUsingTimeReport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "Grp_time", "Grp_contactlist", "visit_time");
      return this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView;
      paramLayoutInflater = this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.getParent();
      if ((paramLayoutInflater != null) && ((paramLayoutInflater instanceof ViewGroup))) {
        ((ViewGroup)paramLayoutInflater).removeView(this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView);
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.TroopFragment", 2, "doOnDestroy");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.b();
    }
    e();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport.b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.TroopFragment", 2, "onResume:" + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView == null) {
      return;
    }
    if (paramBoolean) {
      d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter == null) {
      i();
    }
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.postDelayed(new TroopFragment.1(this), 200L);
    this.e = true;
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport.a();
    new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("exp").a();
  }
  
  public void ag_()
  {
    ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).b();
    this.d = true;
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.TroopFragment", 2, "onPause");
    }
    if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView != null) {
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.hideCurShowingRightView();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.a();
    }
    if (paramBoolean) {
      e();
    }
    if (this.e) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport.b();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.TroopFragment", 2, "resetData");
    }
    i();
    if ((this.b) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.notifyDataSetChanged();
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport = new TroopUsingTimeReport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "Grp_time", "Grp_contactlist", "visit_time");
    if (isResumed()) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport.a();
    }
  }
  
  public void d()
  {
    if (this.b)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopTroopFragment$MyFriendListObserver == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopTroopFragment$MyFriendListObserver = new TroopFragment.MyFriendListObserver(this);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopTroopFragment$MyAvatarObserver == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopTroopFragment$MyAvatarObserver = new TroopFragment.MyAvatarObserver(this);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopTroopFragment$MyTroopObserver == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopTroopFragment$MyTroopObserver = new TroopFragment.MyTroopObserver(this);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopTroopFragment$MyTroopBusinessObserver == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopTroopFragment$MyTroopBusinessObserver = new TroopFragment.MyTroopBusinessObserver(this);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopTroopFragment$MyMessageObserver == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopTroopFragment$MyMessageObserver = new TroopFragment.MyMessageObserver(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopTroopFragment$MyFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopTroopFragment$MyAvatarObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopTroopFragment$MyTroopObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopTroopFragment$MyTroopBusinessObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopTroopFragment$MyMessageObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver);
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopTroopFragment$MyFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopTroopFragment$MyAvatarObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopTroopFragment$MyTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopTroopFragment$MyTroopBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopTroopFragment$MyMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver);
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.e();
      if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.getFirstVisiblePosition() > 0) {
        this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setSelection(0);
      }
    }
  }
  
  public void g()
  {
    if ((this.b) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopUsingTimeReport.b();
    }
    super.g();
  }
  
  void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.notifyDataSetChanged();
    }
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troop.TroopFragment
 * JD-Core Version:    0.7.0.1
 */