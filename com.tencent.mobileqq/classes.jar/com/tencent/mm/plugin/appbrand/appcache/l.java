package com.tencent.mm.plugin.appbrand.appcache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

final class l
  implements h, Closeable
{
  final String a;
  final af b;
  private final Map<String, v> c = new HashMap();
  
  l(String paramString, af paramaf)
  {
    this.a = paramString;
    this.b = paramaf;
    this.b.a(paramString);
  }
  
  private static h.a a(l paraml, v paramv, v.a parama)
  {
    h.a locala = new h.a();
    locala.d = paraml.a;
    locala.e = paraml.b.pkgVersion();
    locala.f = paraml.b.checksumMd5();
    locala.g = paramv;
    locala.h = paramv.b();
    locala.i = parama.b;
    locala.j = parama.c;
    locala.k = parama.d;
    return locala;
  }
  
  private v f(@NonNull String paramString)
  {
    v localv;
    Object localObject1;
    int i;
    synchronized (this.c)
    {
      localv = (v)this.c.get(paramString);
      if (localv == null)
      {
        Object localObject2 = null;
        if ("__APP__".equals(paramString))
        {
          localObject1 = this.b.pkgPath;
        }
        else
        {
          Iterator localIterator = this.b.e.iterator();
          do
          {
            localObject1 = localObject2;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject1 = (ModulePkgInfo)localIterator.next();
          } while (!paramString.equals(((ModulePkgInfo)localObject1).name));
          localObject1 = ((ModulePkgInfo)localObject1).pkgPath;
        }
        if (!com.tencent.luggage.wxa.qz.af.c((String)localObject1))
        {
          localObject1 = new v((String)localObject1);
          this.c.put(paramString, localObject1);
          i = 1;
          if (localObject1 != null)
          {
            boolean bool = ((v)localObject1).e();
            if (i != 0) {
              o.d("Luggage.PkgListReader", "obtainPkgInstance newInstanceCreated, moduleName:%s, readInfo:%b", new Object[] { paramString, Boolean.valueOf(bool) });
            }
          }
          return localObject1;
        }
      }
    }
  }
  
  @Nullable
  public v a(String paramString)
  {
    boolean bool = com.tencent.luggage.wxa.qz.af.c(paramString);
    String str1 = null;
    if (bool) {
      return null;
    }
    String str2 = k.b(paramString);
    Object localObject;
    if (af.a != null)
    {
      localObject = af.a.a(this.b.e, str2, String.format(Locale.ENGLISH, "findAppropriateModuleInfo with appId[%s]", new Object[] { this.a }));
      paramString = str1;
      if (localObject != null)
      {
        if (com.tencent.luggage.wxa.qz.af.c(((ModulePkgInfo)localObject).pkgPath)) {
          o.d("Luggage.PkgListReader", "findAppropriateModuleInfo: [%s] not not download yet", new Object[] { str2 });
        }
        paramString = ((ModulePkgInfo)localObject).name;
      }
    }
    else
    {
      localObject = this.b.e.iterator();
      do
      {
        paramString = str1;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramString = (ModulePkgInfo)((Iterator)localObject).next();
      } while (!str2.startsWith(paramString.name));
      paramString = paramString.name;
    }
    str1 = paramString;
    if (com.tencent.luggage.wxa.qz.af.c(paramString))
    {
      str1 = "__APP__";
      o.c("Luggage.PkgListReader", "findAppropriateModuleInfo: [%s] not exist, fallback to [%s]", new Object[] { str2, "__APP__" });
    }
    return f(str1);
  }
  
  public void a()
  {
    this.b.a(this.a);
    synchronized (this.c)
    {
      f("__APP__");
      Iterator localIterator = this.b.e.iterator();
      while (localIterator.hasNext()) {
        f(((ModulePkgInfo)localIterator.next()).name);
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public InputStream b(String paramString)
  {
    v localv = a(paramString);
    if ((paramString.startsWith("/__plugin__/")) && (localv != null))
    {
      InputStream localInputStream = localv.c(paramString);
      if (localInputStream != null) {
        return localInputStream;
      }
      return localv.c(e(paramString));
    }
    if (localv == null) {
      return null;
    }
    return localv.c(paramString);
  }
  
  public List<ModulePkgInfo> b()
  {
    return new LinkedList(this.b.e);
  }
  
  public h.a c(String paramString)
  {
    v localv = a(paramString);
    if (localv == null) {
      paramString = null;
    } else {
      paramString = localv.b(paramString);
    }
    if (paramString != null) {
      return a(this, localv, paramString);
    }
    return null;
  }
  
  public List<String> c()
  {
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.c)
    {
      Iterator localIterator = this.c.values().iterator();
      while (localIterator.hasNext())
      {
        v localv = (v)localIterator.next();
        if (localv != null) {
          localLinkedList.addAll(localv.g());
        }
      }
      return localLinkedList;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void close()
  {
    synchronized (this.c)
    {
      Collection localCollection = this.c.values();
      this.c.clear();
      ??? = localCollection.iterator();
      while (((Iterator)???).hasNext()) {
        ((v)((Iterator)???).next()).close();
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public boolean d(String paramString)
  {
    return c(paramString) != null;
  }
  
  String e(String paramString)
  {
    String str1 = "/__plugin__/".substring(1, 11);
    String[] arrayOfString = paramString.split("/");
    int i = 0;
    int j;
    for (;;)
    {
      int k = arrayOfString.length;
      j = -1;
      if (i >= k) {
        break;
      }
      if (arrayOfString[i].equalsIgnoreCase(str1))
      {
        j = i + 1;
        if (j < arrayOfString.length)
        {
          String str2 = arrayOfString[j];
          if (!com.tencent.luggage.wxa.qz.af.c(str2))
          {
            j = paramString.indexOf(str2);
            i = str2.length();
            break label95;
          }
        }
      }
      i += 1;
    }
    i = -1;
    label95:
    return paramString.substring(j + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.l
 * JD-Core Version:    0.7.0.1
 */