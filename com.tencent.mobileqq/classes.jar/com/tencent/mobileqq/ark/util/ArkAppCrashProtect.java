package com.tencent.mobileqq.ark.util;

import android.text.TextUtils;
import com.tencent.mobileqq.ark.env.Environment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class ArkAppCrashProtect
{
  private static boolean a = false;
  
  public static void a()
  {
    try
    {
      a = true;
      Object localObject1 = Environment.a();
      if (QLog.isColorLevel()) {
        QLog.e("ArkApp.CrashProtect", 2, "profiling clearAllCrashProtectedMark");
      }
      localObject1 = new File((String)localObject1).listFiles();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject3 = localObject1[i];
          String str = localObject3.getName();
          if ((str != null) && (str.contains(".crash_file")))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ArkApp.CrashProtect", 2, new Object[] { "profiling clearCrashProtectedMark app=", str });
            }
            localObject3.delete();
          }
          i += 1;
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      boolean bool2 = a;
      boolean bool1 = false;
      if ((!bool2) && (!TextUtils.isEmpty(paramString)))
      {
        String str = d(paramString);
        if (QLog.isColorLevel()) {
          QLog.e("ArkApp.CrashProtect", 2, new Object[] { "profiling setCrashProtectedMark appname=", paramString, ",filePath=", str });
        }
        paramString = new File(str);
        try
        {
          bool2 = paramString.createNewFile();
          bool1 = bool2;
        }
        catch (IOException paramString)
        {
          QLog.d("ArkApp.CrashProtect", 1, "createFile exception", paramString);
        }
        return bool1;
      }
      return false;
    }
    finally {}
  }
  
  public static boolean b(String paramString)
  {
    try
    {
      if ((!a) && (!TextUtils.isEmpty(paramString)))
      {
        String str = d(paramString);
        if (QLog.isColorLevel()) {
          QLog.e("ArkApp.CrashProtect", 2, new Object[] { "profiling clearCrashProtectedMark appname=", paramString, ",filePath=", str });
        }
        boolean bool = new File(str).delete();
        return bool;
      }
      return false;
    }
    finally {}
  }
  
  public static boolean c(String paramString)
  {
    try
    {
      boolean bool2 = a;
      boolean bool1 = false;
      if ((!bool2) && (!TextUtils.isEmpty(paramString)))
      {
        String str = d(paramString);
        if (QLog.isColorLevel()) {
          QLog.e("ArkApp.CrashProtect", 2, new Object[] { "profiling isAppCrash appname=", paramString, ",filePath=", str });
        }
        if (new File(str).exists())
        {
          QLog.e("ArkApp.CrashProtect", 1, new Object[] { "profiling find preload crashed app=", paramString, ",filePath=", str });
          bool1 = true;
        }
        return bool1;
      }
      return false;
    }
    finally {}
  }
  
  private static String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(Environment.a());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append(".crash_file");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.util.ArkAppCrashProtect
 * JD-Core Version:    0.7.0.1
 */