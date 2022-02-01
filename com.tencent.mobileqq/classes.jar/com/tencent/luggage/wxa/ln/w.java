package com.tencent.luggage.wxa.ln;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONObject;

public class w
  extends a<b>
{
  public static final int CTRL_INDEX = 8;
  public static final String NAME = "setNavigationBarTitle";
  
  public void a(b paramb, JSONObject paramJSONObject, int paramInt)
  {
    if (!paramJSONObject.has("title"))
    {
      paramb.a(paramInt, b("fail:invalid data"));
      return;
    }
    paramJSONObject = new w.1(this, paramb, paramInt, paramJSONObject.optString("title"));
    if ((!(paramb instanceof u)) && (paramb.q().F()))
    {
      paramb.q().c(paramJSONObject);
      return;
    }
    paramJSONObject.run();
  }
  
  protected boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.w
 * JD-Core Version:    0.7.0.1
 */