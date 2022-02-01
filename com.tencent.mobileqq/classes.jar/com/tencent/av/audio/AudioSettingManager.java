package com.tencent.av.audio;

import android.content.Context;
import android.media.AudioManager;
import java.lang.reflect.Method;

public class AudioSettingManager
{
  public static int a;
  static boolean a;
  static int b;
  public static boolean b;
  static int c;
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 0;
    c = 0;
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      paramContext = (AudioManager)paramContext.getSystemService("audio");
      boolean bool = Boolean.parseBoolean(paramContext.getClass().getMethod("isWiredHeadsetOn", new Class[0]).invoke(paramContext, (Object[])null).toString());
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.audio.AudioSettingManager
 * JD-Core Version:    0.7.0.1
 */