package com.tencent.luggage.wxa.bq;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.qz.t;
import org.json.JSONObject;

public class d
  extends a<h>
{
  private static final int CTRL_INDEX = 70;
  private static final String NAME = "hideKeyboard";
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    t.a(new d.1(this, paramh));
    paramh.a(paramInt, b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bq.d
 * JD-Core Version:    0.7.0.1
 */