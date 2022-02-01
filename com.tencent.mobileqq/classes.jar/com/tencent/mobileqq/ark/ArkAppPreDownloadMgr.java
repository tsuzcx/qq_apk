package com.tencent.mobileqq.ark;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.ark.ArkAppPreloader;
import com.tencent.ark.ArkAppPreloader.PreloadAppCallback;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.ArkConfBean.ArkPlatformConfigBean;
import com.tencent.mobileqq.config.business.ArkManageConfig.ArkPlatformConfig;
import com.tencent.mobileqq.statistics.StatisticCollector;
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
  private int jdField_a_of_type_Int = 0;
  private ArkAppPreloader.PreloadAppCallback jdField_a_of_type_ComTencentArkArkAppPreloader$PreloadAppCallback = new ArkAppPreDownloadMgr.4(this);
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference = null;
  private ConcurrentHashMap<String, ArkAppPreDownloadMgr.PreloadItem> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(8);
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  public ArkAppPreDownloadMgr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_Boolean = false;
    ThreadManagerV2.executeOnSubThread(new ArkAppPreDownloadMgr.1(this));
  }
  
  private void a(ArkAppPreDownloadMgr.PreloadItem paramPreloadItem)
  {
    if (paramPreloadItem == null)
    {
      QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, "profiling preDownloadApp failed for item null");
      return;
    }
    ThreadManagerV2.executeOnSubThread(new ArkAppPreDownloadMgr.3(this, paramPreloadItem));
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
  
  public static void c()
  {
    String str1 = ArkEnvironmentManager.getInstance().getCacheDirectory();
    String str2 = ArkEnvironmentManager.getInstance().getStorageDirectory();
    a(str1);
    a(str2);
    ArkAppPreloader.preloadCommon(ArkAppCenterUtil.a(), str2, str1);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ArkApp.ArkAppPreDownloadMgr", 2, "profiling startPredownload");
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = 0;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        ArkAppPreDownloadMgr.PreloadItem localPreloadItem = (ArkAppPreDownloadMgr.PreloadItem)((Map.Entry)localIterator.next()).getValue();
        if (!TextUtils.isEmpty(localPreloadItem.a)) {
          if (TextUtils.isEmpty(ArkAppMgr.getInstance().getAppPathByNameFromLocal(localPreloadItem.a, "", null, false))) {
            a(localPreloadItem);
          } else {
            QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, new Object[] { "profiling ark app predowloaded,app=", localPreloadItem.a });
          }
        }
      }
    }
  }
  
  public void a(ArkConfBean.ArkPlatformConfigBean paramArkPlatformConfigBean)
  {
    if ((paramArkPlatformConfigBean != null) && (paramArkPlatformConfigBean.a() != null)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = paramArkPlatformConfigBean.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("ArkApp.ArkAppPreDownloadMgr", 2, "profiling updatePreloadConfig cfg is empty");
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        boolean bool;
        if (!TextUtils.isEmpty(paramString))
        {
          bool = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
          if (bool) {}
        }
        else
        {
          return;
        }
        String str;
        HashMap localHashMap;
        try
        {
          SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_app_first_use", 0);
          bool = localSharedPreferences.getBoolean(paramString, false);
          if (bool) {
            break label218;
          }
          str = BaseApplicationImpl.sApplication.getRuntime().getAccount();
          localHashMap = new HashMap();
          localHashMap.put("app_name", paramString);
          if (!paramBoolean) {
            break label193;
          }
          StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(str, "ark_app_predownload_first_hit", true, 0L, 0L, localHashMap, "", false);
          QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, new Object[] { "profiling reportPredownloadFirstHit app=", paramString, ",hasUsed=", Boolean.valueOf(bool), ",hasPreDownload=", Boolean.valueOf(paramBoolean) });
          localSharedPreferences.edit().putBoolean(paramString, true).apply();
        }
        catch (Exception paramString)
        {
          QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, "profiling reportPredownloadFirstHit exception=", paramString);
        }
        continue;
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(str, "ark_app_predownload_first_hit", false, 0L, 0L, localHashMap, "", false);
      }
      finally {}
      label193:
      continue;
      label218:
      QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, new Object[] { "profiling reportPredownloadFirstHit not first use app=", paramString });
    }
  }
  
  public void b()
  {
    QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, "profiling startPreload");
    ArkAppCenter.a(new ArkAppPreDownloadMgr.2(this), 10000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppPreDownloadMgr
 * JD-Core Version:    0.7.0.1
 */