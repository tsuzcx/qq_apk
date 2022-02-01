package com.tencent.mobileqq.apollo.utils;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import common.config.service.QzoneConfig;

public class CmShowWnsUtils
{
  public static float a()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "AioCMShowOffscreenHeight", 118.0F);
  }
  
  public static int a()
  {
    String str = QzoneConfig.getInstance().getConfig("CMShow", "recordThreadPoolSize", "4,2,1");
    if (TextUtils.isEmpty(str)) {}
    String[] arrayOfString;
    do
    {
      return 1;
      arrayOfString = str.split(",");
    } while ((arrayOfString == null) || (arrayOfString.length != 3));
    try
    {
      if (DeviceInfoUtils.a()) {
        return Integer.parseInt(arrayOfString[0]);
      }
      if (DeviceInfoUtils.b()) {
        return Integer.parseInt(arrayOfString[2]);
      }
      int i = Integer.parseInt(arrayOfString[1]);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.e("CmShowWnsUtils", 1, "getRecordAsyncThreadMaxCount exception, config:" + str, localNumberFormatException);
    }
    return 1;
  }
  
  public static long a()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CmsPlayerRecordTimeout", 15000L);
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (QzoneConfig.getInstance().getConfig("CMShow", "AioCMShowToggleButtonSwitch", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static float b()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CmsPanelGetCoverFrameTime", 33.333332F);
  }
  
  public static int b()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CMShowGetFrameDelayTime", 200);
  }
  
  public static boolean b()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CMShowNewAnimation", 1) > 0;
  }
  
  public static boolean c()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CMShowMemeTab", 1) > 0;
  }
  
  public static boolean d()
  {
    boolean bool = false;
    if (QzoneConfig.getInstance().getConfig("CMShow", "CMShowMemeTabInFace", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean e()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CMShowKeywordAssociation", 1) > 0;
  }
  
  public static boolean f()
  {
    String str = QzoneConfig.getInstance().getConfig("CMShow", "CMShowAEKitDeviceBlackList", "");
    if (!TextUtils.isEmpty(str)) {
      return str.contains(Build.MODEL);
    }
    return false;
  }
  
  public static boolean g()
  {
    boolean bool = false;
    if (QzoneConfig.getInstance().getConfig("CMShow", "apolloPanelExtendEnable", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean h()
  {
    boolean bool = false;
    if (QzoneConfig.getInstance().getConfig("CMShow", "C2CCMShowPanelBattleGameEntrance", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean i()
  {
    boolean bool = false;
    if (QzoneConfig.getInstance().getConfig("CMShow", "GroupCMShowPanelBattleGameEntrance", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean j()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "addAnimToFav", 1) > 0;
  }
  
  public static boolean k()
  {
    boolean bool = false;
    if (QzoneConfig.getInstance().getConfig("CMShow", "panelRedDot", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean l()
  {
    boolean bool = false;
    if (QzoneConfig.getInstance().getConfig("CMShow", "encounterChatSupportSprite", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean m()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "enableSizeCorrect", 1) > 0;
  }
  
  public static boolean n()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CMShowAsyncGetDpcSwitch", 1) > 0;
  }
  
  public static boolean o()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "framePlayOpen", 1) > 0;
  }
  
  public static boolean p()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "frameDrawableLowMemoryMode", 1) > 0;
  }
  
  public static boolean q()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CMShowAvatarEnable", 1) > 0;
  }
  
  public static boolean r()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "enableEGLOffscreenConfig", 1) > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.CmShowWnsUtils
 * JD-Core Version:    0.7.0.1
 */