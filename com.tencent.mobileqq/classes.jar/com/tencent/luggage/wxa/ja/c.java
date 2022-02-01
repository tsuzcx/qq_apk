package com.tencent.luggage.wxa.ja;

import android.graphics.Canvas;
import com.tencent.luggage.wxa.jb.aa;
import com.tencent.luggage.wxa.jb.ab;
import com.tencent.luggage.wxa.jb.ac;
import com.tencent.luggage.wxa.jb.ad;
import com.tencent.luggage.wxa.jb.ae;
import com.tencent.luggage.wxa.jb.af;
import com.tencent.luggage.wxa.jb.ag;
import com.tencent.luggage.wxa.jb.ah;
import com.tencent.luggage.wxa.jb.ai;
import com.tencent.luggage.wxa.jb.aj;
import com.tencent.luggage.wxa.jb.ak;
import com.tencent.luggage.wxa.jb.b;
import com.tencent.luggage.wxa.jb.e;
import com.tencent.luggage.wxa.jb.f;
import com.tencent.luggage.wxa.jb.g;
import com.tencent.luggage.wxa.jb.h;
import com.tencent.luggage.wxa.jb.i;
import com.tencent.luggage.wxa.jb.j;
import com.tencent.luggage.wxa.jb.k;
import com.tencent.luggage.wxa.jb.l;
import com.tencent.luggage.wxa.jb.m;
import com.tencent.luggage.wxa.jb.n;
import com.tencent.luggage.wxa.jb.o;
import com.tencent.luggage.wxa.jb.p;
import com.tencent.luggage.wxa.jb.q;
import com.tencent.luggage.wxa.jb.r;
import com.tencent.luggage.wxa.jb.s;
import com.tencent.luggage.wxa.jb.t;
import com.tencent.luggage.wxa.jb.u;
import com.tencent.luggage.wxa.jb.v;
import com.tencent.luggage.wxa.jb.w;
import com.tencent.luggage.wxa.jb.x;
import com.tencent.luggage.wxa.jb.y;
import com.tencent.luggage.wxa.jb.z;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class c
{
  private Map<String, com.tencent.luggage.wxa.jb.d> a = new HashMap();
  
  public c()
  {
    a(new ae());
    a(new q());
    a(new af());
    a(new v());
    a(new k());
    a(new com.tencent.luggage.wxa.jb.a());
    a(new h());
    a(new e());
    a(new l());
    a(new i());
    a(new f());
    a(new ad());
    a(new j());
    a(new g());
    a(new com.tencent.luggage.wxa.jb.c());
    a(new b());
    a(new ag());
    a(new ah());
    a(new x());
    a(new aa());
    a(new ab());
    a(new ac());
    a(new s());
    a(new y());
    a(new t());
    a(new u());
    a(new r());
    a(new z());
    a(new ai());
    a(new w());
    a(new p());
    a(new n());
    a(new ak());
    a(new o());
    a(new m());
    a(new aj());
  }
  
  private void a(com.tencent.luggage.wxa.jb.d paramd)
  {
    if (paramd == null) {
      return;
    }
    this.a.put(paramd.a(), paramd);
  }
  
  public boolean a(d paramd, Canvas paramCanvas, com.tencent.luggage.wxa.jc.a parama)
  {
    com.tencent.luggage.wxa.jb.d locald = (com.tencent.luggage.wxa.jb.d)this.a.get(parama.a);
    if (locald == null) {
      return false;
    }
    return locald.a(paramd, paramCanvas, parama);
  }
  
  public boolean a(d paramd, Canvas paramCanvas, JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optString("method");
    paramJSONObject = paramJSONObject.optJSONArray("data");
    localObject = (com.tencent.luggage.wxa.jb.d)this.a.get(localObject);
    if (localObject == null) {
      return false;
    }
    return ((com.tencent.luggage.wxa.jb.d)localObject).a(paramd, paramCanvas, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ja.c
 * JD-Core Version:    0.7.0.1
 */