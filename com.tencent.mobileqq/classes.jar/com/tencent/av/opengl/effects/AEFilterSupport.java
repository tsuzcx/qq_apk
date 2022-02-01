package com.tencent.av.opengl.effects;

import android.os.SystemClock;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.av.utils.machine.MachineLevelHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.qphone.base.util.QLog;

public class AEFilterSupport
{
  private static int jdField_a_of_type_Int = 0;
  private static long jdField_a_of_type_Long;
  private static MachineLevelHelper jdField_a_of_type_ComTencentAvUtilsMachineMachineLevelHelper;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static Runnable jdField_a_of_type_JavaLangRunnable;
  
  public static int a()
  {
    if (jdField_a_of_type_ComTencentAvUtilsMachineMachineLevelHelper == null) {
      jdField_a_of_type_ComTencentAvUtilsMachineMachineLevelHelper = new MachineLevelHelper(QAVConfigUtils.a("machineMiddleLine"), QAVConfigUtils.a("machineHighLine"));
    }
    return jdField_a_of_type_ComTencentAvUtilsMachineMachineLevelHelper.a();
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool2 = EffectsRenderController.b();
    boolean bool1 = false;
    if (!bool2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AEFilterSupport", 2, "isAEKitSoReady, not support AEKit.");
      }
      return false;
    }
    if (jdField_a_of_type_Int != 1)
    {
      if (((IAEResUtil)QRoute.api(IAEResUtil.class)).isAEBaseSoReady())
      {
        jdField_a_of_type_Int = 1;
        return true;
      }
      if (paramInt == 1)
      {
        jdField_a_of_type_Long = SystemClock.elapsedRealtime();
        b();
      }
      else if ((paramInt == 2) && (jdField_a_of_type_JavaLangRunnable == null) && (Math.abs(SystemClock.elapsedRealtime() - jdField_a_of_type_Long) > 30000L))
      {
        jdField_a_of_type_Long = SystemClock.elapsedRealtime();
        jdField_a_of_type_JavaLangRunnable = new AEFilterSupport.CheckAEFilterTask();
        ThreadManager.excute(jdField_a_of_type_JavaLangRunnable, 16, null, false);
      }
    }
    if (jdField_a_of_type_Int == 1) {
      bool1 = true;
    }
    return bool1;
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
    boolean bool2 = ((IAEResUtil)QRoute.api(IAEResUtil.class)).isAEBaseSoReady();
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = CaptureUtil.b();
    }
    int i;
    if (bool1) {
      i = 1;
    } else {
      i = -1;
    }
    if (jdField_a_of_type_Int != 1) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_Int != 1) {
          jdField_a_of_type_Int = i;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      long l2 = SystemClock.elapsedRealtime();
      ??? = new StringBuilder();
      ((StringBuilder)???).append("checkAndLoadAEKitSo ret[");
      ((StringBuilder)???).append(bool1);
      ((StringBuilder)???).append("], cost[");
      ((StringBuilder)???).append(l2 - l1);
      ((StringBuilder)???).append("], flag[");
      ((StringBuilder)???).append(jdField_a_of_type_Int);
      ((StringBuilder)???).append("]");
      QLog.i("AEFilterSupport", 2, ((StringBuilder)???).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.AEFilterSupport
 * JD-Core Version:    0.7.0.1
 */