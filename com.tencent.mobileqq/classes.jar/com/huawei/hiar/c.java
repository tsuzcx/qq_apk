package com.huawei.hiar;

import android.os.Build;
import android.text.TextUtils;

class c
{
  private static String a = "";
  private static String b = "111111";
  private static String c = "";
  
  static String a()
  {
    if (TextUtils.isEmpty(c)) {
      c = Build.MODEL;
    }
    return c;
  }
  
  static String b()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hiar.c
 * JD-Core Version:    0.7.0.1
 */