package com.tencent.luggage.wxa.go;

import com.tencent.luggage.wxa.gn.f;
import com.tencent.luggage.wxa.gw.a;
import java.util.ArrayList;

public class b
  implements e
{
  private String a;
  
  public b(String paramString)
  {
    this.a = paramString;
  }
  
  public void a()
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioPcmDataTrackRecycleCacheTask", "runTask, appId:%s", new Object[] { this.a });
    f.c().b();
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioPcmDataTrackRecycleCacheTask", "delete all pcm cache File");
    ArrayList localArrayList = f.c().f();
    if (localArrayList.size() > 0) {
      a.a(this.a, localArrayList);
    }
  }
  
  public void b()
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioPcmDataTrackRecycleCacheTask", "end task");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.go.b
 * JD-Core Version:    0.7.0.1
 */