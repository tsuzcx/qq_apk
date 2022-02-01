package com.tencent.av.videoeffect.config;

import android.os.Build.VERSION;
import com.tencent.av.config.ConfigBaseParser;
import com.tencent.avcore.util.ArrayUtils;
import com.tencent.qphone.base.util.QLog;

public class VideoEffectConfigParser
{
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public static String f = b + c;
  public static String g = b + d;
  public static String h = b + e;
  @Deprecated
  ConfigBaseParser a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "sharp/video_effect/";
    b = jdField_a_of_type_JavaLangString + "test/";
    c = "min_sdk";
    d = "disable_sdk";
    e = "flag";
    f = null;
    g = null;
    h = null;
  }
  
  public VideoEffectConfigParser()
  {
    this.jdField_a_of_type_ComTencentAvConfigConfigBaseParser = null;
  }
  
  public int a(ConfigBaseParser paramConfigBaseParser)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoEffectConfigParser", 2, "getVideoEffectTestFlag sdk: " + Build.VERSION.SDK_INT);
    }
    try
    {
      int[] arrayOfInt = paramConfigBaseParser.a(h);
      if (arrayOfInt != null)
      {
        if ((arrayOfInt[0] & 0x1) != 1) {
          return 0;
        }
        arrayOfInt = paramConfigBaseParser.a(f);
        if ((arrayOfInt != null) && (Build.VERSION.SDK_INT >= arrayOfInt[0]))
        {
          boolean bool = ArrayUtils.contains(paramConfigBaseParser.a(g), Build.VERSION.SDK_INT);
          if (!bool) {
            return 1;
          }
        }
      }
    }
    catch (Exception paramConfigBaseParser) {}
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.videoeffect.config.VideoEffectConfigParser
 * JD-Core Version:    0.7.0.1
 */