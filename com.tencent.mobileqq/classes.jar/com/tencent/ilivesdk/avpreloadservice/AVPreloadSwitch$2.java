package com.tencent.ilivesdk.avpreloadservice;

import com.tencent.falco.base.libapi.http.HttpInterface;
import org.json.JSONObject;

class AVPreloadSwitch$2
  implements Runnable
{
  AVPreloadSwitch$2(AVPreloadSwitch paramAVPreloadSwitch, String paramString, JSONObject paramJSONObject, AVPreloadSwitch.OnCgiResponse paramOnCgiResponse) {}
  
  public void run()
  {
    AVPreloadSwitch.a(this.this$0).post(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_OrgJsonJSONObject, new AVPreloadSwitch.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadSwitch.2
 * JD-Core Version:    0.7.0.1
 */