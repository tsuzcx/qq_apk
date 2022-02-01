package com.tencent.luggage.wxa.jo;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.jn.i;
import com.tencent.luggage.wxa.jn.k;
import com.tencent.luggage.wxa.jn.l;
import com.tencent.luggage.wxa.jp.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class c
  implements com.tencent.luggage.wxa.jq.b
{
  @Nullable
  protected b a;
  protected h b = h.a();
  protected f c;
  protected f d;
  protected f e;
  protected e f = new e();
  protected com.tencent.luggage.wxa.jr.c g;
  protected com.tencent.luggage.wxa.jr.c h;
  protected d i;
  protected boolean j = false;
  protected boolean k = false;
  protected boolean l = false;
  
  public c(@Nullable b paramb)
  {
    this.a = paramb;
    c();
  }
  
  @Nullable
  public static c a(b paramb)
  {
    paramb = new c(paramb);
    if (paramb.d()) {
      return paramb;
    }
    return null;
  }
  
  private String a(f paramf)
  {
    b localb = this.a;
    if (localb != null) {
      return com.tencent.luggage.wxa.jp.g.a(localb.b, this.a.c, paramf.d);
    }
    return "";
  }
  
  @Nullable
  public b a()
  {
    return this.a;
  }
  
  public void a(int paramInt, @Nullable com.tencent.luggage.wxa.jq.a parama)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = new k(a((f)localObject), this.d.a, paramInt);
      this.b.a((com.tencent.luggage.wxa.jn.e)localObject, parama);
    }
  }
  
  public void a(d paramd)
  {
    this.i = paramd;
  }
  
  public void a(e.a parama)
  {
    this.f.a = parama;
  }
  
  public void a(@Nullable com.tencent.luggage.wxa.jq.a parama)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = new com.tencent.luggage.wxa.jn.g(a((f)localObject), this.c.a);
      this.b.a((com.tencent.luggage.wxa.jn.e)localObject, parama);
    }
  }
  
  public void a(String paramString, @Nullable com.tencent.luggage.wxa.jq.a parama)
  {
    f localf = this.c;
    if (localf != null)
    {
      paramString = new com.tencent.luggage.wxa.jn.j(a(localf), this.c.a, paramString);
      this.b.a(paramString, parama);
    }
  }
  
  public boolean a(com.tencent.luggage.wxa.jr.d paramd)
  {
    if (this.i == null) {
      return true;
    }
    if ((paramd.c != null) && (!paramd.c.containsKey("LastChange"))) {
      return false;
    }
    Object localObject = paramd.c;
    HashMap localHashMap = null;
    if (localObject != null)
    {
      localObject = paramd.c.get("LastChange");
      localObject.getClass();
      localObject = ((com.tencent.luggage.wxa.jr.a)localObject).a();
    }
    else
    {
      localObject = null;
    }
    if (localObject != null) {
      localHashMap = com.tencent.luggage.wxa.jp.j.a().b((String)localObject);
    }
    if (localHashMap == null) {
      return false;
    }
    int m;
    if ("avtEvent".equals(paramd.a))
    {
      paramd = (com.tencent.luggage.wxa.jr.a)localHashMap.get("TransportState");
      if (paramd != null)
      {
        paramd = paramd.b("val");
        if ("PLAYING".equalsIgnoreCase(paramd)) {
          this.i.a(this);
        } else if ("PAUSED_PLAYBACK".equalsIgnoreCase(paramd)) {
          this.i.b(this);
        } else if ("STOPPED".equalsIgnoreCase(paramd)) {
          this.i.c(this);
        }
      }
      paramd = (com.tencent.luggage.wxa.jr.a)localHashMap.get("CurrentTrackDuration");
      if (paramd != null)
      {
        paramd = paramd.b("val").split(":");
        if (paramd.length == 3)
        {
          m = Integer.parseInt(paramd[0]);
          int n = Integer.parseInt(paramd[1]);
          int i1 = Integer.parseInt(paramd[2]);
          this.i.b(this, m * 3600 + n * 60 + i1);
          return true;
        }
      }
    }
    else if ("rdcEvent".equals(paramd.a))
    {
      paramd = (com.tencent.luggage.wxa.jr.a)localHashMap.get("Volume");
      if (paramd != null)
      {
        m = Integer.parseInt(paramd.b("val"));
        this.i.a(this, m);
      }
      paramd = (com.tencent.luggage.wxa.jr.a)localHashMap.get("Mute");
      if (paramd != null)
      {
        boolean bool = "0".equals(paramd.b("val"));
        this.i.a(this, bool ^ true);
      }
    }
    return true;
  }
  
  public e.a b()
  {
    return this.f.a;
  }
  
  public void b(@Nullable com.tencent.luggage.wxa.jq.a parama)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = new com.tencent.luggage.wxa.jn.f(a((f)localObject), this.c.a);
      this.b.a((com.tencent.luggage.wxa.jn.e)localObject, parama);
    }
  }
  
  public void b(String paramString, @Nullable com.tencent.luggage.wxa.jq.a parama)
  {
    f localf = this.c;
    if (localf != null)
    {
      paramString = new i(a(localf), this.c.a, paramString);
      this.b.a(paramString, parama);
    }
  }
  
  protected void c()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    if (((b)localObject).l.size() == 0) {
      return;
    }
    localObject = this.a.l.iterator();
    while (((Iterator)localObject).hasNext())
    {
      f localf = (f)((Iterator)localObject).next();
      if (!TextUtils.isEmpty(localf.a)) {
        if (localf.a.startsWith("urn:schemas-upnp-org:service:AVTransport")) {
          this.c = localf;
        } else if (localf.a.startsWith("urn:schemas-upnp-org:service:RenderingControl")) {
          this.d = localf;
        } else if (localf.a.startsWith("urn:schemas-upnp-org:service:ConnectionManager")) {
          this.e = localf;
        }
      }
    }
  }
  
  public void c(@Nullable com.tencent.luggage.wxa.jq.a parama)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = new l(a((f)localObject), this.c.a);
      this.b.a((com.tencent.luggage.wxa.jn.e)localObject, parama);
    }
  }
  
  public void d(@NonNull com.tencent.luggage.wxa.jq.a parama)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = new com.tencent.luggage.wxa.jn.c(a((f)localObject), this.d.a);
      this.b.a((com.tencent.luggage.wxa.jn.e)localObject, parama);
    }
  }
  
  protected boolean d()
  {
    return (this.c != null) && (this.d != null);
  }
  
  public com.tencent.luggage.wxa.jr.c e()
  {
    return this.g;
  }
  
  public void e(@NonNull com.tencent.luggage.wxa.jq.a parama)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = new com.tencent.luggage.wxa.jn.b(a((f)localObject), this.c.a);
      this.b.a((com.tencent.luggage.wxa.jn.e)localObject, parama);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((this.a == null) && (paramObject == null)) {
      return true;
    }
    b localb = this.a;
    if (localb == null) {
      return false;
    }
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof c)) {
      return localb.equals(((c)paramObject).a());
    }
    return false;
  }
  
  public com.tencent.luggage.wxa.jr.c f()
  {
    return this.h;
  }
  
  public void f(@NonNull com.tencent.luggage.wxa.jq.a parama)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = new com.tencent.luggage.wxa.jn.a(a((f)localObject), this.c.a);
      this.b.a((com.tencent.luggage.wxa.jn.e)localObject, parama);
    }
  }
  
  public f g()
  {
    return this.c;
  }
  
  public f h()
  {
    return this.d;
  }
  
  public void i()
  {
    if (this.k) {
      return;
    }
    com.tencent.luggage.wxa.jp.c.a().a(this, new c.1(this));
  }
  
  public void j()
  {
    if (this.l) {
      return;
    }
    com.tencent.luggage.wxa.jp.c.a().b(this, new c.2(this));
  }
  
  public void k()
  {
    if (!this.k) {
      return;
    }
    com.tencent.luggage.wxa.jp.c.a().a(this, new c.3(this));
  }
  
  public void l()
  {
    if (!this.l) {
      return;
    }
    com.tencent.luggage.wxa.jp.c.a().b(this, new c.4(this));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MRDevice{mDevice=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jo.c
 * JD-Core Version:    0.7.0.1
 */