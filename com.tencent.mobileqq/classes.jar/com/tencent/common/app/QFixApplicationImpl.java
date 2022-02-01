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
import com.tencent.mobileqq.haoliyou.IATHandler;
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
  public static String a = "com.tencent.common.app.BaseApplicationImpl";
  public static boolean a = false;
  private static String b;
  
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
    localObject1 = b;
    if (localObject1 != null) {
      return localObject1;
    }
    localObject1 = null;
    try
    {
      Object localObject2 = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      paramContext = (Context)localObject1;
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        do
        {
          paramContext = (Context)localObject1;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          paramContext = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject2).next();
        } while ((paramContext == null) || (paramContext.pid != Process.myPid()));
        paramContext = paramContext.processName;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = (Context)localObject1;
      }
    }
    localObject1 = paramContext;
    if (paramContext == null) {
      localObject1 = "com.tencent.mobileqq";
    }
    b = (String)localObject1;
    return localObject1;
  }
  
  private JSONObject a(String paramString)
  {
    for (;;)
    {
      int i;
      Object localObject1;
      int k;
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          paramString = new JSONArray();
        } else {
          paramString = new JSONArray(paramString);
        }
        if (paramString.length() == 0) {
          return null;
        }
        if (paramString.length() != 1) {
          break label163;
        }
        return paramString.getJSONObject(0);
      }
      catch (JSONException paramString)
      {
        JSONObject localJSONObject;
        Object localObject2;
        int j;
        int m;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getLatestPatchConfig exception=");
        ((StringBuilder)localObject1).append(paramString);
        Log.d("QFixAppImpl_PatchLogTag", ((StringBuilder)localObject1).toString());
        return null;
      }
      if (i < paramString.length())
      {
        localJSONObject = paramString.getJSONObject(i);
        localObject2 = localObject1;
        j = k;
        if (localJSONObject != null)
        {
          m = localJSONObject.optInt("patchVersion", 0);
          localObject2 = localObject1;
          j = k;
          if (m > k)
          {
            localObject2 = localJSONObject;
            j = m;
          }
        }
        i += 1;
        localObject1 = localObject2;
        k = j;
      }
      else
      {
        return localObject1;
        label163:
        localObject1 = null;
        i = 0;
        k = 0;
      }
    }
  }
  
  public static void a(Context paramContext)
  {
    if (jdField_a_of_type_Boolean)
    {
      paramContext = paramContext.getSharedPreferences("hotpatch_preference", 4).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("androidNTryCount");
      localStringBuilder.append(b);
      paramContext.putInt(localStringBuilder.toString(), 0).commit();
    }
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      label18:
      break label18;
    }
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
        if (Math.abs(System.currentTimeMillis() - l) < 3600000L)
        {
          paramContext.edit().putInt("androidNCrashCount", i + 1).commit();
          paramContext.edit().putLong("androidNCrashTime", System.currentTimeMillis()).commit();
          return;
        }
        paramContext.edit().putInt("androidNCrashCount", 1).commit();
        paramContext.edit().putLong("androidNCrashTime", System.currentTimeMillis()).commit();
      }
    }
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
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("androidNTryCount");
    ((StringBuilder)localObject2).append(str2);
    String str1 = ((StringBuilder)localObject2).toString();
    localObject1 = a((String)localObject1);
    if (localObject1 == null) {
      Log.d("QFixAppImpl_PatchLogTag", "isAndroidNPatchEnable patch config is null");
    }
    boolean bool1;
    int i;
    for (;;)
    {
      bool1 = false;
      break;
      bool1 = ((JSONObject)localObject1).optBoolean("enable", false);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(bool1);
      Log.d("QFixAppImpl_PatchLogTag", ((StringBuilder)localObject2).toString());
      if (bool1)
      {
        for (;;)
        {
          localObject2 = ((JSONObject)localObject1).optString("revision", "");
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("isAndroidNPatchEnable revision=");
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append(", ");
          ((StringBuilder)localObject3).append("01328a87");
          Log.d("QFixAppImpl_PatchLogTag", ((StringBuilder)localObject3).toString());
          if (!"01328a87".equals(localObject2))
          {
            Log.d("QFixAppImpl_PatchLogTag", "isAndroidNPatchEnable revision not match.");
            break;
          }
          localObject2 = ((JSONObject)localObject1).optString("appVersion", "");
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label1073;
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(b(this));
          ((StringBuilder)localObject3).append(".");
          ((StringBuilder)localObject3).append(a(this));
          if (!((String)localObject2).equals(((StringBuilder)localObject3).toString())) {
            break label1073;
          }
          localObject3 = ((JSONObject)localObject1).optJSONArray("patchItemConfigs");
          if ((localObject3 == null) || (((JSONArray)localObject3).length() <= 0)) {
            break label1061;
          }
          i = 0;
          while (i < ((JSONArray)localObject3).length())
          {
            localObject2 = ((JSONArray)localObject3).optJSONObject(i);
            if (localObject2 != null)
            {
              localObject1 = ((JSONObject)localObject2).optString("process", "");
              boolean bool2 = TextUtils.isEmpty((CharSequence)localObject1);
              if (!bool2)
              {
                localObject1 = ((String)localObject1).split(";");
                int k = localObject1.length;
                int j = 0;
                for (;;)
                {
                  bool1 = bool2;
                  if (j >= k) {
                    break;
                  }
                  if (TextUtils.equals(localObject1[j], str2))
                  {
                    bool1 = true;
                    break;
                  }
                  j += 1;
                }
                if (!bool1)
                {
                  Log.d("QFixAppImpl_PatchLogTag", "isAndroidNPatchEnable process not match.");
                  break label549;
                }
              }
              localObject1 = ((JSONObject)localObject2).optString("systemVersion", "");
              if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).contains(String.valueOf(Build.VERSION.SDK_INT))))
              {
                Log.d("QFixAppImpl_PatchLogTag", "isAndroidNPatchEnable systemVersion not match.");
              }
              else
              {
                String str3 = ((JSONObject)localObject2).optString("deviceInfo", "");
                localObject1 = localObject2;
                if (TextUtils.isEmpty(str3)) {
                  break label559;
                }
                if (str3.contains(Build.BRAND))
                {
                  localObject1 = localObject2;
                  if (str3.contains(Build.MODEL)) {
                    break label559;
                  }
                }
                Log.d("QFixAppImpl_PatchLogTag", "isAndroidNPatchEnable device not match.");
              }
            }
            label549:
            i += 1;
          }
          localObject1 = null;
          label559:
          if (localObject1 == null)
          {
            Log.d("QFixAppImpl_PatchLogTag", "isAndroidNPatchEnable patchItemConfig not match.");
            break;
          }
          localObject2 = ((JSONObject)localObject1).optString("patchName", "");
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            Log.d("QFixAppImpl_PatchLogTag", "isAndroidNPatchEnable patchName is empty.");
            break;
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(PatchCommonUtil.getPatchDirPath(this));
          ((StringBuilder)localObject3).append(File.separator);
          ((StringBuilder)localObject3).append((String)localObject2);
          localObject3 = new File(((StringBuilder)localObject3).toString());
          if (!((File)localObject3).exists())
          {
            Log.d("QFixAppImpl_PatchLogTag", "isAndroidNPatchEnable patch file not exist.");
            break;
          }
          i = ((JSONObject)localObject1).optInt("patchSize", 0);
          if ((i <= 0) || (((File)localObject3).length() != i)) {
            break label1049;
          }
          bool1 = ((JSONObject)localObject1).optBoolean("nPatchEnable", false);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("nPatchEnable ");
          ((StringBuilder)localObject1).append(bool1);
          Log.d("QFixAppImpl_PatchLogTag", ((StringBuilder)localObject1).toString());
          if (!bool1) {
            break label1085;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("key_verify_status_patch_");
          ((StringBuilder)localObject1).append((String)localObject2);
          if (!localSharedPreferences.getBoolean(((StringBuilder)localObject1).toString(), false))
          {
            Log.d("QFixAppImpl_PatchLogTag", "isAndroidNPatchEnable patch verify failed.");
            return false;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(str2);
          ((StringBuilder)localObject1).append((String)localObject2);
          localObject1 = ((StringBuilder)localObject1).toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("key_count_fail_install_patch_");
          ((StringBuilder)localObject2).append((String)localObject1);
          if (localSharedPreferences.getInt(((StringBuilder)localObject2).toString(), 0) < 3)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("key_count_fail_startup_patch_");
            ((StringBuilder)localObject2).append((String)localObject1);
            if (localSharedPreferences.getInt(((StringBuilder)localObject2).toString(), 0) <= 5)
            {
              i = localSharedPreferences.getInt(str1, 0);
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("androidNTryCount ");
              ((StringBuilder)localObject1).append(i);
              Log.d("QFixAppImpl_PatchLogTag", ((StringBuilder)localObject1).toString());
              if (i < 3)
              {
                i = localSharedPreferences.getInt("androidNCrashCount", 0);
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("androidNCrashCount ");
                ((StringBuilder)localObject1).append(i);
                Log.d("QFixAppImpl_PatchLogTag", ((StringBuilder)localObject1).toString());
                if (i < 3) {
                  break label1085;
                }
              }
            }
          }
        }
        label1049:
        Log.d("QFixAppImpl_PatchLogTag", "isAndroidNPatchEnable patchSize not match.");
        continue;
        label1061:
        Log.d("QFixAppImpl_PatchLogTag", "isAndroidNPatchEnable patchItemConfig is null");
        continue;
        label1073:
        Log.d("QFixAppImpl_PatchLogTag", "isAndroidNPatchEnable appVersion not match.");
      }
    }
    label1085:
    if (bool1)
    {
      i = localSharedPreferences.getInt(str1, 0);
      localSharedPreferences.edit().putInt(str1, i + 1).commit();
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("isAndroidNPatchEnable = ");
    ((StringBuilder)localObject1).append(bool1);
    Log.d("QFixAppImpl_PatchLogTag", ((StringBuilder)localObject1).toString());
    jdField_a_of_type_Boolean = bool1;
    return bool1;
  }
  
  public void startActivity(Intent paramIntent)
  {
    try
    {
      FileProvider7Helper.intentCompatForN(this, paramIntent);
      ThirdAppReportHelper.reportThirdAppOpen(this, paramIntent, 0);
      IATHandler.a(this, paramIntent, new QFixApplicationImpl.1(this, paramIntent));
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
      IATHandler.a(this, paramIntent, new QFixApplicationImpl.2(this, paramIntent, paramBundle));
      return;
    }
    catch (Throwable paramIntent)
    {
      QLog.e("QFixAppImpl_PatchLogTag", 1, paramIntent, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.common.app.QFixApplicationImpl
 * JD-Core Version:    0.7.0.1
 */