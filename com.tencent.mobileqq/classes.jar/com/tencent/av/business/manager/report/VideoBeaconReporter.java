package com.tencent.av.business.manager.report;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class VideoBeaconReporter
{
  public static void a()
  {
    try
    {
      boolean bool = a("QuaVChatNewIntent", true, null);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("event_QuaVChatNewIntent, isSucceed[true],  ret[");
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.d("VideoBeaconReporter", 1, localStringBuilder.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoBeaconReporter", 2, "event_QuaVChatNewIntent:", localThrowable);
      }
    }
  }
  
  public static void a(int paramInt, long paramLong1, long paramLong2, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportQuaOnCloseVideo_onCloseVideo :reason[");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("], param0[");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append("], param1[");
    ((StringBuilder)localObject).append(paramLong2);
    ((StringBuilder)localObject).append("], param2[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("], ");
    QLog.d("VideoBeaconReporter", 1, ((StringBuilder)localObject).toString());
    boolean bool1 = false;
    for (;;)
    {
      int i;
      try
      {
        localObject = new HashMap();
        if (paramLong2 == 0L) {
          break label405;
        }
        i = (int)paramLong2 + 1000;
        if (paramString == null) {
          break label397;
        }
        try
        {
          paramLong2 = Long.parseLong(paramString);
          paramLong1 = paramLong2;
        }
        catch (Exception paramString)
        {
          paramInt = i;
          paramLong2 = paramLong1;
          if (QLog.isColorLevel())
          {
            QLog.d("VideoBeaconReporter", 2, "parseLong error:", paramString);
            paramInt = i;
            paramLong2 = paramLong1;
          }
        }
        paramString = new StringBuilder();
        paramString.append("");
        paramString.append(paramInt);
        ((HashMap)localObject).put("reason", paramString.toString());
        paramString = new StringBuilder();
        paramString.append("");
        paramString.append(paramLong2);
        ((HashMap)localObject).put("error_code", paramString.toString());
        if (paramInt != 1) {
          break label410;
        }
        if ((paramLong2 == 1L) || (paramLong2 == 2L)) {
          break label416;
        }
      }
      catch (Throwable paramString)
      {
        boolean bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("VideoBeaconReporter", 2, "event_QuaOnCloseVideo:", paramString);
        return;
      }
      bool2 = a("QuaOnCloseVideo", bool1, (HashMap)localObject);
      paramString = new StringBuilder();
      paramString.append("event_QuaOnCloseVideo, isSucceed[");
      paramString.append(bool1);
      paramString.append("], node_reason[");
      paramString.append((String)((HashMap)localObject).get("reason"));
      paramString.append("], node_error_code[");
      paramString.append((String)((HashMap)localObject).get("error_code"));
      paramString.append("],     ret[");
      paramString.append(bool2);
      paramString.append("]");
      QLog.d("VideoBeaconReporter", 1, paramString.toString());
      return;
      label397:
      paramInt = i;
      paramLong2 = paramLong1;
      continue;
      label405:
      paramLong2 = paramLong1;
      continue;
      label410:
      if (paramLong2 == 0L) {
        label416:
        bool1 = true;
      }
    }
  }
  
  public static void a(long paramLong)
  {
    boolean bool1 = false;
    for (;;)
    {
      long l;
      try
      {
        new HashMap();
        l = -1L;
        if (paramLong <= 0L) {
          break label120;
        }
        l = System.currentTimeMillis() - paramLong;
      }
      catch (Throwable localThrowable)
      {
        boolean bool2;
        StringBuilder localStringBuilder;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("VideoBeaconReporter", 2, "event_QuaInviteClose:", localThrowable);
        return;
      }
      bool2 = a("QuaInviteClose", bool1, null);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("event_QuaInviteClose, isSucceed[");
      localStringBuilder.append(bool1);
      localStringBuilder.append("],  ret[");
      localStringBuilder.append(bool2);
      localStringBuilder.append("]");
      QLog.d("VideoBeaconReporter", 1, localStringBuilder.toString());
      return;
      label120:
      if (l > 2000L) {
        bool1 = true;
      }
    }
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      if (paramBoolean1) {
        localHashMap.put("broadcast_created", "1");
      } else {
        localHashMap.put("broadcast_created", "0");
      }
      if (paramBoolean2)
      {
        localHashMap.put("vchat_created", "1");
        paramBoolean1 = true;
      }
      else
      {
        localHashMap.put("vchat_created", "0");
        paramBoolean1 = false;
      }
      paramBoolean2 = a("QuaProcessWakeUp", paramBoolean1, localHashMap);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("event_QuaProcessWakeUp, isSucceed[");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append("], node_broadcast_created[");
      localStringBuilder.append((String)localHashMap.get("broadcast_created"));
      localStringBuilder.append("], node_vchat_created[");
      localStringBuilder.append((String)localHashMap.get("vchat_created"));
      localStringBuilder.append("],     ret[");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append("]");
      QLog.d("VideoBeaconReporter", 1, localStringBuilder.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoBeaconReporter", 2, "event_QuaProcessWakeUp:", localThrowable);
      }
    }
  }
  
  private static boolean a(String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, paramString, paramBoolean, 0L, 0L, paramHashMap, null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.report.VideoBeaconReporter
 * JD-Core Version:    0.7.0.1
 */