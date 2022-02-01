package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import android.text.TextUtils;
import com.tencent.mobileqq.scribble.ScribbleMsgUtils;

public class DrawRedbagMsgUtils
{
  public static int a;
  public static final String a;
  public static int b = 2;
  public static int c = 3;
  public static int d = 4;
  public static int e = 5;
  
  static
  {
    jdField_a_of_type_JavaLangString = ScribbleMsgUtils.a();
    jdField_a_of_type_Int = 1;
  }
  
  private static String c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return jdField_a_of_type_JavaLangString + paramString;
    }
    return "";
  }
  
  private static String d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return jdField_a_of_type_JavaLangString + paramString + "_data";
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedbagMsgUtils
 * JD-Core Version:    0.7.0.1
 */