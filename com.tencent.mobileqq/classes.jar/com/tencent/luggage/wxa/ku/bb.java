package com.tencent.luggage.wxa.ku;

import androidx.annotation.NonNull;
import com.tencent.luggage.util.a;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.pd.p;
import com.tencent.luggage.wxa.pd.p.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.util.Map;
import org.json.JSONObject;

class bb
  extends d
{
  @NonNull
  f.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    boolean bool = paramJSONObject.optBoolean("append", false);
    Object localObject1 = paramJSONObject.optString("encoding");
    p.a(paramc.getJsRuntime(), paramJSONObject, (p.a)paramc.b(p.a.class));
    Object localObject2 = paramJSONObject.opt("data");
    if ((localObject2 instanceof String))
    {
      if (af.c((String)localObject1))
      {
        paramJSONObject = (e)e.a.a.get("utf8");
      }
      else
      {
        localObject1 = (e)e.a.a.get(((String)localObject1).toLowerCase());
        paramJSONObject = (JSONObject)localObject1;
        if (localObject1 == null) {
          return new f.a("fail invalid encoding", new Object[0]);
        }
      }
      try
      {
        paramJSONObject = paramJSONObject.a((String)localObject2);
        paramJSONObject = new a(paramJSONObject);
      }
      catch (Exception paramc)
      {
        paramString = new StringBuilder();
        paramString.append("fail ");
        paramString.append(paramc.getMessage());
        return new f.a(paramString.toString(), new Object[0]);
      }
    }
    else if ((localObject2 instanceof ByteBuffer))
    {
      paramJSONObject = new a((ByteBuffer)localObject2);
    }
    else
    {
      if (localObject2 != null) {
        break label470;
      }
      if (bool) {
        return new f.a("ok", new Object[0]);
      }
      paramJSONObject = new ByteArrayInputStream(new byte[0]);
    }
    paramc = paramc.getFileSystem().a(paramString, paramJSONObject, bool);
    switch (bb.1.a[paramc.ordinal()])
    {
    default: 
      paramString = new StringBuilder();
      paramString.append("fail ");
      paramString.append(paramc.name());
      return new f.a(paramString.toString(), new Object[0]);
    case 7: 
      return new f.a("ok", new Object[0]);
    case 6: 
      return new f.a("fail the maximum size of the file storage limit is exceeded", new Object[0]);
    case 5: 
      return new f.a("fail \"%s\" is not a regular file", new Object[] { paramString });
    case 4: 
      return new f.a("fail permission denied, open \"%s\"", new Object[] { paramString });
    case 3: 
      return new f.a("fail illegal operation on a directory, open \"%s\"", new Object[] { paramString });
    case 2: 
      return new f.a("fail no such file \"%s\"", new Object[] { paramString });
    }
    return new f.a("fail no such file or directory, open \"%s\"", new Object[] { paramString });
    label470:
    return new f.a("fail invalid data", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.bb
 * JD-Core Version:    0.7.0.1
 */