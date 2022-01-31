package com.tencent.mobileqq.app;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.mobileqq.statistics.UEC;
import mqq.app.Constants.LogoutReason;

public abstract class Frame
{
  private View jdField_a_of_type_AndroidViewView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  public QQAppInterface a;
  public boolean w;
  
  public Resources a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
  }
  
  public View a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidViewView.findViewById(paramInt);
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    return null;
  }
  
  public final BaseActivity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  }
  
  public String a()
  {
    return null;
  }
  
  public String a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(paramInt);
  }
  
  public abstract void a();
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramIntent);
  }
  
  public void a(Configuration paramConfiguration) {}
  
  public void a(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      if (paramBoolean) {
        paramView.setBackgroundResource(2130845952);
      }
    }
    else {
      return;
    }
    paramView.setBackgroundColor(a().getColor(2131494260));
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(paramRunnable);
  }
  
  public void a(Constants.LogoutReason paramLogoutReason) {}
  
  public void a(boolean paramBoolean)
  {
    this.w = true;
    if (Build.VERSION.SDK_INT >= 15)
    {
      UEC localUEC = UEC.a;
      if (localUEC != null) {
        localUEC.a(getClass().getSimpleName(), a(), false);
      }
    }
  }
  
  public boolean a()
  {
    if (FrameHelperActivity.a())
    {
      FrameHelperActivity.o();
      return true;
    }
    return false;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public void c()
  {
    f();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime());
    a();
  }
  
  void c(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void e() {}
  
  public void f() {}
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime());
  }
  
  public void h() {}
  
  public void i()
  {
    this.w = false;
    if (Build.VERSION.SDK_INT >= 15)
    {
      UEC localUEC = UEC.a;
      if (localUEC != null) {
        localUEC.a(getClass().getSimpleName(), a(), true);
      }
    }
  }
  
  public void j()
  {
    if (this.w) {
      i();
    }
  }
  
  public void k() {}
  
  public void m() {}
  
  public void v()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      localObject = this.jdField_a_of_type_AndroidViewView.getAnimation();
      if (localObject != null) {
        ((Animation)localObject).setAnimationListener(null);
      }
      this.jdField_a_of_type_AndroidViewView.clearAnimation();
    }
    Object localObject = FrameHelperActivity.a(a());
    if (localObject != null) {
      ((FrameHelperActivity)localObject).q();
    }
  }
  
  public void w()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.Frame
 * JD-Core Version:    0.7.0.1
 */