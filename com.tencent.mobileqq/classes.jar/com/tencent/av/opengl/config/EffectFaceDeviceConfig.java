package com.tencent.av.opengl.config;

import android.text.TextUtils;
import com.tencent.av.config.ConfigBaseParser;
import com.tencent.av.config.ConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class EffectFaceDeviceConfig
  extends ConfigBaseParser
{
  private static EffectFaceDeviceConfig a;
  
  public EffectFaceDeviceConfig(String paramString)
  {
    super(paramString);
  }
  
  public static EffectFaceDeviceConfig a()
  {
    if (a != null) {
      return a;
    }
    try
    {
      Object localObject = ConfigInfo.instance().getSharpConfigPayloadFromFile();
      if (QLog.isColorLevel()) {
        QLog.i("EffectFaceDeviceConfig", 2, "EffectFaceDeviceConfig useEffectFace: mData: " + (String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        a = new EffectFaceDeviceConfig((String)localObject);
        localObject = a;
        return localObject;
      }
    }
    catch (Exception localException) {}
    return null;
  }
  
  public int a()
  {
    return a("sharp/cpuMaxFreq/maxFreq", 0);
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (a("sharp/EffectFilterDeviceConfig/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (a("sharp/qavGestureConfig/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean c()
  {
    boolean bool = false;
    if (a("sharp/qavRedbagConfig/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean d()
  {
    boolean bool = false;
    if (a("sharp/qavScreenRecoder/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean e()
  {
    boolean bool = false;
    if (a("sharp/EffectFaceDeviceConfig/isClose", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean f()
  {
    return a("sharp/CameraFocusMethod/isUseSelfDev", 0) == 1;
  }
  
  public boolean g()
  {
    return 1 == a("sharp/EffectFaceDetectInversion/Inversion", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.opengl.config.EffectFaceDeviceConfig
 * JD-Core Version:    0.7.0.1
 */