package com.tencent.mobileqq.activity.selectmember;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import anvx;
import biuc;
import com.tencent.mobileqq.activity.SelectedAndSearchBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;

public class TroopDiscussionListInnerFrame
  extends SelectMemberInnerFrame
  implements biuc
{
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TroopDiscussionBaseV jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV;
  private TabBarView jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
  private TroopDiscussionBaseV b;
  private TroopDiscussionBaseV c;
  
  public TroopDiscussionListInnerFrame(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public TroopDiscussionListInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TroopDiscussionListInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(TroopDiscussionBaseV paramTroopDiscussionBaseV)
  {
    BaseActivity localBaseActivity = (BaseActivity)a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV != paramTroopDiscussionBaseV)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV != null)
      {
        if (localBaseActivity.isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV.e();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV.f();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV = paramTroopDiscussionBaseV;
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV.b(null);
        if (localBaseActivity.isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV.a();
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV);
      }
    }
  }
  
  public ContactSearchFragment a()
  {
    int i = 1;
    if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mOnlyFriends)
    {
      i = 4194309;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mDonotNeedContacts) {
        i = 4194565;
      }
    }
    return ContactSearchFragment.a(-1, i | 0x8 | 0x200000 | 0x10, null, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mUinsToHide, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
  }
  
  public String a()
  {
    return "-1";
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle = a();
    setContentView(2131560483);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131378400));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, paramBundle.getString(2131691072));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).setContentDescription(anvx.a(2131714649) + paramBundle.getString(2131691072));
    if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mDonotNeedDiscussion)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, paramBundle.getString(2131691071));
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).setContentDescription(paramBundle.getString(2131691071));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131368901));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, false);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mOnlySelectTroopOrDiscussionMember) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.setupTitleBar(false, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131718467), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131718491));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mSelectedAndSearchBar.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mSelectedAndSearchBar.b();
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.quitSearchState();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.setupTitleBar(true, "", this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131718491));
    }
  }
  
  public void c()
  {
    super.c();
  }
  
  public void d()
  {
    if (this.b != null) {
      this.b.b();
    }
    if (this.c != null) {
      this.c.b();
    }
    super.d();
  }
  
  public void f() {}
  
  public void g()
  {
    if (this.b == null)
    {
      this.b = new TroopDiscussionTroop(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
      this.b.a(null);
    }
    a(this.b);
  }
  
  public void h()
  {
    if (this.c == null)
    {
      this.c = new TroopDiscussionDiscussion(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
      this.c.a(null);
    }
    a(this.c);
  }
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      return;
    case 0: 
      g();
      return;
    }
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopDiscussionListInnerFrame
 * JD-Core Version:    0.7.0.1
 */