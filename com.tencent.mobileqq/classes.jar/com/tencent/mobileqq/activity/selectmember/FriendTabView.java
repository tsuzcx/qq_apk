package com.tencent.mobileqq.activity.selectmember;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PinnedFooterExpandableListView;
import xvr;
import xvs;
import xvt;

public class FriendTabView
  extends TroopDiscussionBaseV
  implements View.OnClickListener
{
  private SelectMemberBuddyListAdapter jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberBuddyListAdapter;
  private PinnedFooterExpandableListView jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView;
  public boolean a;
  boolean b = false;
  boolean c = false;
  boolean d = false;
  
  public FriendTabView(SelectMemberActivity paramSelectMemberActivity)
  {
    super(paramSelectMemberActivity);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity = paramSelectMemberActivity;
  }
  
  public void a()
  {
    super.a();
    if ((this.b) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if (localPhoneContactManagerImp != null)
      {
        int i = localPhoneContactManagerImp.c();
        if ((i != 8) && (i != 9)) {}
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
      return;
    }
    finally
    {
      this.b = false;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    boolean bool = true;
    super.a(paramBundle);
    a(2130969707);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView = ((PinnedFooterExpandableListView)findViewById(2131367521));
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("FriendTabView", 2, "firstUserClicked is " + this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setFooterEnable(true);
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setListener(new xvr(this));
      paramBundle = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getLayoutInflater().inflate(2130971619, null);
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.addHeaderView(paramBundle);
      paramBundle.findViewById(2131375118).setOnClickListener(new xvs(this));
      QLog.d("FriendTabView", 2, "----->onCreate");
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberBuddyListAdapter = new SelectMemberBuddyListAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView, new xvt(this), true);
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberBuddyListAdapter);
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setSelector(2131492923);
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setGroupIndicator(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getResources().getDrawable(2130838656));
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setOnScrollListener(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberBuddyListAdapter);
      paramBundle = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if (((paramBundle != null) && (!paramBundle.c()) && (paramBundle.c() == 8)) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f != 10)) {
        break label300;
      }
    }
    for (;;)
    {
      this.c = bool;
      this.d = ConfigSystemImpl.b(getContext());
      return;
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setFooterEnable(false);
      break;
      label300:
      bool = false;
    }
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberBuddyListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberBuddyListAdapter.b();
    }
    this.d = false;
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    c();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberBuddyListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberBuddyListAdapter.a();
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.FriendTabView
 * JD-Core Version:    0.7.0.1
 */