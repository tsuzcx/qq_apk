package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.wxa.pd.v;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.e;
import com.tencent.luggage.wxa.qz.o;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.Checksum;

public final class s
{
  private static final w i = new s.2();
  private final String a;
  private final String b;
  private final String c;
  private com.tencent.luggage.wxa.jx.c d;
  private com.tencent.mm.plugin.appbrand.jsruntime.k e;
  private f.a f;
  private final Collection<s.a> g;
  private final Map<String, com.tencent.luggage.wxa.rt.i> h = new ConcurrentHashMap();
  
  s(String paramString1, String paramString2, String paramString3, f.a parama)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(new com.tencent.luggage.wxa.rt.i(paramString1).l());
    localStringBuilder.append("/");
    this.a = localStringBuilder.toString();
    this.b = paramString2;
    this.c = paramString3;
    this.f = parama;
    paramString1 = new LinkedList();
    paramString1.add(new s.b(this, null));
    this.g = Collections.unmodifiableCollection(paramString1);
  }
  
  private String a(String paramString1, String paramString2)
  {
    return af.b(new v().b(paramString1.getBytes(), paramString2.getBytes()));
  }
  
  private String b()
  {
    return this.a;
  }
  
  private String c()
  {
    e.a(b());
    try
    {
      new com.tencent.luggage.wxa.rt.i(this.a, ".nomedia").v();
      label25:
      return this.a;
    }
    catch (Exception localException)
    {
      break label25;
    }
  }
  
  private long d(String paramString)
  {
    paramString = c(paramString);
    if (paramString == null) {
      return -1L;
    }
    paramString = new CheckedInputStream(new com.tencent.luggage.util.a(paramString), new Adler32());
    byte[] arrayOfByte = new byte[2048];
    while (paramString.read(arrayOfByte) >= 0) {}
    long l = paramString.getChecksum().getValue();
    af.a(paramString);
    return l;
  }
  
  private String d()
  {
    return "unknown";
  }
  
  public com.tencent.luggage.wxa.rt.i a(String paramString)
  {
    if (af.c(paramString)) {
      return null;
    }
    ByteBuffer localByteBuffer = c(paramString);
    boolean bool = b(paramString);
    if ((localByteBuffer == null) && (bool))
    {
      paramString = (com.tencent.luggage.wxa.rt.i)this.h.remove(paramString);
      if ((paramString != null) && (paramString.j())) {
        paramString.w();
      }
      return null;
    }
    Object localObject = (com.tencent.luggage.wxa.rt.i)this.h.get(paramString);
    if ((bool) && (localObject != null) && (((com.tencent.luggage.wxa.rt.i)localObject).j())) {
      return localObject;
    }
    String str = d();
    Iterator localIterator = this.g.iterator();
    localObject = null;
    while (localIterator.hasNext())
    {
      com.tencent.luggage.wxa.rr.a locala = ((s.a)localIterator.next()).a(paramString, str);
      localObject = locala;
      if (locala != null) {
        localObject = locala;
      }
    }
    if ((localObject != null) && (((com.tencent.luggage.wxa.rr.a)localObject).a() >= 2)) {
      try
      {
        localObject = (String)((com.tencent.luggage.wxa.rr.a)localObject).a(1);
        if (af.c((String)localObject))
        {
          o.b("MicroMsg.AppBrand.LuggageBlobFileObjectManager", "createTempLocalFile appId %s, Null Or Nil fileFullPath");
          return null;
        }
        if (localByteBuffer != null)
        {
          o.d("MicroMsg.AppBrand.LuggageBlobFileObjectManager", "get buffer success");
          com.tencent.luggage.wxa.rt.k.b((String)localObject, com.tencent.luggage.wxa.pc.c.a(localByteBuffer));
          localObject = new com.tencent.luggage.wxa.rt.i((String)localObject);
          this.h.put(paramString, localObject);
          return localObject;
        }
        o.b("MicroMsg.AppBrand.LuggageBlobFileObjectManager", "get buffer fail");
        return null;
      }
      catch (Exception paramString)
      {
        o.a("MicroMsg.AppBrand.LuggageBlobFileObjectManager", paramString, "", new Object[0]);
        return null;
      }
    }
    int j;
    if (localObject == null) {
      j = -1;
    } else {
      j = ((com.tencent.luggage.wxa.rr.a)localObject).a();
    }
    o.b("MicroMsg.AppBrand.LuggageBlobFileObjectManager", "createTempLocalFile, no handler return correct info, attach.size = %d", new Object[] { Integer.valueOf(j) });
    return null;
  }
  
  public void a()
  {
    this.h.clear();
    com.tencent.luggage.wxa.rt.k.j(b());
  }
  
  public boolean b(String paramString)
  {
    return this.h.containsKey(paramString);
  }
  
  public ByteBuffer c(String paramString)
  {
    if (this.e == null)
    {
      if (this.d == null)
      {
        localObject = this.f;
        if (localObject != null) {
          this.d = ((f.a)localObject).a();
        }
        if (this.d == null)
        {
          o.b("MicroMsg.AppBrand.LuggageBlobFileObjectManager", "service is null");
          return null;
        }
      }
      this.e = ((com.tencent.mm.plugin.appbrand.jsruntime.k)this.d.getJsRuntime().a(com.tencent.mm.plugin.appbrand.jsruntime.k.class));
    }
    Object localObject = this.e;
    if ((localObject != null) && (((com.tencent.mm.plugin.appbrand.jsruntime.k)localObject).q() != null)) {
      return this.e.q().a(paramString);
    }
    boolean bool = true;
    if (this.e != null) {
      bool = false;
    }
    o.b("MicroMsg.AppBrand.LuggageBlobFileObjectManager", "getBuffer failed, mBufferAddon == null?: [%b]", new Object[] { Boolean.valueOf(bool) });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.s
 * JD-Core Version:    0.7.0.1
 */