package com.tencent.ilive.litepages.room.webmodule.js;

import com.tencent.falco.base.libapi.http.HttpResponse;
import org.json.JSONObject;

class MiscJavascriptInterface$2
  implements HttpResponse
{
  MiscJavascriptInterface$2(MiscJavascriptInterface paramMiscJavascriptInterface) {}
  
  public void onResponse(int paramInt, JSONObject paramJSONObject)
  {
    MiscJavascriptInterface.access$100(this.this$0, "MiscJavascriptInterface", "resultCode = " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.js.MiscJavascriptInterface.2
 * JD-Core Version:    0.7.0.1
 */