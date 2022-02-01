package com.tencent.luggage.wxa.nb;

import com.tencent.luggage.wxa.fx.a;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  implements com.tencent.luggage.wxa.gb.b
{
  private com.tencent.luggage.wxa.ju.b a;
  
  private void a(ah paramah, JSONObject paramJSONObject)
  {
    if (paramah != null)
    {
      if ((!paramah.d().equalsIgnoreCase("onXWebLivePlayerEvent")) && (!paramah.d().equalsIgnoreCase("onXWebLivePlayerNetStatus")) && (!paramah.d().equalsIgnoreCase("onXWebLivePlayerAudioVolume"))) {
        o.d("MicroMsg.SameLayer.AppBrandLivePlayerEventHandler", "dispatch event:%s, data:%s", new Object[] { paramah.d(), paramJSONObject.toString() });
      }
      paramah = paramah.b(paramJSONObject.toString());
      paramJSONObject = this.a;
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.g();
        if (paramJSONObject != null) {
          if ((paramJSONObject instanceof h))
          {
            paramJSONObject = (h)paramJSONObject;
            paramJSONObject.a(paramah, null);
            paramJSONObject = paramJSONObject.v();
            if (paramJSONObject != null) {
              paramJSONObject.a(paramah, null);
            }
          }
          else if ((paramJSONObject instanceof u))
          {
            paramJSONObject = (u)paramJSONObject;
            paramJSONObject.a(paramah, null);
            paramJSONObject = paramJSONObject.p();
            if (paramJSONObject != null) {
              paramJSONObject.a(paramah, null);
            }
          }
          else
          {
            paramJSONObject.a(paramah, null);
          }
        }
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("viewId", paramInt);
      localJSONObject.put("playInBackground", paramBoolean);
      a(new b.a(null), localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.SameLayer.AppBrandLivePlayerEventHandler", "onXWebLivePlayerBackgroundPlaybackChange fail", new Object[] { localJSONException });
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
 * Qualified Name:     com.tencent.luggage.wxa.nb.b
 * JD-Core Version:    0.7.0.1
 */