package com.tencent.aelight.camera.ae.cmshow;

import com.tencent.aekit.api.standard.GLCapabilities;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.log.AEQLog;
import org.light.DeviceSupportUtil;
import org.light.device.DeviceInstance;

public class AECMShowUtil
{
  public static String a()
  {
    if (!AEResUtil.b(AEResInfo.LIGHT_RES_BASE_PACKAGE))
    {
      AEQLog.d("AECMShowUtil", "[getLightAssetsDir]: LightBasePackage not exist, return asset path!");
      return "assets://camera/cmshow";
    }
    return AEResUtil.d();
  }
  
  public static void a()
  {
    try
    {
      GLCapabilities.init(false);
      AEQLog.b("AECMShowUtil", "init3DCapabilityChecker: init finish");
      return;
    }
    catch (Throwable localThrowable)
    {
      AEQLog.a("AECMShowUtil", "[init3DCapabilityChecker], error=", localThrowable);
    }
  }
  
  public static boolean a()
  {
    try
    {
      DeviceSupportUtil.init(a());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[isCMShowSupported] 厘米秀设备屏蔽判断，设备名：");
      localStringBuilder.append(DeviceInstance.getInstance().getDeviceName());
      AEQLog.a("AECMShowUtil", localStringBuilder.toString());
      boolean bool = DeviceSupportUtil.isAbilityDeviceSupport("3d.kapu");
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AEQLog.a("AECMShowUtil", "[isCMShowSupported], error=", localThrowable);
    }
    return false;
  }
  
  public static boolean b()
  {
    return (AEResUtil.b(AEResInfo.AE_RES_BASE_PACKAGE)) && (AEResUtil.b(AEResInfo.LIGHT_RES_BASE_PACKAGE)) && (AEResUtil.b(AEResInfo.LIGHT_RES_BUNDLE_ACE3D)) && (AEResUtil.b(AEResInfo.LIGHT_RES_BUNDLE_3DMM));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.AECMShowUtil
 * JD-Core Version:    0.7.0.1
 */