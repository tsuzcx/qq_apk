package com.tencent.mobileqq.activity.qqsettingme;

import android.view.View;
import androidx.annotation.CallSuper;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.mvvm.LifeCycleAndViewModelStoreOwner;
import com.tencent.mobileqq.mvvm.api.ILifeCycleFragmentInjectApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import java.util.HashSet;
import mqq.app.AppRuntime;

public class QQSettingMeBaseProcessor
  implements IQQSettingMeProcessor
{
  protected AppRuntime c;
  protected QBaseActivity d;
  protected LifeCycleAndViewModelStoreOwner e;
  protected HashSet<Integer> f = new HashSet();
  protected boolean g;
  protected String h = "";
  
  public void a(QQSettingMe paramQQSettingMe) {}
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean) {}
  
  public void a(String paramString)
  {
    this.h = paramString;
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.c = paramAppRuntime;
  }
  
  public void a(AppRuntime paramAppRuntime, QBaseActivity paramQBaseActivity)
  {
    this.c = paramAppRuntime;
    this.d = paramQBaseActivity;
    this.e = ((ILifeCycleFragmentInjectApi)QRoute.api(ILifeCycleFragmentInjectApi.class)).checkAndAddLifeCycleFragment(paramQBaseActivity);
  }
  
  public void a(boolean paramBoolean) {}
  
  public String b()
  {
    return this.h;
  }
  
  public void c() {}
  
  @CallSuper
  public void d()
  {
    this.g = true;
  }
  
  @CallSuper
  public void e()
  {
    this.g = false;
    this.f.clear();
  }
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
  
  public void i() {}
  
  public void j() {}
  
  public void k() {}
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeBaseProcessor
 * JD-Core Version:    0.7.0.1
 */