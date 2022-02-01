package com.tencent.luggage.wxa.ln;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONObject;

public final class n
  extends a<b>
{
  private static final int CTRL_INDEX = 170;
  private static final String NAME = "reLaunch";
  
  public void a(b paramb, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = new n.1(this, paramb, paramJSONObject.optString("url"), paramInt);
    if ((!(paramb instanceof u)) && (paramb.q().F()))
    {
      paramb.q().c(paramJSONObject);
      return;
    }
    paramJSONObject.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.n
 * JD-Core Version:    0.7.0.1
 */