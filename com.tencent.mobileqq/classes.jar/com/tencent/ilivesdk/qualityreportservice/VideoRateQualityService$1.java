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
    Log.d("VideoRateQualityService", "onResponse code " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.qualityreportservice.VideoRateQualityService.1
 * JD-Core Version:    0.7.0.1
 */