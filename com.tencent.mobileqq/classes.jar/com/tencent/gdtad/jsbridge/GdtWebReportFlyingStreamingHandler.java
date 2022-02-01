package com.tencent.gdtad.jsbridge;

import com.tencent.gdtad.api.motivevideo.GdtADFlyingStreamingReportHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import org.json.JSONObject;

class GdtWebReportFlyingStreamingHandler
  extends GdtMvWebJsCallHandler
{
  private final String a = "event_code";
  
  public boolean a(GdtAdWebPlugin paramGdtAdWebPlugin, String paramString, String... paramVarArgs)
  {
    if (paramGdtAdWebPlugin != null) {}
    for (paramString = paramGdtAdWebPlugin.a(); (paramGdtAdWebPlugin == null) || (paramString == null); paramString = null)
    {
      QLog.i("WebGdtWebReportFlyingStreamingHandler", 1, "webPlugin == null || activity == null");
      return true;
    }
    QLog.i("WebGdtWebReportFlyingStreamingHandler", 1, "args=" + Arrays.toString(paramVarArgs));
    long l1 = -1L;
    try
    {
      long l2 = new JSONObject(paramVarArgs[0]).optLong("event_code");
      l1 = l2;
    }
    catch (Throwable paramGdtAdWebPlugin)
    {
      for (;;)
      {
        QLog.e("WebGdtWebReportFlyingStreamingHandler", 1, "json", paramGdtAdWebPlugin);
      }
    }
    GdtADFlyingStreamingReportHelper.a().a(l1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtWebReportFlyingStreamingHandler
 * JD-Core Version:    0.7.0.1
 */