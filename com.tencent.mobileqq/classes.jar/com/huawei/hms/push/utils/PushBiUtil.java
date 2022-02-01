package com.huawei.hms.push.utils;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;

public final class PushBiUtil
{
  public static String reportEntry(Context paramContext, String paramString)
  {
    return HiAnalyticsClient.reportEntry(paramContext, paramString, 50101300);
  }
  
  public static void reportExit(Context paramContext, String paramString, ResponseErrorCode paramResponseErrorCode)
  {
    HiAnalyticsClient.reportExit(paramContext, paramString, paramResponseErrorCode.getTransactionId(), paramResponseErrorCode.getStatusCode(), paramResponseErrorCode.getErrorCode(), 50101300);
  }
  
  public static void reportExit(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    HiAnalyticsClient.reportExit(paramContext, paramString1, paramString2, Status.SUCCESS.getStatusCode(), paramInt, 50101300);
  }
  
  public static void reportExit(Context paramContext, String paramString1, String paramString2, ErrorEnum paramErrorEnum)
  {
    HiAnalyticsClient.reportExit(paramContext, paramString1, paramString2, Status.SUCCESS.getStatusCode(), paramErrorEnum.getExternalCode(), 50101300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.utils.PushBiUtil
 * JD-Core Version:    0.7.0.1
 */