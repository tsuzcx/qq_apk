package com.tencent.aelight.camera.aioeditor.poi;

import android.text.TextUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class LbsPackStatsCollector
{
  public static HashMap<String, Integer> a = new HashMap();
  public static HashMap<String, Integer> b;
  
  static
  {
    HashMap localHashMap = a;
    Integer localInteger1 = Integer.valueOf(100);
    localHashMap.put("actLbsSendPoiListFailure", localInteger1);
    a.put("actLbsSendGetPidFailure", localInteger1);
    a.put("actLbsPayBridgeFailure", localInteger1);
    localHashMap = a;
    Integer localInteger2 = Integer.valueOf(10000);
    localHashMap.put("actLbsPoiListFailure", localInteger2);
    a.put("actLbsPackListFailure", Integer.valueOf(1000));
    a.put("actLbsGetPackFailure", localInteger1);
    a.put("actLbsCaiShenResourceFailure", localInteger1);
    b = new HashMap();
    b.put("actLbsSendPoiListFailure", localInteger2);
    b.put("actLbsSendGetPidFailure", localInteger2);
    b.put("actLbsPayBridgeFailure", localInteger2);
    b.put("actLbsPoiListFailure", Integer.valueOf(100000));
    b.put("actLbsPackListFailure", localInteger2);
    b.put("actLbsGetPackFailure", localInteger2);
    b.put("actLbsCaiShenResourceFailure", localInteger2);
  }
  
  public static void a(String paramString, int paramInt)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      String str = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
      if ((!TextUtils.isEmpty(str)) && (a(paramString)))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("uploadFailure ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" ");
          localStringBuilder.append(paramInt);
          QLog.d("LbsPack", 2, localStringBuilder.toString());
        }
        StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(str, paramString, true, 0L, 0L, localHashMap, null);
        return;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static boolean a(String paramString)
  {
    paramString = (Integer)a.get(paramString);
    if (paramString == null) {
      return false;
    }
    double d1 = Math.random();
    double d2 = paramString.intValue();
    Double.isNaN(d2);
    return (int)(d1 * d2) == 1;
  }
  
  public static boolean b(String paramString)
  {
    paramString = (Integer)b.get(paramString);
    if (paramString == null) {
      return false;
    }
    double d1 = Math.random();
    double d2 = paramString.intValue();
    Double.isNaN(d2);
    return (int)(d1 * d2) == 1;
  }
  
  public static void c(String paramString)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      String str = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
      if ((!TextUtils.isEmpty(str)) && (b(paramString)))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("uploadSuccess ");
          localStringBuilder.append(paramString);
          QLog.d("LbsPack", 2, localStringBuilder.toString());
        }
        StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(str, paramString, false, 0L, 0L, localHashMap, null);
        return;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.poi.LbsPackStatsCollector
 * JD-Core Version:    0.7.0.1
 */