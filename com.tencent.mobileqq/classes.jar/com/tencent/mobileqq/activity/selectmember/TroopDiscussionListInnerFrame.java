package com.tencent.mobileqq.activity.selectmember;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;

public class TroopDiscussionListInnerFrame
  extends SelectMemberInnerFrame
  implements TabBarView.OnTabChangeListener
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
    if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.k)
    {
      i = 4194309;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_h_of_type_Boolean) {
        i = 4194565;
      }
    }
    return ContactSearchFragment.a(-1, i | 0x8 | 0x200000 | 0x10, null, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_h_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
  }
  
  public String a()
  {
    return "-1";
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle = a();
    setContentView(2130969724);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131363113));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, paramBundle.getString(2131433275));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).setContentDescription("已选定" + paramBundle.getString(2131433275));
    if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.j)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, paramBundle.getString(2131433278));
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).setContentDescription(paramBundle.getString(2131433278));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131366488));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, false);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.o) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(false, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131435990), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131435984));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a.hasFocus())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a.clearFocus();
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.p();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131435991), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131435984));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopDiscussionListInnerFrame
 * JD-Core Version:    0.7.0.1
 */