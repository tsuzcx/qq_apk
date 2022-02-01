package com.tencent.luggage.wxa.lu;

import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.ku.f.a;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

public class c
  extends a
{
  public static final int CTRL_INDEX = 94;
  public static final String NAME = "enableCompass";
  
  private String a(com.tencent.luggage.wxa.jx.c paramc)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("JsApi#SensorMagneticField");
    localStringBuilder.append(paramc.hashCode());
    return localStringBuilder.toString();
  }
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    j localj = new j("enableCompass");
    paramJSONObject = localj.a(paramc, paramJSONObject, new c.1(this, paramc, paramc, localj), a(paramc), new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(1) })));
    paramc.a(paramInt, a(paramJSONObject.b, paramJSONObject.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lu.c
 * JD-Core Version:    0.7.0.1
 */