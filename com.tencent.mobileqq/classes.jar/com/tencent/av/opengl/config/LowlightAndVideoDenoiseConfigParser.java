package com.tencent.av.opengl.config;

import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.av.config.ConfigBaseParser;
import com.tencent.av.config.ConfigInfo;

public class LowlightAndVideoDenoiseConfigParser
  extends ConfigBaseParser
{
  private static LowlightAndVideoDenoiseConfigParser a;
  
  public LowlightAndVideoDenoiseConfigParser(String paramString)
  {
    super(paramString);
  }
  
  public static LowlightAndVideoDenoiseConfigParser a()
  {
    if (a != null) {
      return a;
    }
    try
    {
      Object localObject = ConfigInfo.instance().getSharpConfigPayloadFromFile();
      if (QLog.isColorLevel()) {
        QLog.i("LowlightAndVideoDenoise", 0, "LowlightAndVideoDenoiseConfigParser mData: " + (String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        a = new LowlightAndVideoDenoiseConfigParser((String)localObject);
        localObject = a;
        return localObject;
      }
    }
    catch (Exception localException) {}
    return null;
  }
  
  public float a()
  {
    try
    {
      float f1 = Float.parseFloat(a("sharp/lowlight_denoise/videodenoiseratio", "15.0"));
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
    return a("sharp/lowlight_denoise/lowlightflag", 0) == 1;
  }
  
  public boolean b()
  {
    return a("sharp/lowlight_denoise/videodenoiseflag", 0) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.opengl.config.LowlightAndVideoDenoiseConfigParser
 * JD-Core Version:    0.7.0.1
 */