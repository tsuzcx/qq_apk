package com.tencent.luggage.wxa.bq;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.qz.t;
import org.json.JSONObject;

public class f
  extends a<h>
{
  private static final int CTRL_INDEX = 463;
  private static final String NAME = "updateKeyboard";
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    t.a(new f.1(this, paramh, paramJSONObject.optString("value"), paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bq.f
 * JD-Core Version:    0.7.0.1
 */