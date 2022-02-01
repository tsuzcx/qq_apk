package com.tencent.luggage.wxa.ln;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jj.a.g;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONObject;

public class ah
  extends com.tencent.luggage.wxa.jx.a<b>
{
  public static final int CTRL_INDEX = 150;
  public static final String NAME = "switchTab";
  
  public void a(b paramb, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = paramJSONObject.optString("url");
    if (!paramb.q().aj().e().a(paramJSONObject))
    {
      paramb.a(paramInt, b("fail:can not switch to non-TabBar page"));
      return;
    }
    paramJSONObject = new ah.1(this, paramb, paramJSONObject, paramInt);
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
 * Qualified Name:     com.tencent.luggage.wxa.ln.ah
 * JD-Core Version:    0.7.0.1
 */