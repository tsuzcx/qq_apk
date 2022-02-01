package com.tencent.map.sdk.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public abstract class gc
{
  protected SharedPreferences a = null;
  
  public final String a(String paramString)
  {
    SharedPreferences localSharedPreferences = this.a;
    if (localSharedPreferences == null) {
      return null;
    }
    return localSharedPreferences.getString(paramString, null);
  }
  
  public final boolean a()
  {
    return a(new String[] { "mapConfigVersion", "poiIconVersion", "mapIconVersion", "rttConfigVersion", "mapConfigIndoorVersion", "mapPoiIcon3dIndoorVersion", "closeRoadSytleNomalModeVersion", "closeRoadStyleTrafficModeVersion", "offlineCityListVersion", "mapConfigZipMd5", "mapPoiIconZipMd5", "mapIconZipMd5", "rttConfigMd5", "mapConfigIndoorMd5", "poiIcon3dIndoorMd5", "closeRoadSytleNomalModeMd5", "closeRoadStyleTrafficModeMd5", "offlineCityListMd5" });
  }
  
  public final boolean a(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = this.a;
    if (localSharedPreferences == null) {
      return false;
    }
    return localSharedPreferences.edit().putInt(paramString, paramInt).commit();
  }
  
  public final boolean a(String paramString, long paramLong)
  {
    SharedPreferences localSharedPreferences = this.a;
    if (localSharedPreferences == null) {
      return false;
    }
    return localSharedPreferences.edit().putLong(paramString, paramLong).commit();
  }
  
  public final boolean a(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = this.a;
    if (localSharedPreferences == null) {
      return false;
    }
    return localSharedPreferences.edit().putString(paramString1, paramString2).commit();
  }
  
  public final boolean a(String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = this.a;
    if (localSharedPreferences == null) {
      return false;
    }
    return localSharedPreferences.edit().putBoolean(paramString, paramBoolean).commit();
  }
  
  public final boolean a(String[] paramArrayOfString)
  {
    Object localObject = this.a;
    int i = 0;
    if (localObject == null) {
      return false;
    }
    localObject = ((SharedPreferences)localObject).edit();
    int j = paramArrayOfString.length;
    while (i < j)
    {
      ((SharedPreferences.Editor)localObject).remove(paramArrayOfString[i]);
      i += 1;
    }
    return ((SharedPreferences.Editor)localObject).commit();
  }
  
  public final int b(String paramString)
  {
    SharedPreferences localSharedPreferences = this.a;
    if (localSharedPreferences == null) {
      return -1;
    }
    return localSharedPreferences.getInt(paramString, -1);
  }
  
  public final String b()
  {
    int i = b("mapConfigVersion");
    String str4 = a("mapConfigZipMd5");
    int j = b("mapConfigIndoorPremiumVersion");
    Object localObject = a("mapConfigIndoorPremiumMd5");
    String str2 = String.valueOf(b("mapConfigIndoorVersion"));
    String str3 = a("mapConfigIndoorMd5");
    String str1;
    if (!nl.a((String)localObject))
    {
      str2 = String.valueOf(j);
      str1 = "indoormap_config_premium";
    }
    else
    {
      str1 = "indoormap_config";
      localObject = str3;
    }
    return String.format("mapconfig-%s-%s,%s-%s-%s", new Object[] { String.valueOf(i), str4, str1, str2, localObject });
  }
  
  public final boolean c(String paramString)
  {
    SharedPreferences localSharedPreferences = this.a;
    if (localSharedPreferences == null) {
      return false;
    }
    return localSharedPreferences.getBoolean(paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.gc
 * JD-Core Version:    0.7.0.1
 */