package com.tencent.biz.qqstory.app;

import android.annotation.TargetApi;
import com.tencent.mobileqq.app.AppConstants;

@TargetApi(14)
public class QQStoryConstant
{
  public static final String a;
  public static boolean a;
  public static final String b = jdField_a_of_type_JavaLangString + "debug/";
  public static final String c = jdField_a_of_type_JavaLangString + "upload/";
  public static final String d = c + ".music/";
  public static final String e = jdField_a_of_type_JavaLangString + ".tmp/";
  public static final String f = e + "download/preload/";
  public static final String g = e + "download/mine/";
  public static final String h = e + ".tmp/";
  public static final String i = h + "watermark/";
  public static final String j = h + "merge/";
  public static final String k = h + "audio/";
  public static final String l = h + "video/";
  public static final String m = h + "slideshow/";
  public static final String n = i + "source/";
  public static final String o = i + "doodle/";
  public static final String p = i + "composite/";
  public static final String q = i + "download/";
  
  static
  {
    jdField_a_of_type_Boolean = "V 7.6.3.3565".contains("r");
    jdField_a_of_type_JavaLangString = AppConstants.aJ + "qqstory/";
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 0: 
      return "VIDEO";
    case 1: 
      return "MASK_PIC";
    }
    return "THUMBNAIL";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.app.QQStoryConstant
 * JD-Core Version:    0.7.0.1
 */