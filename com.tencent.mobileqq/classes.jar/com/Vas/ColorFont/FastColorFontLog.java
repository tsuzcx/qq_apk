package com.Vas.ColorFont;

import android.os.Build;
import com.tencent.qphone.base.util.QLog;

public class FastColorFontLog
{
  private static float a;
  public static int a;
  public static final String a;
  private static float jdField_b_of_type_Float;
  private static int jdField_b_of_type_Int;
  public static final String b;
  private static float jdField_c_of_type_Float;
  private static int jdField_c_of_type_Int;
  private static float jdField_d_of_type_Float;
  private static int jdField_d_of_type_Int;
  private static float jdField_e_of_type_Float;
  private static int jdField_e_of_type_Int;
  private static float jdField_f_of_type_Float;
  private static int jdField_f_of_type_Int;
  
  static
  {
    jdField_a_of_type_JavaLangString = Build.MANUFACTURER;
    jdField_b_of_type_JavaLangString = Build.MODEL;
  }
  
  public static float a()
  {
    if (jdField_a_of_type_Int > 0) {
      return jdField_a_of_type_Float / jdField_a_of_type_Int;
    }
    return 0.0F;
  }
  
  public static void a(float paramFloat)
  {
    jdField_a_of_type_Int += 1;
    jdField_a_of_type_Float += paramFloat;
  }
  
  static void a(int paramInt, float paramFloat)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      jdField_b_of_type_Float += paramFloat;
      jdField_b_of_type_Int += 1;
      return;
    case 2: 
      jdField_c_of_type_Float += paramFloat;
      jdField_c_of_type_Int += 1;
      return;
    case 3: 
      jdField_d_of_type_Float += paramFloat;
      jdField_d_of_type_Int += 1;
      return;
    case 4: 
      jdField_e_of_type_Float += paramFloat;
      jdField_e_of_type_Int += 1;
      return;
    }
    jdField_f_of_type_Float += paramFloat;
    jdField_f_of_type_Int += 1;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2);
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    QLog.e(paramString1, 1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.Vas.ColorFont.FastColorFontLog
 * JD-Core Version:    0.7.0.1
 */