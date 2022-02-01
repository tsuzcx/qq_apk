package com.tencent.ilivesdk.qualityreportservice;

import android.util.Log;
import com.tencent.falco.base.libapi.http.HttpResponse;
import org.json.JSONObject;

class VideoRateQualityService$1
  implements HttpResponse
{
  VideoRateQualityService$1(VideoRateQualityService paramVideoRateQualityService) {}
  
  public void onResponse(int paramInt, JSONObject paramJSONObject)
  {
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("onResponse code ");
    paramJSONObject.append(paramInt);
    Log.d("VideoRateQualityService", paramJSONObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.qualityreportservice.VideoRateQualityService.1
 * JD-Core Version:    0.7.0.1
 */