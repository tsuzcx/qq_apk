package com.tencent.avcore.config;

import android.content.Context;
import com.tencent.avcore.jni.config.ConfigInfoJni;

public class ConfigInfo
  extends ConfigInfoJni
{
  private static volatile ConfigInfo instance;
  
  private ConfigInfo(Context paramContext)
  {
    super(paramContext);
  }
  
  public static ConfigInfo instance(Context paramContext)
  {
    if (instance == null) {
      try
      {
        ConfigInfo localConfigInfo = instance;
        if (localConfigInfo == null) {
          try
          {
            instance = new ConfigInfo(paramContext);
          }
          catch (Error paramContext)
          {
            instance = null;
            paramContext.printStackTrace();
          }
          catch (Exception paramContext)
          {
            instance = null;
            paramContext.printStackTrace();
          }
        }
      }
      finally {}
    }
    return instance;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.config.ConfigInfo
 * JD-Core Version:    0.7.0.1
 */