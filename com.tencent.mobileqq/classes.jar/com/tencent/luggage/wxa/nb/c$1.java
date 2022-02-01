package com.tencent.luggage.wxa.nb;

import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.ga.a;
import com.tencent.luggage.wxa.lp.h.a;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONException;
import org.json.JSONObject;

class c$1
  implements ValueCallback<String>
{
  c$1(c paramc, h.a parama) {}
  
  public void a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getVideoPositionAsync, value: ");
    ((StringBuilder)localObject).append(paramString);
    o.d("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", ((StringBuilder)localObject).toString());
    try
    {
      localObject = new JSONObject(paramString);
      c.a(this.b).a((JSONObject)localObject);
      this.a.a(c.a(this.b).p(), c.a(this.b).q());
      return;
    }
    catch (JSONException localJSONException)
    {
      label80:
      break label80;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getVideoPositionAsync, parse ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" failed");
    o.c("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", ((StringBuilder)localObject).toString());
    this.a.a(c.a(this.b).p(), c.a(this.b).q());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nb.c.1
 * JD-Core Version:    0.7.0.1
 */