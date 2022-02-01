package com.tencent.av.opengl.effects;

import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import bbgg;
import bhlo;
import bork;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import llk;
import low;
import lox;
import lpm;
import mtl;

public class AEFilterSupport
{
  private static int jdField_a_of_type_Int = 0;
  private static long jdField_a_of_type_Long;
  private static final Object jdField_a_of_type_JavaLangObject;
  private static Runnable jdField_a_of_type_JavaLangRunnable;
  private static low jdField_a_of_type_Low;
  private static final lox jdField_a_of_type_Lox = new lox(21, 4, 1.1F, 3.0F);
  private static int jdField_b_of_type_Int = 0;
  private static final lox jdField_b_of_type_Lox = new lox(21, 4, 1.4F, 2.7F);
  private static int jdField_c_of_type_Int;
  private static final lox jdField_c_of_type_Lox = new lox(27, 8, 1.8F, 5.0F);
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static int a()
  {
    if (jdField_c_of_type_Int != 0) {
      return jdField_c_of_type_Int;
    }
    String str1 = mtl.a("machineMiddleLine");
    String str2 = mtl.a("machineHighLine");
    jdField_b_of_type_Lox.a(str1);
    jdField_c_of_type_Lox.a(str2);
    low locallow = a();
    if (jdField_c_of_type_Lox.a(locallow)) {
      jdField_c_of_type_Int = 7;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AEFilterSupport", 2, String.format("getCurMachineLevel, level: %s, middle[%s], high[%s], cur[%s], config[%s, %s]", new Object[] { Integer.valueOf(jdField_c_of_type_Int), jdField_b_of_type_Lox, jdField_c_of_type_Lox, locallow, str1, str2 }));
      }
      return jdField_c_of_type_Int;
      if (jdField_b_of_type_Lox.a(locallow)) {
        jdField_c_of_type_Int = 4;
      } else {
        jdField_c_of_type_Int = 3;
      }
    }
  }
  
  @NonNull
  public static low a()
  {
    if (jdField_a_of_type_Low == null)
    {
      low locallow = new low();
      locallow.jdField_a_of_type_Int = Build.VERSION.SDK_INT;
      locallow.jdField_b_of_type_Float = ((float)bhlo.d() / 1.073742E+009F);
      locallow.jdField_b_of_type_Int = bhlo.b();
      locallow.jdField_a_of_type_Float = ((float)llk.d() / 1048576.0F);
      jdField_a_of_type_Low = locallow;
    }
    return jdField_a_of_type_Low;
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool = true;
    if (!lpm.b())
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
        if (bork.a())
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
    if (!lpm.b())
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
    boolean bool = bork.a();
    if (!bool) {
      bool = bbgg.a(false);
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