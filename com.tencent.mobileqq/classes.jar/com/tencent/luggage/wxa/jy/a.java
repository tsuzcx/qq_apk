package com.tencent.luggage.wxa.jy;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class a
  extends com.tencent.luggage.wxa.jx.a<h>
{
  public static final int CTRL_INDEX = 439;
  public static final String NAME = "getInstallState";
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    o.e("MicroMsg.JsApiGetInstallState", "invoke");
    new a.a(this, paramh, paramInt, paramJSONObject).g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jy.a
 * JD-Core Version:    0.7.0.1
 */