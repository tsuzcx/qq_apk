package com.tencent.featuretoggle.utils;

import android.os.SystemClock;
import android.text.TextUtils;

public class RepeatEventUtil
{
  private static long a = ;
  private static String b = "";
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    long l = SystemClock.elapsedRealtime();
    if ((paramString.equals(b)) && (l - a <= 800L)) {
      return false;
    }
    a = l;
    b = paramString;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.utils.RepeatEventUtil
 * JD-Core Version:    0.7.0.1
 */