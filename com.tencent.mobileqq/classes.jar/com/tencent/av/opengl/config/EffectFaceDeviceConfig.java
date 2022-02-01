package com.tencent.av.opengl.config;

import com.tencent.av.business.config.ConfigManager;
import com.tencent.av.config.ConfigBaseParser;
import com.tencent.common.app.BaseApplicationImpl;

public class EffectFaceDeviceConfig
{
  private static EffectFaceDeviceConfig jdField_a_of_type_ComTencentAvOpenglConfigEffectFaceDeviceConfig = null;
  int jdField_a_of_type_Int = 0;
  
  public static EffectFaceDeviceConfig a()
  {
    try
    {
      EffectFaceDeviceConfig localEffectFaceDeviceConfig;
      if (jdField_a_of_type_ComTencentAvOpenglConfigEffectFaceDeviceConfig != null)
      {
        localEffectFaceDeviceConfig = jdField_a_of_type_ComTencentAvOpenglConfigEffectFaceDeviceConfig;
        return localEffectFaceDeviceConfig;
      }
      return null;
    }
    finally
    {
      try
      {
        jdField_a_of_type_ComTencentAvOpenglConfigEffectFaceDeviceConfig = new EffectFaceDeviceConfig();
        localEffectFaceDeviceConfig = jdField_a_of_type_ComTencentAvOpenglConfigEffectFaceDeviceConfig;
        return localEffectFaceDeviceConfig;
      }
      catch (Exception localException) {}
      localObject = finally;
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (ConfigManager.a(BaseApplicationImpl.getContext()).a("sharp/EffectFilterDeviceConfig/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (ConfigManager.a(BaseApplicationImpl.getContext()).a("sharp/qavGestureConfig/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean c()
  {
    boolean bool = false;
    if (ConfigManager.a(BaseApplicationImpl.getContext()).a("sharp/qavRedbagConfig/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean d()
  {
    boolean bool = false;
    if (ConfigManager.a(BaseApplicationImpl.getContext()).a("sharp/qavScreenRecoder/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean e()
  {
    boolean bool = false;
    if (ConfigManager.a(BaseApplicationImpl.getContext()).a("sharp/EffectFaceDeviceConfig/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean f()
  {
    return ConfigManager.a(BaseApplicationImpl.getContext()).a("sharp/EffectFaceDeviceConfig/enable", 0) == 1;
  }
  
  public boolean g()
  {
    return ConfigManager.a(BaseApplicationImpl.getContext()).a("sharp/CameraFocusMethod/isUseSelfDev", 0) == 1;
  }
  
  public boolean h()
  {
    return 1 == ConfigManager.a(BaseApplicationImpl.getContext()).a("sharp/EffectFaceDetectInversion/Inversion", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.config.EffectFaceDeviceConfig
 * JD-Core Version:    0.7.0.1
 */