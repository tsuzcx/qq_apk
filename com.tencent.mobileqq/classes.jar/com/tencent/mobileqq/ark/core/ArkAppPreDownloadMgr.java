package com.tencent.mobileqq.ark.core;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.ark.ArkAppPreloader;
import com.tencent.ark.ArkAppPreloader.PreloadAppCallback;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.base.ArkLogicThread;
import com.tencent.mobileqq.ark.config.PreloadItem;
import com.tencent.mobileqq.ark.config.bean.ArkPlatformConfigBean;
import com.tencent.mobileqq.ark.config.config.ArkPlatformConfig;
import com.tencent.mobileqq.ark.config.processor.ArkConfProcessor;
import com.tencent.mobileqq.ark.temp.api.IDisplayConfig;
import com.tencent.mobileqq.ark.util.ArkAppCrashProtect;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class ArkAppPreDownloadMgr
{
  private boolean a = false;
  private boolean b = false;
  private ConcurrentHashMap<String, PreloadItem> c = new ConcurrentHashMap(8);
  private WeakReference<AppRuntime> d = null;
  private final ArkAppPreloader.PreloadAppCallback e = new ArkAppPreDownloadMgr.3(this);
  
  public ArkAppPreDownloadMgr(AppRuntime paramAppRuntime)
  {
    this.d = new WeakReference(paramAppRuntime);
    this.a = false;
  }
  
  private void a(String paramString1, String paramString2, ArkAppPreloader.PreloadAppCallback paramPreloadAppCallback, int paramInt)
  {
    String str1 = ArkEnvironmentManager.getInstance().getCacheDirectory();
    String str2 = ArkEnvironmentManager.getInstance().getStorageDirectory();
    String str3 = ArkEnvironmentManager.getInstance().getAppResPath(paramString1);
    b(str3);
    ArkAppPreloader.preloadApp(paramString1, paramString2, str2, str3, str1, paramPreloadAppCallback, paramInt);
  }
  
  static boolean a(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_ark_app_first_use", 0);
    if (!localSharedPreferences.getBoolean(paramString, false))
    {
      localSharedPreferences.edit().putBoolean(paramString, true).apply();
      return false;
    }
    return true;
  }
  
  private static void b(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
  }
  
  public static void e()
  {
    String str1 = ArkEnvironmentManager.getInstance().getCacheDirectory();
    String str2 = ArkEnvironmentManager.getInstance().getStorageDirectory();
    b(str1);
    b(str2);
    ArkAppPreloader.preloadCommon(((IDisplayConfig)QRoute.api(IDisplayConfig.class)).getDisplayDensity(), str2, str1);
  }
  
  public void a()
  {
    ArkPlatformConfigBean localArkPlatformConfigBean = (ArkPlatformConfigBean)ArkConfProcessor.a(ArkPlatformConfigBean.class);
    if ((localArkPlatformConfigBean == null) && (QLog.isColorLevel())) {
      QLog.e("ArkApp.ArkAppPreDownloadMgr", 2, "profiling get preload config from default");
    }
    this.c.clear();
    a(localArkPlatformConfigBean);
    e();
    b();
  }
  
  void a(PreloadItem paramPreloadItem)
  {
    if (paramPreloadItem == null)
    {
      QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, "profiling preDownloadApp failed for item null");
      return;
    }
    ThreadManagerV2.executeOnSubThread(new ArkAppPreDownloadMgr.2(this, paramPreloadItem));
  }
  
  public void a(ArkPlatformConfigBean paramArkPlatformConfigBean)
  {
    if ((paramArkPlatformConfigBean != null) && (paramArkPlatformConfigBean.b() != null))
    {
      this.c = paramArkPlatformConfigBean.b().i;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ArkApp.ArkAppPreDownloadMgr", 2, "profiling updatePreloadConfig cfg is empty");
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        boolean bool = this.c.containsKey(paramString);
        if (bool)
        {
          try
          {
            bool = a(paramString);
            if (bool) {
              return;
            }
            String str = ((AppRuntime)this.d.get()).getAccount();
            HashMap localHashMap = new HashMap();
            localHashMap.put("app_name", paramString);
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, "ark_app_predownload_first_hit", paramBoolean, 0L, 0L, localHashMap, "", false);
            QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, new Object[] { "profiling reportPredownloadFirstHit app=", paramString, ",hasPreDownload=", Boolean.valueOf(paramBoolean) });
          }
          catch (Exception paramString)
          {
            QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, "profiling reportPredownloadFirstHit exception=", paramString);
          }
          return;
        }
      }
      return;
    }
    finally {}
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ArkApp.ArkAppPreDownloadMgr", 2, "profiling startPredownload");
    }
    if (this.c.size() > 0)
    {
      if (this.a) {
        return;
      }
      this.a = true;
      Iterator localIterator = this.c.entrySet().iterator();
      while (localIterator.hasNext())
      {
        PreloadItem localPreloadItem = (PreloadItem)((Map.Entry)localIterator.next()).getValue();
        if (!TextUtils.isEmpty(localPreloadItem.a)) {
          if (ArkAppMgr.getInstance().getAppPathFromLocal(localPreloadItem.a) == null) {
            a(localPreloadItem);
          } else {
            QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, new Object[] { "profiling ark app predowloaded,app=", localPreloadItem.a });
          }
        }
      }
    }
  }
  
  public void c()
  {
    QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, "profiling startPreload");
    ArkLogicThread.a(new ArkAppPreDownloadMgr.1(this), 10000L);
  }
  
  void d()
  {
    if (this.c.size() != 0)
    {
      if (this.b) {
        return;
      }
      this.b = true;
      Iterator localIterator = this.c.entrySet().iterator();
      while (localIterator.hasNext())
      {
        PreloadItem localPreloadItem = (PreloadItem)((Map.Entry)localIterator.next()).getValue();
        if ((!TextUtils.isEmpty(localPreloadItem.a)) && (!TextUtils.isEmpty(ArkAppMgr.getInstance().getAppPathFromLocal(localPreloadItem.a))))
        {
          Object localObject;
          if (ArkAppCrashProtect.c(localPreloadItem.a))
          {
            localPreloadItem.b = 0;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("profiling disable to preload ArkApp name = ");
            ((StringBuilder)localObject).append(localPreloadItem.a);
            QLog.w("ArkApp.ArkAppPreDownloadMgr", 1, ((StringBuilder)localObject).toString());
          }
          if (localPreloadItem.b == 1)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("profiling need to preload ArkApp name = ");
            ((StringBuilder)localObject).append(localPreloadItem.a);
            QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, ((StringBuilder)localObject).toString());
            localObject = ArkAppMgr.getInstance().getAppPathFromLocal(localPreloadItem.a, "");
            a(localPreloadItem.a, (String)localObject, this.e, 1);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkAppPreDownloadMgr
 * JD-Core Version:    0.7.0.1
 */