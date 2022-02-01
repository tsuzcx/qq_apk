package com.tencent.mm.plugin.appbrand.appstorage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.util.a;
import com.tencent.luggage.util.m;
import com.tencent.luggage.wxa.qz.af;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class t
  implements o
{
  private final LinkedList<o> a = new LinkedList();
  private final o b = new g();
  
  public t(LinkedList<o> paramLinkedList)
  {
    this.a.addAll(paramLinkedList);
  }
  
  @Nullable
  public com.tencent.luggage.wxa.rt.i a(String paramString, boolean paramBoolean)
  {
    return l(paramString).a(paramString, paramBoolean);
  }
  
  @NonNull
  public j a(com.tencent.luggage.wxa.pc.i<String> parami)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      j localj = ((o)localIterator.next()).a(parami);
      if (localj != j.q) {
        return localj;
      }
    }
    return j.q;
  }
  
  @NonNull
  public j a(com.tencent.luggage.wxa.rt.i parami, String paramString, com.tencent.luggage.wxa.pc.i<String> parami1)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      j localj = ((o)localIterator.next()).a(parami, paramString, parami1);
      if (localj != j.q) {
        return localj;
      }
    }
    return j.q;
  }
  
  @NonNull
  public j a(com.tencent.luggage.wxa.rt.i parami, String paramString, boolean paramBoolean, com.tencent.luggage.wxa.pc.i<String> parami1)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      j localj = ((o)localIterator.next()).a(parami, paramString, paramBoolean, parami1);
      if (localj != j.q) {
        return localj;
      }
    }
    return j.q;
  }
  
  @NonNull
  public j a(String paramString, long paramLong1, long paramLong2, com.tencent.luggage.wxa.pc.i<ByteBuffer> parami)
  {
    return l(paramString).a(paramString, paramLong1, paramLong2, parami);
  }
  
  @NonNull
  public j a(String paramString, com.tencent.luggage.wxa.pc.i<List<h>> parami)
  {
    return l(paramString).a(paramString, parami);
  }
  
  @NonNull
  public j a(String paramString, @NonNull com.tencent.luggage.wxa.rt.i parami)
  {
    return l(paramString).a(paramString, parami);
  }
  
  @NonNull
  public j a(String paramString, com.tencent.luggage.wxa.rt.i parami, boolean paramBoolean)
  {
    return l(paramString).a(paramString, parami, paramBoolean);
  }
  
  @NonNull
  public j a(String paramString, FileStructStat paramFileStructStat)
  {
    return l(paramString).a(paramString, paramFileStructStat);
  }
  
  @NonNull
  public j a(String paramString, InputStream paramInputStream, boolean paramBoolean)
  {
    return l(paramString).a(paramString, paramInputStream, paramBoolean);
  }
  
  @NonNull
  public j a(String paramString, List<v> paramList)
  {
    return l(paramString).a(paramString, paramList);
  }
  
  @Nullable
  public <T extends o> T a(Class<T> paramClass)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      if (paramClass.isInstance(localo)) {
        return localo;
      }
    }
    return null;
  }
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((o)localIterator.next()).a();
    }
    this.b.a();
  }
  
  public boolean a(String paramString)
  {
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "file://";
    arrayOfString[1] = "http://";
    arrayOfString[2] = "https://";
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (m.a(paramString, arrayOfString[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  @NonNull
  public j b(String paramString)
  {
    return l(paramString).b(paramString);
  }
  
  @NonNull
  public j b(String paramString, com.tencent.luggage.wxa.pc.i<ByteBuffer> parami)
  {
    return l(paramString).b(paramString, parami);
  }
  
  @NonNull
  public j b(String paramString, boolean paramBoolean)
  {
    return l(paramString).b(paramString, paramBoolean);
  }
  
  public void b()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((o)localIterator.next()).b();
    }
    this.a.clear();
    this.b.b();
  }
  
  @NonNull
  public j c(String paramString)
  {
    return l(paramString).c(paramString);
  }
  
  @NonNull
  public j c(String paramString, boolean paramBoolean)
  {
    return l(paramString).c(paramString, paramBoolean);
  }
  
  @Nullable
  public List<? extends o.a> c()
  {
    return ((l)a(l.class)).c();
  }
  
  @Nullable
  public com.tencent.luggage.wxa.rt.i d(String paramString)
  {
    return l(paramString).d(paramString);
  }
  
  public LinkedList<o> d()
  {
    return this.a;
  }
  
  public boolean e(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      if ((localo.a(paramString)) && (!localo.e(paramString))) {
        return false;
      }
    }
    return true;
  }
  
  @NonNull
  public j f(String paramString)
  {
    return l(paramString).f(paramString);
  }
  
  @Nullable
  public com.tencent.luggage.wxa.rt.i g(String paramString)
  {
    return a(paramString, false);
  }
  
  public boolean h(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      if ((localo.a(paramString)) && (localo.h(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  @Nullable
  public com.tencent.luggage.wxa.rt.i i(String paramString)
  {
    return ((l)a(l.class)).i(paramString);
  }
  
  public boolean j(String paramString)
  {
    return ((l)a(l.class)).j(paramString);
  }
  
  public InputStream k(String paramString)
  {
    com.tencent.luggage.wxa.pc.i locali = new com.tencent.luggage.wxa.pc.i();
    j localj = b(paramString, locali);
    if (localj == j.a) {
      return new a((ByteBuffer)locali.a);
    }
    com.tencent.luggage.wxa.qz.o.b("MicroMsg.LuggageFileSystemRegistry", "readStream error: %s %s", new Object[] { localj, paramString });
    return null;
  }
  
  @NonNull
  public final o l(String paramString)
  {
    if (af.c(paramString)) {
      return this.b;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      if (localo.a(paramString)) {
        return localo;
      }
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.t
 * JD-Core Version:    0.7.0.1
 */