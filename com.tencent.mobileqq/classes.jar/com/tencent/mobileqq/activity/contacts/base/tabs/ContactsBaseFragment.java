package com.tencent.mobileqq.activity.contacts.base.tabs;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.contacts.base.HeaderScrollHelper.ScrollableContainer;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public abstract class ContactsBaseFragment
  extends BaseFragment
  implements HeaderScrollHelper.ScrollableContainer, AbsListView.OnScrollListener
{
  public static Rect a;
  private int a;
  protected ContactsBaseFragment.FragmentLifeListener a;
  protected ContactsBaseFragment.RefreshDataListener a;
  protected BaseActivity a;
  protected QQAppInterface a;
  public boolean a;
  private int b;
  protected View b;
  public boolean b;
  protected boolean c = false;
  
  private void a(View paramView, int paramInt)
  {
    if ((paramInt != -1) && (paramView != null)) {
      paramView.setPadding(0, 0, 0, paramInt);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a()
  {
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  protected abstract View a(LayoutInflater paramLayoutInflater, Bundle paramBundle);
  
  public abstract void a();
  
  public void a(ContactsBaseFragment.FragmentLifeListener paramFragmentLifeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsBaseFragment$FragmentLifeListener = paramFragmentLifeListener;
  }
  
  public void a(ContactsBaseFragment.RefreshDataListener paramRefreshDataListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsBaseFragment$RefreshDataListener = paramRefreshDataListener;
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((localQQAppInterface != null) && (paramQQAppInterface != localQQAppInterface)) {
      e();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    d();
  }
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void ae_();
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public abstract void b(boolean paramBoolean);
  
  public void b(boolean paramBoolean, int paramInt)
  {
    a(a(), paramInt);
  }
  
  public abstract void c();
  
  protected abstract void d();
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      if (paramBoolean)
      {
        a(true);
        return;
      }
      b(true);
    }
  }
  
  protected abstract void e();
  
  public void e(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void f() {}
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      e();
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pos:");
      localStringBuilder.append(b());
      localStringBuilder.append(" onAttach");
      QLog.d("Contacts.BaseFragment", 2, localStringBuilder.toString());
    }
    super.onAttach(paramActivity);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pos:");
      localStringBuilder.append(b());
      localStringBuilder.append(" onCreate");
      QLog.d("Contacts.BaseFragment", 2, localStringBuilder.toString());
    }
    super.onCreate(paramBundle);
  }
  
  @TargetApi(16)
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("pos:");
      paramViewGroup.append(b());
      paramViewGroup.append(" onCreateView");
      QLog.d("Contacts.BaseFragment", 2, paramViewGroup.toString());
    }
    this.jdField_b_of_type_AndroidViewView = a(paramLayoutInflater, paramBundle);
    paramLayoutInflater = a();
    if ((paramLayoutInflater != null) && (Build.VERSION.SDK_INT >= 14)) {
      paramLayoutInflater.setAccessibilityDelegate(new ContactsBaseFragment.1(this));
    }
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_a_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Contacts.BaseFragment", 2, "onCreateView->doOnResume");
      }
      this.jdField_a_of_type_Boolean = false;
      a(true);
    }
    paramLayoutInflater = this.jdField_b_of_type_AndroidViewView;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pos:");
      ((StringBuilder)localObject).append(b());
      ((StringBuilder)localObject).append(" onDestroy");
      QLog.d("Contacts.BaseFragment", 2, ((StringBuilder)localObject).toString());
    }
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      e();
    }
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Boolean = false;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsBaseFragment$FragmentLifeListener;
    if (localObject != null) {
      ((ContactsBaseFragment.FragmentLifeListener)localObject).a(this.jdField_a_of_type_Int);
    }
  }
  
  public void onDestroyView()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pos:");
      localStringBuilder.append(b());
      localStringBuilder.append(" onDestroyView");
      QLog.d("Contacts.BaseFragment", 2, localStringBuilder.toString());
    }
    super.onDestroyView();
  }
  
  public void onDetach()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pos:");
      localStringBuilder.append(b());
      localStringBuilder.append(" onDetach");
      QLog.d("Contacts.BaseFragment", 2, localStringBuilder.toString());
    }
    super.onDetach();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {
      return;
    }
    if (paramInt != 0) {
      ApngImage.pauseByTag(3);
    }
    if (paramInt == 0) {
      ApngImage.playByTag(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
 * JD-Core Version:    0.7.0.1
 */