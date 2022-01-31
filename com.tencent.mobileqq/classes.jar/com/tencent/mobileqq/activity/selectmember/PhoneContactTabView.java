package com.tencent.mobileqq.activity.selectmember;

import SecurityAccountServer.RespondQueryQQBindingStat;
import ahqz;
import ahra;
import ahrb;
import ahrc;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import aroh;
import atog;
import bbjs;
import bblg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class PhoneContactTabView
  extends TroopDiscussionBaseV
  implements View.OnClickListener, View.OnTouchListener, bbjs, bblg
{
  private ahrc jdField_a_of_type_Ahrc;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aroh jdField_a_of_type_Aroh;
  private atog jdField_a_of_type_Atog;
  ContactFriendInnerFrame jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactFriendInnerFrame;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  private String jdField_a_of_type_JavaLangString;
  public List<PhoneContact> a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new ahra(this);
  
  public PhoneContactTabView(SelectMemberActivity paramSelectMemberActivity, ContactFriendInnerFrame paramContactFriendInnerFrame)
  {
    super(paramSelectMemberActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactFriendInnerFrame = paramContactFriendInnerFrame;
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131298501));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131302454));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131101491);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131312558));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ahqz(this));
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Aroh == null) {
      this.jdField_a_of_type_Aroh = ((aroh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11));
    }
    if (this.jdField_a_of_type_Atog == null) {
      this.jdField_a_of_type_Atog = new ahrb(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Atog);
  }
  
  private void j() {}
  
  public void a(Bundle paramBundle)
  {
    a(2131496798);
    this.jdField_a_of_type_Aroh = ((aroh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(PhoneContactTabView.class, this.jdField_a_of_type_MqqOsMqqHandler);
    h();
    this.jdField_a_of_type_Ahrc = new ahrc(this, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Ahrc);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(false, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131653378), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.d);
    int i = this.jdField_a_of_type_Aroh.d();
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
    if (this.jdField_a_of_type_Aroh.a().lastUsedFlag == 2L)
    {
      d();
      return;
    }
    g();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() > 0) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount() < this.jdField_a_of_type_Ahrc.getCount() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount()))) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.e()))
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
      i = this.jdField_a_of_type_Ahrc.a(paramString);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount());
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(3);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(PhoneContactTabView.class);
    if (this.jdField_a_of_type_Ahrc != null) {
      this.jdField_a_of_type_Ahrc.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Atog);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Ahrc.notifyDataSetChanged();
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_Aroh.g();
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(3);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(3, 1000L);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
      if (this.jdField_a_of_type_Ahrc == null)
      {
        this.jdField_a_of_type_Ahrc = new ahrc(this, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Ahrc);
      }
      this.jdField_a_of_type_Ahrc.a();
    }
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
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