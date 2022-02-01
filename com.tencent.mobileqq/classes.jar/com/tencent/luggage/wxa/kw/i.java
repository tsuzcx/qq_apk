package com.tencent.luggage.wxa.kw;

import com.tencent.luggage.wxa.pc.l;
import com.tencent.luggage.wxa.pw.h;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONException;
import org.json.JSONObject;

public class i
  extends a<h>
{
  private static final int CTRL_INDEX = 112;
  private static final String NAME = "updateInput";
  
  public void a(u paramu, JSONObject paramJSONObject, int paramInt)
  {
    h localh = new h();
    if (!a(localh, paramJSONObject, paramu, paramInt)) {
      return;
    }
    try
    {
      int i = paramJSONObject.getInt("inputId");
      if ((localh.j != null) && (localh.j.intValue() < 0)) {
        localh.j = Integer.valueOf(0);
      }
      if ((localh.k != null) && (localh.k.intValue() < 0)) {
        localh.k = Integer.valueOf(0);
      }
      paramJSONObject = paramJSONObject.optString("data", null);
      if (paramJSONObject != null) {
        a(i, paramJSONObject);
      }
      l.a(new i.1(this, paramu, i, localh, paramInt));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      label123:
      break label123;
    }
    paramu.a(paramInt, b("fail:invalid data"));
  }
  
  protected boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kw.i
 * JD-Core Version:    0.7.0.1
 */