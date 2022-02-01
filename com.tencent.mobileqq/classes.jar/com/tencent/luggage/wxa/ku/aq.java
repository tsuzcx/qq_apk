package com.tencent.luggage.wxa.ku;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import org.json.JSONObject;

final class aq
  extends bb
{
  @NonNull
  f.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("append", true);
      return super.a(paramc, paramString, paramJSONObject);
    }
    catch (Exception paramc)
    {
      o.b("MicroMsg.AppBrand.UnitAppendFile", "call with path(%s), put append fail ex = %s", new Object[] { paramString, paramc });
      paramc = new StringBuilder();
      paramc.append("fail ");
      paramc.append(j.b.name());
    }
    return new f.a(paramc.toString(), new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.aq
 * JD-Core Version:    0.7.0.1
 */