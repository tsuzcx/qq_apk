package com.tencent.avgame.report;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class AVGameQualityCameraReportUtil
{
  public static String a = "actAVGameOpenCamera";
  public static String b = "param_Type";
  private static int c;
  private static long d;
  
  public static void a(int paramInt)
  {
    d = System.currentTimeMillis();
    c = paramInt;
  }
  
  public static void a(boolean paramBoolean)
  {
    if (d > 0L)
    {
      if (c <= 0) {
        return;
      }
      long l = System.currentTimeMillis() - d;
      Object localObject = new HashMap();
      ((HashMap)localObject).put(b, String.valueOf(c));
      StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance("", a, paramBoolean, l, 1L, (HashMap)localObject, "", true);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reportOpenCameraEnd duration:");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append(" success:");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append(" type:");
        ((StringBuilder)localObject).append(c);
        QLog.i("actAVGameOpenCamera", 1, ((StringBuilder)localObject).toString());
      }
      c = 0;
      d = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.report.AVGameQualityCameraReportUtil
 * JD-Core Version:    0.7.0.1
 */