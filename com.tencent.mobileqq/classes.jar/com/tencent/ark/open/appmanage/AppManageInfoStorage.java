package com.tencent.ark.open.appmanage;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.Logger;
import com.tencent.ark.open.ArkAppMgr;

public class AppManageInfoStorage
{
  private static final String PREF_APP_DESC = "ArkAppDescCache";
  private static final String PREF_APP_LAST_USE_TIME = "ArkAppLastUsedTime";
  public static final String PREF_UPDATE_TIME_RECORD = "ArkLocalAppUpdateTime";
  private static final String TAG = "ArkApp.ArkAppMgr";
  
  public static SharedPreferences getAppDescSP()
  {
    return ArkEnvironmentManager.getSharedPreferences("ArkAppDescCache");
  }
  
  public static long getAppLastUseTime(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return System.currentTimeMillis();
    }
    long l2 = ArkEnvironmentManager.getSharedPreferences("ArkAppLastUsedTime").getLong(paramString, 0L);
    long l1 = l2;
    if (l2 == 0L)
    {
      updateAppLastUseTime(paramString);
      l1 = System.currentTimeMillis();
    }
    if (ArkAppMgr.DEBUG)
    {
      if (l1 > 0L) {
        return l1;
      }
      throw new AssertionError("Assertion failed");
    }
    return l1;
  }
  
  public static SharedPreferences getUpdateTimeSP()
  {
    return ArkEnvironmentManager.getSharedPreferences("ArkLocalAppUpdateTime");
  }
  
  public static boolean isAppNotRecentUse(String paramString)
  {
    return System.currentTimeMillis() - getAppLastUseTime(paramString) >= 2592000000L;
  }
  
  public static String loadAppDesc(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    SharedPreferences localSharedPreferences = getAppDescSP();
    if (localSharedPreferences == null) {
      return null;
    }
    return localSharedPreferences.getString(paramString, null);
  }
  
  public static byte[] loadAppSignature(String paramString)
  {
    SharedPreferences localSharedPreferences = getUpdateTimeSP();
    if (localSharedPreferences == null) {
      return null;
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_sign");
      paramString = Base64.decode(localSharedPreferences.getString(localStringBuilder.toString(), "bad"), 0);
      return paramString;
    }
    catch (IllegalArgumentException paramString) {}
    return null;
  }
  
  public static void saveAppDesc(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      Object localObject = getAppDescSP();
      if (localObject == null) {
        return;
      }
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
      ((SharedPreferences.Editor)localObject).apply();
    }
  }
  
  public static void saveAppSignature(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = getUpdateTimeSP();
    if (localObject == null)
    {
      Logger.logE("ArkApp.ArkAppMgr", "saveAppSignature sp is null");
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_sign");
    ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), Base64.encodeToString(paramArrayOfByte, 0));
    ((SharedPreferences.Editor)localObject).apply();
  }
  
  public static void updateAppLastUseTime(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = ArkEnvironmentManager.getSharedPreferences("ArkAppLastUsedTime");
    if (localObject == null)
    {
      Logger.logE("ArkApp.ArkAppMgr", "updateAppLastUseTime sp is null");
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong(paramString, System.currentTimeMillis());
    ((SharedPreferences.Editor)localObject).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.appmanage.AppManageInfoStorage
 * JD-Core Version:    0.7.0.1
 */