package com.tencent.luggage.wxa.ln;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jx.a;
import org.json.JSONObject;

public class y
  extends a<h>
{
  private static final int CTRL_INDEX = 197;
  private static final String NAME = "setStatusBarStyle";
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = new y.1(this, paramJSONObject, paramh, paramInt);
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
 * Qualified Name:     com.tencent.luggage.wxa.ln.y
 * JD-Core Version:    0.7.0.1
 */