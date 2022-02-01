package com.tencent.luggage.wxa.lh;

import android.os.Bundle;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class g
  extends d
{
  public static final int CTRL_INDEX = 354;
  public static final String NAME = "sendHCEMessage";
  
  private void a(c paramc, int paramInt, String paramString)
  {
    o.d("MicroMsg.JsApiNFCSendHCEResponseCommand", "alvinluo sendHCEMessage callback json: %s", new Object[] { paramString });
    if (paramc != null) {
      paramc.a(paramInt, paramString);
    }
  }
  
  private void a(c paramc, int paramInt, JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    paramJSONObject = paramJSONObject.optString("data");
    if (af.c(paramJSONObject))
    {
      localHashMap.put("errCode", Integer.valueOf(13005));
      a(paramc, paramInt, a("fail", localHashMap));
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("key_apdu_command", paramJSONObject);
    b.a(paramc.getAppId(), 32, localBundle);
    localHashMap.put("errCode", Integer.valueOf(0));
    paramc.a(paramInt, a("ok", localHashMap));
  }
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    a(new g.1(this, paramc, paramInt, paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lh.g
 * JD-Core Version:    0.7.0.1
 */