package com.huawei.hms.framework.common.hianalytics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings.Secure;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hianalytics.v2.HiAnalytics;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutorService;

public class HianalyticsHelper
{
  private static final String EVENT_ID = "networkkit_restclient";
  private static final String HWID_HA_SERVICE_TAG = "hms_hwid";
  private static final String TAG = "HianalyticsHelper";
  private static final int TYPE_MAINTF = 1;
  private static final String USER_EXPERIENCE_INVOLVED = "user_experience_involved";
  private static final int USER_EXPERIENCE_ON = 1;
  @SuppressLint({"StaticFieldLeak"})
  private static volatile HianalyticsHelper instance;
  private HiAnalyticsInstance hInstance = null;
  private String haTag = "hms_hwid";
  private boolean hasHianalytics;
  private ExecutorService reportExecutor = ExecutorsUtils.newSingleThreadExecutor("report_ha");
  
  private HianalyticsHelper()
  {
    try
    {
      HiAnalytics.getInitFlag();
      this.hasHianalytics = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.w("HianalyticsHelper", "maybe you need add Hianalytics sdk");
      this.hasHianalytics = false;
    }
  }
  
  public static HianalyticsHelper getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new HianalyticsHelper();
      }
      return instance;
    }
    finally {}
  }
  
  public ExecutorService getReportExecutor()
  {
    return this.reportExecutor;
  }
  
  public boolean isEnableReport(Context paramContext)
  {
    if (!this.hasHianalytics) {
      return false;
    }
    return isEnableReportNoSeed(paramContext);
  }
  
  public boolean isEnableReportNoSeed(Context paramContext)
  {
    boolean bool = true;
    if (!this.hasHianalytics) {}
    while ((paramContext == null) || (Settings.Secure.getInt(paramContext.getContentResolver(), "user_experience_involved", -1) != 1)) {
      return false;
    }
    if (HiAnalytics.getInitFlag()) {
      return true;
    }
    if (this.hInstance == null) {
      this.hInstance = HiAnalyticsManager.getInstanceByTag(this.haTag);
    }
    if (this.hInstance != null) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public void onEvent(LinkedHashMap<String, String> paramLinkedHashMap)
  {
    onEvent(paramLinkedHashMap, "networkkit_restclient");
  }
  
  public void onEvent(LinkedHashMap<String, String> paramLinkedHashMap, String paramString)
  {
    if (!this.hasHianalytics) {}
    do
    {
      do
      {
        return;
      } while (paramLinkedHashMap == null);
      Logger.v("HianalyticsHelper", "data = %s", new Object[] { paramLinkedHashMap });
      if (HiAnalytics.getInitFlag())
      {
        HiAnalytics.onEvent(1, paramString, paramLinkedHashMap);
        return;
      }
    } while (this.hInstance == null);
    this.hInstance.onEvent(1, paramString, paramLinkedHashMap);
  }
  
  public void setHaTag(String paramString)
  {
    this.haTag = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.framework.common.hianalytics.HianalyticsHelper
 * JD-Core Version:    0.7.0.1
 */