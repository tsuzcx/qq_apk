package com.tencent.mobileqq.activity.contacts.fragment;

import aekt;
import ahnd;
import ahpg;
import ahph;
import ahpi;
import ahpj;
import ahpk;
import aljr;
import alkl;
import alzf;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import azmo;
import bcpe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;

public class TroopFragment
  extends ContactsBaseFragment
  implements View.OnClickListener
{
  public ahnd a;
  protected ahpi a;
  protected ahpj a;
  protected ahpk a;
  private aljr a;
  protected alkl a;
  protected bcpe a;
  protected SwipPinnedHeaderExpandableListView a;
  public boolean c;
  protected boolean d;
  
  public TroopFragment()
  {
    this.jdField_a_of_type_Alkl = new ahpg(this);
    this.jdField_a_of_type_Aljr = new ahph(this);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView != null)
    {
      if (this.jdField_a_of_type_Ahnd != null) {
        this.jdField_a_of_type_Ahnd.f();
      }
      this.jdField_a_of_type_Ahnd = new ahnd(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_Ahnd);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setOnGroupClickListener(this.jdField_a_of_type_Ahnd);
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
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setId(2131373092);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setSelector(2131167138);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setNeedCheckSpringback(true);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setGroupIndicator(null);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setPadding(0, 0, 0, aekt.a(54.0F, getResources()));
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setClipToPadding(false);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setScrollBarStyle(33554432);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.mForContacts = true;
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setOnScrollListener(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bcpe = new bcpe(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "Grp_time", "Grp_contactlist", "visit_time");
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
    if (this.jdField_a_of_type_Ahnd != null) {
      this.jdField_a_of_type_Ahnd.f();
    }
    e();
    if (this.jdField_a_of_type_Bcpe != null) {
      this.jdField_a_of_type_Bcpe.b();
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
    if (this.jdField_a_of_type_Ahnd == null) {
      i();
    }
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.postDelayed(new TroopFragment.1(this), 200L);
    this.d = true;
    this.jdField_a_of_type_Bcpe.a();
    new azmo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("exp").a();
  }
  
  public void av_()
  {
    ((alzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).b();
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
    if (this.jdField_a_of_type_Ahnd != null) {
      this.jdField_a_of_type_Ahnd.a();
    }
    if (paramBoolean) {
      e();
    }
    if (this.d) {
      this.jdField_a_of_type_Bcpe.b();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.TroopFragment", 2, "resetData");
    }
    i();
    if ((this.b) && (this.jdField_a_of_type_Ahnd != null)) {
      this.jdField_a_of_type_Ahnd.notifyDataSetChanged();
    }
    this.jdField_a_of_type_Bcpe = new bcpe(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "Grp_time", "Grp_contactlist", "visit_time");
    if (isResumed()) {
      this.jdField_a_of_type_Bcpe.a();
    }
  }
  
  protected void d()
  {
    if (this.b)
    {
      if (this.jdField_a_of_type_Ahpi == null) {
        this.jdField_a_of_type_Ahpi = new ahpi(this);
      }
      if (this.jdField_a_of_type_Ahpk == null) {
        this.jdField_a_of_type_Ahpk = new ahpk(this);
      }
      if (this.jdField_a_of_type_Ahpj == null) {
        this.jdField_a_of_type_Ahpj = new ahpj(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ahpi);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ahpk);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ahpj);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alkl);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aljr);
    }
  }
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ahpi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ahpk);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ahpj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alkl);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aljr);
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView != null) && (this.jdField_a_of_type_Ahnd != null))
    {
      this.jdField_a_of_type_Ahnd.d();
      if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.getFirstVisiblePosition() > 0) {
        this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setSelection(0);
      }
    }
  }
  
  public void g()
  {
    if ((this.b) && (this.jdField_a_of_type_Ahnd != null)) {
      this.jdField_a_of_type_Ahnd.a();
    }
    if (this.jdField_a_of_type_Bcpe != null) {
      this.jdField_a_of_type_Bcpe.b();
    }
    super.g();
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Ahnd != null) {
      this.jdField_a_of_type_Ahnd.notifyDataSetChanged();
    }
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.fragment.TroopFragment
 * JD-Core Version:    0.7.0.1
 */