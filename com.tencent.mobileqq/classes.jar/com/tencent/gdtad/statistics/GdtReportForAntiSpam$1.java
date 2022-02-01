package com.tencent.gdtad.statistics;

import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdHttp.Params;
import com.tencent.gdtad.log.GdtLog;
import org.json.JSONObject;

final class GdtReportForAntiSpam$1
  implements Runnable
{
  GdtReportForAntiSpam$1(byte[] paramArrayOfByte, JSONObject paramJSONObject) {}
  
  public void run()
  {
    AdHttp.Params localParams = new AdHttp.Params();
    localParams.setUrl("https://rpt.gdt.qq.com/mqq_log");
    localParams.method = "POST";
    localParams.contentType = "application/json";
    localParams.requestData = this.jdField_a_of_type_ArrayOfByte;
    if (!localParams.canSend())
    {
      GdtLog.d("GdtReportForAntiSpam", "reportAntiSpam error");
      return;
    }
    AdHttp.send(localParams);
    GdtLog.b("GdtReportForAntiSpam", String.format("reportAntiSpam responseCode:%d durationMillis:%d %s", new Object[] { Integer.valueOf(localParams.responseCode), Long.valueOf(localParams.durationMillis), this.jdField_a_of_type_OrgJsonJSONObject.toString() }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtReportForAntiSpam.1
 * JD-Core Version:    0.7.0.1
 */