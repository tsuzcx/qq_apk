package com.tencent.av.opengl.effects;

import com.tencent.av.AVLog;
import com.tencent.av.opengl.config.LowlightAndVideoDenoiseConfigParser;

public class LowlightAndDenoiseTools
{
  private static float jdField_a_of_type_Float = -1.0F;
  private static int jdField_a_of_type_Int;
  private static int b;
  
  public static float a()
  {
    if (jdField_a_of_type_Float != -1.0F) {
      return jdField_a_of_type_Float;
    }
    for (;;)
    {
      try
      {
        LowlightAndVideoDenoiseConfigParser localLowlightAndVideoDenoiseConfigParser = LowlightAndVideoDenoiseConfigParser.a();
        if (localLowlightAndVideoDenoiseConfigParser == null) {
          continue;
        }
        jdField_a_of_type_Float = localLowlightAndVideoDenoiseConfigParser.a();
        AVLog.c("LowlightAndDenoiseTools", "mVideoDenoiseRatio:" + jdField_a_of_type_Float);
      }
      catch (Exception localException)
      {
        AVLog.c("LowlightAndDenoiseTools", "getVideoDenoiseRatio Exception:" + localException);
        jdField_a_of_type_Float = 15.0F;
        continue;
      }
      return jdField_a_of_type_Float;
      jdField_a_of_type_Float = 15.0F;
    }
  }
  
  public static boolean a()
  {
    if (jdField_a_of_type_Int != 0) {
      return jdField_a_of_type_Int == 2;
    }
    for (;;)
    {
      try
      {
        LowlightAndVideoDenoiseConfigParser localLowlightAndVideoDenoiseConfigParser = LowlightAndVideoDenoiseConfigParser.a();
        if ((localLowlightAndVideoDenoiseConfigParser == null) || (!localLowlightAndVideoDenoiseConfigParser.a())) {
          continue;
        }
        jdField_a_of_type_Int = 2;
        AVLog.c("LowlightAndDenoiseTools", "mIsSupportLowlightFlag:" + jdField_a_of_type_Int);
      }
      catch (Exception localException)
      {
        AVLog.c("LowlightAndDenoiseTools", "is SupportLowlightFlag Excpetion: " + localException);
        jdField_a_of_type_Int = 1;
        continue;
      }
      if (jdField_a_of_type_Int == 2) {
        break;
      }
      return false;
      jdField_a_of_type_Int = 1;
    }
  }
  
  public static boolean b()
  {
    if (b != 0) {
      return b == 2;
    }
    for (;;)
    {
      try
      {
        LowlightAndVideoDenoiseConfigParser localLowlightAndVideoDenoiseConfigParser = LowlightAndVideoDenoiseConfigParser.a();
        if ((localLowlightAndVideoDenoiseConfigParser == null) || (!localLowlightAndVideoDenoiseConfigParser.b())) {
          continue;
        }
        b = 2;
        AVLog.c("LowlightAndDenoiseTools", "mIsSupportVideoDenoise: " + b);
      }
      catch (Exception localException)
      {
        AVLog.c("LowlightAndDenoiseTools", "is SupportVideoDenoise Excpetion: " + localException);
        b = 1;
        continue;
      }
      if (b == 2) {
        break;
      }
      return false;
      b = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.opengl.effects.LowlightAndDenoiseTools
 * JD-Core Version:    0.7.0.1
 */