package com.tencent.gdtad.statistics;

import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdHttp.Params;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import org.json.JSONObject;

final class GdtReportForAntiSpam$2
  implements Runnable
{
  GdtReportForAntiSpam$2(byte[] paramArrayOfByte, GdtReportForAntiSpam.ReportCallback paramReportCallback, JSONObject paramJSONObject) {}
  
  public void run()
  {
    AdHttp.Params localParams = new AdHttp.Params();
    localParams.setUrl("https://sdk.e.qq.com/xq_event");
    localParams.method = "POST";
    localParams.contentType = "application/json";
    localParams.requestData = this.a;
    if (!localParams.canSend())
    {
      QLog.e("GdtReportForAntiSpam", 1, "reportFlyingStreaming error");
      return;
    }
    AdHttp.send(localParams);
    GdtReportForAntiSpam.ReportCallback localReportCallback = this.b;
    if (localReportCallback != null) {
      localReportCallback.a(localParams);
    }
    GdtLog.b("GdtReportForAntiSpam", String.format(Locale.getDefault(), "reportFlyingStreaming responseCode:%d durationMillis:%d %s", new Object[] { Integer.valueOf(localParams.responseCode), Long.valueOf(localParams.durationMillis), this.c.toString() }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtReportForAntiSpam.2
 * JD-Core Version:    0.7.0.1
 */