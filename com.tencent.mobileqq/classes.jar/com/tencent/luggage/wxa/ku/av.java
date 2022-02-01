package com.tencent.luggage.wxa.ku;

import androidx.annotation.NonNull;
import com.tencent.luggage.util.a;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.pc.i;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import java.nio.ByteBuffer;
import java.util.Map;
import org.json.JSONObject;

class av
  extends d
{
  @NonNull
  f.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optString("encoding");
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrand.UnitReadFile", "call, path %s, encoding %s", new Object[] { paramString, localObject });
    if (af.c((String)localObject))
    {
      localObject = null;
    }
    else
    {
      e locale = (e)e.a.a.get(((String)localObject).toLowerCase());
      localObject = locale;
      if (locale == null) {
        return new f.a("fail invalid encoding", new Object[0]);
      }
    }
    long l2;
    long l1;
    long l3;
    if ((!paramJSONObject.has("position")) && (!paramJSONObject.has("length")))
    {
      l2 = -9223372036854775808L;
      l1 = l2;
      l3 = l1;
    }
    else
    {
      l1 = paramJSONObject.optLong("position", 0L);
      l3 = paramJSONObject.optLong("length", 9223372036854775807L);
      l2 = l1;
    }
    paramJSONObject = new i();
    if ((l2 != -9223372036854775808L) && (l3 != -9223372036854775808L)) {
      paramc = paramc.getFileSystem().a(paramString, l2, l3, paramJSONObject);
    } else {
      paramc = paramc.getFileSystem().b(paramString, paramJSONObject);
    }
    if (paramc == j.a)
    {
      if (localObject == null) {
        paramc = (Comparable)paramJSONObject.a;
      } else {
        paramc = ((e)localObject).a((ByteBuffer)paramJSONObject.a);
      }
      if (!(paramc instanceof ByteBuffer)) {
        a.a((ByteBuffer)paramJSONObject.a);
      }
      return new f.a("ok", new Object[0]).b("data", paramc);
    }
    int i = av.1.a[paramc.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5)
            {
              paramString = new StringBuilder();
              paramString.append("fail ");
              paramString.append(paramc.name());
              return new f.a(paramString.toString(), new Object[0]);
            }
            return new f.a("fail the value of \"length\" is out of range", new Object[0]);
          }
          return new f.a("fail the value of \"position\" is out of range", new Object[0]);
        }
        return new f.a("fail \"%s\" is not a regular file", new Object[] { paramString });
      }
      return new f.a("fail permission denied, open \"%s\"", new Object[] { paramString });
    }
    return new f.a("fail no such file \"%s\"", new Object[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.av
 * JD-Core Version:    0.7.0.1
 */