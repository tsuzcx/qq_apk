package com.tencent.luggage.wxa.nf;

import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.gd.d;
import com.tencent.luggage.wxa.lp.h.a;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONException;
import org.json.JSONObject;

class j$3
  implements ValueCallback<String>
{
  j$3(j paramj, h.a parama) {}
  
  public void a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getVideoPositionAsync, value: ");
    ((StringBuilder)localObject).append(paramString);
    o.d("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", ((StringBuilder)localObject).toString());
    try
    {
      localObject = new JSONObject(paramString);
      j.b(this.b).a((JSONObject)localObject);
      this.a.a(j.b(this.b).w(), j.b(this.b).x());
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
    o.c("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", ((StringBuilder)localObject).toString());
    this.a.a(j.b(this.b).w(), j.b(this.b).x());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nf.j.3
 * JD-Core Version:    0.7.0.1
 */