package com.tencent.luggage.wxa.nq;

import android.text.TextUtils;
import com.tencent.luggage.wxa.if.e;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.mm.plugin.appbrand.appcache.v.a;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import java.nio.ByteBuffer;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  public static com.tencent.luggage.wxa.if.b a(c paramc, String paramString1, String paramString2, String paramString3, String paramString4, v.a parama, String paramString5)
  {
    if ((!TextUtils.isEmpty(paramString4)) && (!TextUtils.isEmpty(paramString3)))
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.Audio.AudioPlayerParamParser", "parseAudioPlayParam audioId:%s, sourceData:%s", new Object[] { paramString2, paramString4 });
      com.tencent.luggage.wxa.if.b localb = new com.tencent.luggage.wxa.if.b();
      localb.n = paramString1;
      localb.a = paramString2;
      localb.k = paramString5;
      localb.b = paramString3;
      localb.i = 0;
      try
      {
        paramString1 = new JSONObject(paramString4);
        int i = paramString1.optInt("startTime", 0);
        boolean bool1 = paramString1.optBoolean("autoplay", false);
        boolean bool2 = paramString1.optBoolean("loop", false);
        double d1 = paramString1.optDouble("volume", 1.0D);
        double d2 = paramString1.optDouble("playbackRate", 1.0D);
        localb.d = i;
        localb.e = i;
        localb.g = bool1;
        localb.h = bool2;
        localb.l = d1;
        localb.m = d2;
      }
      catch (JSONException paramString1)
      {
        com.tencent.luggage.wxa.qz.o.a("MicroMsg.Audio.AudioPlayerParamParser", paramString1, "parseAudioPlayParam", new Object[0]);
      }
      if (paramString3.startsWith("file://"))
      {
        localb.c = paramString3.substring(7);
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.Audio.AudioPlayerParamParser", "filePath:%s", new Object[] { localb.c });
        return localb;
      }
      if ((paramString3.contains("base64")) && (paramString3.startsWith("data:audio")))
      {
        localb.c = g.a(paramString3.substring(paramString3.indexOf("base64,") + 7).trim());
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.Audio.AudioPlayerParamParser", "base64 decode filePath:%s", new Object[] { localb.c });
        return localb;
      }
      if (paramString3.startsWith("wxblob://"))
      {
        paramString1 = new com.tencent.luggage.wxa.pc.i();
        if (paramc.getFileSystem().b(paramString3, paramString1) == j.a)
        {
          localb.C = ((ByteBuffer)paramString1.a);
          localb.c = paramString3;
          com.tencent.luggage.wxa.qz.o.d("MicroMsg.Audio.AudioPlayerParamParser", "wxblob read ok");
          return localb;
        }
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.Audio.AudioPlayerParamParser", "wxblob read fail");
        paramc = paramc.getFileSystem().d(paramString3);
        if ((paramc != null) && (paramc.j()))
        {
          localb.c = paramc.l();
          return localb;
        }
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.Audio.AudioPlayerParamParser", "wxblob localFile is null");
        return localb;
      }
      if ((!paramString3.startsWith("http://")) && (!paramString3.startsWith("https://")))
      {
        paramc = f.a(parama);
        if ((paramc != null) && (paramc.a()))
        {
          localb.c = paramString3;
          localb.y = paramc;
          return localb;
        }
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.Audio.AudioPlayerParamParser", "the wxa audioDataSource not found for src %s", new Object[] { paramString3 });
        IOUtils.closeQuietly(paramc);
        return null;
      }
      return localb;
    }
    com.tencent.luggage.wxa.qz.o.b("MicroMsg.Audio.AudioPlayerParamParser", "parseAudioPlayParam, sourceData or src is null, sourceData:%s, src:%s", new Object[] { paramString4, paramString3 });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nq.b
 * JD-Core Version:    0.7.0.1
 */