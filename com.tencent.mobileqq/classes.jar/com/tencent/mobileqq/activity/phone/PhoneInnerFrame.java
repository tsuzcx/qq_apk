package com.tencent.mobileqq.activity.phone;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import com.tencent.common.app.InnerFrame;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;

public class PhoneInnerFrame
  extends InnerFrame
{
  private int jdField_a_of_type_Int = 0;
  private BaseActivityView.IPhoneContext jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView$IPhoneContext;
  private BaseActivityView jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView;
  private ContactListView jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView;
  private PhoneLaunchView jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView;
  private PhoneMatchView jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver;
  boolean jdField_a_of_type_Boolean;
  
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
  
  private void a(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView = new PhoneMatchView(a(), this.jdField_a_of_type_Int);
    }
    a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView);
  }
  
  private void a(Intent paramIntent, BaseActivityView paramBaseActivityView)
  {
    BaseActivityView localBaseActivityView = this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView;
    if (localBaseActivityView != paramBaseActivityView)
    {
      if (localBaseActivityView != null)
      {
        if (this.jdField_a_of_type_Boolean) {
          localBaseActivityView.c();
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
  
  protected BaseActivityView.IPhoneContext a()
  {
    return null;
  }
  
  public ForwardBaseOption a()
  {
    ContactListView localContactListView = this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView;
    if (localContactListView != null) {
      return localContactListView.a;
    }
    return null;
  }
  
  public void a()
  {
    BaseActivityView localBaseActivityView = this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView;
    if (localBaseActivityView != null) {
      localBaseActivityView.b();
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
    BaseActivityView localBaseActivityView = this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView;
    if (localBaseActivityView != null) {
      localBaseActivityView.a(paramInt1, paramInt2, paramIntent);
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
      b(paramIntent);
      return;
    }
    if (str.equals(PhoneMatchView.class.getName()))
    {
      a(null);
      return;
    }
    a().startActivityForResult(paramIntent, paramInt);
  }
  
  public final BaseActivityView.IPhoneContext b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView$IPhoneContext == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView$IPhoneContext = a();
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView$IPhoneContext;
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView;
    if (localObject != null) {
      ((BaseActivityView)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView;
    if (localObject != null) {
      ((ContactListView)localObject).c();
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
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver = new PhoneInnerFrame.1(this);
      b().a().registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver);
    }
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView;
    if (localObject != null)
    {
      ((BaseActivityView)localObject).d();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView = null;
      removeAllViews();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver != null)
    {
      b().a().unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView;
    if (localObject != null)
    {
      ((ContactListView)localObject).e();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView;
    if (localObject != null)
    {
      ((PhoneLaunchView)localObject).e();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView;
    if (localObject != null)
    {
      ((PhoneMatchView)localObject).e();
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
  
  void g()
  {
    IPhoneContactService localIPhoneContactService = (IPhoneContactService)b().a().getRuntimeService(IPhoneContactService.class, "");
    switch (localIPhoneContactService.getSelfBindState())
    {
    default: 
      h();
      return;
    case 6: 
      if ((!localIPhoneContactService.isAutoUploadContacts()) && (this.jdField_a_of_type_Int != 2))
      {
        a(null);
        return;
      }
      h();
      return;
    case 4: 
    case 5: 
      b(null);
      return;
    case 1: 
    case 2: 
    case 3: 
      if (this.jdField_a_of_type_Int == 2)
      {
        h();
        return;
      }
      b(null);
      return;
    }
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneInnerFrame
 * JD-Core Version:    0.7.0.1
 */