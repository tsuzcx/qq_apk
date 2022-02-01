package com.tencent.luggage.wxa.lx;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class e
  extends a
{
  public static final int CTRL_INDEX = 169;
  public static final String NAME = "getClipboardData";
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = (ClipboardManager)r.a().getSystemService("clipboard");
    if (paramJSONObject == null)
    {
      o.d("MicroMsg.JsApiGetClipboardData", "getSystemService(CLIPBOARD_SERVICE) failed.");
      paramc.a(paramInt, b("fail"));
      return;
    }
    try
    {
      ClipboardMonitor.getPrimaryClip(paramJSONObject);
      Object localObject2 = paramJSONObject.getPrimaryClip();
      Object localObject1 = "";
      paramJSONObject = (JSONObject)localObject1;
      if (localObject2 != null)
      {
        paramJSONObject = (JSONObject)localObject1;
        if (((ClipData)localObject2).getItemCount() > 0)
        {
          localObject2 = ((ClipData)localObject2).getItemAt(0);
          paramJSONObject = (JSONObject)localObject1;
          if (((ClipData.Item)localObject2).getText() != null) {
            paramJSONObject = ((ClipData.Item)localObject2).getText().toString();
          }
        }
      }
      localObject1 = new HashMap();
      ((Map)localObject1).put("data", paramJSONObject);
      paramc.a(paramInt, a("ok", (Map)localObject1));
      return;
    }
    catch (Exception paramJSONObject)
    {
      o.b("MicroMsg.JsApiGetClipboardData", "invoke with appId:%s, but get Exception:%s", new Object[] { paramc.getAppId(), paramJSONObject });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lx.e
 * JD-Core Version:    0.7.0.1
 */