package com.tencent.luggage.wxa.mo;

import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public abstract class a
  extends com.tencent.luggage.wxa.jx.a
{
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == null)
    {
      o.b("MicroMsg.BaseRecordJsApi", "%s invalid data", new Object[] { d() });
      paramc.a(paramInt, b("fail:invalid data"));
      return;
    }
    c localc = (c)paramc.a(c.class);
    if (localc == null)
    {
      o.b("MicroMsg.BaseRecordJsApi", "%s voicePlayer is null, err", new Object[] { d() });
      paramc.a(paramInt, String.format("fail:internal error %s", new Object[] { "player is null" }));
      return;
    }
    a(localc, paramc, paramJSONObject, paramInt);
  }
  
  protected abstract void a(c paramc, com.tencent.luggage.wxa.jx.c paramc1, JSONObject paramJSONObject, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mo.a
 * JD-Core Version:    0.7.0.1
 */