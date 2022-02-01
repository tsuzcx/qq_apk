package com.tencent.mobileqq.activity.selectmember;

import SecurityAccountServer.RespondQueryQQBindingStat;
import amcu;
import amcv;
import amcw;
import ameg;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import anzj;
import axfr;
import azov;
import biyw;
import bjaj;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.os.MqqHandler;

public class ContactsInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener, biyw, bjaj
{
  private amcw jdField_a_of_type_Amcw;
  private axfr jdField_a_of_type_Axfr;
  private azov jdField_a_of_type_Azov;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  public List<PhoneContact> a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new amcu(this);
  
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131364374));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131368624));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131167247);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
  }
  
  private void h()
  {
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_Axfr.f();
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(3);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(3, 1000L);
      return;
    }
    if (this.jdField_a_of_type_Amcw == null)
    {
      this.jdField_a_of_type_Amcw = new amcw(this, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Amcw);
    }
    this.jdField_a_of_type_Amcw.a();
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Axfr == null) {
      this.jdField_a_of_type_Axfr = ((axfr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11));
    }
    if (this.jdField_a_of_type_Azov == null) {
      this.jdField_a_of_type_Azov = new amcv(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Azov);
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
    setContentView(2131562891);
    this.jdField_a_of_type_Axfr = ((axfr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(ContactsInnerFrame.class, this.jdField_a_of_type_MqqOsMqqHandler);
    g();
    this.jdField_a_of_type_Amcw = new amcw(this, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Amcw);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() > 0) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount() < this.jdField_a_of_type_Amcw.getCount() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount()))) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.e()))
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
      i = this.jdField_a_of_type_Amcw.a(paramString);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount());
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131717856), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131694264));
    switch (this.jdField_a_of_type_Axfr.d())
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
    if (this.jdField_a_of_type_Axfr.a().lastUsedFlag == 2L)
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
    if (this.jdField_a_of_type_Amcw != null) {
      this.jdField_a_of_type_Amcw.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Azov);
  }
  
  public void f()
  {
    this.jdField_a_of_type_Amcw.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    ameg localameg = (ameg)paramView.getTag();
    PhoneContact localPhoneContact;
    boolean bool;
    if ((localameg != null) && (localameg.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localameg.jdField_a_of_type_ComTencentMobileqqDataPhoneContact != null))
    {
      localPhoneContact = localameg.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
      if (localameg.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        if (!localameg.jdField_a_of_type_Boolean) {
          break label157;
        }
        bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localameg.jdField_a_of_type_JavaLangString, localPhoneContact.name, 5, "-1");
        localameg.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.c)
        {
          if (!localameg.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label261;
          }
          if (!localameg.jdField_a_of_type_Boolean) {
            break label219;
          }
          paramView.setContentDescription(localameg.b.getText() + this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131717857));
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label157:
      if (localameg.jdField_a_of_type_JavaLangString.startsWith("+"))
      {
        bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localameg.jdField_a_of_type_JavaLangString, localPhoneContact.name, 4, "-1");
        break;
      }
      bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localameg.jdField_a_of_type_JavaLangString, localPhoneContact.name, 0, "-1");
      break;
      label219:
      paramView.setContentDescription(localameg.b.getText().toString() + anzj.a(2131701451));
    }
    label261:
    if (localameg.jdField_a_of_type_Boolean) {}
    for (int i = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localameg.jdField_a_of_type_JavaLangString);; i = 0)
    {
      if ((localameg.jdField_a_of_type_Boolean) && (i != 0))
      {
        paramView.setContentDescription(localameg.b.getText() + this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(i));
        break;
      }
      paramView.setContentDescription(localameg.b.getText().toString() + anzj.a(2131701445));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.ContactsInnerFrame
 * JD-Core Version:    0.7.0.1
 */