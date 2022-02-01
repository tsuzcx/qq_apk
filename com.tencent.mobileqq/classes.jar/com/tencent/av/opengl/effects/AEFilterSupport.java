package com.tencent.av.opengl.effects;

import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.download.AEResUtil;

public class AEFilterSupport
{
  private static int jdField_a_of_type_Int = 0;
  private static long jdField_a_of_type_Long;
  private static AEFilterSupport.MachineInfo jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterSupport$MachineInfo = null;
  private static final AEFilterSupport.MachineLevelLine jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterSupport$MachineLevelLine = new AEFilterSupport.MachineLevelLine(21, 4, 1.1F, 2.7F);
  private static final Object jdField_a_of_type_JavaLangObject;
  private static Runnable jdField_a_of_type_JavaLangRunnable;
  private static int jdField_b_of_type_Int = 0;
  private static final AEFilterSupport.MachineLevelLine jdField_b_of_type_ComTencentAvOpenglEffectsAEFilterSupport$MachineLevelLine = new AEFilterSupport.MachineLevelLine(27, 8, 1.8F, 5.0F);
  
  static
  {
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_JavaLangRunnable = null;
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static int a()
  {
    if (jdField_b_of_type_Int != 0) {
      return jdField_b_of_type_Int;
    }
    String str1 = QAVConfigUtils.a("machineMiddleLine");
    String str2 = QAVConfigUtils.a("machineHighLine");
    jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterSupport$MachineLevelLine.a(str1);
    jdField_b_of_type_ComTencentAvOpenglEffectsAEFilterSupport$MachineLevelLine.a(str2);
    AEFilterSupport.MachineInfo localMachineInfo = a();
    if (jdField_b_of_type_ComTencentAvOpenglEffectsAEFilterSupport$MachineLevelLine.a(localMachineInfo)) {
      jdField_b_of_type_Int = 7;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AEFilterSupport", 2, String.format("getCurMachineLevel, level: %s, middle[%s], high[%s], cur[%s], config[%s, %s]", new Object[] { Integer.valueOf(jdField_b_of_type_Int), jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterSupport$MachineLevelLine, jdField_b_of_type_ComTencentAvOpenglEffectsAEFilterSupport$MachineLevelLine, localMachineInfo, str1, str2 }));
      }
      return jdField_b_of_type_Int;
      if (jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterSupport$MachineLevelLine.a(localMachineInfo)) {
        jdField_b_of_type_Int = 4;
      } else {
        jdField_b_of_type_Int = 3;
      }
    }
  }
  
  @NonNull
  public static AEFilterSupport.MachineInfo a()
  {
    if (jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterSupport$MachineInfo == null)
    {
      AEFilterSupport.MachineInfo localMachineInfo = new AEFilterSupport.MachineInfo();
      localMachineInfo.jdField_a_of_type_Int = Build.VERSION.SDK_INT;
      localMachineInfo.jdField_b_of_type_Float = ((float)DeviceInfoUtil.a() / 1.073742E+009F);
      localMachineInfo.jdField_b_of_type_Int = DeviceInfoUtil.b();
      localMachineInfo.jdField_a_of_type_Float = ((float)VcSystemInfo.getMaxCpuFreq() / 1048576.0F);
      jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterSupport$MachineInfo = localMachineInfo;
    }
    return jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterSupport$MachineInfo;
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool = true;
    if (!EffectsRenderController.b())
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
        if (AEResUtil.a())
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
    if (!EffectsRenderController.b())
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
    boolean bool = AEResUtil.a();
    if (!bool) {
      bool = CaptureUtil.b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.effects.AEFilterSupport
 * JD-Core Version:    0.7.0.1
 */