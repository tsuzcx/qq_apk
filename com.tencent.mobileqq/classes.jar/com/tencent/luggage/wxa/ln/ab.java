package com.tencent.luggage.wxa.ln;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jj.a.g;
import org.json.JSONObject;

public class ab
  extends com.tencent.luggage.wxa.jx.a<h>
{
  public static final int CTRL_INDEX = 417;
  public static final String NAME = "setTabBarStyle";
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    a.g localg = paramh.q().aj().e();
    paramJSONObject = new ab.1(this, paramh, paramInt, paramJSONObject.optString("color", localg.b), paramJSONObject.optString("selectedColor", localg.c), paramJSONObject.optString("backgroundColor", localg.d), paramJSONObject.optString("borderStyle", localg.e));
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
 * Qualified Name:     com.tencent.luggage.wxa.ln.ab
 * JD-Core Version:    0.7.0.1
 */