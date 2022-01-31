package com.sixgod.pluginsdk.log;

import android.util.Log;

public class SGLog
{
  public static ISixGodLog a = null;
  
  public static final void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (a != null)
    {
      a.d("SixGod_PluginSdk", paramString);
      return;
    }
    Log.d("SixGod_PluginSdk", paramString);
  }
  
  public static final void a(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      return;
    }
    if (a != null)
    {
      a.d(paramString1, paramString2);
      return;
    }
    Log.d(paramString1, paramString2);
  }
  
  public static final void b(String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (a != null)
    {
      a.e("SixGod_PluginSdk", paramString);
      return;
    }
    Log.e("SixGod_PluginSdk", paramString);
  }
  
  public static final void b(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      return;
    }
    if (a != null)
    {
      a.e(paramString1, paramString2);
      return;
    }
    Log.e(paramString1, paramString2);
  }
  
  public static final void c(String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (a != null)
    {
      a.w("SixGod_PluginSdk", paramString);
      return;
    }
    Log.w("SixGod_PluginSdk", paramString);
  }
  
  public static final void c(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      return;
    }
    if (a != null)
    {
      a.w(paramString1, paramString2);
      return;
    }
    Log.w(paramString1, paramString2);
  }
  
  public static void init(ISixGodLog paramISixGodLog)
  {
    a = paramISixGodLog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.log.SGLog
 * JD-Core Version:    0.7.0.1
 */