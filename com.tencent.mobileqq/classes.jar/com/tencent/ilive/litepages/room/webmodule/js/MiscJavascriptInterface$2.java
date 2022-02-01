package com.tencent.ilive.litepages.room.webmodule.js;

import com.tencent.falco.base.libapi.http.HttpResponse;
import org.json.JSONObject;

class MiscJavascriptInterface$2
  implements HttpResponse
{
  MiscJavascriptInterface$2(MiscJavascriptInterface paramMiscJavascriptInterface) {}
  
  public void onResponse(int paramInt, JSONObject paramJSONObject)
  {
    paramJSONObject = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resultCode = ");
    localStringBuilder.append(paramInt);
    MiscJavascriptInterface.access$100(paramJSONObject, "MiscJavascriptInterface", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.js.MiscJavascriptInterface.2
 * JD-Core Version:    0.7.0.1
 */