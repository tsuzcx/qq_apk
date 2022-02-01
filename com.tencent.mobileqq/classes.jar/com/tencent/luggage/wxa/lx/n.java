package com.tencent.luggage.wxa.lx;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import org.json.JSONObject;

public class n<CONTEXT extends c>
  extends a<CONTEXT>
{
  public static final int CTRL_INDEX = 168;
  public static final String NAME = "setClipboardData";
  
  public void a(CONTEXT paramCONTEXT, String paramString) {}
  
  public void a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = paramJSONObject.optString("data");
    if (af.c(paramJSONObject))
    {
      paramCONTEXT.a(paramInt, b("fail"));
      return;
    }
    o.e("MicroMsg.JsApiSetClipboardData", "stevyang dataStr %s", new Object[] { paramJSONObject });
    ClipboardManager localClipboardManager = (ClipboardManager)paramCONTEXT.getContext().getSystemService("clipboard");
    if (localClipboardManager == null)
    {
      o.d("MicroMsg.JsApiSetClipboardData", "getSystemService(CLIPBOARD_SERVICE) failed.");
      paramCONTEXT.a(paramInt, b("fail"));
      return;
    }
    ClipData localClipData = ClipData.newPlainText("text", paramJSONObject);
    ClipboardMonitor.setPrimaryClip(localClipboardManager, localClipData);
    localClipboardManager.setPrimaryClip(localClipData);
    paramCONTEXT.a(paramInt, b("ok"));
    a(paramCONTEXT, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lx.n
 * JD-Core Version:    0.7.0.1
 */