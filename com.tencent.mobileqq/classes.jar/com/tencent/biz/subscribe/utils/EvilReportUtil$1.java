package com.tencent.biz.subscribe.utils;

import android.content.Context;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

final class EvilReportUtil$1
  implements Callback
{
  EvilReportUtil$1(Context paramContext, EvilReportUtil.EvilReportParams paramEvilReportParams) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    EvilReportUtil.access$000(this.val$context, this.val$reportParams, "Jbq0Dm55FudiaTa26UjP071XduhCyIKRYaK6MCcYzZA");
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    try
    {
      paramCall = new JSONObject(paramResponse.body().string()).optString("key");
      EvilReportUtil.access$000(this.val$context, this.val$reportParams, paramCall);
      return;
    }
    catch (Throwable paramCall)
    {
      paramCall.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.EvilReportUtil.1
 * JD-Core Version:    0.7.0.1
 */