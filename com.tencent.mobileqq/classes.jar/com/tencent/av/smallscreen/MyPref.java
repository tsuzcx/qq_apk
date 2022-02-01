package com.tencent.av.smallscreen;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class MyPref
{
  public static int a(Context paramContext, String paramString, int paramInt)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString, paramInt);
  }
  
  public static long a(Context paramContext, String paramString, long paramLong)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong(paramString, paramLong);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putInt(paramString, paramInt).commit();
  }
  
  public static void a(Context paramContext, String paramString, long paramLong)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong(paramString, paramLong).commit();
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putBoolean(paramString, paramBoolean).commit();
  }
  
  public static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.smallscreen.MyPref
 * JD-Core Version:    0.7.0.1
 */