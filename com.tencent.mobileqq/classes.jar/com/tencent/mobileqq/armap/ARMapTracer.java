package com.tencent.mobileqq.armap;

import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class ARMapTracer
  implements ARGLSurfaceView.TraceCallback
{
  private static int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ARMapTracer.TraceResultListener jdField_a_of_type_ComTencentMobileqqArmapARMapTracer$TraceResultListener;
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
    if (jdField_a_of_type_Int == 0)
    {
      float f1 = (float)DeviceInfoUtil.a() / 1.073742E+009F;
      int i = DeviceInfoUtil.b();
      float f2 = (float)DeviceInfoUtil.c() / 1000000.0F;
      if ((i >= 4) && (f2 >= 2.0F) && (f1 >= 2.5F)) {
        jdField_a_of_type_Int = 1;
      } else if ((i >= 4) && (f2 >= 1.5F) && (f1 >= 1.7F)) {
        jdField_a_of_type_Int = 2;
      } else {
        jdField_a_of_type_Int = 3;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ARMapTracer", 2, String.format(Locale.getDefault(), "DEV_TYPE: %d, RAM: %f, CPU-NUM: %d, CPU-Freq: %f", new Object[] { Integer.valueOf(jdField_a_of_type_Int), Float.valueOf(f1), Integer.valueOf(i), Float.valueOf(f2) }));
      }
    }
    return jdField_a_of_type_Int;
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
      int i = this.d;
      if ((i != 1) && (i != 2)) {
        if (i != 3) {
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
    if (this.jdField_a_of_type_Long == 0L) {
      return;
    }
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_Long = 0L;
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    float f1 = localObject[0] + localObject[1] + localObject[2];
    if (f1 > 0.0F)
    {
      localObject = new ARMapTracer.ReportRunnable(this.jdField_a_of_type_JavaLangString);
      ((ARMapTracer.ReportRunnable)localObject).jdField_a_of_type_Boolean = a(this.jdField_a_of_type_ArrayOfInt);
      ((ARMapTracer.ReportRunnable)localObject).jdField_a_of_type_Float = (this.e / f1);
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      ((ARMapTracer.ReportRunnable)localObject).b = (arrayOfInt[0] / f1);
      ((ARMapTracer.ReportRunnable)localObject).c = (arrayOfInt[1] / f1);
      ((ARMapTracer.ReportRunnable)localObject).d = (arrayOfInt[2] / f1);
      ((ARMapTracer.ReportRunnable)localObject).jdField_a_of_type_Long = (l1 - l2);
      ((ARMapTracer.ReportRunnable)localObject).jdField_a_of_type_Int = this.c;
      if (QLog.isDevelopLevel()) {
        QLog.i("ARMapTracer", 4, String.format(Locale.getDefault(), "\r\n duration: %d, curLevel: %d, fps [average: %s, <18: %f, 18-25: %s, >=25: %s]", new Object[] { Integer.valueOf(((ARMapTracer.ReportRunnable)localObject).jdField_a_of_type_Int), Integer.valueOf(((ARMapTracer.ReportRunnable)localObject).jdField_a_of_type_Int), Float.valueOf(((ARMapTracer.ReportRunnable)localObject).jdField_a_of_type_Float), Float.valueOf(((ARMapTracer.ReportRunnable)localObject).b), Float.valueOf(((ARMapTracer.ReportRunnable)localObject).c), Float.valueOf(((ARMapTracer.ReportRunnable)localObject).d) }));
      }
      ThreadManager.post((Runnable)localObject, 2, null, false);
    }
  }
  
  public void startTrace()
  {
    if (this.jdField_a_of_type_Long != 0L) {
      return;
    }
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    this.e = 0;
    this.f = 0;
    this.jdField_b_of_type_Int = 0;
    int i = 0;
    for (;;)
    {
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      if (i >= arrayOfInt.length) {
        break;
      }
      arrayOfInt[i] = 0;
      this.jdField_b_of_type_ArrayOfInt[i] = 0;
      i += 1;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("ARMapTracer", 4, "startTrace");
    }
  }
  
  public void trace(long paramLong)
  {
    if (this.jdField_a_of_type_Long == 0L)
    {
      if (this.jdField_a_of_type_Boolean) {
        startTrace();
      }
      return;
    }
    this.e = ((int)(this.e + paramLong));
    this.f += 1;
    int i;
    if (paramLong < 18L) {
      i = 0;
    } else if (paramLong < 25L) {
      i = 1;
    } else {
      i = 2;
    }
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    arrayOfInt[i] += 1;
    arrayOfInt = this.jdField_b_of_type_ArrayOfInt;
    arrayOfInt[i] += 1;
    if ((this.f >= 30) && (this.jdField_a_of_type_ComTencentMobileqqArmapARMapTracer$TraceResultListener != null))
    {
      i = this.jdField_b_of_type_Int;
      if (i > 0) {
        this.jdField_b_of_type_Int = (i - 1);
      }
      boolean bool = a(this.jdField_b_of_type_ArrayOfInt);
      int j = this.c;
      if (this.jdField_b_of_type_Int > 0)
      {
        i = j;
      }
      else
      {
        i = j;
        if (!bool)
        {
          i = j;
          if (j > 8) {
            i = j - 1;
          }
        }
      }
      if ((i != this.c) && (this.d > 2) && (this.jdField_a_of_type_ComTencentMobileqqArmapARMapTracer$TraceResultListener.a(i)))
      {
        this.c = i;
        this.jdField_b_of_type_Int = 3;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("ARMapTracer", 4, String.format(Locale.getDefault(), "isOk: %b, mLastRecommendFlag: %d, recommendLevel: %d, mCurLevel: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(i), Integer.valueOf(this.c) }));
      }
      this.f = 0;
      arrayOfInt = this.jdField_b_of_type_ArrayOfInt;
      arrayOfInt[2] = 0;
      arrayOfInt[1] = 0;
      arrayOfInt[0] = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARMapTracer
 * JD-Core Version:    0.7.0.1
 */