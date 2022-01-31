package com.tencent.mobileqq.activity.contacts.fragment;

import ahoh;
import ahoi;
import ahoj;
import ahqn;
import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bhpo;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

public abstract class ContactsBaseFragment
  extends Fragment
  implements ahqn, bhpo
{
  public static Rect a;
  private int a;
  protected ahoi a;
  public ahoj a;
  public BaseActivity a;
  public QQAppInterface a;
  public boolean a;
  private int b;
  protected View b;
  public boolean b;
  
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
  
  public void a(ahoi paramahoi)
  {
    this.jdField_a_of_type_Ahoi = paramahoi;
  }
  
  public void a(ahoj paramahoj)
  {
    this.jdField_a_of_type_Ahoj = paramahoj;
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
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void av_();
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public abstract void b(boolean paramBoolean);
  
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
      if (paramBoolean) {
        a(true);
      }
    }
    else {
      return;
    }
    b(true);
  }
  
  protected abstract void e();
  
  public void e(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void e(boolean paramBoolean) {}
  
  public void f() {}
  
  public void g()
  {
    e();
  }
  
  public void onAttach(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.BaseFragment", 2, "pos:" + b() + " onAttach");
    }
    super.onAttach(paramActivity);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.BaseFragment", 2, "pos:" + b() + " onCreate");
    }
    super.onCreate(paramBundle);
  }
  
  @TargetApi(16)
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.BaseFragment", 2, "pos:" + b() + " onCreateView");
    }
    this.jdField_b_of_type_AndroidViewView = a(paramLayoutInflater, paramBundle);
    paramLayoutInflater = a();
    if ((paramLayoutInflater != null) && (Build.VERSION.SDK_INT >= 14)) {
      paramLayoutInflater.setAccessibilityDelegate(new ahoh(this));
    }
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_a_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Contacts.BaseFragment", 2, "onCreateView->doOnResume");
      }
      this.jdField_a_of_type_Boolean = false;
      a(true);
    }
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.BaseFragment", 2, "pos:" + b() + " onDestroy");
    }
    super.onDestroy();
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Ahoi != null) {
      this.jdField_a_of_type_Ahoi.d(this.jdField_a_of_type_Int);
    }
  }
  
  public void onDestroyView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.BaseFragment", 2, "pos:" + b() + " onDestroyView");
    }
    super.onDestroyView();
  }
  
  public void onDetach()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.BaseFragment", 2, "pos:" + b() + " onDetach");
    }
    super.onDetach();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.fragment.ContactsBaseFragment
 * JD-Core Version:    0.7.0.1
 */