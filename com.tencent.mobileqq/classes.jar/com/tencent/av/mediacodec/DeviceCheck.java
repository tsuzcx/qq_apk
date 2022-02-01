package com.tencent.av.mediacodec;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.business.config.ConfigManager;
import com.tencent.av.config.api.ICodecConfigParser;
import com.tencent.av.config.api.IConfigParser;
import com.tencent.avcore.jni.codec.HWCodecAbility;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

@SuppressLint({"NewApi"})
public class DeviceCheck
  implements Runnable
{
  public static boolean a()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return false;
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("OPPO")) && (Build.MODEL.equalsIgnoreCase("N5207")) && (Build.PRODUCT.equalsIgnoreCase("N5207"))) {
      return f();
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.MODEL.equalsIgnoreCase("GT-I9500"))) {
      return f();
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) && (Build.MODEL.equalsIgnoreCase("MI NOTE LTE")) && (Build.PRODUCT.equalsIgnoreCase("virgo"))) {
      return f();
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("asus")) && (Build.MODEL.equalsIgnoreCase("ASUS_Z00ADA")) && (Build.PRODUCT.equalsIgnoreCase("CN_Z00A"))) {
      return f();
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) && (Build.MODEL.equalsIgnoreCase("MI 4W")) && (Build.PRODUCT.equalsIgnoreCase("cancro_wc_lte"))) {
      return f();
    }
    return false;
  }
  
  static boolean a(int paramInt)
  {
    return (paramInt == 19) || (paramInt == 21) || (paramInt == 2130706944) || (paramInt == 2141391876);
  }
  
  public static boolean b()
  {
    if (i()) {
      return e();
    }
    if (j()) {
      return e();
    }
    return (Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.MODEL.equalsIgnoreCase("SM-N9005")) && (Build.VERSION.SDK_INT > 18);
  }
  
  static boolean b(int paramInt)
  {
    return (paramInt == 19) || (paramInt == 21);
  }
  
  @SuppressLint({"NewApi"})
  @TargetApi(16)
  public static boolean c()
  {
    List localList = AndroidCodec.getDecoderInfos("video/hevc");
    int i = 0;
    while (i < localList.size())
    {
      MediaCodecInfo.CodecCapabilities localCodecCapabilities = AndroidCodec.getCodecCapabilities((MediaCodecInfo)localList.get(i), "video/hevc");
      if (localCodecCapabilities == null) {
        break;
      }
      if (localCodecCapabilities.colorFormats == null) {
        return false;
      }
      int j = 0;
      while (j < localCodecCapabilities.colorFormats.length)
      {
        if (a(localCodecCapabilities.colorFormats[j])) {
          return true;
        }
        j += 1;
      }
      i += 1;
    }
    return false;
  }
  
  @SuppressLint({"NewApi"})
  @TargetApi(16)
  public static boolean d()
  {
    List localList = AndroidCodec.getEndoderInfos("video/hevc");
    int i = 0;
    while (i < localList.size())
    {
      MediaCodecInfo.CodecCapabilities localCodecCapabilities = AndroidCodec.getCodecCapabilities((MediaCodecInfo)localList.get(i), "video/hevc");
      if (localCodecCapabilities == null) {
        return false;
      }
      int j = 0;
      while (j < localCodecCapabilities.colorFormats.length)
      {
        if (b(localCodecCapabilities.colorFormats[j])) {
          return true;
        }
        j += 1;
      }
      i += 1;
    }
    return false;
  }
  
  @SuppressLint({"NewApi"})
  @TargetApi(16)
  public static boolean e()
  {
    List localList = AndroidCodec.getDecoderInfos("video/avc");
    int i = 0;
    while (i < localList.size())
    {
      MediaCodecInfo.CodecCapabilities localCodecCapabilities = AndroidCodec.getCodecCapabilities((MediaCodecInfo)localList.get(i), "video/avc");
      if ((localCodecCapabilities != null) && (localCodecCapabilities.colorFormats != null))
      {
        int j = 0;
        while (j < localCodecCapabilities.colorFormats.length)
        {
          if (a(localCodecCapabilities.colorFormats[j])) {
            return true;
          }
          j += 1;
        }
      }
      i += 1;
    }
    return false;
  }
  
  @SuppressLint({"NewApi"})
  @TargetApi(16)
  public static boolean f()
  {
    List localList = AndroidCodec.getEndoderInfos("video/avc");
    int i = 0;
    while (i < localList.size())
    {
      MediaCodecInfo.CodecCapabilities localCodecCapabilities = AndroidCodec.getCodecCapabilities((MediaCodecInfo)localList.get(i), "video/avc");
      if (localCodecCapabilities != null)
      {
        int j = 0;
        while (j < localCodecCapabilities.colorFormats.length)
        {
          if (b(localCodecCapabilities.colorFormats[j])) {
            return true;
          }
          j += 1;
        }
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean g()
  {
    if (h()) {
      return false;
    }
    if (Build.VERSION.SDK_INT < 21) {
      return false;
    }
    Object localObject = ConfigManager.a(BaseApplication.getContext());
    ICodecConfigParser localICodecConfigParser = (ICodecConfigParser)QRoute.api(ICodecConfigParser.class);
    localICodecConfigParser.init((IConfigParser)localObject);
    localObject = localICodecConfigParser.getAVCEncoderAbility();
    HWCodecAbility localHWCodecAbility = localICodecConfigParser.getAVCDecoderAbility();
    if ((localObject != null) && (((HWCodecAbility)localObject).isHWCodec) && (localICodecConfigParser.isEnableAsyncApi(2)) && (localHWCodecAbility != null) && (localHWCodecAbility.isHWCodec) && (localICodecConfigParser.isEnableAsyncApi(1)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DeviceCheck", 2, "SUPPORT Async API");
      }
      return true;
    }
    return false;
  }
  
  public static boolean h()
  {
    return false;
  }
  
  private static boolean i()
  {
    if ((Build.MANUFACTURER.equalsIgnoreCase("LGE")) && (Build.MODEL.equalsIgnoreCase("Nexus 4")) && (Build.PRODUCT.equalsIgnoreCase("occam")) && (Build.VERSION.SDK_INT >= 21)) {
      return true;
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("LGE")) && (Build.MODEL.equalsIgnoreCase("Nexus 5")) && (Build.PRODUCT.equalsIgnoreCase("hammerhead"))) {
      return true;
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.MODEL.equalsIgnoreCase("GT-I9500")) && (Build.VERSION.SDK_INT > 18)) {
      return true;
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("LGE")) && (Build.MODEL.equalsIgnoreCase("LG-D802"))) {
      return true;
    }
    return (Build.MANUFACTURER.equalsIgnoreCase("Meizu")) && (Build.MODEL.equalsIgnoreCase("MX4 Pro"));
  }
  
  private static boolean j()
  {
    if ((Build.MANUFACTURER.equalsIgnoreCase("Meizu")) && (Build.MODEL.equalsIgnoreCase("M353")) && (Build.PRODUCT.equalsIgnoreCase("meizu_mx3"))) {
      return true;
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("Meizu")) && (Build.MODEL.equalsIgnoreCase("m1 note")) && (Build.PRODUCT.equalsIgnoreCase("m1 note"))) {
      return true;
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.MODEL.equalsIgnoreCase("SM-N9006V")) && (Build.VERSION.SDK_INT > 18)) {
      return true;
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("smartisan")) && (Build.MODEL.equalsIgnoreCase("SM705")) && (Build.PRODUCT.equalsIgnoreCase("msm8974sfo_lte"))) {
      return true;
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("OPPO")) && (Build.MODEL.equalsIgnoreCase("N5207")) && (Build.PRODUCT.equalsIgnoreCase("N5207"))) {
      return true;
    }
    return (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) && (Build.MODEL.equalsIgnoreCase("HM 1SC")) && (Build.PRODUCT.equalsIgnoreCase("armani"));
  }
  
  public void run() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.mediacodec.DeviceCheck
 * JD-Core Version:    0.7.0.1
 */