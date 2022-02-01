package com.tencent.mobileqq.activity.phone;

import ajll;
import ajnh;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import atky;
import aycd;
import com.tencent.common.app.InnerFrame;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;

public class PhoneInnerFrame
  extends InnerFrame
{
  private int jdField_a_of_type_Int = 0;
  private ajll jdField_a_of_type_Ajll;
  private aycd jdField_a_of_type_Aycd;
  private BaseActivityView jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView;
  private ContactListView jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView;
  private PhoneLaunchView jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView;
  private PhoneMatchView jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView;
  public boolean a;
  
  public PhoneInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public PhoneInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PhoneInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Intent paramIntent, BaseActivityView paramBaseActivityView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView != paramBaseActivityView)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView != null)
      {
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.c();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.d();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView = paramBaseActivityView;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.a(paramIntent, this);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.a();
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.b();
      }
      setContentView(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView);
    }
  }
  
  private void b(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView = new PhoneMatchView(a(), this.jdField_a_of_type_Int);
    }
    a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView);
  }
  
  private void c(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView = new PhoneLaunchView(a(), this.jdField_a_of_type_Int);
    }
    a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView = new ContactListView(getContext(), this.jdField_a_of_type_Int);
    }
    a(null, this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView);
  }
  
  protected ajll a()
  {
    return null;
  }
  
  public atky a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView.a;
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.b();
    }
    this.jdField_a_of_type_Boolean = true;
    super.a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a().overridePendingTransition(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Intent paramIntent, int paramInt)
  {
    String str = paramIntent.getComponent().getClassName();
    if (str.equals(ContactListView.class.getName()))
    {
      h();
      return;
    }
    if (str.equals(PhoneLaunchActivity.class.getName()))
    {
      c(paramIntent);
      return;
    }
    if (str.equals(PhoneMatchView.class.getName()))
    {
      b(null);
      return;
    }
    a().startActivityForResult(paramIntent, paramInt);
  }
  
  public final ajll b()
  {
    if (this.jdField_a_of_type_Ajll == null) {
      this.jdField_a_of_type_Ajll = a();
    }
    return this.jdField_a_of_type_Ajll;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView.c();
    }
    this.jdField_a_of_type_Boolean = false;
    super.b();
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    if (paramBundle != null) {
      this.jdField_a_of_type_Int = paramBundle.getInt("key_req_type");
    }
    g();
    if (this.jdField_a_of_type_Aycd == null)
    {
      this.jdField_a_of_type_Aycd = new ajnh(this);
      b().a().registObserver(this.jdField_a_of_type_Aycd);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.d();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView = null;
      removeAllViews();
    }
    if (this.jdField_a_of_type_Aycd != null)
    {
      b().a().unRegistObserver(this.jdField_a_of_type_Aycd);
      this.jdField_a_of_type_Aycd = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView.e();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView.e();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView.e();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView = null;
    }
    super.c();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView = null;
    super.d();
  }
  
  public void f()
  {
    a().a(0);
  }
  
  public void g()
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)b().a().getManager(11);
    switch (localPhoneContactManagerImp.d())
    {
    default: 
      h();
      return;
    case 0: 
    case 7: 
    case 8: 
    case 9: 
      h();
      return;
    case 1: 
    case 2: 
    case 3: 
      if (this.jdField_a_of_type_Int == 2)
      {
        h();
        return;
      }
      c(null);
      return;
    case 4: 
    case 5: 
      c(null);
      return;
    }
    if ((localPhoneContactManagerImp.f()) || (this.jdField_a_of_type_Int == 2))
    {
      h();
      return;
    }
    b(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneInnerFrame
 * JD-Core Version:    0.7.0.1
 */