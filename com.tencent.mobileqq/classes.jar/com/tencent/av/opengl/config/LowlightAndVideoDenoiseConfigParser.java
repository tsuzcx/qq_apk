package com.tencent.av.opengl.config;

import com.tencent.av.business.config.ConfigManager;
import com.tencent.av.config.ConfigBaseParser;
import com.tencent.common.app.BaseApplicationImpl;

public class LowlightAndVideoDenoiseConfigParser
{
  private static LowlightAndVideoDenoiseConfigParser a = null;
  
  public static LowlightAndVideoDenoiseConfigParser a()
  {
    if (a != null) {
      return a;
    }
    try
    {
      a = new LowlightAndVideoDenoiseConfigParser();
      LowlightAndVideoDenoiseConfigParser localLowlightAndVideoDenoiseConfigParser = a;
      return localLowlightAndVideoDenoiseConfigParser;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public float a()
  {
    try
    {
      float f1 = Float.parseFloat(ConfigManager.a(BaseApplicationImpl.getContext()).a("sharp/lowlight_denoise/videodenoiseratio", "15.0"));
      float f2;
      if (f1 <= 0.0D) {
        f2 = 0.0F;
      }
      do
      {
        return f2;
        f2 = f1;
      } while (f1 < 30.0D);
      return 30.0F;
    }
    catch (Exception localException) {}
    return 15.0F;
  }
  
  public boolean a()
  {
    return ConfigManager.a(BaseApplicationImpl.getContext()).a("sharp/lowlight_denoise/lowlightflag", 0) == 1;
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (ConfigManager.a(BaseApplicationImpl.getContext()).a("sharp/lowlight_denoise/lowlightflag", 0) == -1) {
      bool = true;
    }
    return bool;
  }
  
  public boolean c()
  {
    return ConfigManager.a(BaseApplicationImpl.getContext()).a("sharp/lowlight_denoise/videodenoiseflag", 0) == 1;
  }
  
  public boolean d()
  {
    boolean bool = false;
    if (ConfigManager.a(BaseApplicationImpl.getContext()).a("sharp/lowlight_denoise/videodenoiseflag", 0) == -1) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.config.LowlightAndVideoDenoiseConfigParser
 * JD-Core Version:    0.7.0.1
 */