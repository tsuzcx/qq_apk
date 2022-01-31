package com.tencent.mobileqq.activity.selectmember;

import SecurityAccountServer.RespondQueryQQBindingStat;
import aidp;
import aidq;
import aidr;
import aids;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import askn;
import aumg;
import bcnf;
import bcot;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class PhoneContactTabView
  extends TroopDiscussionBaseV
  implements View.OnClickListener, View.OnTouchListener, bcnf, bcot
{
  private aids jdField_a_of_type_Aids;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private askn jdField_a_of_type_Askn;
  private aumg jdField_a_of_type_Aumg;
  ContactFriendInnerFrame jdField_a_of_type_ComTencentMobileqqActivitySelectmemberContactFriendInnerFrame;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  private String jdField_a_of_type_JavaLangString;
  public List<PhoneContact> a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new aidq(this);
  
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131364058));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131368074));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131167087);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378388));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new aidp(this));
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Askn == null) {
      this.jdField_a_of_type_Askn = ((askn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11));
    }
    if (this.jdField_a_of_type_Aumg == null) {
      this.jdField_a_of_type_Aumg = new aidr(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Aumg);
  }
  
  private void j() {}
  
  public void a(Bundle paramBundle)
  {
    a(2131562397);
    this.jdField_a_of_type_Askn = ((askn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(PhoneContactTabView.class, this.jdField_a_of_type_MqqOsMqqHandler);
    h();
    this.jdField_a_of_type_Aids = new aids(this, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Aids);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(false, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131719218), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.d);
    int i = this.jdField_a_of_type_Askn.d();
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
    if (this.jdField_a_of_type_Askn.a().lastUsedFlag == 2L)
    {
      d();
      return;
    }
    g();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() > 0) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount() < this.jdField_a_of_type_Aids.getCount() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount()))) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.e()))
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
      i = this.jdField_a_of_type_Aids.a(paramString);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount());
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(3);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(PhoneContactTabView.class);
    if (this.jdField_a_of_type_Aids != null) {
      this.jdField_a_of_type_Aids.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Aumg);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Aids.notifyDataSetChanged();
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_Askn.g();
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
      if (this.jdField_a_of_type_Aids == null)
      {
        this.jdField_a_of_type_Aids = new aids(this, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Aids);
      }
      this.jdField_a_of_type_Aids.a();
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