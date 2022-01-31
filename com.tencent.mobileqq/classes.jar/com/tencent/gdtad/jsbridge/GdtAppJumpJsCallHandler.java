package com.tencent.gdtad.jsbridge;

import android.os.Bundle;
import com.tencent.gdtad.aditem.GdtBaseAdItem;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtAppOpenUtil;
import org.json.JSONObject;

public class GdtAppJumpJsCallHandler
  implements GdtJsCallHandler
{
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    try
    {
      paramGdtAdWebPlugin = new JSONObject(paramVarArgs[0]);
      GdtLog.a("GdtAppJumpJsCallHandler", "handleJsCallRequest " + paramGdtAdWebPlugin);
      paramString = paramGdtAdWebPlugin.optString("adId");
      paramGdtAdWebPlugin.optString("downloadUrlType");
      if ("1".equals(paramGdtAdWebPlugin.optString("autoDownload"))) {}
      for (paramGdtAdWebPlugin = "1";; paramGdtAdWebPlugin = "0")
      {
        new Bundle();
        paramVarArgs = GdtBaseAdItem.obtain(paramVarArgs[0]);
        if (("260982".equals(paramString)) && (!"1".equals(paramGdtAdWebPlugin))) {
          paramVarArgs.openmain = true;
        }
        GdtAppOpenUtil.a(paramVarArgs);
        return true;
      }
      return true;
    }
    catch (Exception paramGdtAdWebPlugin)
    {
      GdtLog.d("GdtAppJumpJsCallHandler", "handleJsCallRequest", paramGdtAdWebPlugin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtAppJumpJsCallHandler
 * JD-Core Version:    0.7.0.1
 */