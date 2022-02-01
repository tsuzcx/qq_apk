package com.tencent.luggage.wxa.mg;

import com.tencent.luggage.wxa.ma.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.v.a;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

class b$1
  implements v.a
{
  b$1(b paramb) {}
  
  public boolean p_()
  {
    try
    {
      int i = b.a(this.a).getCurrPosMs();
      if (Math.abs(i - b.b(this.a)) < 250) {
        return true;
      }
      JSONObject localJSONObject = b.c(this.a);
      b.a(this.a, i);
      double d = i;
      Double.isNaN(d);
      d = d * 1.0D / 1000.0D;
      localJSONObject.put("position", new BigDecimal(d).setScale(3, 4).doubleValue());
      localJSONObject.put("duration", b.a(this.a).getDuration());
      b.a(this.a, new b.k(null), localJSONObject);
      return true;
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.Video.JsApiVideoCallback", "OnVideoTimeUpdate e=%s", new Object[] { localJSONException });
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mg.b.1
 * JD-Core Version:    0.7.0.1
 */