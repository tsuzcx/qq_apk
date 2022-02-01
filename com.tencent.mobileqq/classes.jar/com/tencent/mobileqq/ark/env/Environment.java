package com.tencent.mobileqq.ark.env;

import android.os.Build;
import java.io.File;

public final class Environment
{
  public static volatile boolean a = false;
  public static volatile boolean b = false;
  
  static
  {
    if (Build.MODEL.contains("Android SDK built for x86")) {
      b = true;
    }
    String str1 = Build.CPU_ABI;
    String str2 = Build.CPU_ABI2;
    if ((!b) && ((a(str1).booleanValue()) || (a(str2).booleanValue()))) {
      a = true;
    }
  }
  
  private static Boolean a(String paramString)
  {
    boolean bool;
    if ((!paramString.equalsIgnoreCase("armeabi-v7a")) && (!paramString.equalsIgnoreCase("arm64-v8a"))) {
      bool = false;
    } else {
      bool = true;
    }
    return Boolean.valueOf(bool);
  }
  
  public static String a()
  {
    String str = ArkAppEnvConfig.a().d();
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.env.Environment
 * JD-Core Version:    0.7.0.1
 */