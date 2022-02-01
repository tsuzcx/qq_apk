package com.tencent.mm.plugin.appbrand.appstorage;

import androidx.annotation.Keep;
import com.tencent.luggage.wxa.pd.v;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.e;
import com.tencent.luggage.wxa.qz.h;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rc.d;
import com.tencent.luggage.wxa.rr.a;
import com.tencent.luggage.wxa.rt.k;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.Checksum;
import org.apache.commons.io.FilenameUtils;

public final class LuggageLocalFileObjectManager
{
  private static final w e = new LuggageLocalFileObjectManager.3();
  private final String a;
  private final String b;
  private final String c;
  private final Collection<LuggageLocalFileObjectManager.a> d;
  
  LuggageLocalFileObjectManager(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(new com.tencent.luggage.wxa.rt.i(paramString1).l());
    localStringBuilder.append("/");
    this.a = localStringBuilder.toString();
    this.b = paramString2;
    this.c = paramString3;
    paramString1 = new LinkedList();
    paramString1.add(new LuggageLocalFileObjectManager.b(this, null));
    this.d = Collections.unmodifiableCollection(paramString1);
  }
  
  private <T extends w> T a(String paramString1, Class<T> paramClass, String paramString2, boolean paramBoolean)
  {
    if (!k.h(paramString1)) {
      return null;
    }
    String str = a(FilenameUtils.getExtension(paramString1), paramString2);
    Iterator localIterator = this.d.iterator();
    paramString2 = null;
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = ((LuggageLocalFileObjectManager.a)localIterator.next()).a(paramString1, str);
      paramString2 = (String)localObject;
      if (localObject != null) {
        paramString2 = (String)localObject;
      }
    }
    if ((paramString2 != null) && (paramString2.a() >= 2))
    {
      try
      {
        localObject = (w)paramClass.newInstance();
        ((w)localObject).a = ((String)paramString2.a(0));
        ((w)localObject).c = d.a(str);
        ((w)localObject).b = ((String)paramString2.a(1));
        if (af.c(((w)localObject).b))
        {
          o.b("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "attachCast appId %s, Null Or Nil fileFullPath");
          return null;
        }
        paramClass = str;
        if (af.c(str)) {
          paramClass = i();
        }
        ((w)localObject).d = af.a((String)paramString2.a(3), paramClass);
        if (a(paramBoolean, paramString1, ((w)localObject).b))
        {
          paramString1 = new com.tencent.luggage.wxa.rt.i(((w)localObject).b);
          ((w)localObject).f = paramString1.q();
          ((w)localObject).g = paramString1.p();
          return localObject;
        }
      }
      catch (Exception paramString1)
      {
        o.a("MicroMsg.AppBrand.LuggageLocalFileObjectManager", paramString1, "", new Object[0]);
      }
      return null;
    }
    int i;
    if (paramString2 == null) {
      i = -1;
    } else {
      i = paramString2.a();
    }
    o.b("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "attachCast, no handler return correct info, attach.size = %d", new Object[] { Integer.valueOf(i) });
    return null;
  }
  
  private String a(String paramString1, String paramString2)
  {
    if (af.c(paramString1)) {
      return paramString2;
    }
    return paramString1;
  }
  
  private boolean a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (i.a(paramString1, paramString2))) {
      return true;
    }
    return (!paramBoolean) && (h.a(paramString1, paramString2));
  }
  
  private String b(String paramString1, String paramString2)
  {
    return af.b(new v().b(paramString1.getBytes(), paramString2.getBytes()));
  }
  
  private String c(String paramString1, String paramString2)
  {
    byte[] arrayOfByte = af.d(paramString1);
    paramString2 = new v().a(arrayOfByte, paramString2.getBytes());
    if (af.c(paramString1)) {
      return null;
    }
    return new String(paramString2);
  }
  
  private long d(String paramString)
  {
    paramString = k.a(paramString);
    CheckedInputStream localCheckedInputStream = new CheckedInputStream(paramString, new Adler32());
    byte[] arrayOfByte = new byte[2048];
    while (localCheckedInputStream.read(arrayOfByte) >= 0) {}
    long l = localCheckedInputStream.getChecksum().getValue();
    af.a(localCheckedInputStream);
    af.a(paramString);
    return l;
  }
  
  private com.tencent.luggage.wxa.rt.i[] f()
  {
    com.tencent.luggage.wxa.rt.i locali = new com.tencent.luggage.wxa.rt.i(h());
    if ((locali.j()) && (locali.n())) {
      return locali.a(new LuggageLocalFileObjectManager.2(this));
    }
    return null;
  }
  
  private String g()
  {
    return this.a;
  }
  
  private String h()
  {
    e.a(g());
    try
    {
      new com.tencent.luggage.wxa.rt.i(this.a, ".nomedia").v();
      label26:
      return this.a;
    }
    catch (Exception localException)
    {
      break label26;
    }
  }
  
  private String i()
  {
    return "unknown";
  }
  
  public w a(w paramw)
  {
    Iterator localIterator = this.d.iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      w localw = ((LuggageLocalFileObjectManager.a)localIterator.next()).a(paramw);
      localObject = localw;
      if (localw != null) {
        localObject = localw;
      }
    }
    return localObject;
  }
  
  public w a(String paramString)
  {
    return a(paramString, null, false);
  }
  
  public w a(String paramString1, String paramString2, boolean paramBoolean)
  {
    return a(paramString1, w.class, paramString2, paramBoolean);
  }
  
  public List<w> a()
  {
    com.tencent.luggage.wxa.rt.i[] arrayOfi = b();
    if ((arrayOfi != null) && (arrayOfi.length > 0))
    {
      LinkedList localLinkedList = new LinkedList();
      int j = arrayOfi.length;
      int i = 0;
      while (i < j)
      {
        w localw = b(arrayOfi[i].d());
        if (localw != null) {
          localLinkedList.add(localw);
        }
        i += 1;
      }
      return localLinkedList;
    }
    return null;
  }
  
  w b(String paramString)
  {
    boolean bool = af.c(paramString);
    Object localObject = null;
    if (bool) {
      return null;
    }
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      w localw = ((LuggageLocalFileObjectManager.a)localIterator.next()).b(paramString);
      localObject = localw;
      if (localw != null) {
        localObject = localw;
      }
    }
    return localObject;
  }
  
  com.tencent.luggage.wxa.rt.i[] b()
  {
    com.tencent.luggage.wxa.rt.i locali = new com.tencent.luggage.wxa.rt.i(h());
    if ((locali.j()) && (locali.n())) {
      return locali.a(new LuggageLocalFileObjectManager.1(this));
    }
    return null;
  }
  
  @Deprecated
  public w c(String paramString)
  {
    if ((!af.c(paramString)) && (paramString.startsWith(this.c)))
    {
      String str = paramString.substring(this.c.length());
      Iterator localIterator = this.d.iterator();
      paramString = null;
      while (localIterator.hasNext())
      {
        LuggageLocalFileObjectManager.a locala = (LuggageLocalFileObjectManager.a)localIterator.next();
        paramString = locala.a(str);
        if (paramString != null)
        {
          o.d("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "getItemByLocalId, handled by %s, result = %s", new Object[] { locala.toString(), paramString });
          break;
        }
      }
      if (e == paramString) {
        return null;
      }
      return paramString;
    }
    o.b("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "getItemByLocalId, invalid args, localId(%s)", new Object[] { paramString });
    return null;
  }
  
  public List<w> c()
  {
    com.tencent.luggage.wxa.rt.i[] arrayOfi = f();
    if ((arrayOfi != null) && (arrayOfi.length > 0))
    {
      LinkedList localLinkedList = new LinkedList();
      int j = arrayOfi.length;
      int i = 0;
      while (i < j)
      {
        w localw = b(arrayOfi[i].d());
        if (localw != null) {
          localLinkedList.add(localw);
        }
        i += 1;
      }
      return localLinkedList;
    }
    return null;
  }
  
  public long d()
  {
    com.tencent.luggage.wxa.rt.i[] arrayOfi = b();
    long l1 = 0L;
    long l2 = l1;
    if (arrayOfi != null)
    {
      if (arrayOfi.length <= 0) {
        return 0L;
      }
      int j = arrayOfi.length;
      int i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= j) {
          break;
        }
        l1 += arrayOfi[i].q();
        i += 1;
      }
    }
    return l2;
  }
  
  @Keep
  public String genMediaFilePath(String paramString)
  {
    if (af.c(paramString)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(h());
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager
 * JD-Core Version:    0.7.0.1
 */