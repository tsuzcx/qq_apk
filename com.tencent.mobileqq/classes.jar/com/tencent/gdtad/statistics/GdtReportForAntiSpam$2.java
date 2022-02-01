package com.tencent.gdtad.statistics;

import acho;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdHttp.Params;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import org.json.JSONObject;

public final class GdtReportForAntiSpam$2
  implements Runnable
{
  public GdtReportForAntiSpam$2(byte[] paramArrayOfByte, JSONObject paramJSONObject) {}
  
  public void run()
  {
    AdHttp.Params localParams = new AdHttp.Params();
    localParams.setUrl("https://sdk.e.qq.com/xq_event");
    localParams.method = "POST";
    localParams.contentType = "application/json";
    localParams.requestData = this.jdField_a_of_type_ArrayOfByte;
    if (!localParams.canSend())
    {
      QLog.e("GdtReportForAntiSpam", 1, "reportFlyingStreaming error");
      return;
    }
    AdHttp.send(localParams);
    acho.b("GdtReportForAntiSpam", String.format(Locale.getDefault(), "reportFlyingStreaming responseCode:%d durationMillis:%d %s", new Object[] { Integer.valueOf(localParams.responseCode), Long.valueOf(localParams.durationMillis), this.jdField_a_of_type_OrgJsonJSONObject.toString() }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtReportForAntiSpam.2
 * JD-Core Version:    0.7.0.1
 */