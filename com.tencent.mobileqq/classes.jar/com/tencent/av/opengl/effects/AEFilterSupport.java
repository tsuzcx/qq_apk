package com.tencent.av.opengl.effects;

import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import bbhm;
import bnky;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import llq;
import lor;
import los;
import lph;
import mtr;

public class AEFilterSupport
{
  private static int jdField_a_of_type_Int = 0;
  private static long jdField_a_of_type_Long;
  private static final Object jdField_a_of_type_JavaLangObject;
  private static Runnable jdField_a_of_type_JavaLangRunnable;
  private static lor jdField_a_of_type_Lor;
  private static final los jdField_a_of_type_Los = new los(21, 4, 1.1F, 2.7F);
  private static int jdField_b_of_type_Int;
  private static final los jdField_b_of_type_Los = new los(27, 8, 1.8F, 5.0F);
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static int a()
  {
    if (jdField_b_of_type_Int != 0) {
      return jdField_b_of_type_Int;
    }
    String str1 = mtr.a("machineMiddleLine");
    String str2 = mtr.a("machineHighLine");
    jdField_a_of_type_Los.a(str1);
    jdField_b_of_type_Los.a(str2);
    lor locallor = a();
    if (jdField_b_of_type_Los.a(locallor)) {
      jdField_b_of_type_Int = 7;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AEFilterSupport", 2, String.format("getCurMachineLevel, level: %s, middle[%s], high[%s], cur[%s], config[%s, %s]", new Object[] { Integer.valueOf(jdField_b_of_type_Int), jdField_a_of_type_Los, jdField_b_of_type_Los, locallor, str1, str2 }));
      }
      return jdField_b_of_type_Int;
      if (jdField_a_of_type_Los.a(locallor)) {
        jdField_b_of_type_Int = 4;
      } else {
        jdField_b_of_type_Int = 3;
      }
    }
  }
  
  @NonNull
  public static lor a()
  {
    if (jdField_a_of_type_Lor == null)
    {
      lor locallor = new lor();
      locallor.jdField_a_of_type_Int = Build.VERSION.SDK_INT;
      locallor.jdField_b_of_type_Float = ((float)DeviceInfoUtil.getSystemTotalMemory() / 1.073742E+009F);
      locallor.jdField_b_of_type_Int = DeviceInfoUtil.getCpuNumber();
      locallor.jdField_a_of_type_Float = ((float)llq.d() / 1048576.0F);
      jdField_a_of_type_Lor = locallor;
    }
    return jdField_a_of_type_Lor;
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool = true;
    if (!lph.b())
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
        if (bnky.a())
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
    if (!lph.b())
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
    boolean bool = bnky.a();
    if (!bool) {
      bool = bbhm.a(false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.opengl.effects.AEFilterSupport
 * JD-Core Version:    0.7.0.1
 */