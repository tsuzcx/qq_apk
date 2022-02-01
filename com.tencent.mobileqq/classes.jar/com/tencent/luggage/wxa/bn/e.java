package com.tencent.luggage.wxa.bn;

import com.tencent.luggage.wxa.bs.c;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.ku.f.a;
import org.json.JSONObject;

public class e
  extends com.tencent.luggage.wxa.jx.u<h>
{
  public static final int CTRL_INDEX = 401;
  public static final String NAME = "canvasToTempFilePathSync";
  
  public String a(h paramh, JSONObject paramJSONObject)
  {
    paramh = paramh.v();
    if ((c)paramh.d(c.class) == null) {
      return b("fail");
    }
    paramh = d.a(paramh, paramJSONObject, true);
    return a(paramh.b, paramh.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bn.e
 * JD-Core Version:    0.7.0.1
 */