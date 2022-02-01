package com.tencent.luggage.wxa.ku;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import org.json.JSONObject;

class at
  extends d
{
  @NonNull
  f.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    boolean bool = paramJSONObject.optBoolean("recursive", false);
    paramc = paramc.getFileSystem().b(paramString, bool);
    int i = at.1.a[paramc.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            paramString = new StringBuilder();
            paramString.append("fail ");
            paramString.append(paramc.name());
            return new f.a(paramString.toString(), new Object[0]);
          }
          return new f.a("ok", new Object[0]);
        }
        return new f.a("fail file already exists \"%s\"", new Object[] { paramString });
      }
      return new f.a("fail permission denied, open \"%s\"", new Object[] { paramString });
    }
    return new f.a("fail no such file or directory \"%s\"", new Object[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.at
 * JD-Core Version:    0.7.0.1
 */