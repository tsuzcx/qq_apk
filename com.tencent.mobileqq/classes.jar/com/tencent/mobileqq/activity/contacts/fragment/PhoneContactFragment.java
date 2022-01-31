package com.tencent.mobileqq.activity.contacts.fragment;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.SimpleTextView;
import com.tencent.mobileqq.activity.contacts.adapter.PhoneContactAdapter;
import com.tencent.mobileqq.adapter.BuddyListAdapter.GroupTag;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.XListView;
import wsz;
import wtb;
import wtd;
import wtf;

public class PhoneContactFragment
  extends ContactsBaseFragment
  implements PhoneContactManager.IPhoneContactListener
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new wtb(this);
  public PhoneContactAdapter a;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
  public XListView a;
  protected wtf a;
  protected View b;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public PhoneContactFragment()
  {
    this.jdField_a_of_type_Wtf = new wtf(this, null);
  }
  
  private void e(boolean paramBoolean)
  {
    this.d = false;
    if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10));
    }
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a();
    BuddyListAdapter.GroupTag localGroupTag = (BuddyListAdapter.GroupTag)this.jdField_c_of_type_AndroidViewView.getTag();
    localGroupTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(getActivity().getResources().getString(2131435999));
    StringBuilder localStringBuilder = new StringBuilder(localGroupTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.a());
    int i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c();
    this.jdField_c_of_type_AndroidViewView.findViewById(2131363462).setVisibility(0);
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.PhoneContactFragment", 2, "checkPhoneStatus :" + i);
    }
    Object localObject;
    if ((i >= 9) || ((i == 7) && (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.e())))
    {
      localGroupTag.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      if ((localRespondQueryQQBindingStat != null) && (localRespondQueryQQBindingStat.isStopFindMatch))
      {
        if (QLog.isColorLevel()) {
          QLog.d("contacts.fragment.PhoneContactFragment", 2, "stopFindMatch");
        }
        localObject = "未启用";
        localGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText((CharSequence)localObject);
        if (AppSetting.jdField_b_of_type_Boolean) {
          localStringBuilder.append((String)localObject);
        }
      }
    }
    for (;;)
    {
      if (AppSetting.jdField_b_of_type_Boolean) {
        this.jdField_c_of_type_AndroidViewView.setContentDescription(localStringBuilder);
      }
      return;
      if (!paramBoolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("contacts.fragment.PhoneContactFragment", 2, "checkPhoneStatus has no permission: state" + i);
        }
        this.d = true;
        localObject = "未开启权限";
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("contacts.fragment.PhoneContactFragment", 2, "hide headview");
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      return;
      if (i == 8)
      {
        if (QLog.isColorLevel()) {
          QLog.d("contacts.fragment.PhoneContactFragment", 2, "uploading");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b())
        {
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
          this.jdField_c_of_type_AndroidViewView.findViewById(2131363462).setVisibility(8);
          localGroupTag.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          localGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("");
          if (AppSetting.jdField_b_of_type_Boolean) {
            localStringBuilder.append("正在加载联系人");
          }
        }
        else
        {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
      }
      else if (((i == 6) && (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a().lastUsedFlag == 3L)) || (i == 7))
      {
        if (QLog.isColorLevel()) {
          QLog.d("contacts.fragment.PhoneContactFragment", 2, "other state " + localRespondQueryQQBindingStat);
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        String str = "未匹配";
        localObject = str;
        if (localRespondQueryQQBindingStat != null)
        {
          localObject = str;
          if (localRespondQueryQQBindingStat.isStopFindMatch) {
            localObject = "未启用";
          }
        }
        localGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText((CharSequence)localObject);
        if (AppSetting.jdField_b_of_type_Boolean) {
          localStringBuilder.append((String)localObject);
        }
        localGroupTag.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("contacts.fragment.PhoneContactFragment", 2, "else other " + localRespondQueryQQBindingStat);
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localGroupTag.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        localGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("未启用");
        if (AppSetting.jdField_b_of_type_Boolean) {
          localStringBuilder.append("未启用");
        }
      }
    }
  }
  
  public int a()
  {
    return 3;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentWidgetXListView;
  }
  
  protected View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2130968823, null, false);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131363952));
      this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131363863);
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(new ColorDrawable(0));
      this.jdField_a_of_type_ComTencentWidgetXListView.setNeedCheckSpringback(true);
      this.jdField_a_of_type_ComTencentWidgetXListView.setCacheColorHint(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.mForContacts = true;
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838589);
      paramLayoutInflater = new BuddyListAdapter.GroupTag();
      paramLayoutInflater.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131363866));
      paramLayoutInflater.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView = ((SimpleTextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131363867));
      paramLayoutInflater.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_c_of_type_AndroidViewView.findViewById(2131363865));
      this.jdField_c_of_type_AndroidViewView.setTag(paramLayoutInflater);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      return this.jdField_b_of_type_AndroidViewView;
      paramLayoutInflater = this.jdField_b_of_type_AndroidViewView.getParent();
      if ((paramLayoutInflater instanceof ViewGroup)) {
        ((ViewGroup)paramLayoutInflater).removeView(this.jdField_b_of_type_AndroidViewView);
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.PhoneContactFragment", 2, "doOnDestroy");
    }
    e();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.PhoneContactFragment", 2, "onBindStateChanged " + paramInt);
    }
    c();
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.PhoneContactFragment", 2, "onUIBitsChanged " + paramLong);
    }
    c();
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.PhoneContactFragment", 2, "doOnResume:" + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null) {
      return;
    }
    if (paramBoolean) {
      d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterPhoneContactAdapter == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterPhoneContactAdapter = new PhoneContactAdapter(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 1, true, this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterPhoneContactAdapter);
    }
    ThreadManager.postImmediately(new wsz(this), null, false);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.PhoneContactFragment", 2, "onRecommendCountChanged " + paramBoolean + " " + paramInt);
    }
    c();
  }
  
  public boolean a()
  {
    if (this.jdField_c_of_type_AndroidViewView == null) {}
    while (this.jdField_c_of_type_AndroidViewView.getVisibility() != 0) {
      return false;
    }
    return true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.PhoneContactFragment", 2, "refresh");
    }
    c();
    ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a(true, false);
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void b(int paramInt) {}
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.PhoneContactFragment", 2, "doOnPause:" + paramBoolean);
    }
    if (paramBoolean) {
      e();
    }
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_Boolean) {
      ThreadManager.postImmediately(new wtd(this), null, false);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterPhoneContactAdapter == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterPhoneContactAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.PhoneContactFragment", 2, "onUpdateContactList " + paramInt);
    }
    c();
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_b_of_type_Boolean))
    {
      ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Wtf);
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).b(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Wtf);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterPhoneContactAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterPhoneContactAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterPhoneContactAdapter.Z_();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterPhoneContactAdapter = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.fragment.PhoneContactFragment
 * JD-Core Version:    0.7.0.1
 */