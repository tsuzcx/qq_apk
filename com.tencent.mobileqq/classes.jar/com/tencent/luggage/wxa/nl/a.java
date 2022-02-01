package com.tencent.luggage.wxa.nl;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.do.b;
import com.tencent.luggage.wxa.do.c;
import com.tencent.luggage.wxa.hv.h;
import com.tencent.luggage.wxa.jj.j;
import com.tencent.luggage.wxa.jj.s;
import com.tencent.luggage.wxa.jj.s.f;
import com.tencent.luggage.wxa.jj.u;
import com.tencent.luggage.wxa.jj.v;
import com.tencent.luggage.wxa.ou.d;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import org.json.JSONObject;

public class a
  implements Runnable
{
  private final a.a a;
  final j b;
  protected final int c;
  protected final int d;
  protected volatile String e;
  protected volatile String f;
  protected final String g;
  protected d h;
  @Nullable
  protected final com.tencent.luggage.wxa.dw.a i;
  
  public a(@NonNull com.tencent.luggage.wxa.nn.a parama, @Nullable a.a parama1)
  {
    this.a = parama1;
    this.c = parama.d;
    this.e = parama.b;
    this.f = parama.a;
    this.d = parama.c;
    this.h = parama.f;
    this.g = parama.e;
    this.i = parama.m;
    this.b = parama.g;
  }
  
  protected Pair<s, Boolean> a()
  {
    return new Pair(u.a().b(this.e, com.tencent.luggage.wxa.jj.t.b), Boolean.valueOf(false));
  }
  
  protected void a(c paramc, d paramd)
  {
    a.a locala = this.a;
    if (locala != null) {
      locala.a(paramc, paramd, 1);
    }
  }
  
  protected boolean a(@NonNull s params)
  {
    if ((d.a.a(this.c)) && (1 == params.e().b))
    {
      com.tencent.luggage.wxa.qz.t.a(new a.1(this));
      return true;
    }
    return false;
  }
  
  protected void b()
  {
    a.a locala = this.a;
    if (locala != null) {
      locala.a(null, null, 2);
    }
  }
  
  public void run()
  {
    Object localObject = (s)a().first;
    if (localObject == null)
    {
      o.d("Luggage.AppBrandPreLaunchProcess", "onGetWxaAttr null return");
      b();
      return;
    }
    if (a((s)localObject))
    {
      b();
      return;
    }
    c localc = b.b().a((s)localObject);
    if (localc == null)
    {
      o.b("Luggage.AppBrandPreLaunchProcess", "onGetWxaAttr, assembled NULL config with username(%s) appId(%s)", new Object[] { ((s)localObject).c, ((s)localObject).d });
      b();
      return;
    }
    o.d("Luggage.AppBrandPreLaunchProcess", "appId:%s initConfig appVersion:%d", new Object[] { localc.D, Integer.valueOf(localc.n) });
    localc.G = this.c;
    this.e = localc.D;
    this.f = localc.b;
    if (this.c == 0) {
      localc.H = ((s)localObject).e().d;
    } else {
      localc.k = g.a().a(this.e, this.c);
    }
    try
    {
      localObject = h.a(localc.k);
      localc.H = ((JSONObject)localObject).optString("device_orientation");
      localc.d = ((JSONObject)localObject).optBoolean("open_remote", false);
      localc.p = v.a(localc.k);
    }
    catch (Exception localException)
    {
      label216:
      break label216;
    }
    if (this.h == null) {
      this.h = new d();
    }
    a(localc, this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.a
 * JD-Core Version:    0.7.0.1
 */