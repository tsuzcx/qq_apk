package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import java.util.Map;

public class PLSharedPreferences
{
  private static final String MOVE_TO_DE_RECORDS = "grs_move2DE_records";
  private static final String TAG = "PLSharedPreferences";
  private SharedPreferences sp = getSharedPreferences(paramContext, paramString);
  
  public PLSharedPreferences(Context paramContext, String paramString) {}
  
  private SharedPreferences getSharedPreferences(Context paramContext, String paramString)
  {
    if (paramContext == null)
    {
      Logger.e("PLSharedPreferences", "context is null, must call init method to set context");
      return null;
    }
    Context localContext = paramContext;
    SharedPreferences localSharedPreferences;
    if (Build.VERSION.SDK_INT >= 24)
    {
      localContext = paramContext.createDeviceProtectedStorageContext();
      localSharedPreferences = localContext.getSharedPreferences("grs_move2DE_records", 0);
      if (localSharedPreferences.getBoolean(paramString, false)) {
        break label90;
      }
      if (localContext.moveSharedPreferencesFrom(paramContext, paramString)) {
        break label67;
      }
      localContext = paramContext;
    }
    label67:
    label90:
    for (;;)
    {
      return localContext.getSharedPreferences(paramString, 0);
      paramContext = localSharedPreferences.edit();
      paramContext.putBoolean(paramString, true);
      paramContext.apply();
    }
  }
  
  public void clear()
  {
    if (this.sp == null) {
      return;
    }
    this.sp.edit().clear().apply();
  }
  
  public SharedPreferences.Editor edit()
  {
    if (this.sp == null) {
      return null;
    }
    return this.sp.edit();
  }
  
  public Map<String, ?> getAll()
  {
    if (this.sp == null) {
      return null;
    }
    return this.sp.getAll();
  }
  
  public long getLong(String paramString, long paramLong)
  {
    if (this.sp == null) {
      return paramLong;
    }
    return this.sp.getLong(paramString, paramLong);
  }
  
  public String getString(String paramString)
  {
    return getString(paramString, "");
  }
  
  public String getString(String paramString1, String paramString2)
  {
    if (this.sp == null) {
      return paramString2;
    }
    return this.sp.getString(paramString1, paramString2);
  }
  
  public void putLong(String paramString, long paramLong)
  {
    if (this.sp == null) {
      return;
    }
    this.sp.edit().putLong(paramString, paramLong).apply();
  }
  
  public void putString(String paramString1, String paramString2)
  {
    if (this.sp == null) {
      return;
    }
    this.sp.edit().putString(paramString1, paramString2).apply();
  }
  
  public void remove(String paramString)
  {
    if (this.sp == null) {
      return;
    }
    this.sp.edit().remove(paramString).apply();
  }
  
  public void removeKeyValue(String paramString)
  {
    if (this.sp == null) {
      return;
    }
    this.sp.edit().remove(paramString).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.framework.common.PLSharedPreferences
 * JD-Core Version:    0.7.0.1
 */