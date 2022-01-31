package com.tencent.biz.qqstory.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;

public class ThumbnailUrlHelper
{
  public static int a;
  public static String a;
  public static final int[] a;
  public static String b;
  public static final int[] b;
  public static String c = Integer.toString(jdField_a_of_type_ArrayOfInt[0]);
  public static String d = Integer.toString(jdField_a_of_type_ArrayOfInt[1]);
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 120, 200, 320, 512, 640, 750, 1000 };
    jdField_b_of_type_ArrayOfInt = new int[] { 40, 60, 80, 100, 120, 140, 160, 200 };
  }
  
  public static int a(int paramInt)
  {
    int j = 2147483647;
    int m = jdField_a_of_type_ArrayOfInt.length - 1;
    int i = 0;
    while (i < jdField_a_of_type_ArrayOfInt.length)
    {
      int n = Math.abs(jdField_a_of_type_ArrayOfInt[i] - paramInt);
      int k = j;
      if (n <= j)
      {
        m = i;
        k = n;
      }
      i += 1;
      j = k;
    }
    return jdField_a_of_type_ArrayOfInt[m];
  }
  
  public static String a(Context paramContext, String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (!b(paramString));
    paramString = d(paramString);
    if (jdField_a_of_type_JavaLangString == null)
    {
      jdField_a_of_type_Int = a(UIUtils.a(paramContext));
      jdField_a_of_type_JavaLangString = String.valueOf(jdField_a_of_type_Int);
      SLog.b("Q.qqstory.home.ThumbnailUrlHelper", "full screen thumbnail size: %s", jdField_a_of_type_JavaLangString);
    }
    if (jdField_a_of_type_JavaLangString == null)
    {
      SLog.d("Q.qqstory.home.ThumbnailUrlHelper", "can not find suitable size for full screen");
      return paramString + 0;
    }
    return paramString + jdField_a_of_type_JavaLangString;
  }
  
  public static String a(String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      if (a(paramString))
      {
        paramString = d(paramString);
        return paramString + c;
      }
      str = paramString;
    } while (!b(paramString));
    paramString = d(paramString);
    return paramString + jdField_b_of_type_ArrayOfInt[4];
  }
  
  public static boolean a(@NonNull String paramString)
  {
    if ((paramString.length() >= "https://p.qpic.cn".length() + "/qqstory_pic/".length()) && (paramString.startsWith("/qqstory_pic/", "https://p.qpic.cn".length()))) {
      return true;
    }
    return paramString.contains("/qqstory_pic/");
  }
  
  public static String b(Context paramContext, String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (!a(paramString));
    paramString = d(paramString);
    if (jdField_b_of_type_JavaLangString == null)
    {
      jdField_b_of_type_JavaLangString = String.valueOf(a(UIUtils.a(paramContext) / 4));
      SLog.b("Q.qqstory.home.ThumbnailUrlHelper", "1/4 thumbnail size: %s", jdField_b_of_type_JavaLangString);
    }
    if (jdField_b_of_type_JavaLangString == null)
    {
      SLog.d("Q.qqstory.home.ThumbnailUrlHelper", "can not find suitable size for 1/4 screen");
      return paramString + 0;
    }
    return paramString + jdField_b_of_type_JavaLangString;
  }
  
  public static String b(String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      if (a(paramString))
      {
        paramString = d(paramString);
        return paramString + d;
      }
      str = paramString;
    } while (!b(paramString));
    paramString = d(paramString);
    return paramString + jdField_b_of_type_ArrayOfInt[7];
  }
  
  public static boolean b(@NonNull String paramString)
  {
    if ((paramString.length() >= "https://p.qpic.cn".length() + "/qqstory/".length()) && (paramString.startsWith("/qqstory/", "https://p.qpic.cn".length()))) {
      return true;
    }
    return paramString.contains("/qqstory/");
  }
  
  public static String c(String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      if (a(paramString))
      {
        paramString = d(paramString);
        return paramString + Integer.toString(jdField_a_of_type_ArrayOfInt[2]);
      }
      str = paramString;
    } while (!b(paramString));
    paramString = d(paramString);
    return paramString + jdField_b_of_type_ArrayOfInt[7];
  }
  
  public static String d(String paramString)
  {
    if (paramString.endsWith("/")) {
      return paramString;
    }
    int k = paramString.lastIndexOf("/");
    String str;
    int j;
    if ((k >= 0) && (k < paramString.length() - 1))
    {
      str = paramString.substring(k + 1, paramString.length());
      j = str.length() - 1;
      i = 0;
      if (j >= 0) {
        if (Character.isDigit(str.charAt(j))) {
          break label109;
        }
      }
    }
    for (int i = 0;; i = 0)
    {
      str = paramString;
      if (i != 0) {
        str = paramString.substring(0, k);
      }
      return str + "/";
      label109:
      j -= 1;
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ThumbnailUrlHelper
 * JD-Core Version:    0.7.0.1
 */