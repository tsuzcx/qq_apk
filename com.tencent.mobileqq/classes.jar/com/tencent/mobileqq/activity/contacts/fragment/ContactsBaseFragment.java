package com.tencent.mobileqq.activity.contacts.fragment;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.contacts.view.HeaderScrollHelper.ScrollableContainer;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import wju;

public abstract class ContactsBaseFragment
  extends Fragment
  implements HeaderScrollHelper.ScrollableContainer, AbsListView.OnScrollListener
{
  private int a;
  protected View a;
  protected ContactsBaseFragment.FragmentLifeListener a;
  public ContactsBaseFragment.RefreshDataListener a;
  public BaseActivity a;
  public QQAppInterface a;
  public boolean a;
  public boolean b;
  
  public abstract int a();
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  protected abstract View a(LayoutInflater paramLayoutInflater, Bundle paramBundle);
  
  public abstract void a();
  
  public void a(ContactsBaseFragment.FragmentLifeListener paramFragmentLifeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentContactsBaseFragment$FragmentLifeListener = paramFragmentLifeListener;
  }
  
  public void a(ContactsBaseFragment.RefreshDataListener paramRefreshDataListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentContactsBaseFragment$RefreshDataListener = paramRefreshDataListener;
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    d();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {}
    do
    {
      return;
      if (paramInt != 0) {
        ApngImage.pauseByTag(3);
      }
    } while (paramInt != 0);
    ApngImage.playByTag(3);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b();
  
  public abstract void b(boolean paramBoolean);
  
  public abstract void c();
  
  public void c(boolean paramBoolean)
  {
    this.b = paramBoolean;
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (paramBoolean) {
        a(true);
      }
    }
    else {
      return;
    }
    b(true);
  }
  
  protected abstract void d();
  
  public void d(boolean paramBoolean) {}
  
  protected abstract void e();
  
  public void f()
  {
    e();
  }
  
  public void g() {}
  
  public void onAttach(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.BaseFragment", 2, "pos:" + a() + " onAttach");
    }
    super.onAttach(paramActivity);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.BaseFragment", 2, "pos:" + a() + " onCreate");
    }
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Int = a();
  }
  
  @TargetApi(16)
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.BaseFragment", 2, "pos:" + a() + " onCreateView");
    }
    this.jdField_a_of_type_AndroidViewView = a(paramLayoutInflater, paramBundle);
    paramLayoutInflater = a();
    if ((paramLayoutInflater != null) && (Build.VERSION.SDK_INT >= 14)) {
      paramLayoutInflater.setAccessibilityDelegate(new wju(this));
    }
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Contacts.BaseFragment", 2, "onCreateView->doOnResume");
      }
      this.jdField_a_of_type_Boolean = false;
      a(true);
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.BaseFragment", 2, "pos:" + a() + " onDestroy");
    }
    super.onDestroy();
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentContactsBaseFragment$FragmentLifeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentContactsBaseFragment$FragmentLifeListener.d(this.jdField_a_of_type_Int);
    }
  }
  
  public void onDestroyView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.BaseFragment", 2, "pos:" + a() + " onDestroyView");
    }
    super.onDestroyView();
  }
  
  public void onDetach()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.BaseFragment", 2, "pos:" + a() + " onDetach");
    }
    super.onDetach();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.fragment.ContactsBaseFragment
 * JD-Core Version:    0.7.0.1
 */