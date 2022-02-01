package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.utils.Util;
import java.util.Map;

public class b
  extends a
{
  public static void a(Context paramContext, ResponseHeader paramResponseHeader, String paramString)
  {
    HiAnalyticsUtil.getInstance();
    paramResponseHeader = HiAnalyticsUtil.getMapFromRequestHeader(paramResponseHeader);
    paramResponseHeader.put("direction", "rsp");
    if (!TextUtils.isEmpty(paramString)) {
      paramResponseHeader.put("version", HiAnalyticsUtil.versionCodeToName(paramString));
    }
    paramResponseHeader.put("phoneType", Util.getSystemProperties("ro.logsystem.usertype", ""));
    HiAnalyticsUtil.getInstance().onNewEvent(paramContext, "HMS_SDK_BASE_API_CALLED", paramResponseHeader);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Map localMap = a.getMapForBi(paramContext, paramString1);
    localMap.put("appid", paramString2);
    String str = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      str = TransactionIdCreater.getId(paramString2, paramString1);
    }
    localMap.put("transId", str);
    localMap.put("direction", "req");
    if (!TextUtils.isEmpty(paramString4)) {
      localMap.put("version", HiAnalyticsUtil.versionCodeToName(paramString4));
    }
    localMap.put("phoneType", Util.getSystemProperties("ro.logsystem.usertype", ""));
    HiAnalyticsUtil.getInstance().onNewEvent(paramContext, "HMS_SDK_BASE_API_CALLED", localMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.support.hianalytics.b
 * JD-Core Version:    0.7.0.1
 */