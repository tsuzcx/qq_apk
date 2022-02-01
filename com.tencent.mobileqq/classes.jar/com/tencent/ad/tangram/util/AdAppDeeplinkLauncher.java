package com.tencent.ad.tangram.util;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.log.AdLog;

@Keep
public final class AdAppDeeplinkLauncher
{
  private static final String TAG = "AdAppDeeplinkLauncher";
  
  public static AdAppDeeplinkLauncher.Result canLaunch(Activity paramActivity, AdAppDeeplinkLauncher.Params paramParams)
  {
    AdAppDeeplinkLauncher.Result localResult = new AdAppDeeplinkLauncher.Result();
    if ((paramActivity != null) && (paramParams.isValid()))
    {
      paramParams = paramParams.getIntent();
      if (paramParams == null)
      {
        localResult.error = new AdError(201);
        return localResult;
      }
      localResult.resolveInfo = AdAppUtil.resolveActivity(paramActivity, paramParams);
      if (localResult.resolveInfo == null)
      {
        localResult.error = new AdError(204);
        return localResult;
      }
      localResult.error = new AdError(0);
      return localResult;
    }
    localResult.error = new AdError(4);
    return localResult;
  }
  
  public static AdAppDeeplinkLauncher.Result launch(Activity paramActivity, AdAppDeeplinkLauncher.Params paramParams)
  {
    Object localObject1 = new AdAppDeeplinkLauncher.Result();
    Object localObject2;
    if ((paramActivity != null) && (paramParams.isValid()))
    {
      localIntent = paramParams.getIntent();
      if (localIntent == null)
      {
        ((AdAppDeeplinkLauncher.Result)localObject1).error = new AdError(201);
      }
      else
      {
        localObject2 = canLaunch(paramActivity, paramParams);
        localObject1 = localObject2;
        if (localObject2 != null) {
          if (!((AdAppDeeplinkLauncher.Result)localObject2).isSuccess()) {
            localObject1 = localObject2;
          } else {
            try
            {
              paramActivity.startActivity(localIntent);
              ((AdAppDeeplinkLauncher.Result)localObject2).error = new AdError(0);
              localObject1 = localObject2;
            }
            catch (Throwable paramActivity)
            {
              AdLog.e("AdAppDeeplinkLauncher", "launch", paramActivity);
              ((AdAppDeeplinkLauncher.Result)localObject2).error = new AdError(202, paramActivity);
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    else
    {
      ((AdAppDeeplinkLauncher.Result)localObject1).error = new AdError(4);
    }
    paramActivity = (Activity)localObject1;
    if (localObject1 == null)
    {
      paramActivity = new AdAppDeeplinkLauncher.Result();
      paramActivity.error = new AdError(1);
    }
    Intent localIntent = null;
    if (paramParams != null) {
      localObject1 = paramParams.deeplink;
    } else {
      localObject1 = null;
    }
    if (paramParams != null) {
      localObject2 = paramParams.packageName;
    } else {
      localObject2 = null;
    }
    int i;
    if (paramParams != null) {
      i = paramParams.addflags;
    } else {
      i = -2147483648;
    }
    int j = paramActivity.getErrorCode();
    paramParams = localIntent;
    if (paramActivity.resolveInfo != null)
    {
      paramParams = localIntent;
      if (paramActivity.resolveInfo.activityInfo != null) {
        paramParams = paramActivity.resolveInfo.activityInfo.toString();
      }
    }
    AdLog.i("AdAppDeeplinkLauncher", String.format("launch \nparams deeplink:%s packageName:%s flags:%d \nresult errorCode:%d resolveInfo.activityInfo:%s", new Object[] { localObject1, localObject2, Integer.valueOf(i), Integer.valueOf(j), paramParams }));
    return paramActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdAppDeeplinkLauncher
 * JD-Core Version:    0.7.0.1
 */