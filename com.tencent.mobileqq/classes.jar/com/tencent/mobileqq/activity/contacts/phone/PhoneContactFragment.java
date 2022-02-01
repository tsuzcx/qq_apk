package com.tencent.mobileqq.activity.contacts.phone;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.activity.phone.PhoneContactStatusCheckView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.interfaces.INewFriendListener;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.listener.IPhoneContactListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import mqq.os.MqqHandler;

public class PhoneContactFragment
  extends ContactsBaseFragment
  implements INewFriendListener, IPhoneContactListener
{
  protected Handler a;
  protected View a;
  protected FrameLayout a;
  protected PhoneContactAdapter a;
  protected PhoneContactFragment.MyContactObserver a;
  protected PhoneContactStatusCheckView a;
  protected XListView a;
  private Runnable a;
  private Runnable b;
  protected boolean d = false;
  
  public PhoneContactFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPhonePhoneContactFragment$MyContactObserver = new PhoneContactFragment.MyContactObserver(this, null);
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), null);
    this.jdField_a_of_type_JavaLangRunnable = new PhoneContactFragment.2(this);
    this.jdField_b_of_type_JavaLangRunnable = new PhoneContactFragment.3(this);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentWidgetXListView;
  }
  
  protected View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    paramBundle = this.jdField_a_of_type_AndroidViewView;
    if (paramBundle == null)
    {
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131558928, null, false);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372513));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidViewView.getContext());
      paramLayoutInflater = new AbsListView.LayoutParams(-1, -2);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(paramLayoutInflater);
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneContactStatusCheckView = new PhoneContactStatusCheckView(this.jdField_a_of_type_AndroidViewView.getContext());
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneContactStatusCheckView.setOrientation(1);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneContactStatusCheckView.setGravity(17);
      int i = getResources().getDimensionPixelSize(2131297527);
      paramLayoutInflater = new FrameLayout.LayoutParams(-1, i);
      paramLayoutInflater.gravity = 17;
      if (jdField_a_of_type_AndroidGraphicsRect != null) {
        paramLayoutInflater.height = Math.max(i, jdField_a_of_type_AndroidGraphicsRect.bottom - jdField_a_of_type_AndroidGraphicsRect.top);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneContactStatusCheckView.setLayoutParams(paramLayoutInflater);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneContactStatusCheckView, paramLayoutInflater);
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(new ColorDrawable(0));
      this.jdField_a_of_type_ComTencentWidgetXListView.setNeedCheckSpringback(true);
      this.jdField_a_of_type_ComTencentWidgetXListView.setCacheColorHint(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.mForContacts = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneContactStatusCheckView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneContactStatusCheckView.setPhoneContactFragment(this);
    }
    else
    {
      paramLayoutInflater = paramBundle.getParent();
      if ((paramLayoutInflater instanceof ViewGroup)) {
        ((ViewGroup)paramLayoutInflater).removeView(this.jdField_a_of_type_AndroidViewView);
      }
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactFragment", 2, "doOnDestroy");
    }
    e();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBindStateChanged ");
      localStringBuilder.append(paramInt);
      QLog.d("PhoneContactFragment", 2, localStringBuilder.toString());
    }
    c();
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUIBitsChanged ");
      localStringBuilder.append(paramLong);
      QLog.d("PhoneContactFragment", 2, localStringBuilder.toString());
    }
    c();
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnResume:");
      localStringBuilder.append(paramBoolean);
      QLog.d("PhoneContactFragment", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null) {
      return;
    }
    if (paramBoolean) {
      d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPhonePhoneContactAdapter == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPhonePhoneContactAdapter = new PhoneContactAdapter(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 1, true, this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsPhonePhoneContactAdapter);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneContactStatusCheckView.a();
    ThreadManager.excute(new PhoneContactFragment.1(this), 16, null, true);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecommendCountChanged ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramInt);
      QLog.d("PhoneContactFragment", 2, localStringBuilder.toString());
    }
    c();
  }
  
  public boolean a()
  {
    PhoneContactStatusCheckView localPhoneContactStatusCheckView = this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneContactStatusCheckView;
    return (localPhoneContactStatusCheckView != null) && (localPhoneContactStatusCheckView.getVisibility() == 0);
  }
  
  public void ac_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactFragment", 2, "onMayKnowStatesChanged");
    }
    c();
  }
  
  public void ae_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactFragment", 2, "refresh");
    }
    c();
    ((IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).checkUpdateBindStateAndListIgnoreBindState(true, false, 16);
    this.d = true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactFragment", 2, "onContactCountChanged");
    }
    c();
  }
  
  public void b(int paramInt) {}
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnPause:");
      localStringBuilder.append(paramBoolean);
      QLog.d("PhoneContactFragment", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      e();
    }
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    super.b(paramBoolean, paramInt);
    PhoneContactStatusCheckView localPhoneContactStatusCheckView = this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneContactStatusCheckView;
    if (localPhoneContactStatusCheckView != null) {
      localPhoneContactStatusCheckView.a(paramBoolean);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reset data  mIsTabSelected:");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      QLog.d("PhoneContactFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_b_of_type_Boolean)
    {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      ThreadManager.getSubThreadHandler().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 500L);
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsPhonePhoneContactAdapter;
    if (localObject != null) {
      ((PhoneContactAdapter)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateContactList ");
      localStringBuilder.append(paramInt);
      QLog.d("PhoneContactFragment", 2, localStringBuilder.toString());
    }
    c();
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_b_of_type_Boolean))
    {
      ((IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).addListener(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsPhonePhoneContactFragment$MyContactObserver);
      ((INewFriendService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(INewFriendService.class, "")).addListener(this);
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ((IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).removeListener(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactsPhonePhoneContactFragment$MyContactObserver);
      ((INewFriendService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(INewFriendService.class, "")).removeListener(this);
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView;
    if (localObject != null) {
      ((XListView)localObject).setAdapter(null);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsPhonePhoneContactAdapter;
    if (localObject != null)
    {
      ((PhoneContactAdapter)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPhonePhoneContactAdapter.c();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPhonePhoneContactAdapter = null;
    }
  }
  
  public void g_(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.phone.PhoneContactFragment
 * JD-Core Version:    0.7.0.1
 */