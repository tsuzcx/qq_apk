package com.tencent.common.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import auxf;
import com.tencent.mobileqq.msf.core.net.patch.PatchCommonUtil;
import com.tencent.mobileqq.qfix.ApplicationDelegate;
import com.tencent.mobileqq.qfix.QFixApplication;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import mqq.app.ThirdAppReportHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QFixApplicationImpl
  extends QFixApplication
{
  public static String a;
  public static boolean a;
  private static String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "com.tencent.common.app.BaseApplicationImpl";
  }
  
  public QFixApplicationImpl()
  {
    super(jdField_a_of_type_JavaLangString);
  }
  
  public static int a(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static String a(Context paramContext)
  {
    if (b != null) {
      return b;
    }
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (paramContext == null) {
        break label93;
      }
      paramContext = paramContext.iterator();
      do
      {
        if (!paramContext.hasNext()) {
          break;
        }
        localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      } while ((localObject == null) || (((ActivityManager.RunningAppProcessInfo)localObject).pid != Process.myPid()));
      paramContext = ((ActivityManager.RunningAppProcessInfo)localObject).processName;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Object localObject;
        paramContext = null;
        continue;
        paramContext = null;
      }
    }
    localObject = paramContext;
    if (paramContext == null) {
      localObject = "com.tencent.mobileqq";
    }
    b = (String)localObject;
    return localObject;
  }
  
  private JSONObject a(String paramString)
  {
    for (;;)
    {
      int j;
      int i;
      try
      {
        if (TextUtils.isEmpty(paramString))
        {
          localJSONArray = new JSONArray();
          if (localJSONArray.length() == 0) {
            return null;
          }
        }
        else
        {
          localJSONArray = new JSONArray(paramString);
          continue;
        }
        if (localJSONArray.length() != 1) {
          break label139;
        }
        return localJSONArray.getJSONObject(0);
      }
      catch (JSONException paramString)
      {
        JSONArray localJSONArray;
        JSONObject localJSONObject;
        int k;
        Log.d("QFixAppImpl_PatchLogTag", "getLatestPatchConfig exception=" + paramString);
        return null;
      }
      if (j < localJSONArray.length())
      {
        localJSONObject = localJSONArray.getJSONObject(j);
        if (localJSONObject != null)
        {
          k = localJSONObject.optInt("patchVersion", 0);
          if (k > i)
          {
            i = k;
            paramString = localJSONObject;
            j += 1;
            continue;
          }
        }
      }
      else
      {
        return paramString;
        label139:
        j = 0;
        paramString = null;
        i = 0;
      }
    }
  }
  
  public static void a(Context paramContext)
  {
    if (jdField_a_of_type_Boolean) {
      paramContext.getSharedPreferences("hotpatch_preference", 4).edit().putInt("androidNTryCount" + b, 0).commit();
    }
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  public static void b(Context paramContext)
  {
    if (jdField_a_of_type_Boolean)
    {
      paramContext = paramContext.getSharedPreferences("hotpatch_preference", 4);
      int i = paramContext.getInt("androidNCrashCount", 0);
      long l = paramContext.getLong("androidNCrashTime", 0L);
      if (i < 3)
      {
        if (Math.abs(System.currentTimeMillis() - l) >= 3600000L) {
          break label99;
        }
        paramContext.edit().putInt("androidNCrashCount", i + 1).commit();
        paramContext.edit().putLong("androidNCrashTime", System.currentTimeMillis()).commit();
      }
    }
    return;
    label99:
    paramContext.edit().putInt("androidNCrashCount", 1).commit();
    paramContext.edit().putLong("androidNCrashTime", System.currentTimeMillis()).commit();
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    if (this.applicationLike != null) {
      return this.applicationLike.getSharedPreferences(paramString, paramInt);
    }
    return super.getSharedPreferences(paramString, paramInt);
  }
  
  public SharedPreferences getSystemSharedPreferences(String paramString, int paramInt)
  {
    return super.getSharedPreferences(paramString, paramInt);
  }
  
  public boolean isAndroidNPatchEnable()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("hotpatch_preference", 4);
    Object localObject1 = localSharedPreferences.getString("key_config_patch_dex", "");
    String str2 = a(this);
    String str1 = "androidNTryCount" + str2;
    localObject1 = a((String)localObject1);
    boolean bool1;
    if (localObject1 == null)
    {
      Log.d("QFixAppImpl_PatchLogTag", "isAndroidNPatchEnable patch config is null");
      bool1 = false;
    }
    Object localObject2;
    for (;;)
    {
      if (bool1)
      {
        i = localSharedPreferences.getInt(str1, 0);
        localSharedPreferences.edit().putInt(str1, i + 1).commit();
      }
      Log.d("QFixAppImpl_PatchLogTag", "isAndroidNPatchEnable = " + bool1);
      jdField_a_of_type_Boolean = bool1;
      return bool1;
      bool1 = ((JSONObject)localObject1).optBoolean("enable", false);
      Log.d("QFixAppImpl_PatchLogTag", "" + bool1);
      if (!bool1)
      {
        bool1 = false;
      }
      else
      {
        localObject2 = ((JSONObject)localObject1).optString("revision", "");
        Log.d("QFixAppImpl_PatchLogTag", "isAndroidNPatchEnable revision=" + (String)localObject2 + ", " + "2703aac4");
        if (!"2703aac4".equals(localObject2))
        {
          Log.d("QFixAppImpl_PatchLogTag", "isAndroidNPatchEnable revision not match.");
          bool1 = false;
        }
        else
        {
          localObject2 = ((JSONObject)localObject1).optString("appVersion", "");
          if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals(b(this) + "." + a(this))))
          {
            Log.d("QFixAppImpl_PatchLogTag", "isAndroidNPatchEnable appVersion not match.");
            bool1 = false;
          }
          else
          {
            localObject2 = ((JSONObject)localObject1).optJSONArray("patchItemConfigs");
            if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0)) {
              break;
            }
            Log.d("QFixAppImpl_PatchLogTag", "isAndroidNPatchEnable patchItemConfig is null");
            bool1 = false;
          }
        }
      }
    }
    int i = 0;
    Object localObject3;
    boolean bool2;
    if (i < ((JSONArray)localObject2).length())
    {
      localObject1 = ((JSONArray)localObject2).optJSONObject(i);
      if (localObject1 == null) {}
      for (;;)
      {
        i += 1;
        break;
        localObject3 = ((JSONObject)localObject1).optString("process", "");
        bool2 = TextUtils.isEmpty((CharSequence)localObject3);
        if (!bool2)
        {
          localObject3 = ((String)localObject3).split(";");
          int k = localObject3.length;
          int j = 0;
          for (;;)
          {
            bool1 = bool2;
            if (j < k)
            {
              if (TextUtils.equals(localObject3[j], str2)) {
                bool1 = true;
              }
            }
            else
            {
              if (bool1) {
                break label498;
              }
              Log.d("QFixAppImpl_PatchLogTag", "isAndroidNPatchEnable process not match.");
              break;
            }
            j += 1;
          }
        }
        label498:
        localObject3 = ((JSONObject)localObject1).optString("systemVersion", "");
        if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!((String)localObject3).contains(String.valueOf(Build.VERSION.SDK_INT))))
        {
          Log.d("QFixAppImpl_PatchLogTag", "isAndroidNPatchEnable systemVersion not match.");
        }
        else
        {
          localObject3 = ((JSONObject)localObject1).optString("deviceInfo", "");
          if ((TextUtils.isEmpty((CharSequence)localObject3)) || ((((String)localObject3).contains(Build.BRAND)) && (((String)localObject3).contains(Build.MODEL)))) {
            break label598;
          }
          Log.d("QFixAppImpl_PatchLogTag", "isAndroidNPatchEnable device not match.");
        }
      }
    }
    for (;;)
    {
      label598:
      if (localObject1 == null)
      {
        Log.d("QFixAppImpl_PatchLogTag", "isAndroidNPatchEnable patchItemConfig not match.");
        bool1 = false;
        break;
      }
      localObject2 = ((JSONObject)localObject1).optString("patchName", "");
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        Log.d("QFixAppImpl_PatchLogTag", "isAndroidNPatchEnable patchName is empty.");
        bool1 = false;
        break;
      }
      localObject3 = new File(PatchCommonUtil.getPatchDirPath(this) + File.separator + (String)localObject2);
      if (!((File)localObject3).exists())
      {
        Log.d("QFixAppImpl_PatchLogTag", "isAndroidNPatchEnable patch file not exist.");
        bool1 = false;
        break;
      }
      i = ((JSONObject)localObject1).optInt("patchSize", 0);
      if ((i <= 0) || (((File)localObject3).length() != i))
      {
        Log.d("QFixAppImpl_PatchLogTag", "isAndroidNPatchEnable patchSize not match.");
        bool1 = false;
        break;
      }
      bool2 = ((JSONObject)localObject1).optBoolean("nPatchEnable", false);
      Log.d("QFixAppImpl_PatchLogTag", "nPatchEnable " + bool2);
      bool1 = bool2;
      if (!bool2) {
        break;
      }
      if (!localSharedPreferences.getBoolean("key_verify_status_patch_" + (String)localObject2, false))
      {
        Log.d("QFixAppImpl_PatchLogTag", "isAndroidNPatchEnable patch verify failed.");
        return false;
      }
      localObject1 = str2 + (String)localObject2;
      if (localSharedPreferences.getInt("key_count_fail_install_patch_" + (String)localObject1, 0) >= 3)
      {
        bool1 = false;
        break;
      }
      if (localSharedPreferences.getInt("key_count_fail_startup_patch_" + (String)localObject1, 0) > 5)
      {
        bool1 = false;
        break;
      }
      i = localSharedPreferences.getInt(str1, 0);
      Log.d("QFixAppImpl_PatchLogTag", "androidNTryCount " + i);
      if (i >= 3)
      {
        bool1 = false;
        break;
      }
      i = localSharedPreferences.getInt("androidNCrashCount", 0);
      Log.d("QFixAppImpl_PatchLogTag", "androidNCrashCount " + i);
      bool1 = bool2;
      if (i < 3) {
        break;
      }
      bool1 = false;
      break;
      localObject1 = null;
    }
  }
  
  public void startActivity(Intent paramIntent)
  {
    try
    {
      FileProvider7Helper.intentCompatForN(this, paramIntent);
      ThirdAppReportHelper.reportThirdAppOpen(this, paramIntent, 0);
      auxf.a(this, paramIntent, new QFixApplicationImpl.1(this, paramIntent));
      return;
    }
    catch (Throwable paramIntent)
    {
      QLog.e("QFixAppImpl_PatchLogTag", 1, paramIntent, new Object[0]);
    }
  }
  
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    try
    {
      FileProvider7Helper.intentCompatForN(this, paramIntent);
      ThirdAppReportHelper.reportThirdAppOpen(this, paramIntent, 0);
      auxf.a(this, paramIntent, new QFixApplicationImpl.2(this, paramIntent, paramBundle));
      return;
    }
    catch (Throwable paramIntent)
    {
      QLog.e("QFixAppImpl_PatchLogTag", 1, paramIntent, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.app.QFixApplicationImpl
 * JD-Core Version:    0.7.0.1
 */