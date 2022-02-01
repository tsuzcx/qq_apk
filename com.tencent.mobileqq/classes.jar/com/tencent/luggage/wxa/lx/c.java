package com.tencent.luggage.wxa.lx;

import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.mn.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends a
{
  private static final int CTRL_INDEX = 851;
  private static final String NAME = "checkIsOpenAccessibility";
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = b.a(paramc.getContext());
    if (paramJSONObject == null)
    {
      paramc.a(paramInt, b("fail"));
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("open", paramJSONObject);
    paramc.a(paramInt, a("ok", localHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lx.c
 * JD-Core Version:    0.7.0.1
 */