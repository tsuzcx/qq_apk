package com.tencent.luggage.wxa.ln;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jj.a.g;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONObject;

public class i
  extends com.tencent.luggage.wxa.jx.a<b>
{
  public static final int CTRL_INDEX = 14;
  public static final String NAME = "navigateTo";
  
  public void a(b paramb, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = paramJSONObject.optString("url");
    if (paramb.q().aj().e().a(paramJSONObject))
    {
      paramb.a(paramInt, b("fail:can not navigate to a tab bar page"));
      return;
    }
    paramJSONObject = new i.1(this, paramb, paramInt, paramJSONObject);
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
 * Qualified Name:     com.tencent.luggage.wxa.ln.i
 * JD-Core Version:    0.7.0.1
 */