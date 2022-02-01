package com.tencent.av.opengl.effects;

import android.os.SystemClock;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.constants.CameraCompatibleConstants;
import com.tencent.aelight.camera.download.api.IAEKitForQQ;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.av.utils.machine.MachineLevelHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.offlineset.AEOfflineConfig;
import org.light.DeviceSupportUtil;

public class AEFilterSupport
{
  private static MachineLevelHelper a;
  private static long b;
  private static Runnable c;
  private static final Object d = new Object();
  private static int e = 0;
  
  public static int a()
  {
    if (a == null) {
      a = new MachineLevelHelper(QAVConfigUtils.b("machineMiddleLine"), QAVConfigUtils.b("machineHighLine"));
    }
    return a.a();
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool2 = EffectsRenderController.c();
    boolean bool1 = false;
    if (!bool2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AEFilterSupport", 2, "isAEKitSoReady, not support AEKit.");
      }
      return false;
    }
    if (e != 1)
    {
      if (((IAEResUtil)QRoute.api(IAEResUtil.class)).isAEBaseSoReady())
      {
        e = 1;
        return true;
      }
      if (paramInt == 1)
      {
        b = SystemClock.elapsedRealtime();
        e();
      }
      else if ((paramInt == 2) && (c == null) && (Math.abs(SystemClock.elapsedRealtime() - b) > 30000L))
      {
        b = SystemClock.elapsedRealtime();
        c = new AEFilterSupport.CheckAEFilterTask();
        ThreadManager.excute(c, 16, null, false);
      }
    }
    if (e == 1) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean b()
  {
    boolean bool1 = ((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProductManufacturer(CameraCompatibleConstants.x);
    boolean bool2 = false;
    if (bool1)
    {
      QLog.d("lgx", 1, "KEY_BLACK_NOT_SUPPORT_AVATAR2D_PHONE return false.");
      return false;
    }
    int i;
    if (((IAEKitForQQ)QRoute.api(IAEKitForQQ.class)).init()) {
      i = AEOfflineConfig.getPhonePerfLevel();
    } else {
      i = -1;
    }
    boolean bool3 = DeviceSupportUtil.isAbilityDeviceSupport("avatar2d");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isAbilityDeviceSupport=");
    localStringBuilder.append(bool3);
    localStringBuilder.append(" getPhonePerfLevel=");
    localStringBuilder.append(i);
    QLog.d("lgx", 1, localStringBuilder.toString());
    bool1 = bool2;
    if (bool3) {
      if (i <= 1)
      {
        bool1 = bool2;
        if (i != -1) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static void e()
  {
    if (!EffectsRenderController.c())
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
    if (e != 1) {
      synchronized (d)
      {
        if (e != 1) {
          e = i;
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
      ((StringBuilder)???).append(e);
      ((StringBuilder)???).append("]");
      QLog.i("AEFilterSupport", 2, ((StringBuilder)???).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.AEFilterSupport
 * JD-Core Version:    0.7.0.1
 */