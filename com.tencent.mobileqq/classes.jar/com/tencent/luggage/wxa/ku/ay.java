package com.tencent.luggage.wxa.ku;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.appstorage.v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

class ay
  extends d
{
  private static Map<String, Object> a(FileStructStat paramFileStructStat, Map<String, Object> paramMap)
  {
    paramMap.put("mode", Integer.valueOf(paramFileStructStat.st_mode));
    paramMap.put("size", Long.valueOf(paramFileStructStat.st_size));
    paramMap.put("lastAccessedTime", Long.valueOf(paramFileStructStat.st_atime));
    paramMap.put("lastModifiedTime", Long.valueOf(paramFileStructStat.st_mtime));
    return paramMap;
  }
  
  private static f.a b(c paramc, String paramString, JSONObject paramJSONObject)
  {
    paramJSONObject = new LinkedList();
    paramc = paramc.getFileSystem().a(paramString, paramJSONObject);
    if (ay.1.a[paramc.ordinal()] != 1)
    {
      paramString = new StringBuilder();
      paramString.append("fail ");
      paramString.append(paramc.name());
      return new f.a(paramString.toString(), new Object[0]);
    }
    paramc = new f.a("ok", new Object[0]);
    paramString = paramJSONObject.iterator();
    while (paramString.hasNext())
    {
      paramJSONObject = (v)paramString.next();
      paramc.b(paramJSONObject.a(), a(paramJSONObject, new HashMap()));
    }
    return paramc;
  }
  
  @NonNull
  f.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    boolean bool = paramJSONObject.optBoolean("recursive", false);
    FileStructStat localFileStructStat = new FileStructStat();
    j localj = paramc.getFileSystem().a(paramString, localFileStructStat);
    int i = ay.1.a[localj.ordinal()];
    if (i != 1)
    {
      if ((i != 2) && (i != 3))
      {
        if (i != 4)
        {
          paramc = new StringBuilder();
          paramc.append("fail ");
          paramc.append(localj.name());
          return new f.a(paramc.toString(), new Object[0]);
        }
        return new f.a("fail permission denied, open \"%s\"", new Object[] { paramString });
      }
      return new f.a("fail no such file or directory \"%s\"", new Object[] { paramString });
    }
    if ((localFileStructStat.isDirectory()) && (bool)) {
      return b(paramc, paramString, paramJSONObject);
    }
    return new f.a("ok", new Object[0]).b(a(localFileStructStat, new HashMap()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.ay
 * JD-Core Version:    0.7.0.1
 */