package com.tencent.av.opengl.effects;

import android.os.SystemClock;
import android.text.TextUtils;
import autt;
import awly;
import babp;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import lbk;
import lfi;
import mhr;

public class AEFilterSupport
{
  private static int jdField_a_of_type_Int = 0;
  private static long jdField_a_of_type_Long;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static Runnable jdField_a_of_type_JavaLangRunnable;
  private static int b = 0;
  
  public static boolean a()
  {
    if (!lfi.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("AEFilterSupport", 2, "isSupportPtuNew, not support AEKit.");
      }
      return false;
    }
    String str1;
    float f1;
    float f2;
    int j;
    int i;
    float f4;
    int k;
    float f3;
    String str2;
    if (b == 0)
    {
      str1 = mhr.b();
      f1 = 3.0F;
      f2 = 1.1F;
      if (!TextUtils.isEmpty(str1))
      {
        String[] arrayOfString = str1.split(";");
        int m = arrayOfString.length;
        j = 0;
        i = 4;
        f4 = f2;
        k = i;
        f3 = f1;
        if (j >= m) {
          break label258;
        }
        str2 = arrayOfString[j];
        if (str2 == null)
        {
          f4 = f1;
          k = i;
          f3 = f2;
        }
      }
    }
    for (;;)
    {
      j += 1;
      f2 = f3;
      i = k;
      f1 = f4;
      break;
      int n = str2.indexOf('=');
      f3 = f2;
      k = i;
      f4 = f1;
      if (n > 0)
      {
        f3 = f2;
        k = i;
        f4 = f1;
        if (n < str2.length())
        {
          try
          {
            String str3 = str2.substring(0, n);
            f3 = Float.parseFloat(str2.substring(n + 1));
            if ("MemoryLimit".equalsIgnoreCase(str3))
            {
              f1 = f3;
            }
            else if ("CpuNumLimit".equalsIgnoreCase(str3))
            {
              i = (int)f3;
            }
            else
            {
              bool = "CpuFreqLimit".equalsIgnoreCase(str3);
              if (bool) {
                f2 = f3;
              }
            }
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
            f3 = f2;
            k = i;
            f4 = f1;
          }
          continue;
          k = 4;
          f3 = f1;
          f4 = f2;
          label258:
          f1 = (float)babp.d() / 1.073742E+009F;
          i = babp.b();
          f2 = (float)lbk.c() / 1048576.0F;
          if ((f3 <= f1) && (k <= i) && (f4 <= f2))
          {
            b = 1;
            if (QLog.isColorLevel()) {
              QLog.i("AEFilterSupport", 2, String.format("isSupportPtuNew, memory[%s, %s], cpuNum[%s, %s], cpuFreq[%s, %s], config[%s]", new Object[] { Float.valueOf(f3), Float.valueOf(f1), Integer.valueOf(k), Integer.valueOf(i), Float.valueOf(f4), Float.valueOf(f2), str1 }));
            }
            if (b != 1) {
              break label394;
            }
          }
          label394:
          for (boolean bool = true;; bool = false)
          {
            return bool;
            b = -1;
            break;
          }
          f3 = f2;
          k = i;
          f4 = f1;
        }
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool = true;
    if (!lfi.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("AEFilterSupport", 2, "isAEKitSoReady, not support AEKit.");
      }
      bool = false;
    }
    for (;;)
    {
      return bool;
      if (jdField_a_of_type_Int != 1)
      {
        if (awly.a())
        {
          jdField_a_of_type_Int = 1;
          return true;
        }
        if (paramInt != 1) {
          break label68;
        }
        jdField_a_of_type_Long = SystemClock.elapsedRealtime();
        b();
      }
      while (jdField_a_of_type_Int != 1)
      {
        return false;
        label68:
        if ((paramInt == 2) && (jdField_a_of_type_JavaLangRunnable == null) && (Math.abs(SystemClock.elapsedRealtime() - jdField_a_of_type_Long) > 30000L))
        {
          jdField_a_of_type_Long = SystemClock.elapsedRealtime();
          jdField_a_of_type_JavaLangRunnable = new AEFilterSupport.CheckAEFilterTask();
          ThreadManager.excute(jdField_a_of_type_JavaLangRunnable, 16, null, false);
        }
      }
    }
  }
  
  private static void b()
  {
    if (!lfi.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("AEFilterSupport", 2, "checkAndLoadAEKitSo, not support AEKit.");
      }
      return;
    }
    long l1 = 0L;
    if (QLog.isColorLevel()) {
      l1 = SystemClock.elapsedRealtime();
    }
    boolean bool = awly.a();
    if (!bool) {
      bool = autt.a(false);
    }
    for (;;)
    {
      for (;;)
      {
        int i;
        if (bool)
        {
          i = 1;
          if (jdField_a_of_type_Int == 1) {}
        }
        synchronized (jdField_a_of_type_JavaLangObject)
        {
          if (jdField_a_of_type_Int != 1) {
            jdField_a_of_type_Int = i;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          long l2 = SystemClock.elapsedRealtime();
          QLog.i("AEFilterSupport", 2, "checkAndLoadAEKitSo ret[" + bool + "], cost[" + (l2 - l1) + "], flag[" + jdField_a_of_type_Int + "]");
          return;
          i = -1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.opengl.effects.AEFilterSupport
 * JD-Core Version:    0.7.0.1
 */