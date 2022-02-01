package com.tencent.gdtad.jsbridge;

import com.tencent.gdtad.IGdtAPI;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import org.json.JSONObject;

class GdtWebReportFlyingStreamingHandler
  extends GdtMvWebJsCallHandler
{
  private final String b = "event_code";
  
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    if (paramGdtAdWebPlugin != null) {
      paramString = paramGdtAdWebPlugin.a();
    } else {
      paramString = null;
    }
    if ((paramGdtAdWebPlugin != null) && (paramString != null))
    {
      paramGdtAdWebPlugin = new StringBuilder();
      paramGdtAdWebPlugin.append("args=");
      paramGdtAdWebPlugin.append(Arrays.toString(paramVarArgs));
      QLog.i("WebGdtWebReportFlyingStreamingHandler", 1, paramGdtAdWebPlugin.toString());
      long l1 = -1L;
      try
      {
        long l2 = new JSONObject(paramVarArgs[0]).optLong("event_code");
        l1 = l2;
      }
      catch (Throwable paramGdtAdWebPlugin)
      {
        QLog.e("WebGdtWebReportFlyingStreamingHandler", 1, "json", paramGdtAdWebPlugin);
      }
      ((IGdtAPI)QRoute.api(IGdtAPI.class)).reportADFlyingStreaming(l1);
      return true;
    }
    QLog.i("WebGdtWebReportFlyingStreamingHandler", 1, "webPlugin == null || activity == null");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtWebReportFlyingStreamingHandler
 * JD-Core Version:    0.7.0.1
 */