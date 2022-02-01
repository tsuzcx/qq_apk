package com.tencent.biz.pubaccount.util.api.impl;

import com.tencent.biz.pubaccount.readinjoy.video.VideoWebPreDownload.CallbackListener;
import org.json.JSONException;
import org.json.JSONObject;

class PublicAccountH5AbilityPluginImpl$8
  implements VideoWebPreDownload.CallbackListener
{
  PublicAccountH5AbilityPluginImpl$8(PublicAccountH5AbilityPluginImpl paramPublicAccountH5AbilityPluginImpl) {}
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("video_vid", paramString1);
      localJSONObject.put("retCode", paramInt);
      this.a.callJs(paramString2, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.8
 * JD-Core Version:    0.7.0.1
 */