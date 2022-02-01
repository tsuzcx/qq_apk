package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.util.HashMap;
import java.util.Map;

public class HiAnalyticsUtil
{
  private static final Object a = new Object();
  private static HiAnalyticsUtil b;
  private static HiAnalyticsUtils c;
  
  private String a(Context paramContext, String paramString)
  {
    String str = paramContext.getPackageName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("01|");
    localStringBuilder.append("");
    localStringBuilder.append("|");
    localStringBuilder.append(str);
    localStringBuilder.append("|");
    localStringBuilder.append(Util.getAppId(paramContext));
    localStringBuilder.append("|");
    localStringBuilder.append(50200300);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static HiAnalyticsUtil getInstance()
  {
    synchronized (a)
    {
      if (b == null)
      {
        b = new HiAnalyticsUtil();
        c = HiAnalyticsUtils.getInstance();
      }
      HiAnalyticsUtil localHiAnalyticsUtil = b;
      return localHiAnalyticsUtil;
    }
  }
  
  public static Map<String, String> getMapFromForegroundResponseHeader(ResponseHeader paramResponseHeader)
  {
    HashMap localHashMap = new HashMap();
    if (paramResponseHeader == null) {
      return localHashMap;
    }
    localHashMap.put("transId", paramResponseHeader.getTransactionId());
    localHashMap.put("appid", paramResponseHeader.getActualAppID());
    localHashMap.put("service", paramResponseHeader.getSrvName());
    localHashMap.put("apiName", paramResponseHeader.getApiName());
    localHashMap.put("package", paramResponseHeader.getPkgName());
    localHashMap.put("statusCode", String.valueOf(paramResponseHeader.getStatusCode()));
    localHashMap.put("result", String.valueOf(paramResponseHeader.getErrorCode()));
    localHashMap.put("errorReason", paramResponseHeader.getErrorReason());
    localHashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
    localHashMap.put("baseVersion", "5.2.0.300");
    return localHashMap;
  }
  
  public static Map<String, String> getMapFromRequestHeader(ResponseHeader paramResponseHeader)
  {
    HashMap localHashMap = new HashMap();
    if (paramResponseHeader == null) {
      return localHashMap;
    }
    localHashMap.put("transId", paramResponseHeader.getTransactionId());
    localHashMap.put("appid", paramResponseHeader.getActualAppID());
    localHashMap.put("service", paramResponseHeader.getSrvName());
    Object localObject = paramResponseHeader.getApiName();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\.");
      if (localObject.length >= 2) {
        localHashMap.put("apiName", localObject[1]);
      }
    }
    localHashMap.put("package", paramResponseHeader.getPkgName());
    localHashMap.put("statusCode", String.valueOf(paramResponseHeader.getStatusCode()));
    localHashMap.put("result", String.valueOf(paramResponseHeader.getErrorCode()));
    localHashMap.put("errorReason", paramResponseHeader.getErrorReason());
    localHashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
    localHashMap.put("baseVersion", "5.2.0.300");
    return localHashMap;
  }
  
  public static String versionCodeToName(String paramString)
  {
    return HiAnalyticsUtils.versionCodeToName(paramString);
  }
  
  @Deprecated
  public Map<String, String> getMapForBi(Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    Object localObject2 = paramString.split("\\.");
    if (localObject2.length >= 2)
    {
      Object localObject1 = localObject2[0];
      localObject2 = localObject2[1];
      String str = Util.getAppId(paramContext);
      localHashMap.put("transId", TransactionIdCreater.getId(str, paramString));
      localHashMap.put("appid", str);
      localHashMap.put("service", localObject1);
      localHashMap.put("apiName", localObject2);
      localHashMap.put("package", paramContext.getPackageName());
      localHashMap.put("version", "5.2.0.300");
      localHashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
    }
    return localHashMap;
  }
  
  public Map<String, String> getMapFromForegroundRequestHeader(RequestHeader paramRequestHeader)
  {
    HashMap localHashMap = new HashMap();
    if (paramRequestHeader == null) {
      return localHashMap;
    }
    localHashMap.put("transId", paramRequestHeader.getTransactionId());
    localHashMap.put("appid", paramRequestHeader.getActualAppID());
    localHashMap.put("service", paramRequestHeader.getSrvName());
    localHashMap.put("apiName", paramRequestHeader.getApiName());
    localHashMap.put("package", paramRequestHeader.getPkgName());
    localHashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
    localHashMap.put("baseVersion", "5.2.0.300");
    return localHashMap;
  }
  
  public Map<String, String> getMapFromRequestHeader(RequestHeader paramRequestHeader)
  {
    HashMap localHashMap = new HashMap();
    if (paramRequestHeader == null) {
      return localHashMap;
    }
    localHashMap.put("transId", paramRequestHeader.getTransactionId());
    localHashMap.put("appid", paramRequestHeader.getActualAppID());
    localHashMap.put("service", paramRequestHeader.getSrvName());
    Object localObject = paramRequestHeader.getApiName();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\.");
      if (localObject.length >= 2) {
        localHashMap.put("apiName", localObject[1]);
      }
    }
    localHashMap.put("package", paramRequestHeader.getPkgName());
    localHashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
    localHashMap.put("baseVersion", "5.2.0.300");
    return localHashMap;
  }
  
  @Deprecated
  public boolean hasError()
  {
    if (!SystemUtils.isChinaROM())
    {
      HMSLog.i("HiAnalyticsUtil", "not ChinaROM ");
      return true;
    }
    return false;
  }
  
  public boolean hasError(Context paramContext)
  {
    return c.hasError(paramContext);
  }
  
  public void onBuoyEvent(Context paramContext, String paramString1, String paramString2)
  {
    c.onBuoyEvent(paramContext, paramString1, paramString2);
  }
  
  public void onEvent(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext != null) {
      onEvent2(paramContext, paramString1, a(paramContext, paramString2));
    }
  }
  
  public void onEvent(Context paramContext, String paramString, Map<String, String> paramMap)
  {
    c.onEvent(paramContext, paramString, paramMap);
  }
  
  public void onEvent2(Context paramContext, String paramString1, String paramString2)
  {
    c.onEvent2(paramContext, paramString1, paramString2);
  }
  
  public void onNewEvent(Context paramContext, String paramString, Map paramMap)
  {
    c.onNewEvent(paramContext, paramString, paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.support.hianalytics.HiAnalyticsUtil
 * JD-Core Version:    0.7.0.1
 */