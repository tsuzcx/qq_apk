package com.tencent.mobileqq.armap;

import android.os.SystemClock;
import aqfv;
import bhlo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class ARMapTracer
  implements ARGLSurfaceView.TraceCallback
{
  private static int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private aqfv jdField_a_of_type_Aqfv;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt;
  private int jdField_b_of_type_Int;
  private final int[] jdField_b_of_type_ArrayOfInt;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public static int a()
  {
    float f1;
    int i;
    float f2;
    if (jdField_a_of_type_Int == 0)
    {
      f1 = (float)bhlo.d() / 1.073742E+009F;
      i = bhlo.b();
      f2 = (float)bhlo.b() / 1000000.0F;
      if ((i < 4) || (f2 < 2.0F) || (f1 < 2.5F)) {
        break label106;
      }
      jdField_a_of_type_Int = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ARMapTracer", 2, String.format(Locale.getDefault(), "DEV_TYPE: %d, RAM: %f, CPU-NUM: %d, CPU-Freq: %f", new Object[] { Integer.valueOf(jdField_a_of_type_Int), Float.valueOf(f1), Integer.valueOf(i), Float.valueOf(f2) }));
      }
      return jdField_a_of_type_Int;
      label106:
      if ((i >= 4) && (f2 >= 1.5F) && (f1 >= 1.7F)) {
        jdField_a_of_type_Int = 2;
      } else {
        jdField_a_of_type_Int = 3;
      }
    }
  }
  
  public boolean a(int[] paramArrayOfInt)
  {
    boolean bool = true;
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length != 3) || (paramArrayOfInt[0] + paramArrayOfInt[1] + paramArrayOfInt[2] <= 0)) {
      bool = false;
    }
    float f1;
    do
    {
      float f2;
      do
      {
        do
        {
          return bool;
          f2 = paramArrayOfInt[0] + paramArrayOfInt[1] + paramArrayOfInt[2];
          f1 = (paramArrayOfInt[1] + paramArrayOfInt[2]) / f2;
          f2 = paramArrayOfInt[2] / f2;
          switch (this.d)
          {
          }
        } while (f1 >= 0.9F);
        return false;
      } while (f2 >= 0.9F);
      return false;
    } while (f1 >= 0.9F);
    return false;
  }
  
  public void endTrace()
  {
    if (this.jdField_a_of_type_Long == 0L) {}
    long l1;
    long l2;
    float f1;
    do
    {
      return;
      l1 = SystemClock.elapsedRealtime();
      l2 = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Long = 0L;
      f1 = this.jdField_a_of_type_ArrayOfInt[0] + this.jdField_a_of_type_ArrayOfInt[1] + this.jdField_a_of_type_ArrayOfInt[2];
    } while (f1 <= 0.0F);
    ARMapTracer.ReportRunnable localReportRunnable = new ARMapTracer.ReportRunnable(this.jdField_a_of_type_JavaLangString);
    localReportRunnable.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_ArrayOfInt);
    localReportRunnable.jdField_a_of_type_Float = (this.e / f1);
    localReportRunnable.b = (this.jdField_a_of_type_ArrayOfInt[0] / f1);
    localReportRunnable.c = (this.jdField_a_of_type_ArrayOfInt[1] / f1);
    localReportRunnable.d = (this.jdField_a_of_type_ArrayOfInt[2] / f1);
    localReportRunnable.jdField_a_of_type_Long = (l1 - l2);
    localReportRunnable.jdField_a_of_type_Int = this.c;
    if (QLog.isDevelopLevel()) {
      QLog.i("ARMapTracer", 4, String.format(Locale.getDefault(), "\r\n duration: %d, curLevel: %d, fps [average: %s, <18: %f, 18-25: %s, >=25: %s]", new Object[] { Integer.valueOf(localReportRunnable.jdField_a_of_type_Int), Integer.valueOf(localReportRunnable.jdField_a_of_type_Int), Float.valueOf(localReportRunnable.jdField_a_of_type_Float), Float.valueOf(localReportRunnable.b), Float.valueOf(localReportRunnable.c), Float.valueOf(localReportRunnable.d) }));
    }
    ThreadManager.post(localReportRunnable, 2, null, false);
  }
  
  public void startTrace()
  {
    if (this.jdField_a_of_type_Long != 0L) {}
    do
    {
      return;
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      this.e = 0;
      this.f = 0;
      this.jdField_b_of_type_Int = 0;
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        this.jdField_a_of_type_ArrayOfInt[i] = 0;
        this.jdField_b_of_type_ArrayOfInt[i] = 0;
        i += 1;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("ARMapTracer", 4, "startTrace");
  }
  
  public void trace(long paramLong)
  {
    if (this.jdField_a_of_type_Long == 0L) {
      if (this.jdField_a_of_type_Boolean) {
        startTrace();
      }
    }
    int i;
    int[] arrayOfInt1;
    do
    {
      return;
      this.e = ((int)(this.e + paramLong));
      this.f += 1;
      if (paramLong >= 18L) {
        break;
      }
      i = 0;
      arrayOfInt1 = this.jdField_a_of_type_ArrayOfInt;
      arrayOfInt1[i] += 1;
      arrayOfInt1 = this.jdField_b_of_type_ArrayOfInt;
      arrayOfInt1[i] += 1;
    } while ((this.f < 30) || (this.jdField_a_of_type_Aqfv == null));
    if (this.jdField_b_of_type_Int > 0) {
      this.jdField_b_of_type_Int -= 1;
    }
    boolean bool = a(this.jdField_b_of_type_ArrayOfInt);
    int j = this.c;
    if (this.jdField_b_of_type_Int > 0) {
      i = j;
    }
    for (;;)
    {
      if ((i != this.c) && (this.d > 2) && (this.jdField_a_of_type_Aqfv.a(i)))
      {
        this.c = i;
        this.jdField_b_of_type_Int = 3;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("ARMapTracer", 4, String.format(Locale.getDefault(), "isOk: %b, mLastRecommendFlag: %d, recommendLevel: %d, mCurLevel: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(i), Integer.valueOf(this.c) }));
      }
      this.f = 0;
      arrayOfInt1 = this.jdField_b_of_type_ArrayOfInt;
      int[] arrayOfInt2 = this.jdField_b_of_type_ArrayOfInt;
      this.jdField_b_of_type_ArrayOfInt[2] = 0;
      arrayOfInt2[1] = 0;
      arrayOfInt1[0] = 0;
      return;
      if (paramLong < 25L)
      {
        i = 1;
        break;
      }
      i = 2;
      break;
      i = j;
      if (!bool)
      {
        i = j;
        if (this.c > 8) {
          i = this.c - 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARMapTracer
 * JD-Core Version:    0.7.0.1
 */