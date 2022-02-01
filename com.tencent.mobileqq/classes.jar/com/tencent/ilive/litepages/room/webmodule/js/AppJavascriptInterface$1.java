package com.tencent.ilive.litepages.room.webmodule.js;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class AppJavascriptInterface$1
  implements DialogInterface.OnDismissListener
{
  AppJavascriptInterface$1(AppJavascriptInterface paramAppJavascriptInterface, Map paramMap) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("url", this.val$params.get("url"));
      this.this$0.callJsFunctionByNative("__PENDANT_WEBVIEW_CLOSE", paramDialogInterface);
      return;
    }
    catch (JSONException paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.js.AppJavascriptInterface.1
 * JD-Core Version:    0.7.0.1
 */