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
  protected boolean u;
  
  static
  {
    try
    {
      if (FrameInjectUtil.a.size() > 0)
      {
        jdField_a_of_type_ComTencentMobileqqAppIFrameInjectInterface = (IFrameInjectInterface)((Class)FrameInjectUtil.a.get(0)).newInstance();
        QLog.d("Frame", 1, "FrameInjectUtil newInstance");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("Frame", 1, "FrameInjectUtil static statement: ", localException);
    }
  }
  
  public void B()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
  }
  
  public void C()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null)
    {
      localObject = ((View)localObject).getAnimation();
      if (localObject != null) {
        ((Animation)localObject).setAnimationListener(null);
      }
      this.jdField_a_of_type_AndroidViewView.clearAnimation();
    }
    jdField_a_of_type_ComTencentMobileqqAppIFrameInjectInterface.a(this);
  }
  
  protected void D() {}
  
  protected void V_() {}
  
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
  
  protected String a()
  {
    return null;
  }
  
  public String a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(paramInt);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_MqqAppAppRuntime = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.startActivity(paramIntent);
  }
  
  public void a(Configuration paramConfiguration) {}
  
  void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      if (paramBoolean)
      {
        paramView.setBackgroundResource(2130850434);
        return;
      }
      paramView.setBackgroundColor(a().getColor(2131167114));
    }
  }
  
  protected void a(QBaseActivity paramQBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
  }
  
  protected void a(Runnable paramRunnable)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      localView.post(paramRunnable);
    }
  }
  
  protected void a(Constants.LogoutReason paramLogoutReason) {}
  
  public void a(boolean paramBoolean)
  {
    this.u = true;
    if (Build.VERSION.SDK_INT >= 15) {
      jdField_a_of_type_ComTencentMobileqqAppIFrameInjectInterface.a(this, false);
    }
  }
  
  public boolean a()
  {
    return jdField_a_of_type_ComTencentMobileqqAppIFrameInjectInterface.a();
  }
  
  public void ab_()
  {
    this.u = false;
    if (Build.VERSION.SDK_INT >= 15) {
      jdField_a_of_type_ComTencentMobileqqAppIFrameInjectInterface.a(this, true);
    }
  }
  
  public void b(Runnable paramRunnable)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.runOnUiThread(paramRunnable);
  }
  
  public abstract void b(boolean paramBoolean);
  
  public boolean b()
  {
    return true;
  }
  
  public void c()
  {
    if (this.u) {
      ab_();
    }
  }
  
  protected void d() {}
  
  public void e() {}
  
  protected void f()
  {
    h();
    AppRuntime localAppRuntime1 = this.jdField_a_of_type_MqqAppAppRuntime;
    this.jdField_a_of_type_MqqAppAppRuntime = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
    AppRuntime localAppRuntime2 = this.jdField_a_of_type_MqqAppAppRuntime;
    boolean bool;
    if ((localAppRuntime1 != null) && (localAppRuntime2 != null)) {
      bool = TextUtils.equals(localAppRuntime1.getAccount(), localAppRuntime2.getAccount()) ^ true;
    } else {
      bool = false;
    }
    b(bool);
  }
  
  protected void h() {}
  
  public void q() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.Frame
 * JD-Core Version:    0.7.0.1
 */