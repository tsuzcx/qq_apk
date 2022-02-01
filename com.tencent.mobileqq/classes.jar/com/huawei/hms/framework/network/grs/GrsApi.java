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
    if ((grsClient == null) || (paramString1 == null) || (paramString2 == null))
    {
      paramIQueryUrlCallBack.onCallBackFail(-6);
      return;
    }
    grsClient.ayncGetGrsUrl(paramString1, paramString2, paramIQueryUrlCallBack);
  }
  
  public static void ayncGetGrsUrls(String paramString, IQueryUrlsCallBack paramIQueryUrlsCallBack)
  {
    if (paramIQueryUrlsCallBack == null)
    {
      Logger.w("GrsApi", "IQueryUrlsCallBack is must not null for process continue.");
      return;
    }
    if ((grsClient == null) || (paramString == null))
    {
      paramIQueryUrlsCallBack.onCallBackFail(-6);
      return;
    }
    grsClient.ayncGetGrsUrls(paramString, paramIQueryUrlsCallBack);
  }
  
  public static void clearSp()
  {
    if (grsClient == null)
    {
      Logger.w("GrsApi", "GrsApi.clearSp return because grsClient is null.");
      return;
    }
    grsClient.clearSp();
  }
  
  public static boolean forceExpire()
  {
    if (grsClient == null)
    {
      Logger.w("GrsApi", "GrsApi.forceExpire return false because grsClient is null.");
      return false;
    }
    return grsClient.forceExpire();
  }
  
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
    if ((grsClient == null) || (paramString1 == null) || (paramString2 == null))
    {
      Logger.w("GrsApi", "GrsApi.synGetGrsUrl method maybe grsSdkInit has not completed and grsClient is null.");
      return null;
    }
    return grsClient.synGetGrsUrl(paramString1, paramString2);
  }
  
  public static Map<String, String> synGetGrsUrls(String paramString)
  {
    if ((grsClient == null) || (paramString == null))
    {
      Logger.w("GrsApi", "GrsApi.synGetGrsUrls method maybe grsSdkInit has not completed and grsClient is null.");
      return new HashMap();
    }
    return grsClient.synGetGrsUrls(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.GrsApi
 * JD-Core Version:    0.7.0.1
 */