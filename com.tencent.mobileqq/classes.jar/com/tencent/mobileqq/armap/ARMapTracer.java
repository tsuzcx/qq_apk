package com.tencent.mobileqq.armap;

import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class ARMapTracer
  implements ARGLSurfaceView.TraceCallback
{
  private static int a;
  private String b;
  private boolean c;
  private ARMapTracer.TraceResultListener d;
  private int e;
  private int f;
  private long g;
  private int h;
  private int i;
  private int j;
  private final int[] k;
  private final int[] l;
  
  public static int a()
  {
    if (a == 0)
    {
      float f1 = (float)DeviceInfoUtil.a() / 1.073742E+009F;
      int m = DeviceInfoUtil.h();
      float f2 = (float)DeviceInfoUtil.l() / 1000000.0F;
      if ((m >= 4) && (f2 >= 2.0F) && (f1 >= 2.5F)) {
        a = 1;
      } else if ((m >= 4) && (f2 >= 1.5F) && (f1 >= 1.7F)) {
        a = 2;
      } else {
        a = 3;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ARMapTracer", 2, String.format(Locale.getDefault(), "DEV_TYPE: %d, RAM: %f, CPU-NUM: %d, CPU-Freq: %f", new Object[] { Integer.valueOf(a), Float.valueOf(f1), Integer.valueOf(m), Float.valueOf(f2) }));
      }
    }
    return a;
  }
  
  public boolean a(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length == 3))
    {
      if (paramArrayOfInt[0] + paramArrayOfInt[1] + paramArrayOfInt[2] <= 0) {
        return false;
      }
      float f2 = paramArrayOfInt[0] + paramArrayOfInt[1] + paramArrayOfInt[2];
      float f1 = (paramArrayOfInt[1] + paramArrayOfInt[2]) / f2;
      f2 = paramArrayOfInt[2] / f2;
      int m = this.h;
      if ((m != 1) && (m != 2)) {
        if (m != 3) {
          if (f1 < 0.9F) {
            break label110;
          }
        }
      }
      while (f2 >= 0.9F) {
        for (;;)
        {
          return true;
          if (f1 < 0.9F) {
            break;
          }
        }
      }
    }
    label110:
    return false;
  }
  
  public void endTrace()
  {
    if (this.g == 0L) {
      return;
    }
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.g;
    this.g = 0L;
    Object localObject = this.k;
    float f1 = localObject[0] + localObject[1] + localObject[2];
    if (f1 > 0.0F)
    {
      localObject = new ARMapTracer.ReportRunnable(this.b);
      ((ARMapTracer.ReportRunnable)localObject).b = a(this.k);
      ((ARMapTracer.ReportRunnable)localObject).c = (this.i / f1);
      int[] arrayOfInt = this.k;
      ((ARMapTracer.ReportRunnable)localObject).d = (arrayOfInt[0] / f1);
      ((ARMapTracer.ReportRunnable)localObject).e = (arrayOfInt[1] / f1);
      ((ARMapTracer.ReportRunnable)localObject).f = (arrayOfInt[2] / f1);
      ((ARMapTracer.ReportRunnable)localObject).g = (l1 - l2);
      ((ARMapTracer.ReportRunnable)localObject).h = this.f;
      if (QLog.isDevelopLevel()) {
        QLog.i("ARMapTracer", 4, String.format(Locale.getDefault(), "\r\n duration: %d, curLevel: %d, fps [average: %s, <18: %f, 18-25: %s, >=25: %s]", new Object[] { Integer.valueOf(((ARMapTracer.ReportRunnable)localObject).h), Integer.valueOf(((ARMapTracer.ReportRunnable)localObject).h), Float.valueOf(((ARMapTracer.ReportRunnable)localObject).c), Float.valueOf(((ARMapTracer.ReportRunnable)localObject).d), Float.valueOf(((ARMapTracer.ReportRunnable)localObject).e), Float.valueOf(((ARMapTracer.ReportRunnable)localObject).f) }));
      }
      ThreadManager.post((Runnable)localObject, 2, null, false);
    }
  }
  
  public void startTrace()
  {
    if (this.g != 0L) {
      return;
    }
    this.g = SystemClock.elapsedRealtime();
    this.i = 0;
    this.j = 0;
    this.e = 0;
    int m = 0;
    for (;;)
    {
      int[] arrayOfInt = this.k;
      if (m >= arrayOfInt.length) {
        break;
      }
      arrayOfInt[m] = 0;
      this.l[m] = 0;
      m += 1;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("ARMapTracer", 4, "startTrace");
    }
  }
  
  public void trace(long paramLong)
  {
    if (this.g == 0L)
    {
      if (this.c) {
        startTrace();
      }
      return;
    }
    this.i = ((int)(this.i + paramLong));
    this.j += 1;
    int m;
    if (paramLong < 18L) {
      m = 0;
    } else if (paramLong < 25L) {
      m = 1;
    } else {
      m = 2;
    }
    int[] arrayOfInt = this.k;
    arrayOfInt[m] += 1;
    arrayOfInt = this.l;
    arrayOfInt[m] += 1;
    if ((this.j >= 30) && (this.d != null))
    {
      m = this.e;
      if (m > 0) {
        this.e = (m - 1);
      }
      boolean bool = a(this.l);
      int n = this.f;
      if (this.e > 0)
      {
        m = n;
      }
      else
      {
        m = n;
        if (!bool)
        {
          m = n;
          if (n > 8) {
            m = n - 1;
          }
        }
      }
      if ((m != this.f) && (this.h > 2) && (this.d.a(m)))
      {
        this.f = m;
        this.e = 3;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("ARMapTracer", 4, String.format(Locale.getDefault(), "isOk: %b, mLastRecommendFlag: %d, recommendLevel: %d, mCurLevel: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.e), Integer.valueOf(m), Integer.valueOf(this.f) }));
      }
      this.j = 0;
      arrayOfInt = this.l;
      arrayOfInt[2] = 0;
      arrayOfInt[1] = 0;
      arrayOfInt[0] = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARMapTracer
 * JD-Core Version:    0.7.0.1
 */