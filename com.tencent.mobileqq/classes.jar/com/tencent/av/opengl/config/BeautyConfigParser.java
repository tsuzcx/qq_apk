package com.tencent.av.opengl.config;

import android.text.TextUtils;
import com.tencent.av.config.ConfigBaseParser;
import com.tencent.av.config.ConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class BeautyConfigParser
  extends ConfigBaseParser
{
  private static BeautyConfigParser a;
  
  public BeautyConfigParser(String paramString)
  {
    super(paramString);
  }
  
  public static BeautyConfigParser a()
  {
    if (a != null) {
      return a;
    }
    try
    {
      Object localObject = ConfigInfo.instance().getSharpConfigPayloadFromFile();
      if (QLog.isColorLevel()) {
        QLog.i("BeautyConfigParser", 2, "BeautyConfigParser mData: " + (String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        a = new BeautyConfigParser((String)localObject);
        localObject = a;
        return localObject;
      }
    }
    catch (Exception localException) {}
    return null;
  }
  
  public float a()
  {
    float f;
    try
    {
      f = Float.parseFloat(a("sharp/beauty_3/ratio", "1.0"));
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
    return a("sharp/beauty_3/flag", 0) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.opengl.config.BeautyConfigParser
 * JD-Core Version:    0.7.0.1
 */