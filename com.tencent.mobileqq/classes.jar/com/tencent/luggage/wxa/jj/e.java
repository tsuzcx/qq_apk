package com.tencent.luggage.wxa.jj;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.nz.j;
import com.tencent.luggage.wxa.pc.i;
import com.tencent.luggage.wxa.pc.m;
import com.tencent.luggage.wxa.pc.m.a;
import com.tencent.luggage.wxa.pd.p.a;
import com.tencent.luggage.wxa.qu.b;
import com.tencent.luggage.wxa.qw.fi;
import com.tencent.luggage.wxa.qz.ag;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class e
{
  public static com.tencent.luggage.wxa.ku.a a(com.tencent.luggage.wxa.do.d paramd)
  {
    com.tencent.luggage.wxa.ku.a locala = new com.tencent.luggage.wxa.ku.a();
    locala.a = paramd.r;
    if (locala.a <= 0L) {
      locala.a = 10L;
    }
    locala.b = paramd.D.E;
    if (locala.b <= 0L) {
      locala.b = 30L;
    }
    return locala;
  }
  
  public static com.tencent.luggage.wxa.nz.a a(com.tencent.luggage.wxa.ed.d paramd)
  {
    com.tencent.luggage.wxa.do.c localc = paramd.j();
    com.tencent.luggage.wxa.do.d locald = paramd.i();
    a locala = paramd.aj();
    com.tencent.luggage.wxa.nz.a locala1 = new com.tencent.luggage.wxa.nz.a();
    boolean bool;
    if ((!localc.c()) && (!localc.g())) {
      bool = false;
    } else {
      bool = true;
    }
    locala1.a = bool;
    locala1.b = d(locald);
    int i = locala.d().a;
    if (i > 0) {
      locala1.c = i;
    }
    i = locala.d().b;
    if (i > 0) {
      locala1.d = i;
    }
    i = locala.d().c;
    if (i > 0) {
      locala1.e = i;
    }
    i = locala.d().d;
    if (i > 0) {
      locala1.f = i;
    }
    locala1.g = locald.k;
    locala1.h = locald.n;
    locala1.i = locald.l;
    locala1.j = locald.m;
    locala1.k = locald.t;
    locala1.l = locald.u;
    locala1.m = locald.v;
    locala1.n = locald.w;
    locala1.o = locald.x;
    if (locald.D.l.a == 1)
    {
      if (locald.D.l.b != null) {
        locala1.p = locald.D.l.b;
      }
    }
    else if ((locald.D.l.a == 2) && (locald.D.l.c != null)) {
      locala1.q = locald.D.l.c;
    }
    locala1.x = locald.D.l.a;
    locala1.r = a(paramd);
    if (localc.g()) {
      i = locald.D.x;
    } else {
      i = locald.D.f;
    }
    locala1.s = i;
    locala1.t = locald.p;
    locala1.z = locald.q;
    locala1.u = a();
    com.tencent.luggage.wxa.qz.o.d("Luggage.FULL.AppBrandConfigAdapter", "runtime(%s).getNetworkConfig.userAgentString = [ %s ]", new Object[] { paramd.aa(), locala1.u });
    paramd = (com.tencent.luggage.wxa.lr.a)com.tencent.luggage.wxa.ba.e.a(com.tencent.luggage.wxa.lr.a.class);
    if (paramd != null) {
      locala1.v = paramd.a(locala.c);
    } else {
      com.tencent.luggage.wxa.qz.o.c("", "getNetworkConfig, referrerHelper is null");
    }
    locala1.w = e(locald);
    locala1.y = localc.d;
    locala1.A = d.a.b(locald.c());
    if ((locala1.A) || (!com.tencent.luggage.wxa.qz.af.a(locala1.r))) {
      j.b(locala1);
    }
    return locala1;
  }
  
  private static String a()
  {
    String str = k.a();
    return m.a(r.a(), str, (m.a)com.tencent.luggage.wxa.ba.e.a(m.a.class));
  }
  
  private static ArrayList<byte[]> a(com.tencent.luggage.wxa.iu.d paramd)
  {
    localArrayList = new ArrayList();
    Object localObject = new i();
    paramd.z().b("cer", (i)localObject);
    if (((i)localObject).a == null) {
      return localArrayList;
    }
    paramd = com.tencent.luggage.wxa.pc.c.a((ByteBuffer)((i)localObject).a);
    try
    {
      localObject = new fi();
      ((fi)localObject).a(paramd);
      if (((fi)localObject).a == null) {
        return localArrayList;
      }
      paramd = ((fi)localObject).a.iterator();
      while (paramd.hasNext()) {
        localArrayList.add(((b)paramd.next()).c());
      }
      return localArrayList;
    }
    catch (Exception paramd)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("readPkgCertificate, parse error: ");
      ((StringBuilder)localObject).append(paramd);
      com.tencent.luggage.wxa.qz.o.b("", ((StringBuilder)localObject).toString());
    }
  }
  
  public static com.tencent.luggage.wxa.ix.a b(com.tencent.luggage.wxa.ed.d paramd)
  {
    com.tencent.luggage.wxa.do.d locald = paramd.i();
    paramd = paramd.aj();
    com.tencent.luggage.wxa.ix.a locala = new com.tencent.luggage.wxa.ix.a();
    if (locald != null)
    {
      if (paramd == null) {
        return locala;
      }
      if (d.a.b(locald.c()))
      {
        locala.a = paramd.g().contains("audio");
        locala.b = paramd.g().contains("location");
        return locala;
      }
      locala.a = locald.M;
      locala.b = locald.N;
    }
    return locala;
  }
  
  public static p.a b(com.tencent.luggage.wxa.do.d paramd)
  {
    p.a locala = new p.a();
    locala.e = paramd.D.u;
    return locala;
  }
  
  public static com.tencent.luggage.wxa.om.a c(@NonNull com.tencent.luggage.wxa.do.d paramd)
  {
    com.tencent.luggage.wxa.om.a locala = new com.tencent.luggage.wxa.om.a();
    boolean bool1 = paramd.c;
    boolean bool2 = false;
    if ((bool1) && ((paramd.c() == 1) || (paramd.c() == 2) || (ag.a()))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    locala.a = bool1;
    bool1 = bool2;
    if (paramd.c() != 0) {
      bool1 = true;
    }
    locala.b = bool1;
    locala.c = paramd.b;
    return locala;
  }
  
  private static boolean d(com.tencent.luggage.wxa.do.d paramd)
  {
    int i = paramd.S.b;
    boolean bool2 = false;
    boolean bool1 = false;
    if ((i != 1) && (paramd.S.b != 2)) {
      i = 0;
    } else {
      i = 1;
    }
    if (paramd.f)
    {
      if ((i == 0) || (!paramd.e)) {
        bool1 = true;
      }
      return bool1;
    }
    if (i != 0)
    {
      bool1 = bool2;
      if (paramd.b) {}
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  private static String e(com.tencent.luggage.wxa.do.d paramd)
  {
    if ((paramd.D != null) && (paramd.D.l != null)) {
      localObject1 = paramd.D.l.h;
    } else {
      localObject1 = "";
    }
    Object localObject2 = localObject1;
    if (com.tencent.luggage.wxa.qz.af.c((String)localObject1)) {
      localObject2 = "servicewechat.com";
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("https://");
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("/");
    ((StringBuilder)localObject1).append(paramd.J);
    ((StringBuilder)localObject1).append("/");
    ((StringBuilder)localObject1).append(paramd.S.pkgVersion);
    ((StringBuilder)localObject1).append("/page-frame.html");
    return ((StringBuilder)localObject1).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.e
 * JD-Core Version:    0.7.0.1
 */