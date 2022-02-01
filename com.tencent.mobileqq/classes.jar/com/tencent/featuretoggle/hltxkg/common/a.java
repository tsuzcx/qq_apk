package com.tencent.featuretoggle.hltxkg.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import com.tencent.featuretoggle.hltxkg.HalleyInitParam;
import com.tencent.featuretoggle.hltxkg.common.e.c;

public final class a
{
  private static int jdField_a_of_type_Int = 0;
  private static Context jdField_a_of_type_AndroidContentContext;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  public static String a = "null";
  private static boolean jdField_a_of_type_Boolean = false;
  public static String b = "";
  private static boolean b = false;
  public static int c = 0;
  private static String jdField_c_of_type_JavaLangString = "";
  private static boolean jdField_c_of_type_Boolean = false;
  public static String d = "";
  public static String e;
  private static String f = "3.5.9.1";
  public static volatile boolean f = false;
  private static String g = "";
  public static boolean g = true;
  private static String h = "";
  public static boolean h = false;
  
  public static Context a()
  {
    return jdField_a_of_type_AndroidContentContext;
  }
  
  public static void a(boolean paramBoolean, int paramInt1, HalleyInitParam paramHalleyInitParam, String paramString, int paramInt2)
  {
    jdField_h_of_type_Boolean = paramHalleyInitParam.maskDeviceInfo;
    jdField_c_of_type_Boolean = paramBoolean;
    Process.myPid();
    Context localContext = paramHalleyInitParam.getContext();
    jdField_a_of_type_AndroidContentContext = localContext.getApplicationContext();
    jdField_c_of_type_JavaLangString = localContext.getPackageName();
    jdField_a_of_type_Int = paramInt1;
    jdField_a_of_type_Boolean = paramHalleyInitParam.isSDKMode();
    String str2 = paramHalleyInitParam.getUuid();
    String str1 = str2;
    if (c.a(str2)) {
      str1 = "";
    }
    d = str1;
    c.a(paramHalleyInitParam.getChannelid());
    f = "3.5.9.1";
    new Handler(jdField_a_of_type_AndroidContentContext.getMainLooper());
    try
    {
      paramHalleyInitParam = localContext.getPackageManager().getPackageInfo(localContext.getPackageName(), 0);
      jdField_a_of_type_JavaLangString = paramHalleyInitParam.versionName;
      paramInt1 = paramHalleyInitParam.versionCode;
      label129:
      g = paramString;
      b = jdField_c_of_type_JavaLangString.equals(g);
      paramHalleyInitParam = new StringBuilder("halley_");
      paramHalleyInitParam.append(jdField_a_of_type_Int);
      paramHalleyInitParam.append("_");
      paramHalleyInitParam.append("TempTask");
      paramHalleyInitParam = new HandlerThread(paramHalleyInitParam.toString(), 10);
      paramHalleyInitParam.start();
      paramHalleyInitParam = new Handler(paramHalleyInitParam.getLooper());
      jdField_a_of_type_AndroidOsHandler = paramHalleyInitParam;
      paramHalleyInitParam.post(new b());
      return;
    }
    catch (Throwable paramHalleyInitParam)
    {
      break label129;
    }
  }
  
  public static boolean b()
  {
    return jdField_c_of_type_Boolean;
  }
  
  public static int c()
  {
    return jdField_a_of_type_Int;
  }
  
  public static String d()
  {
    return jdField_c_of_type_JavaLangString;
  }
  
  public static boolean e()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static String f()
  {
    return f;
  }
  
  public static boolean g()
  {
    return b;
  }
  
  public static String h()
  {
    if (!c.a(jdField_h_of_type_JavaLangString)) {
      return jdField_h_of_type_JavaLangString;
    }
    if ((!c.a(g)) && (g.contains(":")))
    {
      int i = g.indexOf(":");
      return g.substring(i + 1);
    }
    return "";
  }
  
  public static Handler i()
  {
    return jdField_a_of_type_AndroidOsHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.a
 * JD-Core Version:    0.7.0.1
 */