package com.tencent.luggage.wxa.nd;

import com.tencent.luggage.wxa.fx.a;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  implements com.tencent.luggage.wxa.gc.b
{
  private com.tencent.luggage.wxa.ju.b a;
  
  private void a(ah paramah, JSONObject paramJSONObject)
  {
    if (paramah != null)
    {
      if ((!paramah.d().equalsIgnoreCase("onXWebLivePusherEvent")) && (!paramah.d().equalsIgnoreCase("onXWebLivePusherNetStatus"))) {
        o.d("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "dispatch event:%s, data:%s", new Object[] { paramah.d(), paramJSONObject.toString() });
      }
      paramah = paramah.b(paramJSONObject.toString());
      paramJSONObject = this.a;
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.g();
        if (paramJSONObject != null)
        {
          if ((paramJSONObject instanceof h))
          {
            ((h)paramJSONObject).a(paramah, null);
            return;
          }
          if ((paramJSONObject instanceof u))
          {
            ((u)paramJSONObject).a(paramah, null);
            return;
          }
          paramJSONObject.a(paramah, null);
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, HashMap<String, Object> paramHashMap)
  {
    b.a locala = new b.a(null);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("viewId", paramInt1);
      localJSONObject.put("errCode", paramInt2);
      localJSONObject.put("errMsg", af.b(paramString));
      if ((paramHashMap != null) && (!paramHashMap.isEmpty())) {
        localJSONObject.put("data", new JSONObject(paramHashMap));
      }
      a(locala, localJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      o.b("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherError fail", new Object[] { paramString });
    }
  }
  
  public void a(a parama)
  {
    if ((parama instanceof com.tencent.luggage.wxa.ju.b)) {
      this.a = ((com.tencent.luggage.wxa.ju.b)parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nd.b
 * JD-Core Version:    0.7.0.1
 */