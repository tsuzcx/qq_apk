package com.tencent.mobileqq.activity.qqsettingme;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.mvvm.LifeCycleAndViewModelStoreOwner;
import com.tencent.mobileqq.mvvm.api.ILifeCycleFragmentInjectApi;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.AppRuntime;

public class BaseDrawerBizFacade
  implements IDrawerBizFacade
{
  protected AppRuntime a;
  protected QBaseActivity b;
  protected LifeCycleAndViewModelStoreOwner c;
  
  public void a() {}
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      paramView.setAlpha(0.5F);
      paramView.invalidate();
      return;
    }
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
    {
      paramView.setAlpha(1.0F);
      paramView.invalidate();
    }
  }
  
  public void a(QQSettingMe paramQQSettingMe) {}
  
  public void a(String paramString) {}
  
  public void a(AppRuntime paramAppRuntime) {}
  
  public void a(AppRuntime paramAppRuntime, QBaseActivity paramQBaseActivity)
  {
    this.a = paramAppRuntime;
    this.b = paramQBaseActivity;
    this.c = ((ILifeCycleFragmentInjectApi)QRoute.api(ILifeCycleFragmentInjectApi.class)).checkAndAddLifeCycleFragment(paramQBaseActivity);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
  
  public void i() {}
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.BaseDrawerBizFacade
 * JD-Core Version:    0.7.0.1
 */