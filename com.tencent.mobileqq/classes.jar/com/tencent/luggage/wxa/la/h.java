package com.tencent.luggage.wxa.la;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.jj.j;
import com.tencent.luggage.wxa.pc.i;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.x;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.widget.dialog.e;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.a;
import org.json.JSONObject;

public class h
  implements c
{
  public static h a = new h();
  
  private static u a(com.tencent.luggage.wxa.jx.h paramh)
  {
    if ((paramh instanceof u)) {
      return (u)paramh;
    }
    return ((com.tencent.luggage.wxa.iu.h)paramh).v();
  }
  
  @NonNull
  public com.tencent.luggage.wxa.ro.d<com.tencent.luggage.wxa.do.c> a(@NonNull b paramb, @NonNull com.tencent.luggage.wxa.nn.a parama, @NonNull JSONObject paramJSONObject)
  {
    return com.tencent.luggage.wxa.ro.h.a((com.tencent.luggage.wxa.do.c)null);
  }
  
  @UiThread
  protected i.a a(@NonNull com.tencent.luggage.wxa.iu.d paramd)
  {
    return new e(paramd.ah());
  }
  
  public final void a(b paramb, String paramString1, int paramInt, String paramString2, @Nullable c.a parama, @NonNull JSONObject paramJSONObject, c.c paramc)
  {
    com.tencent.mm.plugin.appbrand.keylogger.d.a(com.tencent.luggage.wxa.oy.a.class, paramString1);
    com.tencent.mm.plugin.appbrand.keylogger.d.a(com.tencent.luggage.wxa.oy.a.class, paramString1, String.format("Network:%s", new Object[] { x.b(paramb.q().ag()) }));
    Object localObject1 = paramb.getAppId();
    int i;
    if (parama != null) {
      i = parama.f;
    } else {
      i = 0;
    }
    o.d("MicroMsg.MiniProgramNavigator", "navigateTo fromAppID(%s) targetAppID(%s) sourceType:%d", new Object[] { localObject1, paramString1, Integer.valueOf(i) });
    JSONObject localJSONObject2 = paramJSONObject.optJSONObject("extraData");
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("privateExtraData");
    localObject1 = a(paramb);
    if (localObject1 != null) {
      localObject1 = ((u)localObject1).ao();
    } else {
      localObject1 = "";
    }
    com.tencent.luggage.wxa.ed.d locald = (com.tencent.luggage.wxa.ed.d)paramb.q();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramb.getAppId());
    ((StringBuilder)localObject2).append(":");
    ((StringBuilder)localObject2).append(locald.j().h());
    ((StringBuilder)localObject2).append(":");
    ((StringBuilder)localObject2).append(locald.j().c + 1000);
    String str = ((StringBuilder)localObject2).toString();
    localObject2 = locald.l();
    com.tencent.luggage.wxa.ou.d locald1 = new com.tencent.luggage.wxa.ou.d();
    if ((parama != null) && (parama.a != 0)) {
      i = parama.a;
    } else {
      i = 1037;
    }
    locald1.c = i;
    locald1.f = ((com.tencent.luggage.wxa.ou.d)localObject2).f;
    localObject2 = str;
    if (parama != null)
    {
      localObject2 = str;
      if (parama.a != 0)
      {
        localObject2 = str;
        if (!af.c(parama.b)) {
          localObject2 = String.format("%s:%s", new Object[] { str, parama.b });
        }
      }
    }
    locald1.d = ((String)localObject2);
    if (parama != null) {
      i = parama.c;
    } else {
      i = 0;
    }
    locald1.a = i;
    if (parama != null) {
      localObject2 = parama.d;
    } else {
      localObject2 = null;
    }
    locald1.b = ((String)localObject2);
    if (parama != null) {
      localObject2 = parama.g;
    } else {
      localObject2 = null;
    }
    locald1.g = ((String)localObject2);
    j localj = new j();
    localj.b = paramb.getAppId();
    str = "{}";
    if (localJSONObject2 == null) {
      localObject2 = "{}";
    } else {
      localObject2 = localJSONObject2.toString();
    }
    localj.c = ((String)localObject2);
    if (localJSONObject1 == null) {
      localObject2 = str;
    } else {
      localObject2 = localJSONObject1.toString();
    }
    localj.d = ((String)localObject2);
    localj.a = 1;
    localj.f = ((String)localObject1);
    if (parama != null) {
      i = parama.f;
    } else {
      i = 0;
    }
    localj.h = i;
    if (parama != null) {
      localObject1 = parama.e;
    } else {
      localObject1 = null;
    }
    localj.g = ((String)localObject1);
    if (parama != null) {
      parama = parama.h;
    } else {
      parama = null;
    }
    localj.i = parama;
    long l = af.d();
    parama = new com.tencent.luggage.wxa.nn.a();
    parama.a = null;
    parama.b = paramString1;
    parama.c = 0;
    parama.d = paramInt;
    parama.e = paramString2;
    parama.f = locald1;
    parama.g = localj;
    parama.h = null;
    parama.i = l;
    localObject1 = new i();
    com.tencent.luggage.wxa.ro.h.a().a(locald).d(new h.4(this, (i)localObject1, locald, paramb, parama)).d(new h.3(this, paramb, paramString1, paramString2, parama, paramJSONObject)).d(new h.2(this, (i)localObject1, paramb, parama, paramc)).a(new h.1(this, paramc, locald, (i)localObject1));
  }
  
  public boolean a(@NonNull b paramb, @NonNull com.tencent.luggage.wxa.nn.a parama, @NonNull c.b paramb1)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.la.h
 * JD-Core Version:    0.7.0.1
 */