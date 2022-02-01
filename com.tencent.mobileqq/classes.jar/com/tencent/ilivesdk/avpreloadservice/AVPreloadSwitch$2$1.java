package com.tencent.ilivesdk.avpreloadservice;

import com.tencent.falco.base.libapi.http.HttpResponse;
import com.tencent.falco.utils.ThreadCenter;
import org.json.JSONObject;

class AVPreloadSwitch$2$1
  implements HttpResponse
{
  AVPreloadSwitch$2$1(AVPreloadSwitch.2 param2) {}
  
  public void onResponse(int paramInt, JSONObject paramJSONObject)
  {
    ThreadCenter.postUITask(this.a.this$0, new AVPreloadSwitch.2.1.1(this, paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadSwitch.2.1
 * JD-Core Version:    0.7.0.1
 */