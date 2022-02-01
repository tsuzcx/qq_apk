package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.protocol.link_report.LinkReport.ReportBiz;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.ad.tangram.statistics.AdReporterForLinkEvent;
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
        GdtLog.b("GdtLaunchAppWithDeeplinkJsCallHandler", paramVarArgs.toString());
        String str3 = paramVarArgs.getString("deeplink");
        String str4 = paramVarArgs.optString("packageName");
        String str1 = paramVarArgs.optString("traceId");
        String str2 = paramVarArgs.optString("aid");
        paramVarArgs = new link_report.LinkReport.ReportBiz();
        paramVarArgs.aid = str2;
        paramVarArgs.deeplink_scene = 2;
        paramVarArgs.traceid = str1;
        AdReporterForLinkEvent.reportAsync(localActivity, 4002001, null, paramVarArgs, null);
        if ((!TextUtils.isEmpty(str4)) && (!AdAppUtil.isInstalled(localActivity, str4)))
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
          paramVarArgs.deeplink = str3;
          paramVarArgs.packageName = str4;
          paramVarArgs.extrasForIntent = localBundle;
          paramVarArgs = AdAppDeeplinkLauncher.launch(localActivity, paramVarArgs);
          if (paramVarArgs != null) {
            i = paramVarArgs.getErrorCode();
          } else {
            i = 1;
          }
          if (i == 0)
          {
            paramVarArgs = new link_report.LinkReport.ReportBiz();
            paramVarArgs.aid = str2;
            paramVarArgs.deeplink_scene = 2;
            paramVarArgs.deeplink_type = 1;
            paramVarArgs.traceid = str1;
            AdReporterForLinkEvent.reportAsync(localActivity, 4002011, null, paramVarArgs, null);
          }
        }
      }
      catch (Throwable paramVarArgs)
      {
        GdtLog.d("GdtLaunchAppWithDeeplinkJsCallHandler", "handleJsCallRequest", paramVarArgs);
        i = 4;
      }
      paramVarArgs = new JSONObject();
      try
      {
        paramVarArgs.put("error", i);
      }
      catch (JSONException localJSONException)
      {
        GdtLog.d("GdtLaunchAppWithDeeplinkJsCallHandler", "handleJsCallRequest error", localJSONException);
      }
      try
      {
        paramGdtAdWebPlugin.callJs(paramString, new String[] { paramVarArgs.toString() });
      }
      catch (Throwable paramString)
      {
        GdtLog.d("GdtLaunchAppWithDeeplinkJsCallHandler", "handleJsCallRequest error", paramString);
      }
      paramString = localObject;
      if (paramGdtAdWebPlugin != null) {
        paramString = paramGdtAdWebPlugin.b();
      }
      AdAnalysisHelperForUtil.reportForJSBridgeInvoked(localActivity, false, "launchAppWithDeeplink", paramString);
      return true;
    }
    GdtLog.d("GdtLaunchAppWithDeeplinkJsCallHandler", "handleJsCallRequest error");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtLaunchAppWithDeeplinkJsCallHandler
 * JD-Core Version:    0.7.0.1
 */