package com.tencent.luggage.wxa.ku;

import androidx.annotation.NonNull;
import com.tencent.luggage.util.b;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.pc.i;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class au
  extends d
{
  @NonNull
  f.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    paramJSONObject = new LinkedList();
    i locali = new i();
    paramc = paramc.getFileSystem().a(paramString, locali);
    b.a(paramJSONObject, (List)locali.a);
    switch (au.1.a[paramc.ordinal()])
    {
    default: 
      paramString = new StringBuilder();
      paramString.append("fail ");
      paramString.append(paramc.name());
      return new f.a(paramString.toString(), new Object[0]);
    case 6: 
      paramc = new JSONArray();
      paramString = paramJSONObject.iterator();
      while (paramString.hasNext()) {
        paramc.put(((h)paramString.next()).a);
      }
      return new f.a("ok", new Object[0]).b("files", paramc);
    case 5: 
      return new f.a("fail \"%s\" is not a regular file", new Object[] { paramString });
    case 4: 
      return new f.a("fail permission denied, open \"%s\"", new Object[] { paramString });
    case 3: 
      return new f.a("fail not a directory \"%s\"", new Object[] { paramString });
    }
    return new f.a("fail no such file or directory \"%s\"", new Object[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.au
 * JD-Core Version:    0.7.0.1
 */