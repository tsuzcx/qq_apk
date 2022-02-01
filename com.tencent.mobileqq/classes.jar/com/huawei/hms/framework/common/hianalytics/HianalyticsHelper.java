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
import java.util.concurrent.RejectedExecutionException;

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
      label34:
      break label34;
    }
    Logger.w("HianalyticsHelper", "maybe you need add Hianalytics sdk");
    this.hasHianalytics = false;
  }
  
  public static HianalyticsHelper getInstance()
  {
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new HianalyticsHelper();
        }
      }
      finally {}
    }
    return instance;
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
    if (!this.hasHianalytics) {
      paramContext = "Hianalytics sdk need to be initialized";
    }
    for (;;)
    {
      Logger.i("HianalyticsHelper", paramContext);
      return false;
      if (paramContext == null)
      {
        paramContext = "HianalyticsHelper context can't be null";
      }
      else
      {
        if (Settings.Secure.getInt(paramContext.getContentResolver(), "user_experience_involved", -1) == 1)
        {
          if (HiAnalytics.getInitFlag()) {
            return true;
          }
          if (this.hInstance == null) {
            this.hInstance = HiAnalyticsManager.getInstanceByTag(this.haTag);
          }
          return this.hInstance != null;
        }
        paramContext = "user experience involved needs to be opened";
      }
    }
  }
  
  public void onEvent(LinkedHashMap<String, String> paramLinkedHashMap)
  {
    onEvent(paramLinkedHashMap, "networkkit_restclient");
  }
  
  public void onEvent(LinkedHashMap<String, String> paramLinkedHashMap, String paramString)
  {
    if (!this.hasHianalytics) {
      return;
    }
    if (paramLinkedHashMap == null) {
      return;
    }
    Logger.v("HianalyticsHelper", "data = %s", new Object[] { paramLinkedHashMap });
    if (HiAnalytics.getInitFlag())
    {
      HiAnalytics.onEvent(1, paramString, paramLinkedHashMap);
      return;
    }
    HiAnalyticsInstance localHiAnalyticsInstance = this.hInstance;
    if (localHiAnalyticsInstance != null) {
      localHiAnalyticsInstance.onEvent(1, paramString, paramLinkedHashMap);
    }
  }
  
  public void reportException(Throwable paramThrowable, String paramString)
  {
    String str = Thread.currentThread().getName();
    try
    {
      this.reportExecutor.submit(new HianalyticsHelper.1(this, str, paramThrowable, paramString));
      return;
    }
    catch (RejectedExecutionException paramThrowable)
    {
      break label45;
    }
    catch (Exception paramString)
    {
      label29:
      break label29;
    }
    Logger.i("HianalyticsHelper", "reportException error!", new Object[] { paramThrowable });
    return;
    label45:
    Logger.i("HianalyticsHelper", "reportException error RejectedExecutionException");
  }
  
  public void setHaTag(String paramString)
  {
    this.haTag = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.common.hianalytics.HianalyticsHelper
 * JD-Core Version:    0.7.0.1
 */