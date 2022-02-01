package com.tencent.luggage.wxa.jx;

import com.tencent.luggage.wxa.du.c;
import org.json.JSONObject;

public class at
  extends a<c>
{
  public static final int CTRL_INDEX = 249;
  public static final String NAME = "setEnableDebug";
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    boolean bool = paramJSONObject.optBoolean("enableDebug", false);
    if (paramc.i().i().b == bool)
    {
      paramc.a(paramInt, b("ok"));
      return;
    }
    com.tencent.luggage.wxa.nx.a.a(paramc, paramc.getAppId(), bool);
    paramc.a(paramInt, b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.at
 * JD-Core Version:    0.7.0.1
 */