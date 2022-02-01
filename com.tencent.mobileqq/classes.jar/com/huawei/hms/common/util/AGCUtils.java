package com.huawei.hms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.IOUtils;
import java.io.IOException;
import java.io.InputStream;

public class AGCUtils
{
  private static String a(Context paramContext, String paramString)
  {
    Object localObject2 = AGConnectServicesConfig.fromContext(paramContext);
    String str = "";
    Context localContext2 = null;
    Object localObject1 = null;
    Context localContext1 = null;
    try
    {
      paramContext = paramContext.getResources().getAssets().open("agconnect-services.json");
      localContext1 = paramContext;
      localContext2 = paramContext;
      localObject1 = paramContext;
      ((AGConnectServicesConfig)localObject2).overlayWith(paramContext);
      localContext1 = paramContext;
      localContext2 = paramContext;
      localObject1 = paramContext;
      localObject2 = ((AGConnectServicesConfig)localObject2).getString(paramString);
      localObject1 = localObject2;
      IOUtils.closeQuietly(paramContext);
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        localObject1 = localContext1;
        HMSLog.e("AGCUtils", "Get " + paramString + " failed: " + paramContext);
        IOUtils.closeQuietly(localContext1);
        localObject1 = str;
      }
    }
    catch (NullPointerException paramContext)
    {
      for (;;)
      {
        localObject1 = localContext2;
        HMSLog.e("AGCUtils", "Get " + paramString + " with AGConnectServicesConfig failed: " + paramContext);
        IOUtils.closeQuietly(localContext2);
        localObject1 = str;
      }
    }
    finally
    {
      IOUtils.closeQuietly((InputStream)localObject1);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      return localObject1;
    }
    HMSLog.e("AGCUtils", "The " + paramString + " is null.");
    return "";
  }
  
  private static boolean a(Context paramContext)
  {
    return paramContext.getPackageName().equals(HMSPackageManager.getInstance(paramContext).getHMSPackageName());
  }
  
  private static String b(Context paramContext)
  {
    Object localObject = paramContext.getPackageManager();
    if (localObject == null)
    {
      HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to get 'PackageManager' instance.");
      paramContext = "";
    }
    for (;;)
    {
      return paramContext;
      try
      {
        paramContext = ((PackageManager)localObject).getPackageInfo(paramContext.getPackageName(), 128).applicationInfo;
        if ((paramContext != null) && (paramContext.metaData != null))
        {
          paramContext = paramContext.metaData.get("com.huawei.hms.client.appid");
          if (paramContext != null)
          {
            localObject = String.valueOf(paramContext);
            paramContext = (Context)localObject;
            if (!((String)localObject).startsWith("appid=")) {
              continue;
            }
            return ((String)localObject).substring("appid=".length());
          }
        }
        HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.");
        return "";
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.");
      }
    }
    return "";
  }
  
  private static String c(Context paramContext)
  {
    Object localObject = paramContext.getPackageManager();
    if (localObject == null)
    {
      HMSLog.e("AGCUtils", "In getMetaDataCpId, Failed to get 'PackageManager' instance.");
      paramContext = "";
    }
    for (;;)
    {
      return paramContext;
      try
      {
        paramContext = ((PackageManager)localObject).getPackageInfo(paramContext.getPackageName(), 128).applicationInfo;
        if ((paramContext != null) && (paramContext.metaData != null))
        {
          paramContext = paramContext.metaData.get("com.huawei.hms.client.cpid");
          if (paramContext != null)
          {
            localObject = String.valueOf(paramContext);
            paramContext = (Context)localObject;
            if (!((String)localObject).startsWith("cpid=")) {
              continue;
            }
            return ((String)localObject).substring("cpid=".length());
          }
        }
        HMSLog.i("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.");
        return "";
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        HMSLog.e("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.");
      }
    }
    return "";
  }
  
  public static String getAppId(Context paramContext)
  {
    Object localObject2;
    if (a(paramContext)) {
      localObject2 = a(paramContext, "client/app_id");
    }
    Object localObject1;
    do
    {
      return localObject2;
      localObject1 = null;
      try
      {
        localObject2 = AGConnectServicesConfig.fromContext(paramContext).getString("client/app_id");
        localObject1 = localObject2;
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;)
        {
          HMSLog.e("AGCUtils", "Get appId with AGConnectServicesConfig failed");
        }
      }
      localObject2 = localObject1;
    } while (!TextUtils.isEmpty(localObject1));
    return b(paramContext);
  }
  
  public static String getCpId(Context paramContext)
  {
    Object localObject2;
    if (a(paramContext)) {
      localObject2 = a(paramContext, "client/cp_id");
    }
    Object localObject1;
    do
    {
      return localObject2;
      localObject1 = null;
      try
      {
        localObject2 = AGConnectServicesConfig.fromContext(paramContext).getString("client/cp_id");
        localObject1 = localObject2;
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;)
        {
          HMSLog.e("AGCUtils", "Get cpid with AGConnectServicesConfig failed");
        }
      }
      localObject2 = localObject1;
    } while (!TextUtils.isEmpty(localObject1));
    return c(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.common.util.AGCUtils
 * JD-Core Version:    0.7.0.1
 */