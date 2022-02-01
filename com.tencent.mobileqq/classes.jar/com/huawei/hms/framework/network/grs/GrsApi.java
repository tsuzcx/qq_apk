package com.huawei.hms.framework.network.grs;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.util.HashMap;
import java.util.Map;

public class GrsApi
{
  private static final String TAG = "GrsApi";
  private static GrsClient grsClient;
  
  public static void ayncGetGrsUrl(String paramString1, String paramString2, IQueryUrlCallBack paramIQueryUrlCallBack)
  {
    if (paramIQueryUrlCallBack == null)
    {
      Logger.w("GrsApi", "IQueryUrlCallBack is must not null for process continue.");
      return;
    }
    GrsClient localGrsClient = grsClient;
    if ((localGrsClient != null) && (paramString1 != null) && (paramString2 != null))
    {
      localGrsClient.ayncGetGrsUrl(paramString1, paramString2, paramIQueryUrlCallBack);
      return;
    }
    paramIQueryUrlCallBack.onCallBackFail(-6);
  }
  
  public static void ayncGetGrsUrls(String paramString, IQueryUrlsCallBack paramIQueryUrlsCallBack)
  {
    if (paramIQueryUrlsCallBack == null)
    {
      Logger.w("GrsApi", "IQueryUrlsCallBack is must not null for process continue.");
      return;
    }
    GrsClient localGrsClient = grsClient;
    if ((localGrsClient != null) && (paramString != null))
    {
      localGrsClient.ayncGetGrsUrls(paramString, paramIQueryUrlsCallBack);
      return;
    }
    paramIQueryUrlsCallBack.onCallBackFail(-6);
  }
  
  public static void clearSp()
  {
    GrsClient localGrsClient = grsClient;
    if (localGrsClient == null)
    {
      Logger.w("GrsApi", "GrsApi.clearSp return because grsClient is null.");
      return;
    }
    localGrsClient.clearSp();
  }
  
  public static boolean forceExpire()
  {
    GrsClient localGrsClient = grsClient;
    if (localGrsClient == null)
    {
      Logger.w("GrsApi", "GrsApi.forceExpire return false because grsClient is null.");
      return false;
    }
    return localGrsClient.forceExpire();
  }
  
  @Deprecated
  public static CountryCodeBean getCountryCode(Context paramContext, boolean paramBoolean)
  {
    return a.a(paramContext, paramBoolean);
  }
  
  public static int grsSdkInit(Context paramContext, GrsBaseInfo paramGrsBaseInfo)
  {
    grsClient = new GrsClient(paramContext, paramGrsBaseInfo);
    return 0;
  }
  
  public static String synGetGrsUrl(String paramString1, String paramString2)
  {
    GrsClient localGrsClient = grsClient;
    if ((localGrsClient != null) && (paramString1 != null) && (paramString2 != null)) {
      return localGrsClient.synGetGrsUrl(paramString1, paramString2);
    }
    Logger.w("GrsApi", "GrsApi.synGetGrsUrl method maybe grsSdkInit has not completed and grsClient is null.");
    return null;
  }
  
  public static Map<String, String> synGetGrsUrls(String paramString)
  {
    GrsClient localGrsClient = grsClient;
    if ((localGrsClient != null) && (paramString != null)) {
      return localGrsClient.synGetGrsUrls(paramString);
    }
    Logger.w("GrsApi", "GrsApi.synGetGrsUrls method maybe grsSdkInit has not completed and grsClient is null.");
    return new HashMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.GrsApi
 * JD-Core Version:    0.7.0.1
 */