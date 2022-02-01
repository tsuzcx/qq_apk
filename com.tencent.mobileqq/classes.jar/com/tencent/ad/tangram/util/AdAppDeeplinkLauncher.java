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
    if ((paramActivity == null) || (!paramParams.isValid()))
    {
      localResult.error = new AdError(4);
      return localResult;
    }
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
  
  public static AdAppDeeplinkLauncher.Result launch(Activity paramActivity, AdAppDeeplinkLauncher.Params paramParams)
  {
    Object localObject3 = null;
    Object localObject1 = new AdAppDeeplinkLauncher.Result();
    label77:
    Object localObject2;
    if ((paramActivity == null) || (!paramParams.isValid()))
    {
      ((AdAppDeeplinkLauncher.Result)localObject1).error = new AdError(4);
      paramActivity = (Activity)localObject1;
      localObject1 = paramActivity;
      if (paramActivity == null)
      {
        localObject1 = new AdAppDeeplinkLauncher.Result();
        ((AdAppDeeplinkLauncher.Result)localObject1).error = new AdError(1);
      }
      if (paramParams == null) {
        break label297;
      }
      paramActivity = paramParams.deeplink;
      if (paramParams == null) {
        break label302;
      }
      localObject2 = paramParams.packageName;
      label87:
      if (paramParams == null) {
        break label308;
      }
    }
    label297:
    label302:
    label308:
    for (int i = paramParams.addflags;; i = -2147483648)
    {
      for (;;)
      {
        int j = ((AdAppDeeplinkLauncher.Result)localObject1).getErrorCode();
        paramParams = localObject3;
        if (((AdAppDeeplinkLauncher.Result)localObject1).resolveInfo != null)
        {
          paramParams = localObject3;
          if (((AdAppDeeplinkLauncher.Result)localObject1).resolveInfo.activityInfo != null) {
            paramParams = ((AdAppDeeplinkLauncher.Result)localObject1).resolveInfo.activityInfo.toString();
          }
        }
        AdLog.i("AdAppDeeplinkLauncher", String.format("launch \nparams deeplink:%s packageName:%s flags:%d \nresult errorCode:%d resolveInfo.activityInfo:%s", new Object[] { paramActivity, localObject2, Integer.valueOf(i), Integer.valueOf(j), paramParams }));
        return localObject1;
        localObject2 = paramParams.getIntent();
        if (localObject2 == null)
        {
          ((AdAppDeeplinkLauncher.Result)localObject1).error = new AdError(201);
          paramActivity = (Activity)localObject1;
          break;
        }
        localObject1 = canLaunch(paramActivity, paramParams);
        if (localObject1 != null)
        {
          if (!((AdAppDeeplinkLauncher.Result)localObject1).isSuccess())
          {
            paramActivity = (Activity)localObject1;
            break;
          }
          try
          {
            paramActivity.startActivity((Intent)localObject2);
            ((AdAppDeeplinkLauncher.Result)localObject1).error = new AdError(0);
            paramActivity = (Activity)localObject1;
          }
          catch (Throwable paramActivity)
          {
            AdLog.e("AdAppDeeplinkLauncher", "launch", paramActivity);
            ((AdAppDeeplinkLauncher.Result)localObject1).error = new AdError(202, paramActivity);
          }
        }
      }
      paramActivity = (Activity)localObject1;
      break;
      paramActivity = null;
      break label77;
      localObject2 = null;
      break label87;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdAppDeeplinkLauncher
 * JD-Core Version:    0.7.0.1
 */