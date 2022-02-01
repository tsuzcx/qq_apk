package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.text.TextUtils;
import com.huawei.hms.stats.bs;
import com.huawei.hms.stats.bu;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.countrycode.CountryCodeBean;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class HiAnalyticsUtils
{
  private static final Object a = new Object();
  private static final Object b = new Object();
  private static HiAnalyticsUtils c;
  private static String e = new String();
  private int d = 0;
  private final int f = -1;
  private int g = -1;
  private int h = -1;
  private boolean i = false;
  
  private String a(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return null;
    }
    localJSONObject = new JSONObject();
    try
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
      }
      return localJSONObject.toString();
    }
    catch (JSONException paramMap)
    {
      HMSLog.e("HiAnalyticsUtils", "AnalyticsHelper create json exception" + paramMap.getMessage());
    }
  }
  
  private void a()
  {
    synchronized (b)
    {
      if (this.d < 60)
      {
        this.d += 1;
        return;
      }
      this.d = 0;
      bs.a();
    }
  }
  
  private boolean a(Context paramContext)
  {
    if (paramContext == null)
    {
      HMSLog.e("HiAnalyticsUtils", "In getBiIsReportSetting, context is null.");
      return false;
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager == null)
    {
      HMSLog.e("HiAnalyticsUtils", "In getBiIsReportSetting, Failed to get 'PackageManager' instance.");
      return false;
    }
    this.h = 0;
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 128).applicationInfo;
      if ((paramContext != null) && (paramContext.metaData != null))
      {
        this.i = paramContext.metaData.getBoolean("com.huawei.hms.client.bireport.setting");
        return this.i;
      }
      HMSLog.i("HiAnalyticsUtils", "In getBiIsReportSetting, Failed to read meta data bi report setting.");
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      HMSLog.e("HiAnalyticsUtils", "In getBiIsReportSetting, Failed to read meta data bi report setting.");
    }
    return false;
  }
  
  private static LinkedHashMap<String, String> b(Map<String, String> paramMap)
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
    synchronized (a)
    {
      if (c == null) {
        c = new HiAnalyticsUtils();
      }
      HiAnalyticsUtils localHiAnalyticsUtils = c;
      return localHiAnalyticsUtils;
    }
  }
  
  public static String versionCodeToName(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.length() == 8) || (paramString.length() == 9))) {
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
      catch (NumberFormatException paramString)
      {
        return "";
      }
    }
    return "";
  }
  
  public void enableLog()
  {
    HMSLog.i("HiAnalyticsUtils", "Enable Log");
    bu.a();
  }
  
  public boolean getInitFlag()
  {
    HMSLog.i("HiAnalyticsUtils", "Get the init flag");
    return bs.b();
  }
  
  public boolean hasError(Context paramContext)
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.h == -1)
    {
      bool1 = a(paramContext);
      if (!bool1) {
        break label39;
      }
      HMSLog.i("HiAnalyticsUtils", "cp BI report protocol is true");
      bool1 = false;
    }
    label39:
    label179:
    label204:
    label209:
    do
    {
      String str;
      do
      {
        return bool1;
        bool1 = this.i;
        break;
        if ((e == null) || (e.isEmpty()))
        {
          HMSLog.i("HiAnalyticsUtils", "issueCountry initial");
          e = new CountryCodeBean(paramContext, false).a();
          if (!TextUtils.isEmpty(e)) {
            break label179;
          }
          str = "CN";
          e = str;
        }
        if (("CN".equalsIgnoreCase(e)) || (this.g != -1)) {
          break label209;
        }
        HMSLog.i("HiAnalyticsUtils", "not ChinaROM");
        bool1 = bool2;
      } while (paramContext == null);
      for (;;)
      {
        try
        {
          this.g = Settings.Secure.getInt(paramContext.getContentResolver(), "hw_app_analytics_state");
          HMSLog.i("HiAnalyticsUtils", "hw_app_analytics_state value is " + this.g);
          if (this.g == 1) {
            break label204;
          }
          bool1 = true;
          return bool1;
        }
        catch (Settings.SettingNotFoundException paramContext)
        {
          HMSLog.i("HiAnalyticsUtils", "Get OOBE failed");
          return true;
        }
        str = e.toUpperCase(Locale.ENGLISH);
        break;
        bool1 = false;
      }
      bool1 = bool2;
    } while (this.g == 0);
    return false;
  }
  
  public void onBuoyEvent(Context paramContext, String paramString1, String paramString2)
  {
    if (hasError(paramContext)) {}
    while (paramContext == null) {
      return;
    }
    onEvent2(paramContext, paramString1, paramString2);
  }
  
  public void onEvent(Context paramContext, String paramString, Map<String, String> paramMap)
  {
    if (hasError(paramContext)) {}
    String str;
    do
    {
      return;
      str = a(paramMap);
    } while (TextUtils.isEmpty(str));
    onEvent2(paramContext, paramString, str);
    bs.a(1, paramString, b(paramMap));
    a();
  }
  
  public void onEvent2(Context paramContext, String paramString1, String paramString2)
  {
    if (hasError(paramContext)) {}
    while ((paramContext == null) || (!bs.b())) {
      return;
    }
    bs.a(paramContext, paramString1, paramString2);
  }
  
  public void onNewEvent(Context paramContext, String paramString, Map paramMap)
  {
    if (hasError(paramContext)) {}
    String str;
    do
    {
      return;
      str = a(paramMap);
    } while ((paramContext == null) || (!bs.b()));
    bs.a(paramContext, paramString, str);
    bs.a(1, paramString, b(paramMap));
    a();
  }
  
  public void onReport(Context paramContext, String paramString, Map paramMap)
  {
    if (hasError(paramContext)) {}
    String str;
    do
    {
      return;
      str = a(paramMap);
    } while (TextUtils.isEmpty(str));
    HMSLog.i("HiAnalyticsUtils", "Report the data");
    onEvent2(paramContext, paramString, str);
    bs.a(1, paramString, b(paramMap));
    bs.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.support.hianalytics.HiAnalyticsUtils
 * JD-Core Version:    0.7.0.1
 */