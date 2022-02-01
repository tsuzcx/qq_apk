package com.tencent.featuretoggle.utils;

import android.os.SystemClock;
import android.text.TextUtils;

public class RepeatEventUtil
{
  private static long jdField_a_of_type_Long = ;
  private static String jdField_a_of_type_JavaLangString = "";
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    long l = SystemClock.elapsedRealtime();
    if ((paramString.equals(jdField_a_of_type_JavaLangString)) && (l - jdField_a_of_type_Long <= 800L)) {
      return false;
    }
    jdField_a_of_type_Long = l;
    jdField_a_of_type_JavaLangString = paramString;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.utils.RepeatEventUtil
 * JD-Core Version:    0.7.0.1
 */