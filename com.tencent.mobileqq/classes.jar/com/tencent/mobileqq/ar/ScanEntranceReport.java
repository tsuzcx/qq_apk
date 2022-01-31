package com.tencent.mobileqq.ar;

import aakg;
import aakh;
import aaki;
import aakj;
import aakk;
import aakl;
import aakm;
import aakn;
import aako;
import aakp;
import aakq;
import aakr;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ScanEntranceReport
{
  private static ScanEntranceReport jdField_a_of_type_ComTencentMobileqqArScanEntranceReport;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public static ScanEntranceReport a()
  {
    if (jdField_a_of_type_ComTencentMobileqqArScanEntranceReport == null) {
      jdField_a_of_type_ComTencentMobileqqArScanEntranceReport = new ScanEntranceReport();
    }
    return jdField_a_of_type_ComTencentMobileqqArScanEntranceReport;
  }
  
  private boolean a(long paramLong)
  {
    return (paramLong >= 0L) && (paramLong <= 600000L);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
  }
  
  public void a(int paramInt)
  {
    long l1 = 0L;
    if ((paramInt <= 0) || (paramInt > 60)) {
      return;
    }
    long l2 = DeviceInfoUtil.a(Process.myPid());
    if (l2 < 0L) {}
    for (;;)
    {
      String str = Build.MODEL;
      int i = (int)(l1 / 1024L / 1024L);
      if ((i <= 0) || (i > 500)) {
        break;
      }
      QLog.d("ScanEntranceReport", 2, String.format("reportAverageFPS deviceName=%s fps=%s memorySize=%s", new Object[] { str, Integer.valueOf(paramInt), Integer.valueOf(i) }));
      ThreadManager.post(new aakh(this, str, i, paramInt), 5, null, false);
      return;
      l1 = l2;
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    if ((paramInt <= 0) || (paramInt > 100) || (paramLong <= 0L)) {}
    while (!a(paramLong)) {
      return;
    }
    QLog.d("ScanEntranceReport", 2, String.format("reportARCloudUploadCount uploadCount=%s selectImageAvgTime=%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
    ThreadManager.post(new aakp(this, paramLong, paramInt), 5, null, false);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (paramLong <= 0L) {}
    do
    {
      return;
      paramLong = System.currentTimeMillis() - paramLong;
    } while (!a(paramLong));
    QLog.d("ScanEntranceReport", 2, String.format("reportARCloudFirstSuccess totalTime=%s", new Object[] { Long.valueOf(paramLong) }));
    ThreadManager.post(new aako(this, paramInt, paramLong), 5, null, false);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if ((paramLong <= 0L) || (paramInt1 < 0) || (paramInt1 > 100) || (paramInt2 < 0) || (paramInt2 > 100)) {}
    do
    {
      return;
      paramLong = System.currentTimeMillis() - paramLong;
    } while (!a(paramLong));
    QLog.d("ScanEntranceReport", 2, String.format("reportQRSuccess totalTime=%s uploadCount=%s zoomCount=%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    ThreadManager.post(new aakq(this, paramInt1, paramInt2, paramLong), 5, null, false);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt, String paramString)
  {
    if ((paramLong1 <= 0L) || (paramLong2 <= 0L) || (paramInt <= 0) || (paramInt > 100) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      long l = System.currentTimeMillis();
      paramLong1 = l - paramLong1;
      paramLong2 = l - paramLong2;
    } while ((!a(paramLong1)) || (!a(paramLong2)));
    QLog.d("ScanEntranceReport", 2, String.format("reportFirstOCRTips totalTime=%s lastTotalTime=%s uploadCount=%s sessionIds=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt), paramString }));
    ThreadManager.post(new aaki(this, paramLong2, paramInt, paramString, paramLong1), 5, null, false);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    if ((paramLong1 <= 0L) || (paramLong2 <= 0L) || (paramLong3 <= 0L)) {
      return;
    }
    long l = System.currentTimeMillis();
    if ((!this.jdField_a_of_type_Boolean) || (this.b)) {}
    for (boolean bool = true;; bool = false)
    {
      paramLong1 = paramLong2 - paramLong1;
      paramLong2 = paramLong3 - paramLong2;
      paramLong3 = l - paramLong3;
      l = paramLong1 + paramLong2 + paramLong3;
      if ((!a(paramLong1)) || (!a(paramLong2)) || (!a(paramLong3)) || (!a(l))) {
        break;
      }
      QLog.d("ScanEntranceReport", 2, String.format("reportARCloudFirstUpload firstInit=%s startDelay=%s firstSelectTime=%s firstUploadDelay=%s totalTime=%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(l) }));
      ThreadManager.post(new aakm(this, bool, paramLong1, paramLong2, paramLong3, paramInt, l), 5, null, false);
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    if ((paramLong1 <= 0L) || (paramLong2 <= 0L) || (paramLong3 <= 0L) || (paramLong4 <= 0L) || (paramLong5 <= 0L)) {
      return;
    }
    if ((!this.jdField_a_of_type_Boolean) || (this.b)) {}
    for (boolean bool = true;; bool = false)
    {
      long l = paramLong2 - paramLong1;
      paramLong2 = paramLong3 - paramLong2;
      paramLong3 = paramLong4 - paramLong3;
      paramLong4 = paramLong5 - paramLong4;
      paramLong1 = paramLong5 - paramLong1;
      if ((!a(l)) || (!a(paramLong2)) || (!a(paramLong3)) || (!a(paramLong4))) {
        break;
      }
      QLog.d("ScanEntranceReport", 2, String.format("reportARInitPreTime bindTime=%s gotConfigTime=%s resourceCheckTime=%s dependenceWaitTime=%s totalTime=%s", new Object[] { Long.valueOf(l), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong1) }));
      ThreadManager.post(new aakl(this, bool, l, paramLong2, paramLong3, paramLong4, paramLong1), 5, null, false);
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if ((paramLong1 <= 0L) || (paramLong2 <= 0L)) {
      return;
    }
    long l = System.currentTimeMillis();
    if ((!this.jdField_a_of_type_Boolean) || (this.b)) {}
    for (boolean bool = true;; bool = false)
    {
      paramLong1 = Math.max(0L, paramLong2 - paramLong1);
      paramLong2 = l - paramLong2;
      l = paramLong1 + paramLong2;
      if ((!a(paramLong1)) || (!a(paramLong2)) || (!a(l))) {
        break;
      }
      QLog.d("ScanEntranceReport", 2, String.format("reportARInitTime firstInit=%s initDelay=%s initTime=%s totalTime=%s downloadResource=%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(l), Boolean.valueOf(paramBoolean) }));
      ThreadManager.post(new aakk(this, bool, paramLong1, paramLong2, paramBoolean, l), 5, null, false);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("ScanEntranceReport", 2, String.format("reportQBarSoLoadFail systemLoadSuccess=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    HashMap localHashMap = new HashMap();
    StatisticCollector.a(BaseApplication.getContext()).a("", "scanner_qbar_so_load_fail", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    if (paramLong <= 0L) {}
    do
    {
      return;
      paramLong = System.currentTimeMillis() - paramLong;
    } while (!a(paramLong));
    QLog.d("ScanEntranceReport", 2, String.format("reportARCloudFirstResult success=%s totalTime=%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong) }));
    ThreadManager.post(new aakn(this, paramBoolean, paramLong), 5, null, false);
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString)
  {
    if ((paramLong1 <= 0L) || (paramLong2 <= 0L)) {}
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
      paramLong1 = paramLong2 - paramLong1;
      paramLong2 = l - paramLong2;
      l = paramLong1 + paramLong2;
    } while ((!a(paramLong1)) || (!a(paramLong2)) || (!a(l)));
    this.jdField_a_of_type_Boolean = paramBoolean;
    if ((paramBoolean) && (paramLong1 > 500L)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.b = paramBoolean;
      QLog.d("ScanEntranceReport", 2, String.format("reportActivityLaunchTime procExist=%s procRestart=%s procLoadTimeCost=%s activityLaunchTimeCost=%s totalTimeCost=%s source=%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.b), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(l), paramString }));
      ThreadManager.post(new aakg(this, paramLong1, paramLong2, paramString, l), 5, null, false);
      return;
    }
  }
  
  public void b()
  {
    QLog.d("ScanEntranceReport", 2, "reportZoomCamera");
    ThreadManager.post(new aakr(this), 5, null, false);
  }
  
  public void b(long paramLong1, long paramLong2, int paramInt, String paramString)
  {
    if ((paramLong1 <= 0L) || (paramLong2 <= 0L) || (paramInt <= 0) || (paramInt > 100) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      long l = System.currentTimeMillis();
      paramLong1 = l - paramLong1;
      paramLong2 = l - paramLong2;
    } while ((!a(paramLong1)) || (!a(paramLong2)));
    QLog.d("ScanEntranceReport", 2, String.format("reportFirstARRecog totalTime=%s lastTotalTime=%s uploadCount=%s sessionIds=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt), paramString }));
    ThreadManager.post(new aakj(this, paramLong2, paramInt, paramString, paramLong1), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanEntranceReport
 * JD-Core Version:    0.7.0.1
 */