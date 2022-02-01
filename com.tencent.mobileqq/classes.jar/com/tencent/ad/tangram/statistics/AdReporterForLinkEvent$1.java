package com.tencent.ad.tangram.statistics;

import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdHttp.Params;
import java.util.Locale;
import org.json.JSONObject;

final class AdReporterForLinkEvent$1
  implements Runnable
{
  AdReporterForLinkEvent$1(byte[] paramArrayOfByte, JSONObject paramJSONObject) {}
  
  public void run()
  {
    AdHttp.Params localParams = new AdHttp.Params();
    localParams.setUrl("https://sdk.e.qq.com/link_event");
    localParams.method = "POST";
    localParams.contentType = "application/json";
    localParams.requestData = this.val$data;
    if (!localParams.canSend())
    {
      AdLog.e("AdReporterForLinkEvent", "reportAsync to link event error");
      return;
    }
    AdHttp.send(localParams);
    AdLog.i("AdReporterForLinkEvent", String.format(Locale.getDefault(), "reportAsync to link event responseCode:%d durationMillis:%d %s", new Object[] { Integer.valueOf(localParams.responseCode), Long.valueOf(localParams.durationMillis), this.val$jsonObject.toString() }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.statistics.AdReporterForLinkEvent.1
 * JD-Core Version:    0.7.0.1
 */