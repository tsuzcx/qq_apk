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
        localParams.c = 7;
        localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localActivity);
        localParams.b = new WeakReference(paramGdtAdWebPlugin.a());
        localParams.jdField_a_of_type_JavaLangClass = GdtBaseHalfScreenFragmentForJs.class;
        paramVarArgs = paramGdtAdWebPlugin.a().getIntent();
        if (TextUtils.isEmpty(paramVarArgs.getStringExtra("big_brother_ref_source_key"))) {
          paramVarArgs = paramVarArgs.getStringExtra("big_brother_source_key");
        } else {
          paramVarArgs = paramVarArgs.getStringExtra("big_brother_ref_source_key");
        }
        localParams.jdField_a_of_type_AndroidOsBundle = new Bundle();
        localParams.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", paramVarArgs);
        GdtHandler.a(localParams);
        paramGdtAdWebPlugin.callJs(paramString, null);
        paramString = localObject;
        if (paramGdtAdWebPlugin != null) {
          paramString = paramGdtAdWebPlugin.a();
        }
        AdAnalysisHelperForUtil.reportForJSBridgeInvoked(localActivity, false, "handleClick", paramString, localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtHandleClickJsCallHandler
 * JD-Core Version:    0.7.0.1
 */