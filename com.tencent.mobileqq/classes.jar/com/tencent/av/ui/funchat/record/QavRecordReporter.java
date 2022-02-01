package com.tencent.av.ui.funchat.record;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class QavRecordReporter
{
  private static int jdField_a_of_type_Int = 0;
  private static long jdField_a_of_type_Long = 0L;
  private static Throwable jdField_a_of_type_JavaLangThrowable;
  private static boolean jdField_a_of_type_Boolean = false;
  private static int jdField_b_of_type_Int;
  private static long jdField_b_of_type_Long;
  private static int c;
  
  public static void a()
  {
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_Long = System.currentTimeMillis();
    jdField_b_of_type_Long = -1L;
    jdField_b_of_type_Int = 0;
    jdField_a_of_type_Boolean = false;
    c = 0;
    jdField_a_of_type_JavaLangThrowable = null;
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    long l1 = System.currentTimeMillis();
    long l2 = jdField_a_of_type_Long;
    long l3 = jdField_b_of_type_Long;
    int i = jdField_a_of_type_Int;
    int j = jdField_b_of_type_Int;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecordEnd cores=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", fqc=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", start=");
      localStringBuilder.append(l2);
      localStringBuilder.append(", end=");
      localStringBuilder.append(l1);
      localStringBuilder.append(", frames=");
      localStringBuilder.append(i);
      localStringBuilder.append(", stopType=");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(", mp4Start=");
      localStringBuilder.append(l3);
      localStringBuilder.append(", mp4Frames=");
      localStringBuilder.append(j);
      QLog.i("QavRecordReporter", 2, localStringBuilder.toString());
    }
    ThreadManager.post(new QavRecordReporter.1(paramInt2, i, l1, l2, j, l3, paramLong, paramInt1, paramInt3), 5, null, false);
  }
  
  public static void a(int paramInt, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onError ");
      localStringBuilder.append(paramInt);
      QLog.i("QavRecordReporter", 2, localStringBuilder.toString());
    }
    jdField_a_of_type_Boolean = true;
    c = paramInt;
    jdField_a_of_type_JavaLangThrowable = paramThrowable;
  }
  
  public static void a(String paramString)
  {
    ReportController.b(null, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static void b()
  {
    jdField_a_of_type_Int += 1;
  }
  
  public static void c()
  {
    if (jdField_b_of_type_Long < 0L) {
      jdField_b_of_type_Long = System.currentTimeMillis();
    }
    jdField_b_of_type_Int += 1;
  }
  
  public static void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavRecordReporter", 2, "reportEnd");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(c));
    localHashMap.put("device_model", DeviceInfoUtil.d());
    localHashMap.put("api", DeviceInfoUtil.e());
    localHashMap.put("manufacture", DeviceInfoUtil.h());
    localHashMap.put("throwable", String.valueOf(jdField_a_of_type_JavaLangThrowable));
    jdField_a_of_type_JavaLangThrowable = null;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportEnd params=");
      localStringBuilder.append(localHashMap);
      QLog.i("QavRecordReporter", 2, localStringBuilder.toString());
    }
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "av_record_report_end", jdField_a_of_type_Boolean ^ true, 0L, 0L, localHashMap, "", false);
  }
  
  public static void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavRecordReporter", 2, "onAudioTrackInitFail");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("device_model", DeviceInfoUtil.d());
    localHashMap.put("api", DeviceInfoUtil.e());
    localHashMap.put("manufacture", DeviceInfoUtil.h());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAudioTrackInitFail  params=");
      localStringBuilder.append(localHashMap);
      QLog.i("QavRecordReporter", 2, localStringBuilder.toString());
    }
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "av_record_audio_fail", jdField_a_of_type_Boolean ^ true, 0L, 0L, localHashMap, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.record.QavRecordReporter
 * JD-Core Version:    0.7.0.1
 */