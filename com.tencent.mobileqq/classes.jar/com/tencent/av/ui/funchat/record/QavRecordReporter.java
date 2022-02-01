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
  private static int a = 0;
  private static long b = 0L;
  private static int c = 0;
  private static long d = 0L;
  private static boolean e = false;
  private static int f;
  private static Throwable g;
  
  public static void a()
  {
    a = 0;
    b = System.currentTimeMillis();
    d = -1L;
    c = 0;
    e = false;
    f = 0;
    g = null;
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    long l1 = System.currentTimeMillis();
    long l2 = b;
    long l3 = d;
    int i = a;
    int j = c;
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
    e = true;
    f = paramInt;
    g = paramThrowable;
  }
  
  public static void a(String paramString)
  {
    ReportController.b(null, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static void b()
  {
    a += 1;
  }
  
  public static void c()
  {
    if (d < 0L) {
      d = System.currentTimeMillis();
    }
    c += 1;
  }
  
  public static void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavRecordReporter", 2, "reportEnd");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(f));
    localHashMap.put("device_model", DeviceInfoUtil.f());
    localHashMap.put("api", DeviceInfoUtil.g());
    localHashMap.put("manufacture", DeviceInfoUtil.t());
    localHashMap.put("throwable", String.valueOf(g));
    g = null;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportEnd params=");
      localStringBuilder.append(localHashMap);
      QLog.i("QavRecordReporter", 2, localStringBuilder.toString());
    }
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "av_record_report_end", e ^ true, 0L, 0L, localHashMap, "", false);
  }
  
  public static void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavRecordReporter", 2, "onAudioTrackInitFail");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("device_model", DeviceInfoUtil.f());
    localHashMap.put("api", DeviceInfoUtil.g());
    localHashMap.put("manufacture", DeviceInfoUtil.t());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAudioTrackInitFail  params=");
      localStringBuilder.append(localHashMap);
      QLog.i("QavRecordReporter", 2, localStringBuilder.toString());
    }
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "av_record_audio_fail", e ^ true, 0L, 0L, localHashMap, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.record.QavRecordReporter
 * JD-Core Version:    0.7.0.1
 */