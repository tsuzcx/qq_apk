package com.tencent.mobileqq.ar.config;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class WorldCupReport
{
  public static void a()
  {
    a("0X800930B", 0);
  }
  
  public static void a(int paramInt)
  {
    a("0X8009309", paramInt);
  }
  
  public static void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong)
  {
    int i;
    String str1;
    if (paramBoolean1)
    {
      i = 1;
      if (!paramBoolean2) {
        break label145;
      }
      str1 = "1";
      label15:
      if (!paramBoolean3) {
        break label152;
      }
    }
    label145:
    label152:
    for (String str2 = "1";; str2 = "2")
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("WorldCupReport", 1, "onDwonloadResult, key[" + "0X800931A" + "], index[" + paramInt + "], nSuc[" + i + "], strPreConver[" + str1 + "], strAuto[" + str2 + "], cost[" + paramLong + "]");
      }
      ReportController.b(null, "dc00898", "", "", "0X800931A", "0X800931A", paramInt, i, str1, str2, String.valueOf(paramLong), AppSetting.b);
      return;
      i = 0;
      break;
      str1 = "2";
      break label15;
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("WorldCupReport", 1, "reportClickEvent, key[" + paramString + "], fromType[" + paramInt + "]");
    }
    ReportController.b(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  public static void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      a("0X8009311", paramInt);
      return;
    }
    a("0X8009312", paramInt);
  }
  
  public static void b()
  {
    a("0X800930C", 0);
  }
  
  static void c()
  {
    a("0X800930D", 0);
  }
  
  public static void d()
  {
    a("0X800930E", 0);
  }
  
  public static void e()
  {
    a("0X800930F", 0);
  }
  
  public static void f()
  {
    a("0X8009310", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.config.WorldCupReport
 * JD-Core Version:    0.7.0.1
 */