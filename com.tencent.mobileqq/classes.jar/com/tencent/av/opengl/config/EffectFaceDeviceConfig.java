package com.tencent.av.opengl.config;

import com.tencent.av.business.config.ConfigManager;
import com.tencent.av.config.api.IConfigParser;
import com.tencent.qphone.base.util.BaseApplication;

public class EffectFaceDeviceConfig
{
  private static EffectFaceDeviceConfig a;
  
  public static EffectFaceDeviceConfig a()
  {
    EffectFaceDeviceConfig localEffectFaceDeviceConfig;
    label37:
    try
    {
      if (a != null)
      {
        localEffectFaceDeviceConfig = a;
        return localEffectFaceDeviceConfig;
      }
    }
    finally {}
    try
    {
      a = new EffectFaceDeviceConfig();
      localEffectFaceDeviceConfig = a;
      return localEffectFaceDeviceConfig;
    }
    catch (Exception localException)
    {
      break label37;
    }
    return null;
  }
  
  public boolean a()
  {
    IConfigParser localIConfigParser = ConfigManager.a(BaseApplication.getContext());
    boolean bool = false;
    if (localIConfigParser.getIntValue("sharp/EffectFilterDeviceConfig/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean b()
  {
    IConfigParser localIConfigParser = ConfigManager.a(BaseApplication.getContext());
    boolean bool = false;
    if (localIConfigParser.getIntValue("sharp/qavScreenRecoder/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean c()
  {
    IConfigParser localIConfigParser = ConfigManager.a(BaseApplication.getContext());
    boolean bool = false;
    if (localIConfigParser.getIntValue("sharp/EffectFaceDeviceConfig/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean d()
  {
    IConfigParser localIConfigParser = ConfigManager.a(BaseApplication.getContext());
    boolean bool = false;
    if (localIConfigParser.getIntValue("sharp/EffectFaceDeviceConfig/enable", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public boolean e()
  {
    IConfigParser localIConfigParser = ConfigManager.a(BaseApplication.getContext());
    boolean bool = false;
    if (localIConfigParser.getIntValue("sharp/CameraFocusMethod/isUseSelfDev", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public boolean f()
  {
    IConfigParser localIConfigParser = ConfigManager.a(BaseApplication.getContext());
    boolean bool = false;
    if (1 == localIConfigParser.getIntValue("sharp/EffectFaceDetectInversion/Inversion", 0)) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.config.EffectFaceDeviceConfig
 * JD-Core Version:    0.7.0.1
 */