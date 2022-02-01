package com.tencent.component.network.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Preference
{
  private static final String CACHE_NAME;
  private static final String DEFAULT_NAME = "preference";
  private static final String GLOBAL = "global";
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Preference.class.getName());
    localStringBuilder.append("_cache");
    CACHE_NAME = localStringBuilder.toString();
  }
  
  public static SharedPreferences getGlobalPreference(Context paramContext, String paramString)
  {
    return getPreference(paramContext, 0L, paramString);
  }
  
  public static SharedPreferences getPreference(Context paramContext, long paramLong, String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      str = "preference";
    }
    paramString = new StringBuilder();
    paramString.append(paramContext.getPackageName());
    paramString.append("_");
    paramString.append("global");
    paramString.append("_");
    paramString.append(str);
    return paramContext.getSharedPreferences(paramString.toString(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.Preference
 * JD-Core Version:    0.7.0.1
 */