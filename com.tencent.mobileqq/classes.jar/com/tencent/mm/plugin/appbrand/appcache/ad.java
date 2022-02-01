package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import android.webkit.WebResourceResponse;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jj.l;
import com.tencent.luggage.wxa.pc.c;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class ad
  implements i
{
  private static final Map<d, ad> a = new HashMap();
  @NonNull
  private final h b;
  private final String c;
  private final LinkedList<String> d;
  
  private ad(@NonNull d paramd)
  {
    this.c = paramd.aa();
    l locall = paramd.A();
    o.d("MicroMsg.WxaPkgRuntimeReader", "<init> appId[%s] sysConfig.class[%s], stacktrace=%s", new Object[] { this.c, locall.getClass().getName(), Log.getStackTraceString(new Throwable()) });
    this.d = new LinkedList();
    this.b = ak.a(paramd, this);
    this.b.a();
  }
  
  public static i a(d paramd, boolean paramBoolean)
  {
    if ((paramd != null) && (!paramd.au()))
    {
      if (paramd.A() == null)
      {
        o.b("MicroMsg.WxaPkgRuntimeReader", "obtainReader with runtime(%s) sysConfig(NULL), stack=%s", new Object[] { paramd.aa(), Log.getStackTraceString(new Throwable()) });
        return i.a.a;
      }
      synchronized (a)
      {
        ad localad = (ad)a.get(paramd);
        if ((localad == null) || (paramBoolean))
        {
          if (paramBoolean) {
            c(paramd);
          }
          localad = new ad(paramd);
          a.put(paramd, localad);
        }
        return localad;
      }
    }
    return i.a.a;
  }
  
  public static String a(d paramd, String paramString)
  {
    return af.b((String)b(paramd).a(paramString, String.class));
  }
  
  public static void a(d paramd)
  {
    b(paramd).a();
  }
  
  public static WebResourceResponse b(d paramd, String paramString)
  {
    return (WebResourceResponse)b(paramd).a(paramString, WebResourceResponse.class);
  }
  
  public static i b(d paramd)
  {
    return a(paramd, false);
  }
  
  public static InputStream c(d paramd, String paramString)
  {
    return (InputStream)b(paramd).a(paramString, InputStream.class);
  }
  
  public static boolean c(d paramd)
  {
    synchronized (a)
    {
      paramd = (ad)a.remove(paramd);
      if (paramd != null)
      {
        paramd.close();
        return true;
      }
      return false;
    }
  }
  
  public static boolean d(d paramd, String paramString)
  {
    return b(paramd).d(paramString);
  }
  
  public static String e(d paramd, String paramString)
  {
    if (g(paramString)) {
      return null;
    }
    paramd = b(paramd).c(paramString);
    if (paramd != null) {
      return m.a(paramd.g, paramd.i);
    }
    return null;
  }
  
  private static boolean g(String paramString)
  {
    if (af.c(paramString)) {
      return true;
    }
    if (URLUtil.isAboutUrl(paramString)) {
      return true;
    }
    if (c.c(paramString)) {
      return true;
    }
    return URLUtil.isFileUrl(paramString);
  }
  
  @Nullable
  public v a(String paramString)
  {
    try
    {
      paramString = e(paramString);
      return this.b.a(paramString);
    }
    catch (IllegalArgumentException paramString)
    {
      label17:
      break label17;
    }
    return null;
  }
  
  public <T> T a(String paramString, Class<T> paramClass)
  {
    String str1 = null;
    try
    {
      String str2 = e(paramString);
      long l = System.currentTimeMillis();
      InputStream localInputStream = b(str2);
      int i = -1;
      boolean bool = true;
      paramString = str1;
      int j = i;
      if (localInputStream != null)
      {
        try
        {
          j = localInputStream.available();
          i = j;
        }
        catch (IOException paramString)
        {
          o.b("MicroMsg.WxaPkgRuntimeReader", "openRead, appId = %s, reqURL = %s, access stream.available e = %s", new Object[] { this.c, str2, paramString });
        }
        paramString = ((ad.b)ad.b.a.a.get(paramClass)).b(str2, localInputStream);
        j = i;
      }
      str1 = this.c;
      if (paramString != null) {
        bool = false;
      }
      o.d("MicroMsg.WxaPkgRuntimeReader", "openRead, appId = %s, reqURL = %s, null(%B), type = %s, length = %d, cost = %dms", new Object[] { str1, str2, Boolean.valueOf(bool), paramClass.getName(), Integer.valueOf(j), Long.valueOf(System.currentTimeMillis() - l) });
      return paramString;
    }
    catch (IllegalArgumentException paramString) {}
    return null;
  }
  
  public void a()
  {
    this.b.a();
  }
  
  public final InputStream b(String paramString)
  {
    try
    {
      paramString = e(paramString);
      return this.b.b(paramString);
    }
    catch (IllegalArgumentException paramString)
    {
      label17:
      break label17;
    }
    return null;
  }
  
  public List<ModulePkgInfo> b()
  {
    return this.b.b();
  }
  
  @Nullable
  public h.a c(String paramString)
  {
    try
    {
      paramString = e(paramString);
      return this.b.c(paramString);
    }
    catch (IllegalArgumentException paramString)
    {
      label17:
      break label17;
    }
    return null;
  }
  
  public List<String> c()
  {
    return this.b.c();
  }
  
  public void close()
  {
    this.b.close();
  }
  
  public final h d()
  {
    return this.b;
  }
  
  public final boolean d(String paramString)
  {
    try
    {
      paramString = e(paramString);
      return this.b.d(paramString);
    }
    catch (IllegalArgumentException paramString)
    {
      label17:
      break label17;
    }
    return false;
  }
  
  public String e(String paramString)
  {
    Object localObject = this.d.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramString.startsWith((String)((Iterator)localObject).next())) {
        return paramString;
      }
    }
    if (!g(paramString))
    {
      localObject = k.b(paramString);
      paramString = (String)localObject;
      if (((String)localObject).startsWith("/__APP__")) {
        paramString = k.b(((String)localObject).substring(8));
      }
      return paramString;
    }
    paramString = new IllegalArgumentException("Invalid URL");
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.d.add(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ad
 * JD-Core Version:    0.7.0.1
 */