package com.tencent.mobileqq.activity.selectmember;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.av.utils.PstnUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;
import xwl;
import xwm;
import xwn;
import xwo;

public class PhoneContactTabView
  extends TroopDiscussionBaseV
  implements View.OnClickListener, View.OnTouchListener, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public ContactFriendInnerFrame a;
  public PhoneContactSelectActivity a;
  private PhoneContactManager jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  private String jdField_a_of_type_JavaLangString;
  public List a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new xwm(this);
  private xwo jdField_a_of_type_Xwo;
  private ViewGroup b;
  
  public PhoneContactTabView(SelectMemberActivity paramSelectMemberActivity, ContactFriendInnerFrame paramContactFriendInnerFrame)
  {
    super(paramSelectMemberActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactFriendInnerFrame = paramContactFriendInnerFrame;
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactSelectActivity = ((PhoneContactSelectActivity)paramSelectMemberActivity);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactSelectActivity.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactSelectActivity.a())
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.b.setVisibility(8);
      return;
    }
    this.b.setVisibility(0);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131374854));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131363807));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131492923);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
    this.b = ((ViewGroup)findViewById(2131365253));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374856));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new xwl(this));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131374860));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131374861));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new xwn(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
  }
  
  private void j()
  {
    PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactSelectActivity, 100, true);
  }
  
  public void a(Bundle paramBundle)
  {
    a(2130971502);
    this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(PhoneContactTabView.class, this.jdField_a_of_type_MqqOsMqqHandler);
    h();
    this.jdField_a_of_type_Xwo = new xwo(this, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Xwo);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactSelectActivity.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(false, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131435973), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.d);
    int i = this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.c();
    if (QLog.isColorLevel()) {
      QLog.i("ContactsInnerFrame", 2, "onStart state:" + i);
    }
    switch (i)
    {
    case 2: 
    case 3: 
    case 4: 
    case 8: 
    default: 
      i();
      return;
    case 9: 
      d();
      return;
    case 0: 
    case 1: 
    case 5: 
    case 7: 
      g();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.a().lastUsedFlag == 2L)
    {
      d();
      return;
    }
    g();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() > 0) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount() < this.jdField_a_of_type_Xwo.getCount() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount()))) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.d()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(2);
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(3);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(PhoneContactTabView.class);
    if (this.jdField_a_of_type_Xwo != null) {
      this.jdField_a_of_type_Xwo.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
  }
  
  public void b(String paramString)
  {
    if ("$".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Xwo.a(paramString);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount());
  }
  
  public void c()
  {
    this.jdField_a_of_type_Xwo.notifyDataSetChanged();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactSelectActivity.b)
    {
      this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.f();
      if (this.jdField_a_of_type_JavaUtilList != null) {
        break label122;
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(3);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(3, 1000L);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.b.setVisibility(8);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactSelectActivity.a()) {
        break label175;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactSelectActivity.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(0);
      return;
      this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.g();
      break;
      label122:
      if (this.jdField_a_of_type_Xwo == null)
      {
        this.jdField_a_of_type_Xwo = new xwo(this, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Xwo);
      }
      this.jdField_a_of_type_Xwo.a();
    }
    label175:
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactSelectActivity.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 2, 2);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {}
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.PhoneContactTabView
 * JD-Core Version:    0.7.0.1
 */