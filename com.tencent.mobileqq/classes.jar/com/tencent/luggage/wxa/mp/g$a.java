package com.tencent.luggage.wxa.mp;

import com.tencent.luggage.wxa.jx.k;
import com.tencent.luggage.wxa.pd.p;
import com.tencent.luggage.wxa.pd.p.a;
import com.tencent.luggage.wxa.pd.p.b;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import java.util.HashMap;
import java.util.Map;

class g$a
  extends e.b
  implements k
{
  private final com.tencent.luggage.wxa.jx.c a;
  
  public g$a(com.tencent.luggage.wxa.jx.c paramc)
  {
    this.a = paramc;
  }
  
  public void a()
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiOperateRecorder", "onStart");
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", e.e.a.h);
    d.a(this.a, localHashMap);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiOperateRecorder", "onStop tempFilePath:%s duration:%d fileSize:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.luggage.wxa.pc.i locali = new com.tencent.luggage.wxa.pc.i();
    if (this.a.getFileSystem().a(new com.tencent.luggage.wxa.rt.i(paramString), b.a(paramString), com.tencent.luggage.wxa.qz.c.a ^ true, locali) == j.a)
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiOperateRecorder", "realFilePath:%s", new Object[] { locali.a });
      paramString = new HashMap();
      paramString.put("state", e.e.c.h);
      paramString.put("tempFilePath", locali.a);
      paramString.put("duration", Integer.valueOf(paramInt1));
      paramString.put("fileSize", Integer.valueOf(paramInt2));
      d.a(this.a, paramString);
      return;
    }
    com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiOperateRecorder", "create file fail");
    paramString = new HashMap();
    paramString.put("state", e.e.d.h);
    paramString.put("errCode", Integer.valueOf(-1));
    paramString.put("errMsg", "create file fail");
    d.a(this.a, paramString);
  }
  
  public void a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int i = 0;
    if (paramArrayOfByte != null) {
      i = paramArrayOfByte.length;
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiOperateRecorder", "onFrameRecorded isLastFrame:%b length:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", e.e.e.h);
    localHashMap.put("isLastFrame", Boolean.valueOf(paramBoolean));
    if (paramArrayOfByte != null) {
      localHashMap.put("frameBuffer", p.a(paramArrayOfByte));
    } else {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.JsApiOperateRecorder", "frameBuffer is null");
    }
    paramArrayOfByte = p.a(this.a.getJsRuntime(), localHashMap, (p.a)this.a.b(p.a.class));
    if ((paramArrayOfByte != p.b.a) && (paramArrayOfByte == p.b.b))
    {
      p.a(this.a, "onRecorderStateChange");
      return;
    }
    d.a(this.a, localHashMap);
  }
  
  public void b()
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiOperateRecorder", "onResume");
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", e.e.a.h);
    d.a(this.a, localHashMap);
  }
  
  public void c()
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiOperateRecorder", "onPause");
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", e.e.b.h);
    d.a(this.a, localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mp.g.a
 * JD-Core Version:    0.7.0.1
 */