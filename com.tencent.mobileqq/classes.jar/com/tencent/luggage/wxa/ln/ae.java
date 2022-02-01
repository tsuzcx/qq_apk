package com.tencent.luggage.wxa.ln;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jx.a;
import org.json.JSONObject;

public class ae
  extends a<h>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "showTabBar";
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = new ae.1(this, paramh, paramInt, paramJSONObject);
    if (!paramh.q().F())
    {
      paramJSONObject.run();
      return;
    }
    paramh.q().c(paramJSONObject);
  }
  
  protected boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.ae
 * JD-Core Version:    0.7.0.1
 */