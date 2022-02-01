package com.tencent.avgame.report;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class AVGameQualityCameraReportUtil
{
  private static int jdField_a_of_type_Int = 0;
  private static long jdField_a_of_type_Long = 0L;
  public static String a = "actAVGameOpenCamera";
  public static String b = "param_Type";
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_Long = System.currentTimeMillis();
    jdField_a_of_type_Int = paramInt;
  }
  
  public static void a(boolean paramBoolean)
  {
    if (jdField_a_of_type_Long > 0L)
    {
      if (jdField_a_of_type_Int <= 0) {
        return;
      }
      long l = System.currentTimeMillis() - jdField_a_of_type_Long;
      Object localObject = new HashMap();
      ((HashMap)localObject).put(b, String.valueOf(jdField_a_of_type_Int));
      StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance("", jdField_a_of_type_JavaLangString, paramBoolean, l, 1L, (HashMap)localObject, "", true);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reportOpenCameraEnd duration:");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append(" success:");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append(" type:");
        ((StringBuilder)localObject).append(jdField_a_of_type_Int);
        QLog.i("actAVGameOpenCamera", 1, ((StringBuilder)localObject).toString());
      }
      jdField_a_of_type_Int = 0;
      jdField_a_of_type_Long = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.report.AVGameQualityCameraReportUtil
 * JD-Core Version:    0.7.0.1
 */