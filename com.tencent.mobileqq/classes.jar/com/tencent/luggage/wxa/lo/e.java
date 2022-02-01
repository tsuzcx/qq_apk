package com.tencent.luggage.wxa.lo;

import org.json.JSONObject;

public final class e
  extends a
{
  public static final int CTRL_INDEX = 84;
  public static final String NAME = "showDatePickerView";
  
  public void a(com.tencent.luggage.wxa.jx.e parame, JSONObject paramJSONObject, int paramInt)
  {
    String str = paramJSONObject.optString("mode");
    if ("date".equals(str))
    {
      new b().a(this, parame, paramJSONObject, paramInt, c());
      return;
    }
    if ("time".equals(str))
    {
      new j().a(this, parame, paramJSONObject, paramInt, c());
      return;
    }
    parame.a(paramInt, b("fail:invalid data"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lo.e
 * JD-Core Version:    0.7.0.1
 */