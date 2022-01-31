package com.tencent.av.opengl.effects;

import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import avte;
import axlg;
import bbdh;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import llw;
import lpj;
import lpk;
import lpu;
import msn;

public class AEFilterSupport
{
  private static int jdField_a_of_type_Int = 0;
  private static long jdField_a_of_type_Long;
  private static final Object jdField_a_of_type_JavaLangObject;
  private static Runnable jdField_a_of_type_JavaLangRunnable;
  private static lpj jdField_a_of_type_Lpj;
  private static final lpk jdField_a_of_type_Lpk = new lpk(21, 4, 1.1F, 3.0F);
  private static int jdField_b_of_type_Int = 0;
  private static final lpk jdField_b_of_type_Lpk = new lpk(21, 4, 1.4F, 2.7F);
  private static int jdField_c_of_type_Int;
  private static final lpk jdField_c_of_type_Lpk = new lpk(27, 8, 1.8F, 5.0F);
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static int a()
  {
    if (jdField_c_of_type_Int != 0) {
      return jdField_c_of_type_Int;
    }
    String str1 = msn.a("machineMiddleLine");
    String str2 = msn.a("machineHighLine");
    jdField_b_of_type_Lpk.a(str1);
    jdField_c_of_type_Lpk.a(str2);
    lpj locallpj = a();
    if (jdField_c_of_type_Lpk.a(locallpj)) {
      jdField_c_of_type_Int = 7;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AEFilterSupport", 2, String.format("getCurMachineLevel, level: %s, middle[%s], high[%s], cur[%s], config[%s, %s]", new Object[] { Integer.valueOf(jdField_c_of_type_Int), jdField_b_of_type_Lpk, jdField_c_of_type_Lpk, locallpj, str1, str2 }));
      }
      return jdField_c_of_type_Int;
      if (jdField_b_of_type_Lpk.a(locallpj)) {
        jdField_c_of_type_Int = 4;
      } else {
        jdField_c_of_type_Int = 3;
      }
    }
  }
  
  @NonNull
  public static lpj a()
  {
    if (jdField_a_of_type_Lpj == null)
    {
      lpj locallpj = new lpj();
      locallpj.jdField_a_of_type_Int = Build.VERSION.SDK_INT;
      locallpj.jdField_b_of_type_Float = ((float)bbdh.d() / 1.073742E+009F);
      locallpj.jdField_b_of_type_Int = bbdh.b();
      locallpj.jdField_a_of_type_Float = ((float)llw.c() / 1048576.0F);
      jdField_a_of_type_Lpj = locallpj;
    }
    return jdField_a_of_type_Lpj;
  }
  
  public static boolean a()
  {
    boolean bool = true;
    if (!lpu.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("AEFilterSupport", 2, "isSupportPtuNew, not support AEKit.");
      }
      return false;
    }
    if (jdField_b_of_type_Int == 0)
    {
      String str = msn.a("ptuNewRenderLimit");
      jdField_a_of_type_Lpk.a(str);
      lpj locallpj = a();
      if (!jdField_a_of_type_Lpk.a(locallpj)) {
        break label114;
      }
      jdField_b_of_type_Int = 1;
      if (QLog.isColorLevel()) {
        QLog.i("AEFilterSupport", 2, String.format("isSupportPtuNew, flag: %s, line: %s, cur: %s, config[%s]", new Object[] { Integer.valueOf(jdField_b_of_type_Int), jdField_a_of_type_Lpk, locallpj, str }));
      }
    }
    if (jdField_b_of_type_Int == 1) {}
    for (;;)
    {
      return bool;
      label114:
      jdField_b_of_type_Int = -1;
      break;
      bool = false;
    }
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool = true;
    if (!lpu.a())
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
        if (axlg.a())
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
    if (!lpu.a())
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
    boolean bool = axlg.a();
    if (!bool) {
      bool = avte.a(false);
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