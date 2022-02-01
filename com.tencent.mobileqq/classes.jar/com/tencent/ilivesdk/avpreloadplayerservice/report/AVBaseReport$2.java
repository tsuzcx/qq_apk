package com.tencent.ilivesdk.avpreloadplayerservice.report;

import com.tencent.falco.base.libapi.http.HttpResponse;
import com.tencent.falco.base.libapi.log.LogInterface;
import org.json.JSONObject;

class AVBaseReport$2
  implements HttpResponse
{
  AVBaseReport$2(AVBaseReport paramAVBaseReport) {}
  
  public void onResponse(int paramInt, JSONObject paramJSONObject)
  {
    if (AVBaseReport.a(this.a) != null)
    {
      paramJSONObject = AVBaseReport.a(this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report result code=");
      localStringBuilder.append(paramInt);
      paramJSONObject.i("AVReport", localStringBuilder.toString(), new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadplayerservice.report.AVBaseReport.2
 * JD-Core Version:    0.7.0.1
 */