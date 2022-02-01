package com.tencent.biz.pubaccount.util.api.impl;

import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.CallCommentJs;
import org.json.JSONObject;

class PublicAccountH5AbilityPluginImpl$9
  implements BridgeModule.CallCommentJs
{
  PublicAccountH5AbilityPluginImpl$9(PublicAccountH5AbilityPluginImpl paramPublicAccountH5AbilityPluginImpl) {}
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    this.a.callJs(paramString, new String[] { paramJSONObject.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.9
 * JD-Core Version:    0.7.0.1
 */