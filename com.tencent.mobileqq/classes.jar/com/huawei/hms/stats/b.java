package com.huawei.hms.stats;

import android.content.Context;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hms.utils.HMSBIInitializer;
import java.util.LinkedHashMap;

public class b
{
  public static HiAnalyticsInstance a;
  
  public static HiAnalyticsInstance a(Context paramContext)
  {
    a = HMSBIInitializer.getInstance(paramContext).getAnalyticsInstance();
    return a;
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if (a(paramContext) != null) {
      a.onReport(paramInt);
    }
  }
  
  public static void a(Context paramContext, int paramInt, String paramString, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    if (a(paramContext) != null) {
      a.onEvent(paramInt, paramString, paramLinkedHashMap);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (a(paramContext) != null) {
      a.onEvent(paramContext, paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.stats.b
 * JD-Core Version:    0.7.0.1
 */