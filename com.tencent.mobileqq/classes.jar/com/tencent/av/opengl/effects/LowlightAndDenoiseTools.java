package com.tencent.av.opengl.effects;

import com.tencent.av.opengl.config.LowlightAndVideoDenoiseConfigParser;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class LowlightAndDenoiseTools
{
  private static float jdField_a_of_type_Float = -1.0F;
  private static int jdField_a_of_type_Int = -1;
  private static int b = -1;
  
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
        if (QLog.isColorLevel()) {
          QLog.w("LowlightAndDenoiseTools", 1, "getVideodenoiseRatio[" + jdField_a_of_type_Float + "]");
        }
      }
      catch (Exception localException)
      {
        QLog.w("LowlightAndDenoiseTools", 1, "getVideoDenoiseRatio, Excpetion", localException);
        jdField_a_of_type_Float = 15.0F;
        continue;
      }
      return jdField_a_of_type_Float;
      jdField_a_of_type_Float = 15.0F;
    }
  }
  
  static boolean a()
  {
    return EffectsRenderController.a(8, 1800000, -2147483648);
  }
  
  public static boolean b()
  {
    if (AudioHelper.a(12) == 1)
    {
      AudioHelper.a(HardCodeUtil.a(2131706407));
      return true;
    }
    if (AudioHelper.a(12) == 0)
    {
      AudioHelper.a(HardCodeUtil.a(2131706409));
      return true;
    }
    if (jdField_a_of_type_Int == -1) {}
    for (;;)
    {
      try
      {
        localLowlightAndVideoDenoiseConfigParser = LowlightAndVideoDenoiseConfigParser.a();
        if (localLowlightAndVideoDenoiseConfigParser == null) {
          continue;
        }
        if (!localLowlightAndVideoDenoiseConfigParser.a()) {
          continue;
        }
        jdField_a_of_type_Int = 1;
        i = 1;
      }
      catch (Exception localException)
      {
        LowlightAndVideoDenoiseConfigParser localLowlightAndVideoDenoiseConfigParser;
        QLog.w("LowlightAndDenoiseTools", 1, "isSupportLowlight, Excpetion", localException);
        jdField_a_of_type_Int = 0;
        continue;
        int i = 4;
        jdField_a_of_type_Int = 0;
        continue;
        i = 5;
        jdField_a_of_type_Int = 0;
        continue;
        i = 0;
        continue;
      }
      if (jdField_a_of_type_Int == -1)
      {
        if (!QAVConfigUtils.b()) {
          continue;
        }
        if (!a()) {
          continue;
        }
        i = 3;
        jdField_a_of_type_Int = 1;
      }
      if (QLog.isColorLevel()) {
        QLog.w("LowlightAndDenoiseTools", 1, "isSupportLowlight[" + jdField_a_of_type_Int + "], step[" + i + "]");
      }
      if (jdField_a_of_type_Int == 1) {
        break;
      }
      return false;
      if (!localLowlightAndVideoDenoiseConfigParser.b()) {
        continue;
      }
      i = 2;
      jdField_a_of_type_Int = 0;
    }
  }
  
  public static boolean c()
  {
    if (AudioHelper.a(12) == 1)
    {
      AudioHelper.a(HardCodeUtil.a(2131706406));
      return true;
    }
    if (AudioHelper.a(12) == 0)
    {
      AudioHelper.a(HardCodeUtil.a(2131706408));
      return true;
    }
    if (b == -1) {}
    try
    {
      localLowlightAndVideoDenoiseConfigParser = LowlightAndVideoDenoiseConfigParser.a();
      if (localLowlightAndVideoDenoiseConfigParser == null) {
        break label187;
      }
      if (!localLowlightAndVideoDenoiseConfigParser.c()) {
        break label145;
      }
      b = 1;
      jdField_a_of_type_Float = 25.0F;
      i = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LowlightAndVideoDenoiseConfigParser localLowlightAndVideoDenoiseConfigParser;
        label70:
        QLog.w("LowlightAndDenoiseTools", 1, "isSupportVideoDenoiseFlag, Excpetion", localException);
        b = 0;
        continue;
        int i = 0;
      }
    }
    if (b == -1)
    {
      if (!a()) {
        break label161;
      }
      b = 1;
    }
    for (i = 3;; i = 4)
    {
      if (QLog.isColorLevel()) {
        QLog.w("LowlightAndDenoiseTools", 1, "isSupportVideoDenoiseFlag[" + b + "], step[" + i + "]");
      }
      if (b == 1) {
        break;
      }
      return false;
      label145:
      if (!localLowlightAndVideoDenoiseConfigParser.d()) {
        break label187;
      }
      b = 0;
      i = 2;
      break label70;
      label161:
      b = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.effects.LowlightAndDenoiseTools
 * JD-Core Version:    0.7.0.1
 */