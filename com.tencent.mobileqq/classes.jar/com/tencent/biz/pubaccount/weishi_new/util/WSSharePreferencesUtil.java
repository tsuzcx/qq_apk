package com.tencent.biz.pubaccount.weishi_new.util;

import cooperation.qzone.LocalMultiProcConfig;
import org.jetbrains.annotations.NotNull;

public class WSSharePreferencesUtil
{
  public static int a(String paramString, int paramInt)
  {
    return LocalMultiProcConfig.getInt("weishi_usergrowth", paramString, paramInt);
  }
  
  public static long a(String paramString, long paramLong)
  {
    return LocalMultiProcConfig.getLong("weishi_usergrowth", paramString, paramLong);
  }
  
  @NotNull
  private static String a()
  {
    if (WeishiUtils.a() != 0L) {
      return "weishi_usergrowth" + WeishiUtils.a();
    }
    return "weishi_usergrowth";
  }
  
  @NotNull
  private static String a(String paramString)
  {
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return LocalMultiProcConfig.getString("weishi_usergrowth", paramString1, paramString2);
  }
  
  public static void a(String paramString, int paramInt)
  {
    LocalMultiProcConfig.putInt("weishi_usergrowth", paramString, paramInt);
  }
  
  public static void a(String paramString, long paramLong)
  {
    LocalMultiProcConfig.putLong("weishi_usergrowth", paramString, paramLong);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    LocalMultiProcConfig.putString("weishi_usergrowth", paramString1, paramString2);
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    LocalMultiProcConfig.putBool(a(), a(paramString), paramBoolean);
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    return LocalMultiProcConfig.getBool(a(), a(paramString), paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSSharePreferencesUtil
 * JD-Core Version:    0.7.0.1
 */