package com.huawei.updatesdk.service.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.huawei.updatesdk.a.a.b.a.a.a;

public class b
{
  private SharedPreferences a;
  
  private b(SharedPreferences paramSharedPreferences)
  {
    this.a = paramSharedPreferences;
  }
  
  public static b a(String paramString, Context paramContext)
  {
    localObject = null;
    Context localContext = paramContext;
    try
    {
      if (Build.VERSION.SDK_INT >= 24) {
        localContext = paramContext.createDeviceProtectedStorageContext();
      }
      paramString = localContext.getSharedPreferences(paramString, 0);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        a.d("SharedPreferencesWrapper", "getSharedPreference error");
        paramString = localObject;
      }
    }
    return new b(paramString);
  }
  
  public void a(String paramString)
  {
    try
    {
      SharedPreferences.Editor localEditor = this.a.edit();
      localEditor.remove(paramString);
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      a.d("SharedPreferencesWrapper", "remove error!!key:" + paramString);
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    try
    {
      SharedPreferences.Editor localEditor = this.a.edit();
      localEditor.putLong(paramString, paramLong);
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      a.a("SharedPreferencesWrapper", "putLong error!!key:" + paramString, localException);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      SharedPreferences.Editor localEditor = this.a.edit();
      localEditor.putString(paramString1, paramString2);
      localEditor.commit();
      return;
    }
    catch (Exception paramString2)
    {
      a.a("SharedPreferencesWrapper", "putString error!!key:" + paramString1, paramString2);
    }
  }
  
  public long b(String paramString, long paramLong)
  {
    try
    {
      long l = this.a.getLong(paramString, paramLong);
      return l;
    }
    catch (Exception paramString) {}
    return paramLong;
  }
  
  public String b(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = this.a.getString(paramString1, paramString2);
      return paramString1;
    }
    catch (Exception paramString1) {}
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.a.b
 * JD-Core Version:    0.7.0.1
 */