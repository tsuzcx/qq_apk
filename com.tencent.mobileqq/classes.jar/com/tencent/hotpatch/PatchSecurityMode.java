package com.tencent.hotpatch;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PatchSecurityMode
{
  public static void a(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("hotpatch_preference", 0);
    SharedPreferences.Editor localEditor = paramContext.edit();
    int i = paramContext.getInt("key_count_start_fail_to_security", 0);
    if (i >= 5)
    {
      localEditor.putBoolean("key_patch_security_mode", true).commit();
      return;
    }
    localEditor.putInt("key_count_start_fail_to_security", i + 1).commit();
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("hotpatch_preference", 0).edit();
    paramContext.putInt("key_count_start_fail_to_security", paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = paramContext.getSharedPreferences("hotpatch_preference", 0);
    int i = ((SharedPreferences)localObject).getInt("key_count_crash_to_security" + paramString1, 0);
    paramContext = ((SharedPreferences)localObject).getString("key_crash_info_to_security" + paramString1, "");
    long l = ((SharedPreferences)localObject).getLong("key_time_crash_to_security" + paramString1, 0L);
    localObject = ((SharedPreferences)localObject).edit();
    if (paramContext.equals(paramString2)) {
      if (Math.abs(System.currentTimeMillis() - l) > 21600000L)
      {
        ((SharedPreferences.Editor)localObject).putInt("key_count_crash_to_security" + paramString1, 1);
        ((SharedPreferences.Editor)localObject).putLong("key_time_crash_to_security" + paramString1, System.currentTimeMillis());
      }
    }
    for (;;)
    {
      ((SharedPreferences.Editor)localObject).commit();
      return;
      if (i > 3)
      {
        ((SharedPreferences.Editor)localObject).putBoolean("key_patch_security_mode", true);
      }
      else
      {
        ((SharedPreferences.Editor)localObject).putInt("key_count_crash_to_security" + paramString1, i + 1);
        continue;
        ((SharedPreferences.Editor)localObject).putInt("key_count_crash_to_security" + paramString1, 1);
        ((SharedPreferences.Editor)localObject).putString("key_crash_info_to_security" + paramString1, paramString2);
        ((SharedPreferences.Editor)localObject).putLong("key_time_crash_to_security" + paramString1, System.currentTimeMillis());
      }
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("hotpatch_preference", 4).edit();
    paramContext.putBoolean("key_patch_security_mode", paramBoolean);
    paramContext.commit();
  }
  
  public static boolean a(Context paramContext)
  {
    return paramContext.getSharedPreferences("hotpatch_preference", 4).getBoolean("key_patch_security_mode", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.hotpatch.PatchSecurityMode
 * JD-Core Version:    0.7.0.1
 */