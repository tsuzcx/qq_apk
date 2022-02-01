package com.tencent.luggage.wxa.ou;

import android.content.Context;
import android.media.AudioManager;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jj.l;
import com.tencent.luggage.wxa.qw.dg;
import com.tencent.luggage.wxa.qw.me;
import com.tencent.luggage.wxa.qw.mf;
import com.tencent.luggage.wxa.qw.mg;
import com.tencent.luggage.wxa.qw.mh;
import com.tencent.luggage.wxa.qw.mj;
import com.tencent.luggage.wxa.qw.mk;
import com.tencent.luggage.wxa.qw.ns;
import com.tencent.luggage.wxa.qz.s;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.appstorage.n;

public class a
{
  private mf a = null;
  private me b = null;
  @Nullable
  private mj c = null;
  @Nullable
  private mk d = null;
  @Nullable
  private mh e = null;
  @Nullable
  private ns f = null;
  private s g = new s(Looper.getMainLooper());
  
  private dg a(com.tencent.luggage.wxa.iu.d paramd)
  {
    Object localObject = paramd.ae().A();
    boolean bool = false;
    if ((localObject != null) && (paramd.ae().A().f() != null))
    {
      localObject = paramd.ae().A().f();
      this.a = new mf();
      this.a.a = ((e)localObject).pkgVersion();
      this.a.b = ((e)localObject).lastModified();
      this.a.c = 0;
    }
    if ((paramd.A() != null) && (paramd.A().S != null))
    {
      localObject = paramd.A().S;
      this.b = new me();
      this.b.a = ((af)localObject).b;
      this.b.b = ((af)localObject).pkgVersion;
      localObject = ((com.tencent.luggage.wxa.ed.d)paramd).l();
      if (localObject != null)
      {
        this.b.c = ((d)localObject).c;
        this.b.e = ((d)localObject).a;
        this.b.d = 0;
      }
    }
    int i = ((AudioManager)paramd.ag().getSystemService("audio")).getStreamVolume(3);
    localObject = new mg();
    if (i == 0) {
      bool = true;
    }
    ((mg)localObject).a = bool;
    dg localdg = new dg();
    localdg.a = paramd.aa();
    localdg.c = this.a;
    localdg.b = this.b;
    localdg.d = ((mg)localObject);
    return localdg;
  }
  
  @UiThread
  public mh a()
  {
    return this.e;
  }
  
  public void a(com.tencent.luggage.wxa.iu.d paramd, @Nullable a.a parama)
  {
    this.g.a(new a.1(this, paramd, parama));
  }
  
  @UiThread
  public void b()
  {
    this.g.a(new a.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ou.a
 * JD-Core Version:    0.7.0.1
 */