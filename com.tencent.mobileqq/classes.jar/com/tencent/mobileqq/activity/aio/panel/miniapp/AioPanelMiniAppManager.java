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
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class AioPanelMiniAppManager
  implements Manager
{
  QQAppInterface a;
  private ConcurrentHashMap<String, Boolean> b;
  private boolean c;
  
  public AioPanelMiniAppManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.b = new ConcurrentHashMap();
  }
  
  public static AioPanelMiniAppManager a(QQAppInterface paramQQAppInterface)
  {
    return (AioPanelMiniAppManager)paramQQAppInterface.getManager(QQManagerFactory.AIO_PANEL_MINI_APP_MANAGER);
  }
  
  private boolean a(String paramString)
  {
    paramString = (Boolean)this.b.get(paramString);
    if (paramString != null) {
      return paramString.booleanValue();
    }
    return false;
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fetchDrawable: invoked.  url: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("AioPanelMiniAppManager", 2, ((StringBuilder)localObject).toString());
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
  
  public void a()
  {
    MiniAppConfBean localMiniAppConfBean = MiniAppConfProcessor.a();
    boolean bool = TextUtils.isEmpty(localMiniAppConfBean.j());
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {
      localObject = (QQAppInterface)localObject;
    } else {
      localObject = null;
    }
    if ((localObject != null) && (!bool)) {
      a((QQAppInterface)localObject, localMiniAppConfBean);
    }
  }
  
  public void a(Context paramContext, BaseChatPie paramBaseChatPie)
  {
    String str = MiniAppConfProcessor.a().j();
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramContext, str, 2053, paramBaseChatPie.aV(), null);
    paramContext = (IRedTouchManager)this.a.getRuntimeService(IRedTouchManager.class, "");
    paramContext.onRedTouchItemClick(paramContext.getAppInfoByPath("110000"), "");
    this.c = true;
    ReportController.b(null, "dc00898", "", "", "0X800A120", "0X800A120", 0, 0, "", "", "", "");
  }
  
  public void a(QQAppInterface paramQQAppInterface, MiniAppConfBean paramMiniAppConfBean)
  {
    a(paramQQAppInterface).b(paramMiniAppConfBean.k());
    a(paramQQAppInterface).b(paramMiniAppConfBean.l());
    a(paramQQAppInterface).b(paramMiniAppConfBean.m());
    a(paramQQAppInterface).b(paramMiniAppConfBean.n());
  }
  
  public boolean b()
  {
    MiniAppConfBean localMiniAppConfBean = MiniAppConfProcessor.a();
    boolean bool1 = TextUtils.isEmpty(localMiniAppConfBean.j());
    boolean bool3 = a(localMiniAppConfBean.k());
    boolean bool4 = a(localMiniAppConfBean.l());
    boolean bool5 = a(localMiniAppConfBean.m());
    boolean bool6 = a(localMiniAppConfBean.n());
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (bool4)
      {
        bool1 = bool2;
        if (bool5)
        {
          bool1 = bool2;
          if (bool6) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public Drawable c()
  {
    Object localObject = MiniAppConfProcessor.a();
    boolean bool1 = SimpleUIUtil.e();
    boolean bool2 = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    if (bool1)
    {
      if (bool2) {
        localObject = ((MiniAppConfBean)localObject).n();
      } else {
        localObject = ((MiniAppConfBean)localObject).m();
      }
    }
    else if (bool2) {
      localObject = ((MiniAppConfBean)localObject).l();
    } else {
      localObject = ((MiniAppConfBean)localObject).k();
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130842122);
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    try
    {
      localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
      return localObject;
    }
    catch (Exception localException) {}
    return localDrawable;
  }
  
  public boolean d()
  {
    if (this.c)
    {
      this.c = false;
      return false;
    }
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)this.a.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("110000");
    return (localAppInfo != null) && (localAppInfo.iNewFlag.get() == 1);
  }
  
  public void onDestroy()
  {
    this.b.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.miniapp.AioPanelMiniAppManager
 * JD-Core Version:    0.7.0.1
 */