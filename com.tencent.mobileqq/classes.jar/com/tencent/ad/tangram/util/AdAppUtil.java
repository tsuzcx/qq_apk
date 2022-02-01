package com.tencent.ad.tangram.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.log.AdLog;

@Keep
public final class AdAppUtil
{
  private static final String TAG = "AdAppUtil";
  private static String currentRunningPackageName;
  
  public static String getCurrentRunningPackageName(Context paramContext, String paramString)
  {
    if ((!TextUtils.isEmpty(currentRunningPackageName)) || (paramContext == null)) {}
    for (;;)
    {
      if (!TextUtils.isEmpty(currentRunningPackageName)) {
        paramString = currentRunningPackageName;
      }
      return paramString;
      paramContext = paramContext.getApplicationContext();
      if (paramContext != null)
      {
        paramContext = paramContext.getPackageName();
        if (!TextUtils.isEmpty(paramContext)) {
          currentRunningPackageName = paramContext;
        }
      }
    }
  }
  
  public static boolean isInstalled(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      AdLog.e("AdAppUtil", "isInstalled error");
    }
    for (;;)
    {
      return false;
      if (TextUtils.isEmpty(paramString)) {
        break;
      }
      paramContext = paramContext.getPackageManager();
      if (paramContext == null) {
        break;
      }
      try
      {
        paramContext = paramContext.getApplicationInfo(paramString, 0);
        if (paramContext != null) {
          return true;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext) {}
    }
    return false;
  }
  
  public static AdError launch(Context paramContext, String paramString, Bundle paramBundle)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
    {
      AdLog.e("AdAppUtil", "launch error");
      return new AdError(4);
    }
    AdLog.i("AdAppUtil", String.format("launch %s", new Object[] { paramString }));
    paramString = paramContext.getPackageManager().getLaunchIntentForPackage(paramString);
    if (paramString == null)
    {
      AdLog.e("AdAppUtil", "launch error");
      return new AdError(203);
    }
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      paramString.putExtras(paramBundle);
    }
    try
    {
      paramContext.startActivity(paramString);
      paramContext = new AdError(0);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      AdLog.e("AdAppUtil", "launch", paramContext);
    }
    return new AdError(202, paramContext);
  }
  
  public static ResolveInfo resolveActivity(Context paramContext, Intent paramIntent)
  {
    if ((paramContext == null) || (paramIntent == null)) {}
    do
    {
      return null;
      paramContext = paramContext.getPackageManager();
    } while (paramContext == null);
    return paramContext.resolveActivity(paramIntent, 65536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdAppUtil
 * JD-Core Version:    0.7.0.1
 */