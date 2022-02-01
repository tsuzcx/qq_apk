package com.tencent.mobileqq.activity.aio.panel.miniapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.business.MiniAppConfBean;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class AioPanelMiniAppManager
  implements Manager
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<String, Boolean> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_a_of_type_Boolean;
  
  public AioPanelMiniAppManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static AioPanelMiniAppManager a(QQAppInterface paramQQAppInterface)
  {
    return (AioPanelMiniAppManager)paramQQAppInterface.getManager(QQManagerFactory.AIO_PANEL_MINI_APP_MANAGER);
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AioPanelMiniAppManager", 2, "fetchDrawable: invoked.  url: " + paramString);
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    try
    {
      localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      if (localObject != null)
      {
        ((URLDrawable)localObject).setURLDrawableListener(new AioPanelMiniAppManager.1(this, paramString));
        ((URLDrawable)localObject).downloadImediatly();
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("AioPanelMiniAppManager", 1, "fetchDrawable: failed. ", paramString);
    }
  }
  
  private boolean a(String paramString)
  {
    paramString = (Boolean)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (paramString != null) {
      return paramString.booleanValue();
    }
    return false;
  }
  
  public Drawable a()
  {
    Object localObject = MiniAppConfProcessor.a();
    boolean bool1 = SimpleUIUtil.a();
    boolean bool2 = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    if (bool1) {
      if (bool2) {
        localObject = ((MiniAppConfBean)localObject).f();
      }
    }
    Drawable localDrawable;
    for (;;)
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130841450);
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mFailedDrawable = localDrawable;
      try
      {
        localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
        return localObject;
      }
      catch (Exception localException) {}
      localObject = ((MiniAppConfBean)localObject).e();
      continue;
      if (bool2) {
        localObject = ((MiniAppConfBean)localObject).d();
      } else {
        localObject = ((MiniAppConfBean)localObject).c();
      }
    }
    return localDrawable;
  }
  
  public void a()
  {
    MiniAppConfBean localMiniAppConfBean = MiniAppConfProcessor.a();
    boolean bool = TextUtils.isEmpty(localMiniAppConfBean.b());
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if ((localObject != null) && (!bool)) {
        a((QQAppInterface)localObject, localMiniAppConfBean);
      }
      return;
    }
  }
  
  public void a(Context paramContext, BaseChatPie paramBaseChatPie)
  {
    String str = MiniAppConfProcessor.a().b();
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramContext, str, 2053, paramBaseChatPie.a(), null);
    paramContext = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
    paramContext.a(paramContext.a("110000"), "");
    this.jdField_a_of_type_Boolean = true;
    ReportController.b(null, "dc00898", "", "", "0X800A120", "0X800A120", 0, 0, "", "", "", "");
  }
  
  public void a(QQAppInterface paramQQAppInterface, MiniAppConfBean paramMiniAppConfBean)
  {
    a(paramQQAppInterface).a(paramMiniAppConfBean.c());
    a(paramQQAppInterface).a(paramMiniAppConfBean.d());
    a(paramQQAppInterface).a(paramMiniAppConfBean.e());
    a(paramQQAppInterface).a(paramMiniAppConfBean.f());
  }
  
  public boolean a()
  {
    MiniAppConfBean localMiniAppConfBean = MiniAppConfProcessor.a();
    boolean bool1 = TextUtils.isEmpty(localMiniAppConfBean.b());
    boolean bool2 = a(localMiniAppConfBean.c());
    boolean bool3 = a(localMiniAppConfBean.d());
    boolean bool4 = a(localMiniAppConfBean.e());
    boolean bool5 = a(localMiniAppConfBean.f());
    if (bool1) {}
    while ((!bool2) || (!bool3) || (!bool4) || (!bool5)) {
      return false;
    }
    return true;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      return false;
    }
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a("110000");
    return (localAppInfo != null) && (localAppInfo.iNewFlag.get() == 1);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.miniapp.AioPanelMiniAppManager
 * JD-Core Version:    0.7.0.1
 */