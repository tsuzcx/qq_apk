package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;

public class HmsHiAnalyticsUtils
{
  public static void enableLog() {}
  
  public static boolean getInitFlag()
  {
    return j1.b();
  }
  
  public static void init(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2)
  {
    new k1(paramContext).a(paramBoolean1).c(paramBoolean2).b(paramBoolean3).a(0, paramString1).a(1, paramString1).a(paramString2).a();
  }
  
  public static void onEvent(int paramInt, String paramString, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    j1.a(paramInt, paramString, paramLinkedHashMap);
  }
  
  public static void onEvent(Context paramContext, String paramString1, String paramString2)
  {
    j1.a(paramContext, paramString1, paramString2);
  }
  
  public static void onReport() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.hatool.HmsHiAnalyticsUtils
 * JD-Core Version:    0.7.0.1
 */