package com.tencent.mobileqq.apollo.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

@Deprecated
public class App3DConfig
{
  public static String sAPKSize;
  public static int sAdId;
  public static String sApkSign;
  public static String sAppId;
  public static String sAppName;
  public static String sDownloadUrl;
  public static String sIconUrl;
  public static String sMd5;
  public static String sPackageName;
  public static String sProgressUrl;
  public static boolean sShow;
  public static String sTraceInfo;
  public static int sVersionCode;
  
  static {}
  
  private static void init()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_app3d_config", 0);
    boolean bool;
    if (localSharedPreferences.getInt("show", 0) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    sShow = bool;
    sShow = true;
    sPackageName = localSharedPreferences.getString("packageName", null);
    sDownloadUrl = localSharedPreferences.getString("downloadUrl", "");
    sIconUrl = localSharedPreferences.getString("iconUrl", "");
    sProgressUrl = localSharedPreferences.getString("progressUrl", "");
    sMd5 = localSharedPreferences.getString("md5", "");
    sAPKSize = localSharedPreferences.getString("apkSize", "");
    sVersionCode = localSharedPreferences.getInt("versionCode", 0);
    sApkSign = localSharedPreferences.getString("apkSign", "");
    sAppName = localSharedPreferences.getString("appName", "");
    sAppId = localSharedPreferences.getString("appId", "");
    sAdId = localSharedPreferences.getInt("adId", 0);
    sTraceInfo = localSharedPreferences.getString("traceInfo", "");
    QLog.d("[cmshow]App3DConfig", 1, new Object[] { "App3DConfig init, sShow=", Boolean.valueOf(sShow) });
  }
  
  public static void parse(Map<String, String> paramMap, int paramInt, String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_app3d_config", 0);
    for (;;)
    {
      try
      {
        if (Integer.parseInt((String)paramMap.get("show")) == 1)
        {
          bool = true;
          sShow = bool;
          sShow = true;
          sPackageName = (String)paramMap.get("packageName");
          sDownloadUrl = (String)paramMap.get("downloadUrl");
          sIconUrl = (String)paramMap.get("iconUrl");
          sProgressUrl = (String)paramMap.get("progressUrl");
          sMd5 = (String)paramMap.get("md5");
          sAPKSize = (String)paramMap.get("apkSize");
          sVersionCode = Integer.parseInt((String)paramMap.get("versionCode"));
          sApkSign = (String)paramMap.get("apkSign");
          sAppName = (String)paramMap.get("appName");
          sAppId = (String)paramMap.get("appId");
          sAdId = paramInt;
          sTraceInfo = paramString;
          if ((TextUtils.isEmpty(sPackageName)) || (TextUtils.isEmpty(sDownloadUrl)) || (TextUtils.isEmpty(sIconUrl)) || (TextUtils.isEmpty(sAppId)))
          {
            sShow = false;
            QLog.w("[cmshow]App3DConfig", 1, "App3DConfig parse invalid param");
          }
          paramMap = localSharedPreferences.edit();
          if (!sShow) {
            break label436;
          }
          paramInt = 1;
          paramMap.putInt("show", paramInt).putString("packageName", sPackageName).putString("downloadUrl", sDownloadUrl).putString("md5", sMd5).putString("iconUrl", sIconUrl).putString("progressUrl", sProgressUrl).putString("apkSize", sAPKSize).putInt("versionCode", sVersionCode).putString("apkSign", sApkSign).putString("appName", sAppName).putString("appId", sAppId).putInt("adId", sAdId).putString("traceInfo", sTraceInfo).commit();
          QLog.d("[cmshow]App3DConfig", 1, new Object[] { "App3DConfig parse, sShow=", Boolean.valueOf(sShow) });
          return;
        }
      }
      catch (Throwable paramMap)
      {
        QLog.e("[cmshow]App3DConfig", 1, "App3DConfig parse error:", paramMap);
        return;
      }
      boolean bool = false;
      continue;
      label436:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.model.App3DConfig
 * JD-Core Version:    0.7.0.1
 */