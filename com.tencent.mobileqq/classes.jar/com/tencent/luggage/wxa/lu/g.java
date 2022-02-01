package com.tencent.luggage.wxa.lu;

import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.pd.t.a;
import java.util.HashMap;
import java.util.Map;

class g
  extends ah
{
  static final int CTRL_INDEX = 473;
  static final String NAME = "onDeviceOrientationChange";
  
  void a(t.a parama)
  {
    parama = parama.name().replace("_", "");
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("errMsg", "ok");
    localHashMap.put("value", parama);
    b(localHashMap).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lu.g
 * JD-Core Version:    0.7.0.1
 */