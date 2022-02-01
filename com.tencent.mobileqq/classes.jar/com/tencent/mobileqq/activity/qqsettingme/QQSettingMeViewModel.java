package com.tencent.mobileqq.activity.qqsettingme;

import android.view.MotionEvent;
import android.view.View;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.mvvm.BaseViewModel;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class QQSettingMeViewModel
  extends BaseViewModel<QQSettingMeBaseRepository>
{
  public static ViewModelProvider.Factory a;
  @ConfigInject(configPath="/Foundation/QQActivity/src/main/resources/Inject_QQSettingMe_processor.yml", version=2)
  private static ArrayList<Class<? extends IDrawerBizFacade>> jdField_a_of_type_JavaUtilArrayList;
  private IDrawerBizFacade jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeIDrawerBizFacade;
  
  static
  {
    jdField_a_of_type_AndroidxLifecycleViewModelProvider$Factory = new QQSettingMeViewModel.1();
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add(DrawerBizFacade.class);
  }
  
  public QQSettingMeViewModel(QQSettingMeBaseRepository paramQQSettingMeBaseRepository)
  {
    super(paramQQSettingMeBaseRepository);
  }
  
  public IDrawerBizFacade a()
  {
    IDrawerBizFacade localIDrawerBizFacade = this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeIDrawerBizFacade;
    if (localIDrawerBizFacade != null) {
      return localIDrawerBizFacade;
    }
    if (jdField_a_of_type_JavaUtilArrayList.size() != 0) {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeIDrawerBizFacade = ((IDrawerBizFacade)((Class)jdField_a_of_type_JavaUtilArrayList.get(0)).newInstance());
        localIDrawerBizFacade = this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeIDrawerBizFacade;
        return localIDrawerBizFacade;
      }
      catch (InstantiationException localInstantiationException)
      {
        localInstantiationException.printStackTrace();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
    } else {
      QLog.i("QQSettingRedesign", 2, "getQQSettingMeProcessor. sInjectProcessor.size() = 0");
    }
    return new BaseDrawerBizFacade();
  }
  
  public IQQSettingMeProcessor a(String paramString)
  {
    return ((IProcessorDispatcher)a()).a(paramString);
  }
  
  public void a()
  {
    a().a();
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    a().a(paramView, paramMotionEvent);
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    a().a(paramQQSettingMe);
  }
  
  public void a(String paramString)
  {
    a().a(paramString);
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    a().a(paramAppRuntime);
  }
  
  public void a(AppRuntime paramAppRuntime, QBaseActivity paramQBaseActivity)
  {
    a().a(paramAppRuntime, paramQBaseActivity);
  }
  
  public void b()
  {
    a().b();
  }
  
  public void c()
  {
    a().c();
  }
  
  public void d()
  {
    a().d();
  }
  
  public void e()
  {
    a().e();
  }
  
  public void f()
  {
    a().f();
  }
  
  public void g()
  {
    a().g();
  }
  
  public void h()
  {
    a().h();
  }
  
  public void i()
  {
    a().i();
  }
  
  public void onClick(View paramView)
  {
    a().onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeViewModel
 * JD-Core Version:    0.7.0.1
 */