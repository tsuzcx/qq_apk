package com.tencent.av.opengl.config;

import com.tencent.av.business.config.ConfigManager;
import com.tencent.av.config.ConfigBaseParser;
import com.tencent.common.app.BaseApplicationImpl;

public class BeautyConfigParser
{
  private static BeautyConfigParser a = null;
  
  public static BeautyConfigParser a()
  {
    if (a != null) {
      return a;
    }
    try
    {
      a = new BeautyConfigParser();
      BeautyConfigParser localBeautyConfigParser = a;
      return localBeautyConfigParser;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public float a()
  {
    float f;
    try
    {
      f = Float.parseFloat(ConfigManager.a(BaseApplicationImpl.getContext()).a("sharp/beauty_3/ratio", "1.0"));
      if (f <= 0.0F) {
        return 1.0F;
      }
    }
    catch (Exception localException)
    {
      return 1.0F;
    }
    return f;
  }
  
  public boolean a()
  {
    return ConfigManager.a(BaseApplicationImpl.getContext()).a("sharp/beauty_3/flag", 0) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.config.BeautyConfigParser
 * JD-Core Version:    0.7.0.1
 */