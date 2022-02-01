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
  protected QBaseActivity a;
  protected LifeCycleAndViewModelStoreOwner a;
  protected String a;
  protected HashSet<Integer> a;
  protected AppRuntime a;
  protected boolean a;
  
  public QQSettingMeBaseProcessor()
  {
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a() {}
  
  public void a(QQSettingMe paramQQSettingMe) {}
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
  }
  
  public void a(AppRuntime paramAppRuntime, QBaseActivity paramQBaseActivity)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner = ((ILifeCycleFragmentInjectApi)QRoute.api(ILifeCycleFragmentInjectApi.class)).checkAndAddLifeCycleFragment(paramQBaseActivity);
  }
  
  public void a(boolean paramBoolean) {}
  
  @CallSuper
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  @CallSuper
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashSet.clear();
  }
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
  
  public void i() {}
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeBaseProcessor
 * JD-Core Version:    0.7.0.1
 */