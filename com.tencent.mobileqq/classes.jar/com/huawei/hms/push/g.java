package com.huawei.hms.push;

import android.content.Context;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;

public final class g
{
  public static String a(Context paramContext, String paramString)
  {
    return HiAnalyticsClient.reportEntry(paramContext, paramString, 50002300);
  }
  
  public static void a(Context paramContext, String paramString, ResponseErrorCode paramResponseErrorCode)
  {
    HiAnalyticsClient.reportExit(paramContext, paramString, paramResponseErrorCode.getTransactionId(), paramResponseErrorCode.getStatusCode(), paramResponseErrorCode.getErrorCode(), 50002300);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    HiAnalyticsClient.reportExit(paramContext, paramString1, paramString2, Status.SUCCESS.getStatusCode(), paramInt, 50002300);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, a parama)
  {
    HiAnalyticsClient.reportExit(paramContext, paramString1, paramString2, Status.SUCCESS.getStatusCode(), parama.b(), 50002300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.g
 * JD-Core Version:    0.7.0.1
 */