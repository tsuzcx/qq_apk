package com.tencent.mobileqq.activity.contacts.fragment;

import actj;
import afpm;
import afrp;
import afrq;
import afrr;
import afrs;
import afrt;
import ajse;
import ajsy;
import akhp;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import axrc;
import baqr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;

public class TroopFragment
  extends ContactsBaseFragment
  implements View.OnClickListener
{
  public afpm a;
  protected afrr a;
  protected afrs a;
  protected afrt a;
  private ajse a;
  protected ajsy a;
  protected baqr a;
  protected SwipPinnedHeaderExpandableListView a;
  public boolean c;
  protected boolean d;
  
  public TroopFragment()
  {
    this.jdField_a_of_type_Ajsy = new afrp(this);
    this.jdField_a_of_type_Ajse = new afrq(this);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView != null)
    {
      if (this.jdField_a_of_type_Afpm != null) {
        this.jdField_a_of_type_Afpm.f();
      }
      this.jdField_a_of_type_Afpm = new afpm(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_Afpm);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setOnGroupClickListener(this.jdField_a_of_type_Afpm);
    }
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView;
  }
  
  protected View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.TroopFragment", 2, "getView");
    }
    if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView = new TroopFragment.ContactsPinnedHeaderExpandableListView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setId(2131372736);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setSelector(2131167087);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setNeedCheckSpringback(true);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setGroupIndicator(null);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setPadding(0, 0, 0, actj.a(54.0F, getResources()));
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setClipToPadding(false);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setScrollBarStyle(33554432);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.mForContacts = true;
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setOnScrollListener(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_Baqr = new baqr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "Grp_time", "Grp_contactlist", "visit_time");
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
    if (this.jdField_a_of_type_Afpm != null) {
      this.jdField_a_of_type_Afpm.f();
    }
    e();
    if (this.jdField_a_of_type_Baqr != null) {
      this.jdField_a_of_type_Baqr.b();
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
    if (this.jdField_a_of_type_Afpm == null) {
      i();
    }
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.postDelayed(new TroopFragment.1(this), 200L);
    this.d = true;
    this.jdField_a_of_type_Baqr.a();
    new axrc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("exp").a();
  }
  
  public void an_()
  {
    ((akhp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).b();
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
    if (this.jdField_a_of_type_Afpm != null) {
      this.jdField_a_of_type_Afpm.a();
    }
    if (paramBoolean) {
      e();
    }
    if (this.d) {
      this.jdField_a_of_type_Baqr.b();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.TroopFragment", 2, "resetData");
    }
    i();
    if ((this.b) && (this.jdField_a_of_type_Afpm != null)) {
      this.jdField_a_of_type_Afpm.notifyDataSetChanged();
    }
    this.jdField_a_of_type_Baqr = new baqr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "Grp_time", "Grp_contactlist", "visit_time");
    if (isResumed()) {
      this.jdField_a_of_type_Baqr.a();
    }
  }
  
  protected void d()
  {
    if (this.b)
    {
      if (this.jdField_a_of_type_Afrr == null) {
        this.jdField_a_of_type_Afrr = new afrr(this);
      }
      if (this.jdField_a_of_type_Afrt == null) {
        this.jdField_a_of_type_Afrt = new afrt(this);
      }
      if (this.jdField_a_of_type_Afrs == null) {
        this.jdField_a_of_type_Afrs = new afrs(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Afrr);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Afrt);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Afrs);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajsy);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajse);
    }
  }
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Afrr);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Afrt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Afrs);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajsy);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajse);
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView != null) && (this.jdField_a_of_type_Afpm != null))
    {
      this.jdField_a_of_type_Afpm.d();
      if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.getFirstVisiblePosition() > 0) {
        this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setSelection(0);
      }
    }
  }
  
  public void g()
  {
    if ((this.b) && (this.jdField_a_of_type_Afpm != null)) {
      this.jdField_a_of_type_Afpm.a();
    }
    if (this.jdField_a_of_type_Baqr != null) {
      this.jdField_a_of_type_Baqr.b();
    }
    super.g();
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Afpm != null) {
      this.jdField_a_of_type_Afpm.notifyDataSetChanged();
    }
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.fragment.TroopFragment
 * JD-Core Version:    0.7.0.1
 */