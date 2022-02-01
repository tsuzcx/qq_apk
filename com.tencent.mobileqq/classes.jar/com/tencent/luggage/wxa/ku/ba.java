package com.tencent.luggage.wxa.ku;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import org.json.JSONObject;

final class ba
  extends d
{
  @NonNull
  f.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("targetDirectory", "");
    paramJSONObject = paramc.getFileSystem().c(str);
    int i = ba.1.a[paramJSONObject.ordinal()];
    Object localObject;
    if ((i != 1) && (i != 2) && (i != 3))
    {
      localObject = paramc.getFileSystem().g(paramString);
      if ((localObject != null) && (((com.tencent.luggage.wxa.rt.i)localObject).j()))
      {
        if ((!((com.tencent.luggage.wxa.rt.i)localObject).n()) && (!com.tencent.mm.plugin.appbrand.appstorage.k.d((com.tencent.luggage.wxa.rt.i)localObject))) {
          i = 0;
        } else {
          return new f.a("fail permission denied, open \"%s\"", new Object[] { paramString });
        }
      }
      else
      {
        paramJSONObject = (JSONObject)localObject;
        if (paramc.getFileSystem().b(paramString) == j.a)
        {
          com.tencent.luggage.wxa.rt.i locali = paramc.getFileSystem().i(URLEncoder.encode(paramString));
          paramJSONObject = (JSONObject)localObject;
          if (locali != null)
          {
            paramJSONObject = new com.tencent.luggage.wxa.pc.i();
            paramc.getFileSystem().b(paramString, paramJSONObject);
            try
            {
              Channels.newChannel(com.tencent.luggage.wxa.rt.k.b(locali)).write((ByteBuffer)paramJSONObject.a);
              paramJSONObject = new com.tencent.luggage.wxa.rt.i(locali.l());
              i = 1;
            }
            catch (IOException paramJSONObject)
            {
              com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrand.FileSystem.UnitUnzip", "copy ByteBuffer failed e = %s", new Object[] { paramJSONObject });
              paramJSONObject = null;
            }
          }
        }
        i = 0;
        localObject = paramJSONObject;
        if (paramJSONObject == null) {
          return new f.a("fail no such file \"%s\"", new Object[] { paramString });
        }
      }
    }
    for (;;)
    {
      try
      {
        paramc = paramc.getFileSystem().a(str, (com.tencent.luggage.wxa.rt.i)localObject);
        if (i != 0) {
          com.tencent.luggage.wxa.rt.k.i(((com.tencent.luggage.wxa.rt.i)localObject).l());
        }
        i = ba.1.a[paramc.ordinal()];
        if (i != 1) {}
        switch (i)
        {
        case 9: 
          paramString = new StringBuilder();
          paramString.append("fail ");
          paramString.append(paramc.name());
          return new f.a(paramString.toString(), new Object[0]);
          return new f.a("ok", new Object[0]);
        case 8: 
          return new f.a("fail write entry", new Object[0]);
        case 7: 
          return new f.a("fail read zip data", new Object[0]);
        case 6: 
          return new f.a("fail the maximum size of the file storage limit is exceeded", new Object[0]);
        case 5: 
          return new f.a("fail illegal operation on a filePath, open \"%s\"", new Object[] { paramString });
        case 4: 
          return new f.a("fail no such file or directory, open \"%s\"", new Object[] { paramString });
          paramc = new f.a("fail permission denied, open \"%s\"", new Object[] { paramString });
          return paramc;
        }
      }
      catch (Exception paramc)
      {
        com.tencent.luggage.wxa.qz.o.a("MicroMsg.AppBrand.FileSystem.UnitUnzip", paramc, "write zip stream", new Object[0]);
        return new f.a("fail read zip data", new Object[0]);
      }
      return new f.a(String.format("fail permission denied, open \"%s\"", new Object[] { str }), new Object[0]);
    }
  }
  
  protected String a(@NonNull JSONObject paramJSONObject)
  {
    return paramJSONObject.optString("zipFilePath");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.ba
 * JD-Core Version:    0.7.0.1
 */