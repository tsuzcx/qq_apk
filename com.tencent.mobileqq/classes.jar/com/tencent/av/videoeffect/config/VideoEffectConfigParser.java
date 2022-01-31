package com.tencent.av.videoeffect.config;

import android.os.Build.VERSION;
import com.tencent.av.config.ConfigBaseParser;
import com.tencent.av.utils.ArrayUtils;
import com.tencent.qphone.base.util.QLog;

public class VideoEffectConfigParser
  extends ConfigBaseParser
{
  public static String a = "sharp/video_effect/";
  public static String b = a + "test/";
  public static String c = "min_sdk";
  public static String d = "disable_sdk";
  public static String e = "flag";
  public static String f = b + c;
  public static String g = b + d;
  public static String h = b + e;
  
  public VideoEffectConfigParser(String paramString)
  {
    super(paramString);
  }
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoEffectConfigParser", 2, "getVideoEffectTestFlag sdk: " + Build.VERSION.SDK_INT);
    }
    try
    {
      int[] arrayOfInt = a(h);
      if (arrayOfInt != null)
      {
        if ((arrayOfInt[0] & 0x1) != 1) {
          return 0;
        }
        arrayOfInt = a(f);
        if ((arrayOfInt != null) && (Build.VERSION.SDK_INT >= arrayOfInt[0]))
        {
          boolean bool = ArrayUtils.a(a(g), Build.VERSION.SDK_INT);
          if (!bool) {
            return 1;
          }
        }
      }
    }
    catch (Exception localException) {}
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.videoeffect.config.VideoEffectConfigParser
 * JD-Core Version:    0.7.0.1
 */