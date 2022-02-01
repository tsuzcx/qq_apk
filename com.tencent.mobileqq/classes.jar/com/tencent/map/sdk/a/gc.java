package com.tencent.map.sdk.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public abstract class gc
{
  protected SharedPreferences a = null;
  
  public final String a(String paramString)
  {
    if (this.a == null) {
      return null;
    }
    return this.a.getString(paramString, null);
  }
  
  public final boolean a()
  {
    return a(new String[] { "mapConfigVersion", "poiIconVersion", "mapIconVersion", "rttConfigVersion", "mapConfigIndoorVersion", "mapPoiIcon3dIndoorVersion", "closeRoadSytleNomalModeVersion", "closeRoadStyleTrafficModeVersion", "offlineCityListVersion", "mapConfigZipMd5", "mapPoiIconZipMd5", "mapIconZipMd5", "rttConfigMd5", "mapConfigIndoorMd5", "poiIcon3dIndoorMd5", "closeRoadSytleNomalModeMd5", "closeRoadStyleTrafficModeMd5", "offlineCityListMd5" });
  }
  
  public final boolean a(String paramString, int paramInt)
  {
    if (this.a == null) {
      return false;
    }
    return this.a.edit().putInt(paramString, paramInt).commit();
  }
  
  public final boolean a(String paramString, long paramLong)
  {
    if (this.a == null) {
      return false;
    }
    return this.a.edit().putLong(paramString, paramLong).commit();
  }
  
  public final boolean a(String paramString1, String paramString2)
  {
    if (this.a == null) {
      return false;
    }
    return this.a.edit().putString(paramString1, paramString2).commit();
  }
  
  public final boolean a(String paramString, boolean paramBoolean)
  {
    if (this.a == null) {
      return false;
    }
    return this.a.edit().putBoolean(paramString, paramBoolean).commit();
  }
  
  public final boolean a(String[] paramArrayOfString)
  {
    int i = 0;
    if (this.a == null) {
      return false;
    }
    SharedPreferences.Editor localEditor = this.a.edit();
    int j = paramArrayOfString.length;
    while (i < j)
    {
      localEditor.remove(paramArrayOfString[i]);
      i += 1;
    }
    return localEditor.commit();
  }
  
  public final int b(String paramString)
  {
    if (this.a == null) {
      return -1;
    }
    return this.a.getInt(paramString, -1);
  }
  
  public final String b()
  {
    int i = b("mapConfigVersion");
    String str3 = a("mapConfigZipMd5");
    int j = b("mapConfigIndoorPremiumVersion");
    Object localObject = a("mapConfigIndoorPremiumMd5");
    int k = b("mapConfigIndoorVersion");
    String str2 = a("mapConfigIndoorMd5");
    String str1;
    if (!nl.a((String)localObject)) {
      str1 = "indoormap_config_premium";
    }
    for (str2 = String.valueOf(j);; str2 = String.valueOf(k))
    {
      return String.format("mapconfig-%s-%s,%s-%s-%s", new Object[] { String.valueOf(i), str3, str1, str2, localObject });
      str1 = "indoormap_config";
      localObject = str2;
    }
  }
  
  public final boolean c(String paramString)
  {
    if (this.a == null) {
      return false;
    }
    return this.a.getBoolean(paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.gc
 * JD-Core Version:    0.7.0.1
 */