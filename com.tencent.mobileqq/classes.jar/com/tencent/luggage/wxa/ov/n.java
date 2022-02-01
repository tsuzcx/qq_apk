package com.tencent.luggage.wxa.ov;

import android.net.Uri;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.jj.l;
import com.tencent.luggage.wxa.ou.g;
import com.tencent.luggage.wxa.ou.h;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.xweb.WebResourceRequest;
import java.util.Map;

public final class n
{
  private static final n p = new n(true);
  public String a;
  public com.tencent.luggage.wxa.ed.d b;
  public int c;
  public int d;
  public int e;
  public String f;
  public String g;
  public String h;
  public String i;
  public int j;
  public int k;
  public int l;
  public int m;
  public String n;
  private final boolean o;
  
  private n(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public static n a(com.tencent.luggage.wxa.ed.d paramd)
  {
    n localn = new n(false);
    localn.a = paramd.aa();
    localn.b = paramd;
    if (paramd.i() == null)
    {
      localn.d = (paramd.ab() + 1);
      localn.c = paramd.j().n;
      return localn;
    }
    localn.d = (paramd.i().c() + 1);
    localn.c = paramd.i().S.pkgVersion;
    return localn;
  }
  
  private void a()
  {
    if (this.o) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("report ");
    ((StringBuilder)localObject).append(toString());
    o.d("MicroMsg.AppBrand.Report.kv_19358", ((StringBuilder)localObject).toString());
    localObject = this.a;
    int i1 = this.c;
    int i2 = this.d;
    int i3 = this.e;
    String str1 = this.f;
    String str2 = this.g;
    String str3 = this.h;
    String str4 = this.i;
    int i4 = this.j;
    int i5 = this.k;
    int i6 = this.l;
    int i7 = this.m;
    String str5 = this.n;
    com.tencent.luggage.wxa.ot.d locald = (com.tencent.luggage.wxa.ot.d)e.b(com.tencent.luggage.wxa.ot.d.class);
    if (locald == null)
    {
      o.b("MicroMsg.AppBrand.Report.kv_19358", "report null kvReporter");
      return;
    }
    locald.a(19358, g.a(new Object[] { localObject, Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), str1, str2, str3, str4, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), str5 }));
  }
  
  private void a(com.tencent.luggage.wxa.dq.c paramc)
  {
    com.tencent.luggage.wxa.do.d locald = paramc.f().i();
    if (locald != null) {
      this.c = locald.S.pkgVersion;
    }
    this.f = h.a();
    paramc = paramc.f();
    if (paramc == null) {
      paramc = null;
    } else {
      paramc = paramc.j();
    }
    if (paramc != null)
    {
      this.e = paramc.c;
    }
    else
    {
      this.e = 0;
      o.b("MicroMsg.AppBrand.Report.kv_19358", "prepareCommonFields null = initConfig! apptype:%s", new Object[] { Integer.valueOf(this.e) });
    }
    this.e += 1000;
  }
  
  public void a(com.tencent.luggage.wxa.dq.c paramc, String paramString, WebResourceRequest paramWebResourceRequest)
  {
    if (!this.o)
    {
      if (paramWebResourceRequest == null) {
        return;
      }
      this.g = paramString;
      this.h = paramWebResourceRequest.a().toString();
      this.i = paramWebResourceRequest.c();
      this.n = ((String)paramWebResourceRequest.d().get("Referer"));
      a(paramc);
      a();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kv_19358{appId='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", appVersion=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", appState=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", appType=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", networkType='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pageUrl='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", url='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", method='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append(", sentSize=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", receivedSize=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", statusCode=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", visitType=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", referer='");
    localStringBuilder.append(this.n);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ov.n
 * JD-Core Version:    0.7.0.1
 */