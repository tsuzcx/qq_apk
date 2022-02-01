package com.tencent.gdtad.jsbridge;

import android.text.TextUtils;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.mini.api.QQMiniManager;
import org.json.JSONException;
import org.json.JSONObject;

final class GdtDeviceDemoJsCallHandler
  implements GdtJsCallHandler
{
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    if (paramGdtAdWebPlugin != null) {
      paramString = paramGdtAdWebPlugin.a();
    } else {
      paramString = null;
    }
    if ((paramGdtAdWebPlugin != null) && (paramString != null)) {
      try
      {
        paramGdtAdWebPlugin = new JSONObject(paramVarArgs[0]).optString("process", "com.tencent.mobileqq:mini");
        if (TextUtils.equals(paramGdtAdWebPlugin, "com.tencent.mobileqq")) {
          paramGdtAdWebPlugin = PublicFragmentActivity.class;
        } else if (TextUtils.equals(paramGdtAdWebPlugin, "com.tencent.mobileqq:tool")) {
          paramGdtAdWebPlugin = PublicFragmentActivityForTool.class;
        } else {
          paramGdtAdWebPlugin = QQMiniManager.getPublicFragmentActivityForMiniClass();
        }
        GdtDeviceDemoFragment.a(paramString, paramGdtAdWebPlugin);
        return true;
      }
      catch (JSONException paramGdtAdWebPlugin)
      {
        GdtLog.d("GdtDeviceDemoJsCallHandler", "handleJsCallRequest error", paramGdtAdWebPlugin);
        return true;
      }
    }
    GdtLog.d("GdtDeviceDemoJsCallHandler", "handleJsCallRequest error");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtDeviceDemoJsCallHandler
 * JD-Core Version:    0.7.0.1
 */