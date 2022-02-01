package com.tencent.biz.pubaccount.weishi_new.util;

import cooperation.qzone.LocalMultiProcConfig;
import org.jetbrains.annotations.NotNull;

public class WSSharePreferencesUtil
{
  @NotNull
  private static String a()
  {
    if (WeishiUtils.b() != 0L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("weishi_usergrowth");
      localStringBuilder.append(WeishiUtils.c());
      return localStringBuilder.toString();
    }
    return "weishi_usergrowth";
  }
  
  @NotNull
  private static String a(String paramString)
  {
    return paramString;
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
  
  public static int b(String paramString, int paramInt)
  {
    return LocalMultiProcConfig.getInt("weishi_usergrowth", paramString, paramInt);
  }
  
  public static long b(String paramString, long paramLong)
  {
    return LocalMultiProcConfig.getLong("weishi_usergrowth", paramString, paramLong);
  }
  
  public static String b(String paramString1, String paramString2)
  {
    return LocalMultiProcConfig.getString("weishi_usergrowth", paramString1, paramString2);
  }
  
  public static boolean b(String paramString, boolean paramBoolean)
  {
    return LocalMultiProcConfig.getBool(a(), a(paramString), paramBoolean);
  }
  
  public static void c(String paramString, int paramInt)
  {
    LocalMultiProcConfig.putInt(a(), a(paramString), paramInt);
  }
  
  public static int d(String paramString, int paramInt)
  {
    return LocalMultiProcConfig.getInt(a(), a(paramString), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSSharePreferencesUtil
 * JD-Core Version:    0.7.0.1
 */