package com.tencent.luggage.wxa.lu;

import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.ku.f.a;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

public class d
  extends a
{
  public static final int CTRL_INDEX = 491;
  public static final String NAME = "enableDeviceMotionChangeListening";
  
  private String a(c paramc)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("JsApi#SensorDeviceMotion");
    localStringBuilder.append(paramc.hashCode());
    return localStringBuilder.toString();
  }
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    j localj = new j("enableDeviceMotionChangeListening");
    paramJSONObject = localj.a(paramc, paramJSONObject, new d.1(this, paramc, paramc, localj), a(paramc), new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(3) })));
    paramc.a(paramInt, a(paramJSONObject.b, paramJSONObject.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lu.d
 * JD-Core Version:    0.7.0.1
 */