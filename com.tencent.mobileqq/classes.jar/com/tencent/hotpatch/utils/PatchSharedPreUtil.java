package com.tencent.hotpatch.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PatchSharedPreUtil
{
  public static int a(Context paramContext)
  {
    return paramContext.getSharedPreferences("hotpatch_preference", 0).getInt("key_config_version_patch", 0);
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences("hotpatch_preference", 0).getInt("key_count_fail_install_patch_" + paramString1 + paramString2, 0);
  }
  
  public static long a(Context paramContext)
  {
    return paramContext.getSharedPreferences("hotpatch_preference", 0).getLong("key_time_pull_patch_reconnect", 0L);
  }
  
  public static String a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("hotpatch_preference", 4).getString("key_config_patch_" + paramString, null);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("hotpatch_preference", 0).edit();
    paramContext.putInt("key_config_version_patch", paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    paramContext = paramContext.getSharedPreferences("hotpatch_preference", 0).edit();
    paramContext.putLong("key_time_pull_patch_reconnect", paramLong);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("hotpatch_preference", 4).edit();
    paramContext.putString("key_config_patch_" + paramString1, paramString2);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("hotpatch_preference", 0).edit();
    paramContext.putInt("key_count_fail_install_patch_" + paramString1 + paramString2, paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("hotpatch_preference", 4).edit();
    paramContext.putBoolean("key_verify_status_patch_" + paramString, paramBoolean);
    paramContext.commit();
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("hotpatch_preference", 4).getBoolean("key_verify_status_patch_" + paramString, false);
  }
  
  public static int b(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences("hotpatch_preference", 0).getInt("key_count_fail_startup_patch_" + paramString1 + paramString2, 0);
  }
  
  public static String b(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("hotpatch_preference", 0).getString(paramString, null);
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("hotpatch_preference", 0).edit();
    paramContext.putString(paramString1, paramString2);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("hotpatch_preference", 0).edit();
    paramContext.putInt("key_count_fail_startup_patch_" + paramString1 + paramString2, paramInt);
    paramContext.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.hotpatch.utils.PatchSharedPreUtil
 * JD-Core Version:    0.7.0.1
 */