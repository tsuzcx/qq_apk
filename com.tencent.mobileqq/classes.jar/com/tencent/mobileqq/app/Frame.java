package com.tencent.mobileqq.app;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;

public abstract class Frame
{
  private static IFrameInjectInterface jdField_a_of_type_ComTencentMobileqqAppIFrameInjectInterface;
  private View jdField_a_of_type_AndroidViewView;
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  public AppRuntime a;
  public boolean w;
  
  static
  {
    try
    {
      if (FrameInjectUtil.a.size() > 0)
      {
        jdField_a_of_type_ComTencentMobileqqAppIFrameInjectInterface = (IFrameInjectInterface)((Class)FrameInjectUtil.a.get(0)).newInstance();
        QLog.d("Frame", 1, "FrameInjectUtil newInstance");
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("Frame", 1, "FrameInjectUtil static statement: ", localException);
    }
  }
  
  public void C()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
  }
  
  public void D()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      Animation localAnimation = this.jdField_a_of_type_AndroidViewView.getAnimation();
      if (localAnimation != null) {
        localAnimation.setAnimationListener(null);
      }
      this.jdField_a_of_type_AndroidViewView.clearAnimation();
    }
    jdField_a_of_type_ComTencentMobileqqAppIFrameInjectInterface.a(this);
  }
  
  protected void E() {}
  
  public Resources a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources();
  }
  
  public View a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidViewView.findViewById(paramInt);
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    return null;
  }
  
  public final QBaseActivity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  }
  
  public String a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(paramInt);
  }
  
  public void a() {}
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.startActivity(paramIntent);
  }
  
  public void a(Configuration paramConfiguration) {}
  
  public void a(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      if (paramBoolean) {
        paramView.setBackgroundResource(2130850508);
      }
    }
    else {
      return;
    }
    paramView.setBackgroundColor(a().getColor(2131167091));
  }
  
  protected void a(QBaseActivity paramQBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
  }
  
  protected void a(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.post(paramRunnable);
    }
  }
  
  protected void a(Constants.LogoutReason paramLogoutReason) {}
  
  protected String a_()
  {
    return null;
  }
  
  void b(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void b(Runnable paramRunnable)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.runOnUiThread(paramRunnable);
  }
  
  public void b(boolean paramBoolean)
  {
    this.w = true;
    if (Build.VERSION.SDK_INT >= 15) {
      jdField_a_of_type_ComTencentMobileqqAppIFrameInjectInterface.a(this, false);
    }
  }
  
  public boolean b()
  {
    return jdField_a_of_type_ComTencentMobileqqAppIFrameInjectInterface.a();
  }
  
  protected void d() {}
  
  protected void e() {}
  
  public abstract void e(boolean paramBoolean);
  
  public boolean e_()
  {
    return true;
  }
  
  protected void f()
  {
    this.jdField_a_of_type_MqqAppAppRuntime = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
  }
  
  public void h()
  {
    if (this.w) {
      n();
    }
  }
  
  protected void k() {}
  
  protected void l()
  {
    boolean bool2 = false;
    d();
    AppRuntime localAppRuntime1 = this.jdField_a_of_type_MqqAppAppRuntime;
    this.jdField_a_of_type_MqqAppAppRuntime = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
    AppRuntime localAppRuntime2 = this.jdField_a_of_type_MqqAppAppRuntime;
    boolean bool1 = bool2;
    if (localAppRuntime1 != null)
    {
      bool1 = bool2;
      if (localAppRuntime2 != null)
      {
        bool1 = bool2;
        if (!TextUtils.equals(localAppRuntime1.getAccount(), localAppRuntime2.getAccount())) {
          bool1 = true;
        }
      }
    }
    e(bool1);
  }
  
  public void n()
  {
    this.w = false;
    if (Build.VERSION.SDK_INT >= 15) {
      jdField_a_of_type_ComTencentMobileqqAppIFrameInjectInterface.a(this, true);
    }
  }
  
  public void r() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.Frame
 * JD-Core Version:    0.7.0.1
 */