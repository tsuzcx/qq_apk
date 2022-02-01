package com.tencent.luggage.wxa.kf;

import android.annotation.TargetApi;
import com.tencent.luggage.wxa.kl.j;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@TargetApi(18)
public class l
  extends com.tencent.luggage.wxa.jx.a
{
  private static final int CTRL_INDEX = 173;
  private static final String NAME = "openBluetoothAdapter";
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    com.tencent.luggage.wxa.ke.c.a(0);
    paramJSONObject = paramc.getAppId();
    o.d("MicroMsg.JsApiOpenBluetoothAdapter", "appid:%s openBluetoothAdapter!", new Object[] { paramJSONObject });
    paramJSONObject = com.tencent.luggage.wxa.ke.a.a(paramJSONObject, new l.1(this, paramc), new l.2(this, paramc), new l.3(this, paramc));
    HashMap localHashMap = new HashMap();
    int i = paramJSONObject.u;
    if (i != 0)
    {
      if (i != 10001)
      {
        if (i != 10009)
        {
          localHashMap.put("errCode", Integer.valueOf(paramJSONObject.u));
          paramc.a(paramInt, a(paramJSONObject.v, localHashMap));
          com.tencent.luggage.wxa.ke.c.a(2);
          return;
        }
        localHashMap.put("errCode", Integer.valueOf(10009));
        paramc.a(paramInt, a("fail:system not support", localHashMap));
        com.tencent.luggage.wxa.ke.c.a(2, 8);
        return;
      }
      localHashMap.put("errCode", Integer.valueOf(10001));
      paramc.a(paramInt, a("fail:not available", localHashMap));
      com.tencent.luggage.wxa.ke.c.a(2, 7);
      return;
    }
    paramc.a(paramInt, a("ok", localHashMap));
    com.tencent.luggage.wxa.ke.c.a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kf.l
 * JD-Core Version:    0.7.0.1
 */