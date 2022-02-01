package com.tencent.luggage.wxa.ku;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import org.json.JSONObject;

class ap
  extends d
{
  @NonNull
  f.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    if (paramc.getFileSystem().b(paramString) == j.a) {
      paramc = "ok";
    } else {
      paramc = String.format("fail no such file or directory \"%s\"", new Object[] { paramString });
    }
    return new f.a(paramc, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.ap
 * JD-Core Version:    0.7.0.1
 */