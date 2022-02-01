package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.log.GdtLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class GdtHandleClickJsCallHandler
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
    GdtHandler.Params localParams = new GdtHandler.Params();
    boolean bool = GdtHandler.a(localParams, paramVarArgs[0]);
    if ((paramGdtAdWebPlugin != null) && (localActivity != null) && (bool)) {
      try
      {
        GdtLog.b("GdtHandleAdJsCallHandler", new JSONObject(paramVarArgs[0]).toString());
        localParams.q = 7;
        localParams.r = new WeakReference(localActivity);
        localParams.s = new WeakReference(paramGdtAdWebPlugin.c());
        localParams.t = GdtBaseHalfScreenFragmentForJs.class;
        paramVarArgs = paramGdtAdWebPlugin.a().getIntent();
        if (TextUtils.isEmpty(paramVarArgs.getStringExtra("big_brother_ref_source_key"))) {
          paramVarArgs = paramVarArgs.getStringExtra("big_brother_source_key");
        } else {
          paramVarArgs = paramVarArgs.getStringExtra("big_brother_ref_source_key");
        }
        localParams.p = new Bundle();
        localParams.p.putString("big_brother_ref_source_key", paramVarArgs);
        GdtHandler.a(localParams);
        paramGdtAdWebPlugin.callJs(paramString, null);
        paramString = localObject;
        if (paramGdtAdWebPlugin != null) {
          paramString = paramGdtAdWebPlugin.b();
        }
        AdAnalysisHelperForUtil.reportForJSBridgeInvoked(localActivity, false, "handleClick", paramString, localParams.a);
        return true;
      }
      catch (Throwable paramGdtAdWebPlugin)
      {
        GdtLog.d("GdtHandleAdJsCallHandler", "handleJsCallRequest error", paramGdtAdWebPlugin);
        return true;
      }
    }
    GdtLog.d("GdtHandleAdJsCallHandler", "handleJsCallRequest error");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtHandleClickJsCallHandler
 * JD-Core Version:    0.7.0.1
 */