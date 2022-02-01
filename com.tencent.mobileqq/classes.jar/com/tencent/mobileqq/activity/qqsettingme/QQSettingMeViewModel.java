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
  public static ViewModelProvider.Factory a = new QQSettingMeViewModel.1();
  @ConfigInject(configPath="/Foundation/QQActivity/src/main/resources/Inject_QQSettingMe_processor.yml", version=2)
  private static ArrayList<Class<? extends IDrawerBizFacade>> b = new ArrayList();
  private IDrawerBizFacade c;
  
  static
  {
    b.add(DrawerBizFacade.class);
  }
  
  public QQSettingMeViewModel(QQSettingMeBaseRepository paramQQSettingMeBaseRepository)
  {
    super(paramQQSettingMeBaseRepository);
  }
  
  public IDrawerBizFacade a()
  {
    IDrawerBizFacade localIDrawerBizFacade = this.c;
    if (localIDrawerBizFacade != null) {
      return localIDrawerBizFacade;
    }
    if (b.size() != 0) {
      try
      {
        this.c = ((IDrawerBizFacade)((Class)b.get(0)).newInstance());
        localIDrawerBizFacade = this.c;
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
    return ((IProcessorDispatcher)a()).b(paramString);
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    a().a(paramView, paramMotionEvent);
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    a().a(paramQQSettingMe);
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
    a().a();
  }
  
  public void b(String paramString)
  {
    a().a(paramString);
  }
  
  public void c()
  {
    a().b();
  }
  
  public void d()
  {
    a().c();
  }
  
  public void e()
  {
    a().d();
  }
  
  public void f()
  {
    a().e();
  }
  
  public void g()
  {
    a().f();
  }
  
  public void h()
  {
    a().g();
  }
  
  public void i()
  {
    a().h();
  }
  
  public void j()
  {
    a().i();
  }
  
  public void onClick(View paramView)
  {
    a().onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeViewModel
 * JD-Core Version:    0.7.0.1
 */