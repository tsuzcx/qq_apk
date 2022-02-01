package com.tencent.mobileqq.activity.contacts.troop;

import agej;
import ajxr;
import ajxs;
import ajxt;
import ajxu;
import ajxv;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import antg;
import anua;
import aoip;
import bdlq;
import bgyg;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;

public class TroopFragment
  extends ContactsBaseFragment
  implements View.OnClickListener
{
  protected ajxt a;
  protected ajxu a;
  protected ajxv a;
  private antg a;
  protected anua a;
  protected bgyg a;
  public ContactsTroopAdapter a;
  protected SwipPinnedHeaderExpandableListView a;
  public boolean c;
  protected boolean d;
  
  public TroopFragment()
  {
    this.jdField_a_of_type_Anua = new ajxr(this);
    this.jdField_a_of_type_Antg = new ajxs(this);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.c();
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
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setId(2131373863);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setSelector(2131167247);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setNeedCheckSpringback(true);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setGroupIndicator(null);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setPadding(0, 0, 0, agej.a(54.0F, getResources()));
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setClipToPadding(false);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setScrollBarStyle(33554432);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.mForContacts = true;
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setOnScrollListener(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bgyg = new bgyg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "Grp_time", "Grp_contactlist", "visit_time");
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
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.c();
    }
    e();
    if (this.jdField_a_of_type_Bgyg != null) {
      this.jdField_a_of_type_Bgyg.b();
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
    this.d = true;
    this.jdField_a_of_type_Bgyg.a();
    new bdlq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("exp").a();
  }
  
  public void ap_()
  {
    ((aoip)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).b();
    this.c = true;
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.TroopFragment", 2, "onPause");
    }
    if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView != null) {
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.a();
    }
    if (paramBoolean) {
      e();
    }
    if (this.d) {
      this.jdField_a_of_type_Bgyg.b();
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
    this.jdField_a_of_type_Bgyg = new bgyg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "Grp_time", "Grp_contactlist", "visit_time");
    if (isResumed()) {
      this.jdField_a_of_type_Bgyg.a();
    }
  }
  
  public void d()
  {
    if (this.b)
    {
      if (this.jdField_a_of_type_Ajxt == null) {
        this.jdField_a_of_type_Ajxt = new ajxt(this);
      }
      if (this.jdField_a_of_type_Ajxv == null) {
        this.jdField_a_of_type_Ajxv = new ajxv(this);
      }
      if (this.jdField_a_of_type_Ajxu == null) {
        this.jdField_a_of_type_Ajxu = new ajxu(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajxt);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajxv);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajxu);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anua);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Antg);
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxv);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anua);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Antg);
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.f();
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
    if (this.jdField_a_of_type_Bgyg != null) {
      this.jdField_a_of_type_Bgyg.b();
    }
    super.g();
  }
  
  public void h()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troop.TroopFragment
 * JD-Core Version:    0.7.0.1
 */