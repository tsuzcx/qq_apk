package com.tencent.mobileqq.activity.selectmember;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PinnedFooterExpandableListView;

public class FriendTabView
  extends TroopDiscussionBaseV
  implements View.OnClickListener
{
  private SelectMemberBuddyListAdapter jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberBuddyListAdapter;
  private PinnedFooterExpandableListView jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public FriendTabView(SelectMemberActivity paramSelectMemberActivity)
  {
    super(paramSelectMemberActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity = paramSelectMemberActivity;
  }
  
  public void a()
  {
    super.a();
    if ((this.b) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
      if (localPhoneContactManagerImp != null)
      {
        int i = localPhoneContactManagerImp.d();
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
    super.a(paramBundle);
    a(2131560567);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView = ((PinnedFooterExpandableListView)findViewById(2131366466));
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("FriendTabView", 2, "firstUserClicked is " + this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setFooterEnable(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setListener(new FriendTabView.1(this));
      paramBundle = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getLayoutInflater().inflate(2131563140, null);
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.addHeaderView(paramBundle);
      paramBundle.findViewById(2131364177).setOnClickListener(new FriendTabView.2(this));
      QLog.d("FriendTabView", 2, "----->onCreate");
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberBuddyListAdapter = new SelectMemberBuddyListAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView, new FriendTabView.3(this), true);
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberBuddyListAdapter);
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setSelector(2131167305);
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setGroupIndicator(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getResources().getDrawable(2130839625));
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setOnScrollListener(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberBuddyListAdapter);
      paramBundle = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
      if ((paramBundle != null) && (!paramBundle.d()) && (paramBundle.d() == 8)) {}
      return;
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setFooterEnable(false);
    }
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberBuddyListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberBuddyListAdapter.b();
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.FriendTabView
 * JD-Core Version:    0.7.0.1
 */