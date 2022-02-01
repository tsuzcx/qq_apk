package com.tencent.comic;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.comic.api.IQQComicPluginUtil.ExtraResult;
import com.tencent.comic.api.plugin.IQQComicPluginPreloadStrategy.PluginPreloadInfo;
import com.tencent.comic.utils.AppHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.module.IQRoutePlugin;
import com.tencent.mobileqq.qroute.module.QRoutePluginInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class PluginPreloader
{
  private static final Handler a;
  
  static
  {
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("PluginPreloader", 0);
    localHandlerThread.start();
    a = new Handler(localHandlerThread.getLooper());
  }
  
  public static void a(PluginPreloadStrategy paramPluginPreloadStrategy)
  {
    a(paramPluginPreloadStrategy, 0L);
  }
  
  public static void a(PluginPreloadStrategy paramPluginPreloadStrategy, long paramLong)
  {
    String str = paramPluginPreloadStrategy.a.jdField_a_of_type_JavaLangString;
    if ((paramPluginPreloadStrategy != null) && (str != null))
    {
      a.postDelayed(new PluginPreloader.1(str, paramPluginPreloadStrategy), paramLong);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PluginPreloader", 2, "the preload strategy or target process is null.");
    }
  }
  
  static void a(AppRuntime paramAppRuntime, PluginPreloadStrategy paramPluginPreloadStrategy, int paramInt, IQQComicPluginUtil.ExtraResult paramExtraResult)
  {
    paramPluginPreloadStrategy.a(paramExtraResult);
    int i = paramPluginPreloadStrategy.a.jdField_b_of_type_Int;
    int j = paramPluginPreloadStrategy.a.c;
    Object localObject1 = paramPluginPreloadStrategy.a.jdField_b_of_type_JavaLangString;
    String str = String.valueOf(paramPluginPreloadStrategy.a.d);
    if (localObject1 != null)
    {
      Object localObject2 = QRoute.plugin("comic_plugin.apk");
      if (localObject2 == null)
      {
        if (QLog.isColorLevel())
        {
          paramPluginPreloadStrategy = new StringBuilder();
          paramPluginPreloadStrategy.append("pluginType:");
          paramPluginPreloadStrategy.append(i);
          paramPluginPreloadStrategy.append(" preload:fail:nopluginmanager");
          QLog.d("PluginPreloader", 2, paramPluginPreloadStrategy.toString());
        }
        PluginPreloadReportUtils.a(paramAppRuntime, 1, i, j, 3, "preload:fail:nopluginmanager", paramInt, new String[] { str });
        return;
      }
      localObject1 = ((IQRoutePlugin)localObject2).queryPluginInfo();
      if (localObject1 == null)
      {
        if (QLog.isColorLevel())
        {
          paramPluginPreloadStrategy = new StringBuilder();
          paramPluginPreloadStrategy.append("pluginType:");
          paramPluginPreloadStrategy.append(i);
          paramPluginPreloadStrategy.append(" preload:fail:noplugininfo");
          QLog.d("PluginPreloader", 2, paramPluginPreloadStrategy.toString());
        }
        PluginPreloadReportUtils.a(paramAppRuntime, 1, i, j, 3, "preload:fail:noplugininfo", paramInt, new String[] { str });
        return;
      }
      if (((QRoutePluginInfo)localObject1).getState() == 4)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("plugin already installed, do preload. ComicPlugin.pluginInfo.version=");
          ((StringBuilder)localObject2).append(((QRoutePluginInfo)localObject1).getVersion());
          QLog.d("PluginPreloader", 2, ((StringBuilder)localObject2).toString());
        }
        PluginPreloadReportUtils.a(paramAppRuntime, 0, i, j, paramExtraResult.jdField_a_of_type_Int, paramExtraResult.jdField_a_of_type_JavaLangString, paramInt, new String[] { str });
        paramPluginPreloadStrategy.a();
        return;
      }
      if ((paramPluginPreloadStrategy.a.jdField_a_of_type_Boolean) && (NetworkUtil.isWifiConnected(AppHelper.a())))
      {
        ((IQRoutePlugin)localObject2).install(new PluginPreloader.2(paramAppRuntime, i, j, paramExtraResult, paramInt, paramPluginPreloadStrategy));
        return;
      }
      if (QLog.isColorLevel())
      {
        paramPluginPreloadStrategy = new StringBuilder();
        paramPluginPreloadStrategy.append("pluginType:");
        paramPluginPreloadStrategy.append(i);
        paramPluginPreloadStrategy.append(" preload:fail:uninstall");
        QLog.d("PluginPreloader", 2, paramPluginPreloadStrategy.toString());
      }
      PluginPreloadReportUtils.a(paramAppRuntime, 1, i, j, 3, "preload:fail:uninstall", paramInt, new String[] { str });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PluginPreloader", 2, "do preload");
    }
    PluginPreloadReportUtils.a(paramAppRuntime, 0, i, j, paramExtraResult.jdField_a_of_type_Int, paramExtraResult.jdField_a_of_type_JavaLangString, paramInt, new String[] { str });
    paramPluginPreloadStrategy.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.PluginPreloader
 * JD-Core Version:    0.7.0.1
 */