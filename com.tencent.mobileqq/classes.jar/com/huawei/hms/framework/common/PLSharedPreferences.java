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
    if (Build.VERSION.SDK_INT >= 24)
    {
      localContext = paramContext.createDeviceProtectedStorageContext();
      SharedPreferences localSharedPreferences = localContext.getSharedPreferences("grs_move2DE_records", 0);
      if (!localSharedPreferences.getBoolean(paramString, false)) {
        if (!localContext.moveSharedPreferencesFrom(paramContext, paramString))
        {
          localContext = paramContext;
        }
        else
        {
          paramContext = localSharedPreferences.edit();
          paramContext.putBoolean(paramString, true);
          paramContext.apply();
        }
      }
    }
    return localContext.getSharedPreferences(paramString, 0);
  }
  
  public void clear()
  {
    SharedPreferences localSharedPreferences = this.sp;
    if (localSharedPreferences == null) {
      return;
    }
    localSharedPreferences.edit().clear().apply();
  }
  
  public SharedPreferences.Editor edit()
  {
    SharedPreferences localSharedPreferences = this.sp;
    if (localSharedPreferences == null) {
      return null;
    }
    return localSharedPreferences.edit();
  }
  
  public Map<String, ?> getAll()
  {
    SharedPreferences localSharedPreferences = this.sp;
    if (localSharedPreferences == null) {
      return null;
    }
    return localSharedPreferences.getAll();
  }
  
  public long getLong(String paramString, long paramLong)
  {
    SharedPreferences localSharedPreferences = this.sp;
    if (localSharedPreferences == null) {
      return paramLong;
    }
    return localSharedPreferences.getLong(paramString, paramLong);
  }
  
  public String getString(String paramString)
  {
    return getString(paramString, "");
  }
  
  public String getString(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = this.sp;
    if (localSharedPreferences == null) {
      return paramString2;
    }
    return localSharedPreferences.getString(paramString1, paramString2);
  }
  
  public void putLong(String paramString, long paramLong)
  {
    SharedPreferences localSharedPreferences = this.sp;
    if (localSharedPreferences == null) {
      return;
    }
    localSharedPreferences.edit().putLong(paramString, paramLong).apply();
  }
  
  public void putString(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = this.sp;
    if (localSharedPreferences == null) {
      return;
    }
    localSharedPreferences.edit().putString(paramString1, paramString2).apply();
  }
  
  public void remove(String paramString)
  {
    SharedPreferences localSharedPreferences = this.sp;
    if (localSharedPreferences == null) {
      return;
    }
    localSharedPreferences.edit().remove(paramString).apply();
  }
  
  public void removeKeyValue(String paramString)
  {
    SharedPreferences localSharedPreferences = this.sp;
    if (localSharedPreferences == null) {
      return;
    }
    localSharedPreferences.edit().remove(paramString).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.common.PLSharedPreferences
 * JD-Core Version:    0.7.0.1
 */