package com.tencent.mobileqq.activity.contacts.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contacts.adapter.ContactsDisAdapter;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;
import wkb;
import wkc;

public class DiscussionFragment
  extends ContactsBaseFragment
  implements View.OnClickListener
{
  public ContactsDisAdapter a;
  protected SwipPinnedHeaderExpandableListView a;
  protected wkc a;
  public boolean c;
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter.f();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter = new ContactsDisAdapter(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter);
    }
  }
  
  public int a()
  {
    return 9999;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView;
  }
  
  protected View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.DiscussionFragment", 2, "getView");
    }
    if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView = new TroopFragment.ContactsPinnedHeaderExpandableListView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setId(2131362391);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setSelector(2131492923);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setNeedCheckSpringback(true);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setGroupIndicator(null);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.mForContacts = true;
      paramLayoutInflater = paramLayoutInflater.inflate(2130968823, this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView, false);
      paramBundle = (TextView)paramLayoutInflater.findViewById(2131363924);
      paramBundle.setText(2131438928);
      paramLayoutInflater.setContentDescription(paramBundle.getText());
      paramLayoutInflater.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.addHeaderView(paramLayoutInflater);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setOnScrollListener(this);
    }
    for (;;)
    {
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
      QLog.d("contacts.fragment.DiscussionFragment", 2, "doOnDestroy");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter.f();
    }
    e();
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.DiscussionFragment", 2, "doOnResume:" + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView == null) {
      return;
    }
    if (paramBoolean) {
      d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter == null) {
      h();
    }
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.postDelayed(new wkb(this), 200L);
  }
  
  public void b()
  {
    ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).f(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue());
    this.c = true;
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.DiscussionFragment", 2, "doOnPause");
    }
    if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView != null) {
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter.b();
    }
    if (paramBoolean) {
      e();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.DiscussionFragment", 2, "resetData");
    }
    h();
    if ((this.b) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter.notifyDataSetChanged();
    }
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Wkc == null) {
      this.jdField_a_of_type_Wkc = new wkc(this, null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Wkc);
    }
  }
  
  protected void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_Wkc != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Wkc);
    }
  }
  
  public void f()
  {
    if ((this.b) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter.b();
    }
    super.f();
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsDisAdapter.a();
      if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.getFirstVisiblePosition() > 0) {
        this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setSelection(0);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((-1 == paramInt2) && (paramInt1 == 1300) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("roomId");
      if (paramIntent != null)
      {
        TroopUtils.a(getActivity(), paramIntent);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006264", "0X8006264", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    paramView = new Intent(getActivity(), SelectMemberActivity.class);
    paramView.putExtra("param_type", 3000);
    paramView.putExtra("param_subtype", 0);
    paramView.putExtra("param_from", 1002);
    paramView.putExtra("param_min", 2);
    paramView.putExtra("param_max", 99);
    paramView.putExtra("multi_chat", true);
    startActivityForResult(paramView, 1300);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Contacts_tab", "Contacts_tab_creat_discuss", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.fragment.DiscussionFragment
 * JD-Core Version:    0.7.0.1
 */