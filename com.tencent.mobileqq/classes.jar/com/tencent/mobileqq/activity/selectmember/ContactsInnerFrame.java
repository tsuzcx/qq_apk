package com.tencent.mobileqq.activity.selectmember;

import SecurityAccountServer.RespondQueryQQBindingStat;
import ajtx;
import ajty;
import ajtz;
import ajvj;
import alpo;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import aubm;
import awdn;
import bemh;
import benv;
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
  implements View.OnClickListener, bemh, benv
{
  private ajtz jdField_a_of_type_Ajtz;
  private aubm jdField_a_of_type_Aubm;
  private awdn jdField_a_of_type_Awdn;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  public List<PhoneContact> a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new ajtx(this);
  
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131364120));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131368212));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131167138);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
  }
  
  private void h()
  {
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_Aubm.f();
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(3);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(3, 1000L);
      return;
    }
    if (this.jdField_a_of_type_Ajtz == null)
    {
      this.jdField_a_of_type_Ajtz = new ajtz(this, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Ajtz);
    }
    this.jdField_a_of_type_Ajtz.a();
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Aubm == null) {
      this.jdField_a_of_type_Aubm = ((aubm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11));
    }
    if (this.jdField_a_of_type_Awdn == null) {
      this.jdField_a_of_type_Awdn = new ajty(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Awdn);
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
    setContentView(2131562601);
    this.jdField_a_of_type_Aubm = ((aubm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(ContactsInnerFrame.class, this.jdField_a_of_type_MqqOsMqqHandler);
    g();
    this.jdField_a_of_type_Ajtz = new ajtz(this, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Ajtz);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() > 0) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount() < this.jdField_a_of_type_Ajtz.getCount() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount()))) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.e()))
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
      i = this.jdField_a_of_type_Ajtz.a(paramString);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount());
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131719713), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131695186));
    switch (this.jdField_a_of_type_Aubm.d())
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
    if (this.jdField_a_of_type_Aubm.a().lastUsedFlag == 2L)
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
    if (this.jdField_a_of_type_Ajtz != null) {
      this.jdField_a_of_type_Ajtz.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Awdn);
  }
  
  public void f()
  {
    this.jdField_a_of_type_Ajtz.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    ajvj localajvj = (ajvj)paramView.getTag();
    PhoneContact localPhoneContact;
    boolean bool;
    if ((localajvj != null) && (localajvj.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localajvj.jdField_a_of_type_ComTencentMobileqqDataPhoneContact != null))
    {
      localPhoneContact = localajvj.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
      if (localajvj.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        if (!localajvj.jdField_a_of_type_Boolean) {
          break label150;
        }
        bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localajvj.jdField_a_of_type_JavaLangString, localPhoneContact.name, 5, "-1");
      }
    }
    for (;;)
    {
      localajvj.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      if (AppSetting.c)
      {
        if (!localajvj.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
          break label252;
        }
        if (!localajvj.jdField_a_of_type_Boolean) {
          break;
        }
        paramView.setContentDescription(localajvj.b.getText() + this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131719717));
      }
      return;
      label150:
      if (localajvj.jdField_a_of_type_JavaLangString.startsWith("+")) {
        bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localajvj.jdField_a_of_type_JavaLangString, localPhoneContact.name, 4, "-1");
      } else {
        bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localajvj.jdField_a_of_type_JavaLangString, localPhoneContact.name, 0, "-1");
      }
    }
    paramView.setContentDescription(localajvj.b.getText().toString() + alpo.a(2131702925));
    return;
    label252:
    if (localajvj.jdField_a_of_type_Boolean) {}
    for (int i = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localajvj.jdField_a_of_type_JavaLangString);; i = 0)
    {
      if ((localajvj.jdField_a_of_type_Boolean) && (i != 0))
      {
        paramView.setContentDescription(localajvj.b.getText() + this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(i));
        return;
      }
      paramView.setContentDescription(localajvj.b.getText().toString() + alpo.a(2131702919));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.ContactsInnerFrame
 * JD-Core Version:    0.7.0.1
 */