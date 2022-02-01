package com.tencent.luggage.wxa.mp;

import com.tencent.luggage.wxa.jx.k;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class h$a
  extends e.b
  implements k
{
  private final com.tencent.luggage.wxa.jx.c a;
  private final h b;
  private final int c;
  private final JSONObject d;
  
  public h$a(com.tencent.luggage.wxa.jx.c paramc, h paramh, int paramInt, JSONObject paramJSONObject)
  {
    this.a = paramc;
    this.b = paramh;
    this.c = paramInt;
    this.d = paramJSONObject;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    com.tencent.luggage.wxa.pc.i locali = new com.tencent.luggage.wxa.pc.i();
    if (this.a.getFileSystem().a(new com.tencent.luggage.wxa.rt.i(paramString), b.a(paramString), com.tencent.luggage.wxa.qz.c.a ^ true, locali) == j.a)
    {
      paramString = new HashMap();
      paramString.put("state", e.e.c.h);
      paramString.put("tempFilePath", locali.a);
      paramString.put("duration", Integer.valueOf(paramInt1));
      paramString.put("fileSize", Integer.valueOf(paramInt2));
      com.tencent.luggage.wxa.qz.o.d("Luggage.AppBrandComponentScopedRecorderStateChangeListener", "startRecord ok:%s", new Object[] { paramString });
      this.a.a(this.c, this.b.a("ok", paramString));
    }
    else
    {
      com.tencent.luggage.wxa.qz.o.b("Luggage.AppBrandComponentScopedRecorderStateChangeListener", "create file fail");
      this.a.a(this.c, this.b.b("fail:create file fail"));
    }
    paramString = (e)this.a.a(e.class);
    if (paramString != null) {
      paramString.b(this.a.getAppId(), this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mp.h.a
 * JD-Core Version:    0.7.0.1
 */