package com.tencent.luggage.wxa.kp;

import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.t;
import org.json.JSONObject;

public class l
  extends a
{
  private static final int CTRL_INDEX = 332;
  public static final String NAME = "operateCamera";
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == null)
    {
      paramc.a(paramInt, b("fail:data is null or nil"));
      return;
    }
    t.a(new l.1(this, paramJSONObject, paramc, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kp.l
 * JD-Core Version:    0.7.0.1
 */