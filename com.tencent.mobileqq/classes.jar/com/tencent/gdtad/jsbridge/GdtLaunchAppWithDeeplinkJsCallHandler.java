package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.ad.tangram.util.AdAppDeeplinkLauncher;
import com.tencent.ad.tangram.util.AdAppDeeplinkLauncher.Params;
import com.tencent.ad.tangram.util.AdAppDeeplinkLauncher.Result;
import com.tencent.ad.tangram.util.AdAppUtil;
import com.tencent.gdtad.log.GdtLog;
import org.json.JSONException;
import org.json.JSONObject;

class GdtLaunchAppWithDeeplinkJsCallHandler
  implements GdtJsCallHandler
{
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    Activity localActivity;
    if (paramGdtAdWebPlugin != null) {
      localActivity = paramGdtAdWebPlugin.a();
    } else {
      localActivity = null;
    }
    if ((paramGdtAdWebPlugin != null) && (localActivity != null))
    {
      int i;
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        GdtLog.b("GdtXiJingLaunchAppWithDeeplinkJsCallHandler", paramVarArgs.toString());
        String str1 = paramVarArgs.getString("deeplink");
        String str2 = paramVarArgs.optString("packageName");
        if ((!TextUtils.isEmpty(str2)) && (!AdAppUtil.isInstalled(localActivity, str2)))
        {
          i = 12;
        }
        else
        {
          Bundle localBundle = new Bundle();
          localBundle.putString("big_brother_source_key", "biz_src_ads");
          if (localActivity.getIntent() != null)
          {
            if (TextUtils.isEmpty(localActivity.getIntent().getStringExtra("big_brother_ref_source_key"))) {
              paramVarArgs = localActivity.getIntent().getStringExtra("big_brother_source_key");
            } else {
              paramVarArgs = localActivity.getIntent().getStringExtra("big_brother_ref_source_key");
            }
            localBundle.putString("big_brother_ref_source_key", paramVarArgs);
          }
          paramVarArgs = new AdAppDeeplinkLauncher.Params();
          paramVarArgs.deeplink = str1;
          paramVarArgs.packageName = str2;
          paramVarArgs.extrasForIntent = localBundle;
          paramVarArgs = AdAppDeeplinkLauncher.launch(localActivity, paramVarArgs);
          if (paramVarArgs != null) {
            i = paramVarArgs.getErrorCode();
          } else {
            i = 1;
          }
        }
      }
      catch (Throwable paramVarArgs)
      {
        GdtLog.d("GdtXiJingLaunchAppWithDeeplinkJsCallHandler", "handleJsCallRequest", paramVarArgs);
        i = 4;
      }
      paramVarArgs = new JSONObject();
      try
      {
        paramVarArgs.put("error", i);
      }
      catch (JSONException localJSONException)
      {
        GdtLog.d("GdtXiJingLaunchAppWithDeeplinkJsCallHandler", "handleJsCallRequest error", localJSONException);
      }
      try
      {
        paramGdtAdWebPlugin.callJs(paramString, new String[] { paramVarArgs.toString() });
      }
      catch (Throwable paramString)
      {
        GdtLog.d("GdtXiJingLaunchAppWithDeeplinkJsCallHandler", "handleJsCallRequest error", paramString);
      }
      paramString = localObject;
      if (paramGdtAdWebPlugin != null) {
        paramString = paramGdtAdWebPlugin.a();
      }
      AdAnalysisHelperForUtil.reportForJSBridgeInvoked(localActivity, false, "launchAppWithDeeplink", paramString);
      return true;
    }
    GdtLog.d("GdtXiJingLaunchAppWithDeeplinkJsCallHandler", "handleJsCallRequest error");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtLaunchAppWithDeeplinkJsCallHandler
 * JD-Core Version:    0.7.0.1
 */