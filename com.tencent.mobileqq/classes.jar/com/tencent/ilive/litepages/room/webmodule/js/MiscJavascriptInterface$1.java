package com.tencent.ilive.litepages.room.webmodule.js;

import com.tencent.falco.base.libapi.http.HttpResponse;
import org.json.JSONObject;

class MiscJavascriptInterface$1
  implements HttpResponse
{
  MiscJavascriptInterface$1(MiscJavascriptInterface paramMiscJavascriptInterface) {}
  
  public void onResponse(int paramInt, JSONObject paramJSONObject)
  {
    MiscJavascriptInterface.access$000(this.this$0, "MiscJavascriptInterface", "resultCode = " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.js.MiscJavascriptInterface.1
 * JD-Core Version:    0.7.0.1
 */