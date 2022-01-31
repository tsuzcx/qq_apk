package com.tencent.mobileqq.activity.selectmember;

import SecurityAccountServer.RespondQueryQQBindingStat;
import ahpx;
import ahpy;
import ahpz;
import ahrj;
import ajjy;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import aroh;
import atog;
import bbjs;
import bblg;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import java.util.List;
import mqq.os.MqqHandler;

public class ContactsInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener, bbjs, bblg
{
  private ahpz jdField_a_of_type_Ahpz;
  private aroh jdField_a_of_type_Aroh;
  private atog jdField_a_of_type_Atog;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  public List<PhoneContact> a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new ahpx(this);
  
  public ContactsInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public ContactsInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ContactsInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131298501));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131302454));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131101491);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
  }
  
  private void h()
  {
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_Aroh.f();
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(3);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(3, 1000L);
      return;
    }
    if (this.jdField_a_of_type_Ahpz == null)
    {
      this.jdField_a_of_type_Ahpz = new ahpz(this, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Ahpz);
    }
    this.jdField_a_of_type_Ahpz.a();
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Aroh == null) {
      this.jdField_a_of_type_Aroh = ((aroh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11));
    }
    if (this.jdField_a_of_type_Atog == null) {
      this.jdField_a_of_type_Atog = new ahpy(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Atog);
  }
  
  private void j() {}
  
  public ContactSearchFragment a()
  {
    return ContactSearchFragment.a(-1, 768, null, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.d, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
  }
  
  public String a()
  {
    return "-1";
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2131496798);
    this.jdField_a_of_type_Aroh = ((aroh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(ContactsInnerFrame.class, this.jdField_a_of_type_MqqOsMqqHandler);
    g();
    this.jdField_a_of_type_Ahpz = new ahpz(this, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Ahpz);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() > 0) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount() < this.jdField_a_of_type_Ahpz.getCount() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount()))) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.e()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(2);
  }
  
  public void a(String paramString)
  {
    if ("$".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Ahpz.a(paramString);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount());
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131653392), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131629351));
    switch (this.jdField_a_of_type_Aroh.d())
    {
    case 2: 
    case 3: 
    case 4: 
    case 8: 
    default: 
      i();
      return;
    case 0: 
    case 7: 
    case 9: 
      h();
      return;
    case 1: 
    case 5: 
      j();
      return;
    }
    if (this.jdField_a_of_type_Aroh.a().lastUsedFlag == 2L)
    {
      h();
      return;
    }
    j();
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(3);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(ContactsInnerFrame.class);
    if (this.jdField_a_of_type_Ahpz != null) {
      this.jdField_a_of_type_Ahpz.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Atog);
  }
  
  public void f()
  {
    this.jdField_a_of_type_Ahpz.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    ahrj localahrj = (ahrj)paramView.getTag();
    PhoneContact localPhoneContact;
    boolean bool;
    if ((localahrj != null) && (localahrj.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localahrj.jdField_a_of_type_ComTencentMobileqqDataPhoneContact != null))
    {
      localPhoneContact = localahrj.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
      if (localahrj.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        if (!localahrj.jdField_a_of_type_Boolean) {
          break label150;
        }
        bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localahrj.jdField_a_of_type_JavaLangString, localPhoneContact.name, 5, "-1");
      }
    }
    for (;;)
    {
      localahrj.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      if (AppSetting.c)
      {
        if (!localahrj.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
          break label252;
        }
        if (!localahrj.jdField_a_of_type_Boolean) {
          break;
        }
        paramView.setContentDescription(localahrj.b.getText() + this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131653396));
      }
      return;
      label150:
      if (localahrj.jdField_a_of_type_JavaLangString.startsWith("+")) {
        bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localahrj.jdField_a_of_type_JavaLangString, localPhoneContact.name, 4, "-1");
      } else {
        bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localahrj.jdField_a_of_type_JavaLangString, localPhoneContact.name, 0, "-1");
      }
    }
    paramView.setContentDescription(localahrj.b.getText().toString() + ajjy.a(2131636758));
    return;
    label252:
    if (localahrj.jdField_a_of_type_Boolean) {}
    for (int i = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localahrj.jdField_a_of_type_JavaLangString);; i = 0)
    {
      if ((localahrj.jdField_a_of_type_Boolean) && (i != 0))
      {
        paramView.setContentDescription(localahrj.b.getText() + this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(i));
        return;
      }
      paramView.setContentDescription(localahrj.b.getText().toString() + ajjy.a(2131636752));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.ContactsInnerFrame
 * JD-Core Version:    0.7.0.1
 */