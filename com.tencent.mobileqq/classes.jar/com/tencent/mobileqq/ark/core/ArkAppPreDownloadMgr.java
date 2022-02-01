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
  private final ArkAppPreloader.PreloadAppCallback jdField_a_of_type_ComTencentArkArkAppPreloader$PreloadAppCallback = new ArkAppPreDownloadMgr.3(this);
  private WeakReference<AppRuntime> jdField_a_of_type_JavaLangRefWeakReference = null;
  private ConcurrentHashMap<String, PreloadItem> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(8);
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  public ArkAppPreDownloadMgr(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppRuntime);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private static void a(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
  }
  
  private void a(String paramString1, String paramString2, ArkAppPreloader.PreloadAppCallback paramPreloadAppCallback, int paramInt)
  {
    String str1 = ArkEnvironmentManager.getInstance().getCacheDirectory();
    String str2 = ArkEnvironmentManager.getInstance().getStorageDirectory();
    String str3 = ArkEnvironmentManager.getInstance().getAppResPath(paramString1);
    a(str3);
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
  
  public static void e()
  {
    String str1 = ArkEnvironmentManager.getInstance().getCacheDirectory();
    String str2 = ArkEnvironmentManager.getInstance().getStorageDirectory();
    a(str1);
    a(str2);
    ArkAppPreloader.preloadCommon(((IDisplayConfig)QRoute.api(IDisplayConfig.class)).getDisplayDensity(), str2, str1);
  }
  
  public void a()
  {
    ArkPlatformConfigBean localArkPlatformConfigBean = (ArkPlatformConfigBean)ArkConfProcessor.a(ArkPlatformConfigBean.class);
    if ((localArkPlatformConfigBean == null) && (QLog.isColorLevel())) {
      QLog.e("ArkApp.ArkAppPreDownloadMgr", 2, "profiling get preload config from default");
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
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
    if ((paramArkPlatformConfigBean != null) && (paramArkPlatformConfigBean.a() != null))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = paramArkPlatformConfigBean.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
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
        boolean bool = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
        if (bool)
        {
          try
          {
            bool = a(paramString);
            if (bool) {
              return;
            }
            String str = ((AppRuntime)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getAccount();
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
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0)
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        PreloadItem localPreloadItem = (PreloadItem)((Map.Entry)localIterator.next()).getValue();
        if (!TextUtils.isEmpty(localPreloadItem.jdField_a_of_type_JavaLangString)) {
          if (ArkAppMgr.getInstance().getAppPathFromLocal(localPreloadItem.jdField_a_of_type_JavaLangString) == null) {
            a(localPreloadItem);
          } else {
            QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, new Object[] { "profiling ark app predowloaded,app=", localPreloadItem.jdField_a_of_type_JavaLangString });
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
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() != 0)
    {
      if (this.b) {
        return;
      }
      this.b = true;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        PreloadItem localPreloadItem = (PreloadItem)((Map.Entry)localIterator.next()).getValue();
        if ((!TextUtils.isEmpty(localPreloadItem.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(ArkAppMgr.getInstance().getAppPathFromLocal(localPreloadItem.jdField_a_of_type_JavaLangString))))
        {
          Object localObject;
          if (ArkAppCrashProtect.c(localPreloadItem.jdField_a_of_type_JavaLangString))
          {
            localPreloadItem.jdField_a_of_type_Int = 0;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("profiling disable to preload ArkApp name = ");
            ((StringBuilder)localObject).append(localPreloadItem.jdField_a_of_type_JavaLangString);
            QLog.w("ArkApp.ArkAppPreDownloadMgr", 1, ((StringBuilder)localObject).toString());
          }
          if (localPreloadItem.jdField_a_of_type_Int == 1)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("profiling need to preload ArkApp name = ");
            ((StringBuilder)localObject).append(localPreloadItem.jdField_a_of_type_JavaLangString);
            QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, ((StringBuilder)localObject).toString());
            localObject = ArkAppMgr.getInstance().getAppPathFromLocal(localPreloadItem.jdField_a_of_type_JavaLangString, "");
            a(localPreloadItem.jdField_a_of_type_JavaLangString, (String)localObject, this.jdField_a_of_type_ComTencentArkArkAppPreloader$PreloadAppCallback, 1);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkAppPreDownloadMgr
 * JD-Core Version:    0.7.0.1
 */