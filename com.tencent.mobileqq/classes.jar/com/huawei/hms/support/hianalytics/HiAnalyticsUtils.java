package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hianalytics.util.HiAnalyticTools;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.hms.stats.a;
import com.huawei.hms.stats.b;
import com.huawei.hms.stats.c;
import com.huawei.hms.support.log.HMSLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class HiAnalyticsUtils
{
  public static final Object c = new Object();
  public static final Object d = new Object();
  public static HiAnalyticsUtils e;
  public int a = 0;
  public boolean b = c.a();
  
  public static LinkedHashMap<String, String> a(Map<String, String> paramMap)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localLinkedHashMap.put(str, paramMap.get(str));
    }
    return localLinkedHashMap;
  }
  
  public static HiAnalyticsUtils getInstance()
  {
    synchronized (c)
    {
      if (e == null) {
        e = new HiAnalyticsUtils();
      }
      HiAnalyticsUtils localHiAnalyticsUtils = e;
      return localHiAnalyticsUtils;
    }
  }
  
  public static String versionCodeToName(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.length() == 8) || (paramString.length() == 9))) {}
    try
    {
      Integer.parseInt(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Integer.parseInt(paramString.substring(0, paramString.length() - 7)));
      localStringBuilder.append(".");
      localStringBuilder.append(Integer.parseInt(paramString.substring(paramString.length() - 7, paramString.length() - 5)));
      localStringBuilder.append(".");
      localStringBuilder.append(Integer.parseInt(paramString.substring(paramString.length() - 5, paramString.length() - 3)));
      localStringBuilder.append(".");
      localStringBuilder.append(Integer.parseInt(paramString.substring(paramString.length() - 3)));
      paramString = localStringBuilder.toString();
      return paramString;
    }
    catch (NumberFormatException paramString) {}
    return "";
    return "";
  }
  
  public final void a(Context paramContext)
  {
    synchronized (d)
    {
      if (this.a < 60)
      {
        this.a += 1;
      }
      else
      {
        this.a = 0;
        if (!this.b)
        {
          HmsHiAnalyticsUtils.onReport();
        }
        else
        {
          b.a(paramContext, 0);
          b.a(paramContext, 1);
        }
      }
      return;
    }
  }
  
  public void enableLog()
  {
    HMSLog.i("HiAnalyticsUtils", "Enable Log");
    if (!this.b)
    {
      HmsHiAnalyticsUtils.enableLog();
      return;
    }
    HMSLog.i("HiAnalyticsUtils", "cp needs to pass in the context, this method is not supported");
  }
  
  public void enableLog(Context paramContext)
  {
    HMSLog.i("HiAnalyticsUtils", "Enable Log");
    if (!this.b)
    {
      HmsHiAnalyticsUtils.enableLog();
      return;
    }
    HiAnalyticTools.enableLog(paramContext);
  }
  
  public boolean getInitFlag()
  {
    if (!this.b) {
      return HmsHiAnalyticsUtils.getInitFlag();
    }
    return HiAnalyticsManager.getInitFlag("hms_config_tag");
  }
  
  public boolean hasError(Context paramContext)
  {
    return a.c(paramContext);
  }
  
  public void onBuoyEvent(Context paramContext, String paramString1, String paramString2)
  {
    if (hasError(paramContext)) {
      return;
    }
    if (paramContext != null) {
      onEvent2(paramContext, paramString1, paramString2);
    }
  }
  
  public void onEvent(Context paramContext, String paramString, Map<String, String> paramMap)
  {
    if (hasError(paramContext)) {
      return;
    }
    if ((paramMap != null) && (!paramMap.isEmpty()) && (paramContext != null))
    {
      if (!getInitFlag()) {
        return;
      }
      if (!this.b)
      {
        HmsHiAnalyticsUtils.onEvent(0, paramString, a(paramMap));
        HmsHiAnalyticsUtils.onEvent(1, paramString, a(paramMap));
      }
      else
      {
        b.a(paramContext, 0, paramString, a(paramMap));
        b.a(paramContext, 1, paramString, a(paramMap));
      }
      a(paramContext);
    }
  }
  
  public void onEvent2(Context paramContext, String paramString1, String paramString2)
  {
    if (hasError(paramContext)) {
      return;
    }
    if (paramContext != null)
    {
      if (!getInitFlag()) {
        return;
      }
      if (!this.b)
      {
        HmsHiAnalyticsUtils.onEvent(paramContext, paramString1, paramString2);
        return;
      }
      b.a(paramContext, paramString1, paramString2);
    }
  }
  
  public void onNewEvent(Context paramContext, String paramString, Map paramMap)
  {
    if (hasError(paramContext)) {
      return;
    }
    if ((paramMap != null) && (!paramMap.isEmpty()) && (paramContext != null))
    {
      if (!getInitFlag()) {
        return;
      }
      if (!this.b)
      {
        HmsHiAnalyticsUtils.onEvent(0, paramString, a(paramMap));
        HmsHiAnalyticsUtils.onEvent(1, paramString, a(paramMap));
      }
      else
      {
        b.a(paramContext, 0, paramString, a(paramMap));
        b.a(paramContext, 1, paramString, a(paramMap));
      }
      a(paramContext);
    }
  }
  
  public void onNewEvent(Context paramContext, String paramString, Map paramMap, int paramInt)
  {
    if (hasError(paramContext)) {
      return;
    }
    if ((paramInt != 0) && (paramInt != 1))
    {
      HMSLog.e("HiAnalyticsUtils", "Data reporting type is not supported");
      return;
    }
    if ((paramMap != null) && (!paramMap.isEmpty()) && (paramContext != null))
    {
      if (!getInitFlag()) {
        return;
      }
      if (!this.b) {
        HmsHiAnalyticsUtils.onEvent(paramInt, paramString, a(paramMap));
      } else {
        b.a(paramContext, paramInt, paramString, a(paramMap));
      }
      a(paramContext);
    }
  }
  
  public void onReport(Context paramContext, String paramString, Map paramMap)
  {
    if (hasError(paramContext)) {
      return;
    }
    if ((paramMap != null) && (!paramMap.isEmpty()) && (paramContext != null))
    {
      if (!getInitFlag()) {
        return;
      }
      if (!this.b)
      {
        HmsHiAnalyticsUtils.onEvent(0, paramString, a(paramMap));
        HmsHiAnalyticsUtils.onEvent(1, paramString, a(paramMap));
        HmsHiAnalyticsUtils.onReport();
        return;
      }
      b.a(paramContext, 0, paramString, a(paramMap));
      b.a(paramContext, 1, paramString, a(paramMap));
      b.a(paramContext, 0);
      b.a(paramContext, 1);
    }
  }
  
  public void onReport(Context paramContext, String paramString, Map paramMap, int paramInt)
  {
    if (hasError(paramContext)) {
      return;
    }
    if ((paramInt != 0) && (paramInt != 1))
    {
      HMSLog.e("HiAnalyticsUtils", "Data reporting type is not supported");
      return;
    }
    if ((paramMap != null) && (!paramMap.isEmpty()) && (paramContext != null))
    {
      if (!getInitFlag()) {
        return;
      }
      if (!this.b)
      {
        HmsHiAnalyticsUtils.onEvent(paramInt, paramString, a(paramMap));
        HmsHiAnalyticsUtils.onReport();
        return;
      }
      b.a(paramContext, paramInt, paramString, a(paramMap));
      b.a(paramContext, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.support.hianalytics.HiAnalyticsUtils
 * JD-Core Version:    0.7.0.1
 */