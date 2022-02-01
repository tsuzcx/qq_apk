package com.tencent.mobileqq.activity.selectmember;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.os.MqqHandler;

public class ContactsInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener
{
  private ContactsInnerFrame.ContactsListAdapter jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactsInnerFrame$ContactsListAdapter;
  private PhoneContactManager jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  List<PhoneContact> jdField_a_of_type_JavaUtilList;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new ContactsInnerFrame.1(this);
  
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131364583));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131369039));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131167305);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
  }
  
  private void h()
  {
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.f();
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(3);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(3, 1000L);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactsInnerFrame$ContactsListAdapter == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactsInnerFrame$ContactsListAdapter = new ContactsInnerFrame.ContactsListAdapter(this, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactsInnerFrame$ContactsListAdapter);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactsInnerFrame$ContactsListAdapter.a();
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new ContactsInnerFrame.2(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
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
    setContentView(2131562988);
    this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(ContactsInnerFrame.class, this.jdField_a_of_type_MqqOsMqqHandler);
    g();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactsInnerFrame$ContactsListAdapter = new ContactsInnerFrame.ContactsListAdapter(this, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactsInnerFrame$ContactsListAdapter);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() > 0) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount() < this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactsInnerFrame$ContactsListAdapter.getCount() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount()))) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.e()))
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
      i = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactsInnerFrame$ContactsListAdapter.a(paramString);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount());
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131719002), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131694800));
    switch (this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.d())
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
    if (this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.a().lastUsedFlag == 2L)
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactsInnerFrame$ContactsListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactsInnerFrame$ContactsListAdapter.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactsInnerFrame$ContactsListAdapter.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    SelectActivityViewHolder localSelectActivityViewHolder = (SelectActivityViewHolder)paramView.getTag();
    PhoneContact localPhoneContact;
    boolean bool;
    if ((localSelectActivityViewHolder != null) && (localSelectActivityViewHolder.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localSelectActivityViewHolder.jdField_a_of_type_ComTencentMobileqqDataPhoneContact != null))
    {
      localPhoneContact = localSelectActivityViewHolder.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
      if (localSelectActivityViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        if (!localSelectActivityViewHolder.jdField_a_of_type_Boolean) {
          break label157;
        }
        bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localSelectActivityViewHolder.jdField_a_of_type_JavaLangString, localPhoneContact.name, 5, "-1");
        localSelectActivityViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.d)
        {
          if (!localSelectActivityViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label261;
          }
          if (!localSelectActivityViewHolder.jdField_a_of_type_Boolean) {
            break label219;
          }
          paramView.setContentDescription(localSelectActivityViewHolder.b.getText() + this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131719003));
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label157:
      if (localSelectActivityViewHolder.jdField_a_of_type_JavaLangString.startsWith("+"))
      {
        bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localSelectActivityViewHolder.jdField_a_of_type_JavaLangString, localPhoneContact.name, 4, "-1");
        break;
      }
      bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localSelectActivityViewHolder.jdField_a_of_type_JavaLangString, localPhoneContact.name, 0, "-1");
      break;
      label219:
      paramView.setContentDescription(localSelectActivityViewHolder.b.getText().toString() + HardCodeUtil.a(2131702584));
    }
    label261:
    if (localSelectActivityViewHolder.jdField_a_of_type_Boolean) {}
    for (int i = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localSelectActivityViewHolder.jdField_a_of_type_JavaLangString);; i = 0)
    {
      if ((localSelectActivityViewHolder.jdField_a_of_type_Boolean) && (i != 0))
      {
        paramView.setContentDescription(localSelectActivityViewHolder.b.getText() + this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(i));
        break;
      }
      paramView.setContentDescription(localSelectActivityViewHolder.b.getText().toString() + HardCodeUtil.a(2131702578));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.ContactsInnerFrame
 * JD-Core Version:    0.7.0.1
 */