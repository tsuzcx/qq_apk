package com.tencent.gdtad.statistics;

import android.text.TextUtils;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdHttp.Params;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.Locale;
import org.json.JSONObject;

final class GdtReporter$2
  implements Runnable
{
  GdtReporter$2(GdtMotiveVideoModel paramGdtMotiveVideoModel, JSONObject paramJSONObject) {}
  
  public void run()
  {
    Object localObject = this.a.d();
    if (localObject == null)
    {
      QLog.i("GdtReporter", 1, "reportPlayFail fail,gdtad is null");
      return;
    }
    if (TextUtils.isEmpty(((GdtAd)localObject).getVideoReportUrl()))
    {
      QLog.i("GdtReporter", 1, "reportPlayFail fail,url is empty");
      return;
    }
    String str = this.b.toString();
    AdHttp.Params localParams = new AdHttp.Params();
    localParams.method = "GET";
    localObject = String.format(Locale.CHINA, "%s&video=%s", new Object[] { ((GdtAd)localObject).getVideoReportUrl(), URLEncoder.encode(str) });
    localParams.setUrl((String)localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportPlayFail url:");
    localStringBuilder.append((String)localObject);
    GdtLog.b("GdtReporter", localStringBuilder.toString());
    if (!localParams.canSend())
    {
      QLog.e("GdtReporter", 1, "reportPlayFail error");
      return;
    }
    AdHttp.send(localParams);
    GdtLog.b("GdtReporter", String.format(Locale.getDefault(), "reportPlayFail responseCode:%d durationMillis:%d %s", new Object[] { Integer.valueOf(localParams.responseCode), Long.valueOf(localParams.durationMillis), str }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtReporter.2
 * JD-Core Version:    0.7.0.1
 */