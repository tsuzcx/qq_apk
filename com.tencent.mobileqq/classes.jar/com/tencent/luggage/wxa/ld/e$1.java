package com.tencent.luggage.wxa.ld;

import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.nz.j;
import com.tencent.luggage.wxa.nz.k.a;
import com.tencent.luggage.wxa.pd.p;
import com.tencent.luggage.wxa.pd.p.a;
import com.tencent.luggage.wxa.pd.p.b;
import com.tencent.luggage.wxa.pd.q;
import com.tencent.luggage.wxa.pm.h;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class e$1
  implements d.a
{
  boolean a = false;
  
  e$1(e parame, com.tencent.luggage.wxa.jx.c paramc, String paramString, boolean paramBoolean) {}
  
  public void a(int paramInt, String paramString)
  {
    if (e.f() != null) {
      e.f().b(this.b, this.c, this.e);
    }
    HashMap localHashMap = new HashMap();
    if (j.a(this.b.getAppState())) {
      localHashMap.put("reason", "interrupted");
    } else if (!af.c(paramString)) {
      localHashMap.put("reason", paramString);
    }
    localHashMap.put("code", Integer.valueOf(paramInt));
    localHashMap.put("socketTaskId", this.c);
    localHashMap.put("state", "close");
    paramString = new JSONObject(localHashMap).toString();
    new e.a().b(this.b).b(paramString).a(this.e.c().a(this.c));
    this.e.c().b(this.c);
  }
  
  public void a(com.tencent.luggage.wxa.pm.a parama)
  {
    if (parama != null)
    {
      if (!((com.tencent.luggage.wxa.nz.a)this.b.b(com.tencent.luggage.wxa.nz.a.class)).y) {
        return;
      }
      com.tencent.luggage.wxa.gz.a locala = new com.tencent.luggage.wxa.gz.a();
      locala.a.a = "socket";
      locala.a.c = e.a(this.e, parama);
      locala.a.b = this.c;
      com.tencent.luggage.wxa.qy.a.a.a(locala);
    }
  }
  
  public void a(h paramh, Map<String, Long> paramMap)
  {
    if (e.f() != null) {
      e.f().a(this.b, this.c, this.e);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("socketTaskId", this.c);
    localHashMap.put("state", "open");
    localHashMap.put("header", e.a(this.e, paramh));
    if ((paramMap != null) && (paramMap.size() > 0) && (this.d)) {
      localHashMap.put("profile", paramMap);
    }
    paramh = new JSONObject(localHashMap).toString();
    new e.a().b(this.b).b(paramh).a(this.e.c().a(this.c));
  }
  
  public void a(String paramString)
  {
    if (this.a)
    {
      o.d("MicroMsg.JsApiCreateSocketTask", "onSocketError is true");
      return;
    }
    this.a = true;
    HashMap localHashMap = new HashMap();
    localHashMap.put("socketTaskId", this.c);
    localHashMap.put("state", "error");
    localHashMap.put("errMsg", paramString);
    paramString = new JSONObject(localHashMap).toString();
    new e.a().b(this.b).b(paramString).a(this.e.c().a(this.c));
    this.e.c().b(this.c);
    if ((!e.a(this.e)) && (!e.b(this.e)))
    {
      ((com.tencent.luggage.wxa.ot.c)com.tencent.luggage.wxa.ba.e.b(com.tencent.luggage.wxa.ot.c.class)).a(972L, 1L, 1L, false);
      return;
    }
    ((com.tencent.luggage.wxa.ot.c)com.tencent.luggage.wxa.ba.e.b(com.tencent.luggage.wxa.ot.c.class)).a(972L, 2L, 1L, false);
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("socketTaskId", this.c);
    localHashMap.put("data", paramByteBuffer);
    localHashMap.put("isBuffer", Boolean.valueOf(true));
    localHashMap.put("state", "message");
    paramByteBuffer = (p.a)this.b.b(p.a.class);
    paramByteBuffer = p.a(this.b.getJsRuntime(), localHashMap, paramByteBuffer);
    if (paramByteBuffer == p.b.a)
    {
      paramByteBuffer = new JSONObject(localHashMap).toString();
      new e.a().b(this.b).b(paramByteBuffer).a(this.e.c().a(this.c));
      return;
    }
    if (paramByteBuffer == p.b.b) {
      p.a(this.b, "onSocketTaskStateChange");
    }
  }
  
  public void b(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", q.a(paramString));
    localHashMap.put("isBuffer", Boolean.valueOf(false));
    localHashMap.put("socketTaskId", this.c);
    localHashMap.put("state", "message");
    paramString = new JSONObject(localHashMap).toString();
    new e.a().b(this.b).b(paramString).a(this.e.c().a(this.c));
  }
  
  public void c(String paramString)
  {
    e.a(this.e, this.b, this.c, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ld.e.1
 * JD-Core Version:    0.7.0.1
 */