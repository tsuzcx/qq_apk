package com.tencent.mobileqq.activity.selectmember;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;

public class ContactFriendInnerFrame
  extends SelectMemberInnerFrame
  implements TabBarView.OnTabChangeListener
{
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public TroopDiscussionBaseV a;
  private TabBarView jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
  private TroopDiscussionBaseV b;
  private TroopDiscussionBaseV c;
  
  public ContactFriendInnerFrame(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public ContactFriendInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ContactFriendInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
  
  private void g()
  {
    if (this.b == null)
    {
      this.b = new PhoneContactTabView(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this);
      this.b.a(null);
    }
    a(this.b);
  }
  
  private void h()
  {
    if (this.c == null)
    {
      this.c = new FriendTabView(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
      this.c.a(null);
    }
    a(this.c);
  }
  
  public ContactSearchFragment a()
  {
    return null;
  }
  
  public String a()
  {
    return "-1";
  }
  
  public void a(int paramInt1, int paramInt2)
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
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 100) && (paramInt2 == -1)) {
      ((PhoneContactTabView)this.b).d();
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle = a();
    setContentView(2131560570);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131378828));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, paramBundle.getString(2131691174));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).setContentDescription(HardCodeUtil.a(2131702511) + paramBundle.getString(2131691174));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, paramBundle.getString(2131691175));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).setContentDescription(paramBundle.getString(2131691175));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131369133));
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(false, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131718990), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.d);
  }
  
  public void d()
  {
    if (this.c != null) {
      this.c.b();
    }
    if (this.b != null) {
      this.b.b();
    }
    super.d();
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV instanceof FriendTabView)) {
      ((FriendTabView)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV).c();
    }
    while (!(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV instanceof PhoneContactTabView)) {
      return;
    }
    ((PhoneContactTabView)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopDiscussionBaseV).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.ContactFriendInnerFrame
 * JD-Core Version:    0.7.0.1
 */