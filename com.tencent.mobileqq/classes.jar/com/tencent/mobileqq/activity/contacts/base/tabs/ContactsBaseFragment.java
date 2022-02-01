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
  public static Rect p;
  private int a;
  private int b;
  protected ContactsBaseFragment.RefreshDataListener q;
  protected ContactsBaseFragment.FragmentLifeListener r;
  protected QQAppInterface s;
  protected View t;
  public boolean u;
  public boolean v;
  protected BaseActivity w;
  protected boolean x = false;
  
  private void a(View paramView, int paramInt)
  {
    if ((paramInt != -1) && (paramView != null)) {
      paramView.setPadding(0, 0, 0, paramInt);
    }
  }
  
  protected abstract View a(LayoutInflater paramLayoutInflater, Bundle paramBundle);
  
  public abstract void a();
  
  public void a(ContactsBaseFragment.FragmentLifeListener paramFragmentLifeListener)
  {
    this.r = paramFragmentLifeListener;
  }
  
  public void a(ContactsBaseFragment.RefreshDataListener paramRefreshDataListener)
  {
    this.q = paramRefreshDataListener;
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    this.w = paramBaseActivity;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    QQAppInterface localQQAppInterface = this.s;
    if ((localQQAppInterface != null) && (paramQQAppInterface != localQQAppInterface)) {
      e();
    }
    this.s = paramQQAppInterface;
    d();
  }
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b(boolean paramBoolean);
  
  public void b(boolean paramBoolean, int paramInt)
  {
    a(getScrollableView(), paramInt);
  }
  
  public abstract void bU_();
  
  public abstract void c();
  
  protected abstract void d();
  
  public void d(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void d(boolean paramBoolean)
  {
    this.v = paramBoolean;
    this.u = paramBoolean;
    if (this.t != null)
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
    this.b = paramInt;
  }
  
  public void f() {}
  
  public void g()
  {
    if (this.s != null) {
      e();
    }
  }
  
  public View getScrollableView()
  {
    return this.t;
  }
  
  public int h()
  {
    return this.a;
  }
  
  public int i()
  {
    return this.b;
  }
  
  public void onAttach(Activity paramActivity)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pos:");
      localStringBuilder.append(i());
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
      localStringBuilder.append(i());
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
      paramViewGroup.append(i());
      paramViewGroup.append(" onCreateView");
      QLog.d("Contacts.BaseFragment", 2, paramViewGroup.toString());
    }
    this.t = a(paramLayoutInflater, paramBundle);
    paramLayoutInflater = getScrollableView();
    if ((paramLayoutInflater != null) && (Build.VERSION.SDK_INT >= 14)) {
      paramLayoutInflater.setAccessibilityDelegate(new ContactsBaseFragment.1(this));
    }
    if ((this.t != null) && (this.u))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Contacts.BaseFragment", 2, "onCreateView->doOnResume");
      }
      this.u = false;
      a(true);
    }
    paramLayoutInflater = this.t;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pos:");
      ((StringBuilder)localObject).append(i());
      ((StringBuilder)localObject).append(" onDestroy");
      QLog.d("Contacts.BaseFragment", 2, ((StringBuilder)localObject).toString());
    }
    super.onDestroy();
    if (this.s != null) {
      e();
    }
    this.t = null;
    this.u = false;
    Object localObject = this.r;
    if (localObject != null) {
      ((ContactsBaseFragment.FragmentLifeListener)localObject).a(this.a);
    }
  }
  
  public void onDestroyView()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pos:");
      localStringBuilder.append(i());
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
      localStringBuilder.append(i());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
 * JD-Core Version:    0.7.0.1
 */