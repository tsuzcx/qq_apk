package com.tencent.luggage.wxa.ku;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import org.json.JSONObject;

class as
  extends d
{
  @NonNull
  f.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    paramc = paramc.getFileSystem().c(paramString);
    int i = as.1.a[paramc.ordinal()];
    boolean bool = true;
    if (i != 1)
    {
      if ((i != 2) && (i != 3))
      {
        paramString = new StringBuilder();
        paramString.append("fail ");
        paramString.append(paramc.name());
        return new f.a(paramString.toString(), new Object[0]);
      }
      paramString = new f.a("ok", new Object[0]);
      if (paramc != j.a) {
        bool = false;
      }
      return paramString.b("result", Boolean.valueOf(bool));
    }
    return new f.a("fail no such file or directory \"%s\"", new Object[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.as
 * JD-Core Version:    0.7.0.1
 */