package com.tencent.luggage.wxa.go;

import com.tencent.luggage.wxa.gq.k;

public class c
{
  protected void a(e parame, String paramString)
  {
    parame = new d(parame, paramString, 5);
    k.a();
    k.a(parame);
  }
  
  public void a(String paramString)
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioPcmDataTrackTaskController", "recycleAllCache appId:%s", new Object[] { paramString });
    a(new b(paramString), "AudioPcmDataTrackRecycleCacheTask");
  }
  
  public void a(String paramString1, String paramString2)
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioPcmDataTrackTaskController", "cacheToFile appId:%s, filePath:%s", new Object[] { paramString1, paramString2 });
    a(new a(paramString1, paramString2), "AudioPcmDataTrackCacheToFileTask");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.go.c
 * JD-Core Version:    0.7.0.1
 */