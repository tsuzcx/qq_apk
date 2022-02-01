package com.tencent.ilivesdk.avpreloadservice;

import com.tencent.falco.base.libapi.http.HttpInterface;
import org.json.JSONObject;

class AVPreloadSwitch$2
  implements Runnable
{
  AVPreloadSwitch$2(AVPreloadSwitch paramAVPreloadSwitch, String paramString, JSONObject paramJSONObject, AVPreloadSwitch.OnCgiResponse paramOnCgiResponse) {}
  
  public void run()
  {
    AVPreloadSwitch.c(this.this$0).post(this.a, this.b, new AVPreloadSwitch.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadSwitch.2
 * JD-Core Version:    0.7.0.1
 */