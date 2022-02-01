package com.huawei.hms.opendevice;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.util.UUID;

public class o
{
  public static DeleteTokenReq a(Context paramContext, String paramString)
  {
    return a(paramContext, null, null, paramString, null);
  }
  
  public static DeleteTokenReq a(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext, paramString1, null, null, paramString2);
  }
  
  public static DeleteTokenReq a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    DeleteTokenReq localDeleteTokenReq = new DeleteTokenReq();
    localDeleteTokenReq.setAppId(paramString1);
    localDeleteTokenReq.setScope(paramString4);
    localDeleteTokenReq.setProjectId(paramString2);
    localDeleteTokenReq.setPkgName(paramContext.getPackageName());
    localDeleteTokenReq.setSubjectId(paramString3);
    if (TextUtils.isEmpty(paramString1)) {
      localDeleteTokenReq.setAppId(Util.getAppId(paramContext));
    }
    if (TextUtils.isEmpty(paramString4)) {
      localDeleteTokenReq.setScope("HCM");
    }
    if (TextUtils.isEmpty(paramString2)) {
      localDeleteTokenReq.setProjectId(d(paramContext));
    }
    return localDeleteTokenReq;
  }
  
  public static String a(Context paramContext)
  {
    paramContext = new PushPreferences(paramContext, "aaid");
    if (paramContext.containsKey("aaid")) {
      return paramContext.getString("aaid");
    }
    return null;
  }
  
  public static DeleteTokenReq b(Context paramContext)
  {
    return a(paramContext, null, null, null, null);
  }
  
  public static TokenReq b(Context paramContext, String paramString)
  {
    return b(paramContext, null, null, paramString, null);
  }
  
  public static TokenReq b(Context paramContext, String paramString1, String paramString2)
  {
    return b(paramContext, paramString1, null, null, paramString2);
  }
  
  public static TokenReq b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    TokenReq localTokenReq = new TokenReq();
    localTokenReq.setPackageName(paramContext.getPackageName());
    localTokenReq.setAppId(paramString1);
    localTokenReq.setScope(paramString4);
    localTokenReq.setProjectId(paramString2);
    localTokenReq.setSubjectId(paramString3);
    localTokenReq.setMultiSender(false);
    if (TextUtils.isEmpty(paramString1)) {
      localTokenReq.setAppId(Util.getAppId(paramContext));
    }
    if (TextUtils.isEmpty(paramString2)) {
      localTokenReq.setProjectId(d(paramContext));
    }
    if (TextUtils.isEmpty(paramString4)) {
      localTokenReq.setScope("HCM");
    }
    paramContext = i.a(paramContext);
    if (!paramContext.getBoolean("hasRequestAgreement"))
    {
      localTokenReq.setFirstTime(true);
      paramContext.saveBoolean("hasRequestAgreement", true);
      return localTokenReq;
    }
    localTokenReq.setFirstTime(false);
    return localTokenReq;
  }
  
  public static String c(Context paramContext)
  {
    try
    {
      PushPreferences localPushPreferences = new PushPreferences(paramContext, "aaid");
      if (localPushPreferences.containsKey("aaid"))
      {
        paramContext = localPushPreferences.getString("aaid");
      }
      else
      {
        paramContext = UUID.randomUUID().toString();
        localPushPreferences.saveString("aaid", paramContext);
        localPushPreferences.saveLong("creationTime", Long.valueOf(System.currentTimeMillis()));
      }
      return paramContext;
    }
    finally {}
  }
  
  public static String d(Context paramContext)
  {
    return AGConnectServicesConfig.fromContext(paramContext).getString("client/project_id");
  }
  
  public static boolean e(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (paramContext != null)
      {
        if (paramContext.metaData == null) {
          return false;
        }
        paramContext = paramContext.metaData;
        boolean bool = TextUtils.isEmpty(paramContext.getString("com.huawei.hms.client.service.name:base"));
        if (!bool) {
          break label57;
        }
      }
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label49:
      label57:
      break label49;
    }
    HMSLog.e(HmsInstanceId.TAG, "isIntegratedBaseSdk failed.");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.opendevice.o
 * JD-Core Version:    0.7.0.1
 */