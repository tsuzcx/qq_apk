package com.tencent.luggage.wxa.lh;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class i
  extends d
{
  public static final int CTRL_INDEX = 353;
  public static final String NAME = "stopHCE";
  
  private void a(c paramc, int paramInt)
  {
    b.b(paramc.getAppId());
    b.a(paramc.getAppId(), 13, null);
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("errCode", Integer.valueOf(0));
    a(paramc, paramInt, a("ok", localHashMap));
  }
  
  private void a(c paramc, int paramInt, String paramString)
  {
    o.d("MicroMsg.JsApiNFCStartHCE", "alvinluo stopHCE callback result: %s", new Object[] { paramString });
    if (paramc != null) {
      paramc.a(paramInt, paramString);
    }
  }
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    a(new i.1(this, paramc, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lh.i
 * JD-Core Version:    0.7.0.1
 */