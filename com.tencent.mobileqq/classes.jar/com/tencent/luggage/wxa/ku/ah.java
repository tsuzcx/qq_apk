package com.tencent.luggage.wxa.ku;

import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.m.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

public final class ah
  extends a
{
  public static final int CTRL_INDEX = 51;
  public static final String NAME = "saveFile";
  
  static m.a a(c paramc, JSONObject paramJSONObject)
  {
    Object localObject2 = paramJSONObject.optString("tempFilePath");
    Object localObject1 = paramJSONObject.optString("filePath");
    if (af.c((String)localObject2))
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiSaveFile", "temp localId is null or nil");
      return new m.a("fail", new Object[0]);
    }
    localObject2 = paramc.getFileSystem().g((String)localObject2);
    if ((localObject2 != null) && (((com.tencent.luggage.wxa.rt.i)localObject2).j()))
    {
      paramJSONObject = new com.tencent.luggage.wxa.pc.i();
      paramc = a(paramc, (com.tencent.luggage.wxa.rt.i)localObject2, (String)localObject1, paramJSONObject);
      localObject1 = new HashMap();
      if ("ok".equals(paramc)) {
        ((Map)localObject1).put("savedFilePath", paramJSONObject.a);
      }
      return new m.a(paramc, new Object[0]).a((Map)localObject1);
    }
    return new m.a("fail tempFilePath file not exist", new Object[0]);
  }
  
  public static String a(c paramc, com.tencent.luggage.wxa.rt.i parami, String paramString, com.tencent.luggage.wxa.pc.i<String> parami1)
  {
    if ((parami != null) && (parami.j()))
    {
      Object localObject = paramc.getFileSystem().c(paramString);
      if (localObject != j.a) {
        try
        {
          localObject = new com.tencent.luggage.wxa.pc.i();
          parami = paramc.getFileSystem().a(parami, paramString, (com.tencent.luggage.wxa.pc.i)localObject);
          paramc = parami;
          if (parami1 == null) {
            break label114;
          }
          parami1.a = ((com.tencent.luggage.wxa.pc.i)localObject).a;
          paramc = parami;
        }
        catch (Exception paramc)
        {
          parami = new StringBuilder();
          parami.append("fail:writeFile exception: ");
          parami.append(paramc.toString());
          return parami.toString();
        }
      } else {
        paramc = (c)localObject;
      }
      label114:
      int i = ah.2.a[paramc.ordinal()];
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
                parami = new StringBuilder();
                parami.append("fail ");
                parami.append(paramc.name());
                return parami.toString();
              }
              return "ok";
            }
            return "fail the maximum size of the file storage limit is exceeded";
          }
          return String.format("fail illegal operation on a directory, open \"%s\"", new Object[] { paramString });
        }
        return String.format("fail no such file or directory \"%s\"", new Object[] { paramString });
      }
      return String.format("fail permission denied, open \"%s\"", new Object[] { paramString });
    }
    return "fail:file not exists";
  }
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    b.a.execute(new ah.1(this, paramc, paramJSONObject, paramInt));
  }
  
  protected boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.ah
 * JD-Core Version:    0.7.0.1
 */