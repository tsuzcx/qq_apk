package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
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
    if (paramGdtAdWebPlugin != null) {}
    GdtHandler.Params localParams;
    for (Activity localActivity = paramGdtAdWebPlugin.a();; localActivity = null)
    {
      localParams = new GdtHandler.Params();
      boolean bool = GdtHandler.a(localParams, paramVarArgs[0]);
      if ((paramGdtAdWebPlugin != null) && (localActivity != null) && (bool)) {
        break;
      }
      GdtLog.d("GdtHandleAdJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    for (;;)
    {
      try
      {
        GdtLog.b("GdtHandleAdJsCallHandler", new JSONObject(paramVarArgs[0]).toString());
        localParams.jdField_c_of_type_Int = 7;
        localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localActivity);
        localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramGdtAdWebPlugin.a());
        localParams.jdField_a_of_type_JavaLangClass = GdtVideoCeilingFragmentForJS.class;
        localParams.jdField_b_of_type_JavaLangClass = GdtCanvasFragmentForJS.class;
        localParams.jdField_c_of_type_JavaLangClass = GdtBaseHalfScreenFragmentForJs.class;
        paramVarArgs = paramGdtAdWebPlugin.a().getIntent();
        if (TextUtils.isEmpty(paramVarArgs.getStringExtra("big_brother_ref_source_key")))
        {
          paramVarArgs = paramVarArgs.getStringExtra("big_brother_source_key");
          localParams.jdField_a_of_type_AndroidOsBundle = new Bundle();
          localParams.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", paramVarArgs);
          GdtHandler.a(localParams);
          paramGdtAdWebPlugin.callJs(paramString, null);
          paramString = localObject;
          if (paramGdtAdWebPlugin != null) {
            paramString = paramGdtAdWebPlugin.a();
          }
          AdReporterForAnalysis.reportForJSBridgeInvoked(localActivity, false, "handleClick", paramString, localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd);
          return true;
        }
      }
      catch (Throwable paramGdtAdWebPlugin)
      {
        GdtLog.d("GdtHandleAdJsCallHandler", "handleJsCallRequest error", paramGdtAdWebPlugin);
        return true;
      }
      paramVarArgs = paramVarArgs.getStringExtra("big_brother_ref_source_key");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtHandleClickJsCallHandler
 * JD-Core Version:    0.7.0.1
 */