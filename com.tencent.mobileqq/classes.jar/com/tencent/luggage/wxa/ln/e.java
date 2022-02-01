package com.tencent.luggage.wxa.ln;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONObject;

public class e
  extends a<b>
{
  public static final int CTRL_INDEX = 10;
  public static final String NAME = "hideNavigationBarLoading";
  
  public void a(b paramb, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = new e.1(this, paramb, paramInt);
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
 * Qualified Name:     com.tencent.luggage.wxa.ln.e
 * JD-Core Version:    0.7.0.1
 */