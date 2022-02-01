package com.tencent.ark.open;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.ark.Logger;
import java.io.File;

public class ArkUtil
{
  private static final String TAG = "ArkApp.ArkUtil";
  public static volatile boolean sARMv7Compatible = false;
  
  static
  {
    String str1 = Build.CPU_ABI;
    String str2 = Build.CPU_ABI2;
    if ((checkCPUABIStringV7(str1).booleanValue()) || (checkCPUABIStringV7(str2).booleanValue())) {
      sARMv7Compatible = true;
    }
    if ((sARMv7Compatible) && (Build.MODEL.contains("Android SDK built for x86")))
    {
      sARMv7Compatible = false;
      Logger.logI("ArkApp.ArkUtil", new Object[] { "sARMv7Compatible set false for MODEL: ", Build.MODEL });
    }
  }
  
  public static void assertTrue(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new AssertionError();
  }
  
  private static Boolean checkCPUABIStringV7(String paramString)
  {
    boolean bool;
    if ((!paramString.equalsIgnoreCase("armeabi-v7a")) && (!paramString.equalsIgnoreCase("arm64-v8a"))) {
      bool = false;
    } else {
      bool = true;
    }
    return Boolean.valueOf(bool);
  }
  
  public static void checkVersion(boolean paramBoolean)
  {
    if ((sARMv7Compatible) && (Build.MODEL.contains("Android SDK built for x86")) && (!paramBoolean))
    {
      sARMv7Compatible = false;
      Logger.logI("ArkApp.ArkUtil", new Object[] { "checkVersion sARMv7Compatible set false for MODEL: ", Build.MODEL, ",isdebug=", Boolean.valueOf(paramBoolean) });
    }
  }
  
  public static void createDir(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      Logger.logE("ArkApp.ArkUtil", "create dir path is empty");
      return;
    }
    File localFile = new File(paramString);
    if ((localFile.exists()) && (localFile.isFile()))
    {
      Logger.logE("ArkApp.ArkUtil", new Object[] { "create dir find dir path is file need to delte, path = ", paramString });
      localFile.delete();
    }
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  public static void delete(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return;
    }
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return;
    }
    if (paramString.isFile())
    {
      paramString.delete();
      return;
    }
    File[] arrayOfFile = paramString.listFiles();
    if (arrayOfFile == null) {
      return;
    }
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      delete(arrayOfFile[i].getAbsolutePath(), paramBoolean);
      i += 1;
    }
    if (!paramBoolean) {
      paramString.delete();
    }
  }
  
  public static boolean fileExists(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  public static String filterKeyForLog(String paramString, String... paramVarArgs)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return paramString.replaceAll("((?i)sid|uin|sec_sig|MOBINFO)=[^&#]+", "$1=****");
  }
  
  public static boolean isDeviceSupportArkMsg()
  {
    return sARMv7Compatible;
  }
  
  public static boolean rename(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return false;
      }
      paramString1 = new File(paramString1);
      bool1 = bool2;
      if (paramString1.exists()) {
        bool1 = paramString1.renameTo(new File(paramString2));
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.ArkUtil
 * JD-Core Version:    0.7.0.1
 */