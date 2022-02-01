package com.tencent.luggage.wxa.ku;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.util.b;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.aj;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class ao
  extends t
{
  static
  {
    com.tencent.luggage.wxa.hg.f.a("appbrandcommon", ao.class.getClassLoader());
  }
  
  public ao(com.tencent.luggage.wxa.ed.d paramd, a parama)
  {
    super(new LinkedList());
    Object localObject1;
    if (aj.a(paramd) != null) {
      localObject1 = new com.tencent.mm.plugin.appbrand.appcache.w(ad.b(paramd));
    } else {
      localObject1 = com.tencent.mm.plugin.appbrand.appcache.x.a(paramd);
    }
    d().clear();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(e());
    ((StringBuilder)localObject2).append(paramd.aa());
    ((StringBuilder)localObject2).append("/blobTmp/");
    localObject2 = new com.tencent.mm.plugin.appbrand.appstorage.f(((StringBuilder)localObject2).toString(), paramd.aa(), "wxblob://", new ao.1(this, paramd));
    ((com.tencent.mm.plugin.appbrand.appstorage.f)localObject2).a(parama.a * 1048576L);
    d().add(localObject2);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(e());
    ((StringBuilder)localObject2).append(paramd.aa());
    ((StringBuilder)localObject2).append("/");
    localObject2 = new l(((StringBuilder)localObject2).toString(), paramd.aa(), "wxfile://");
    ((l)localObject2).a(parama.a * 1048576L);
    com.tencent.mm.plugin.appbrand.appstorage.x localx1 = a(paramd.j().a(), paramd.aa());
    localx1.a(parama.a * 1048576L);
    com.tencent.mm.plugin.appbrand.appstorage.x localx2 = b(paramd.j().a(), paramd.aa());
    localx2.a(parama.b * 1048576L);
    d().add(localx2);
    localx2 = c(paramd.j().a(), paramd.aa());
    localx2.a(9223372036854775807L);
    d().add(localx2);
    paramd = d(paramd.j().a(), paramd.aa());
    paramd.a(parama.a * 1048576L);
    d().add(paramd);
    d().add(localx1);
    d().add(localObject2);
    d().add(localObject1);
    a();
  }
  
  public static com.tencent.mm.plugin.appbrand.appstorage.x a(String paramString1, String paramString2)
  {
    return new com.tencent.mm.plugin.appbrand.appstorage.x(a(new String[] { paramString1, paramString2 }), "wxfile://usr");
  }
  
  public static String a(String... paramVarArgs)
  {
    Object localObject = new StringBuilder(";");
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject).append(af.b(paramVarArgs[i]));
      ((StringBuilder)localObject).append(';');
      i += 1;
    }
    paramVarArgs = com.tencent.luggage.wxa.gl.c.a(((StringBuilder)localObject).toString().getBytes());
    localObject = f();
    if (localObject == null)
    {
      o.b("MicroMsg.AppBrand.LuggageFileSystemRegistryWC", "getIndependentRootPath, extRoot NULL");
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((com.tencent.luggage.wxa.rt.i)localObject).b());
    localStringBuilder.append("/");
    localStringBuilder.append(paramVarArgs);
    return new com.tencent.luggage.wxa.rt.i(localStringBuilder.toString()).b();
  }
  
  public static com.tencent.mm.plugin.appbrand.appstorage.x b(String paramString1, String paramString2)
  {
    return new com.tencent.mm.plugin.appbrand.appstorage.x(a(new String[] { paramString1, paramString2, "opendata" }), "wxfile://opendata");
  }
  
  public static com.tencent.mm.plugin.appbrand.appstorage.x c(String paramString1, String paramString2)
  {
    return new com.tencent.mm.plugin.appbrand.appstorage.x(a(new String[] { paramString1, paramString2, "clientdata" }), "wxfile://clientdata");
  }
  
  public static com.tencent.mm.plugin.appbrand.appstorage.x d(String paramString1, String paramString2)
  {
    return new com.tencent.mm.plugin.appbrand.appstorage.x(a(new String[] { paramString1, paramString2, "singlePage" }), "wxfile://singlepage");
  }
  
  public static String e()
  {
    return AppBrandLocalMediaObjectManager.a();
  }
  
  private static com.tencent.luggage.wxa.rt.i f()
  {
    if (!com.tencent.luggage.wxa.hg.d.a()) {
      return null;
    }
    Object localObject2 = com.tencent.luggage.wxa.pc.c.a();
    Object localObject1 = localObject2;
    if (!((String)localObject2).endsWith("/"))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("/");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("wxanewfiles/");
    return new com.tencent.luggage.wxa.rt.i(((StringBuilder)localObject2).toString());
  }
  
  @NonNull
  public j a(com.tencent.luggage.wxa.rt.i parami, String paramString, boolean paramBoolean, com.tencent.luggage.wxa.pc.i<String> parami1)
  {
    return ((l)a(l.class)).a(parami, paramString, paramBoolean, parami1);
  }
  
  @NonNull
  public j a(String paramString, com.tencent.luggage.wxa.pc.i<List<h>> parami)
  {
    Object localObject = Uri.parse(paramString);
    if (("wxfile".equals(((Uri)localObject).getScheme())) && (af.c(((Uri)localObject).getAuthority())))
    {
      paramString = new LinkedList();
      ((l)a(l.class)).a("", parami);
      if (!af.a((List)parami.a))
      {
        localObject = ((List)parami.a).iterator();
        while (((Iterator)localObject).hasNext())
        {
          h localh = (h)((Iterator)localObject).next();
          localh.a = localh.a.replaceFirst(Pattern.quote("wxfile://"), "");
        }
      }
      b.a(paramString, (List)parami.a);
      ((com.tencent.mm.plugin.appbrand.appstorage.x)l("wxfile://usr")).a("wxfile://usr", parami);
      b.a(paramString, (List)parami.a);
      parami.a = paramString;
      return j.a;
    }
    return super.a(paramString, parami);
  }
  
  @Nullable
  public List<com.tencent.mm.plugin.appbrand.appstorage.w> c()
  {
    return ((l)a(l.class)).c();
  }
  
  @Nullable
  public com.tencent.luggage.wxa.rt.i i(String paramString)
  {
    return ((l)a(l.class)).i(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.ao
 * JD-Core Version:    0.7.0.1
 */