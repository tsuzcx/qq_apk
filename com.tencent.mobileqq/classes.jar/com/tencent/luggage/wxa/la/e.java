package com.tencent.luggage.wxa.la;

import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.h;
import org.json.JSONObject;

public class e
  extends a<h>
{
  public static final int CTRL_INDEX = 252;
  public static final String NAME = "navigateBackMiniProgram";
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    paramh.a(new e.1(this, paramh, paramJSONObject.optJSONObject("extraData"), paramJSONObject.optJSONObject("privateExtraData"), paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.la.e
 * JD-Core Version:    0.7.0.1
 */