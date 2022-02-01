package com.tencent.biz.pubaccount.readinjoy.config;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.aladdin.config.utils.Log;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class QQAladdinPrefUtils
{
  public static int a(int paramInt)
  {
    SharedPreferences localSharedPreferences = a(ReadInJoyUtils.a());
    if (localSharedPreferences == null)
    {
      Log.e("AladdinPrefUtils", "getConfigVersionById: return 0 for sp is null");
      return 0;
    }
    return localSharedPreferences.getInt("config_version_" + paramInt, 0);
  }
  
  private static SharedPreferences a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null)
    {
      Log.e("AladdinPrefUtils", "getSharedPreferences: null for runtime is null");
      return null;
    }
    paramAppRuntime = "readinjoy_sp_aladdin_" + paramAppRuntime.getAccount();
    return BaseApplicationImpl.getApplication().getSharedPreferences(paramAppRuntime, 0);
  }
  
  public static void a()
  {
    Log.d("AladdinPrefUtils", "clearAladdinCommonConfigs");
    SharedPreferences localSharedPreferences = a(ReadInJoyUtils.a());
    if (localSharedPreferences == null)
    {
      Log.d("AladdinPrefUtils", "clearAladdinCommonConfigs: sp is null");
      return;
    }
    localSharedPreferences.edit().clear().commit();
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    SharedPreferences localSharedPreferences = a(ReadInJoyUtils.a());
    if (localSharedPreferences == null)
    {
      Log.e("AladdinPrefUtils", "setConfigVersionById: sp is null");
      return;
    }
    localSharedPreferences.edit().putInt("config_version_" + paramInt1, paramInt2).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.config.QQAladdinPrefUtils
 * JD-Core Version:    0.7.0.1
 */