package com.tencent.hotpatch.utils;

import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.File;

public class PatchCommonUtil
{
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "/data/data/com.tencent.mobileqq/files/hotpatch";
    }
    return "/data/data/com.tencent.mobileqq/files/hotpatch" + File.separator + paramString;
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT <= 20;
  }
  
  public static boolean b()
  {
    return (Build.VERSION.SDK_INT >= 21) && (Build.VERSION.SDK_INT <= 23);
  }
  
  public static boolean c()
  {
    return Build.VERSION.SDK_INT >= 24;
  }
  
  public static boolean d()
  {
    return Build.VERSION.SDK_INT >= 26;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.hotpatch.utils.PatchCommonUtil
 * JD-Core Version:    0.7.0.1
 */