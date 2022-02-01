package com.tencent.mobileqq.activity.qqsettingme;

import android.view.View;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import mqq.app.AppRuntime;

public abstract interface IQQSettingMeProcessor
{
  public abstract void a(QQSettingMe paramQQSettingMe);
  
  public abstract void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean);
  
  public abstract void a(String paramString);
  
  public abstract void a(AppRuntime paramAppRuntime);
  
  public abstract void a(AppRuntime paramAppRuntime, QBaseActivity paramQBaseActivity);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract String b();
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract void f();
  
  public abstract void g();
  
  public abstract void h();
  
  public abstract void i();
  
  public abstract void j();
  
  public abstract void k();
  
  public abstract void onClick(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.IQQSettingMeProcessor
 * JD-Core Version:    0.7.0.1
 */