package com.tencent.biz.pubaccount.util.api.impl;

import com.tencent.mobileqq.kandian.biz.fastweb.CallCommentJs;
import org.json.JSONObject;

class PublicAccountH5AbilityPluginImpl$9
  implements CallCommentJs
{
  PublicAccountH5AbilityPluginImpl$9(PublicAccountH5AbilityPluginImpl paramPublicAccountH5AbilityPluginImpl) {}
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    this.a.callJs(paramString, new String[] { paramJSONObject.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.9
 * JD-Core Version:    0.7.0.1
 */