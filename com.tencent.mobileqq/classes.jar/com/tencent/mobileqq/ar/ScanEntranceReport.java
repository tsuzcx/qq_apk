package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ScanEntranceReport
{
  private static ScanEntranceReport a;
  private boolean b;
  private boolean c;
  
  public static ScanEntranceReport a()
  {
    if (a == null) {
      a = new ScanEntranceReport();
    }
    return a;
  }
  
  private boolean a(long paramLong)
  {
    return (paramLong >= 0L) && (paramLong <= 600000L);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (paramLong <= 0L) {
      return;
    }
    paramLong = System.currentTimeMillis() - paramLong;
    if (!a(paramLong)) {
      return;
    }
    QLog.d("ScanEntranceReport", 2, String.format("reportARCloudFirstSuccess totalTime=%s", new Object[] { Long.valueOf(paramLong) }));
    ThreadManager.post(new ScanEntranceReport.6(this, paramInt, paramLong), 5, null, false);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    if ((paramLong1 > 0L) && (paramLong2 > 0L))
    {
      if (paramLong3 <= 0L) {
        return;
      }
      long l = System.currentTimeMillis();
      boolean bool;
      if ((this.b) && (!this.c)) {
        bool = false;
      } else {
        bool = true;
      }
      paramLong1 = paramLong2 - paramLong1;
      paramLong2 = paramLong3 - paramLong2;
      paramLong3 = l - paramLong3;
      l = paramLong1 + paramLong2 + paramLong3;
      if ((a(paramLong1)) && (a(paramLong2)) && (a(paramLong3)))
      {
        if (!a(l)) {
          return;
        }
        QLog.d("ScanEntranceReport", 2, String.format("reportARCloudFirstUpload firstInit=%s startDelay=%s firstSelectTime=%s firstUploadDelay=%s totalTime=%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(l) }));
        ThreadManager.post(new ScanEntranceReport.4(this, bool, paramLong1, paramLong2, paramLong3, paramInt, l), 5, null, false);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("ScanEntranceReport", 2, String.format("reportQBarSoLoadFail systemLoadSuccess=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    HashMap localHashMap = new HashMap();
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "scanner_qbar_so_load_fail", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    if (paramLong <= 0L) {
      return;
    }
    paramLong = System.currentTimeMillis() - paramLong;
    if (!a(paramLong)) {
      return;
    }
    QLog.d("ScanEntranceReport", 2, String.format("reportARCloudFirstResult success=%s totalTime=%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong) }));
    ThreadManager.post(new ScanEntranceReport.5(this, paramBoolean, paramLong), 5, null, false);
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString)
  {
    if (paramLong1 > 0L)
    {
      if (paramLong2 <= 0L) {
        return;
      }
      long l = System.currentTimeMillis();
      paramLong1 = paramLong2 - paramLong1;
      paramLong2 = l - paramLong2;
      l = paramLong1 + paramLong2;
      if ((a(paramLong1)) && (a(paramLong2)))
      {
        if (!a(l)) {
          return;
        }
        this.b = paramBoolean;
        if ((paramBoolean) && (paramLong1 > 500L)) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        this.c = paramBoolean;
        QLog.d("ScanEntranceReport", 2, String.format("reportActivityLaunchTime procExist=%s procRestart=%s procLoadTimeCost=%s activityLaunchTimeCost=%s totalTimeCost=%s source=%s", new Object[] { Boolean.valueOf(this.b), Boolean.valueOf(this.c), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(l), paramString }));
        ThreadManager.post(new ScanEntranceReport.1(this, paramLong1, paramLong2, paramString, l), 5, null, false);
      }
    }
  }
  
  public void b()
  {
    this.b = false;
    this.c = false;
  }
  
  public void c()
  {
    QLog.d("ScanEntranceReport", 2, "reportZoomCamera");
    ThreadManager.post(new ScanEntranceReport.9(this), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanEntranceReport
 * JD-Core Version:    0.7.0.1
 */