package com.tencent.luggage.wxa.op;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.lp.b;
import com.tencent.luggage.wxa.lp.d;
import com.tencent.luggage.wxa.lp.h;
import com.tencent.luggage.wxa.lp.i.a;
import com.tencent.luggage.wxa.lp.j.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.m;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class a
{
  private final String a;
  @NonNull
  private final u b;
  private boolean c;
  @Nullable
  private j.a d;
  private final LinkedList<String> e;
  private final Map<String, a.a> f;
  
  a(@NonNull u paramu)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("MicroMsg.AppBrand.AppBrandPageScopedPipInfo#");
    ((StringBuilder)localObject).append(hashCode());
    this.a = ((StringBuilder)localObject).toString();
    this.d = null;
    this.e = new LinkedList();
    this.f = new ConcurrentHashMap();
    this.b = paramu;
    this.c = this.b.R();
    localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mIsCurPageForeground: ");
    localStringBuilder.append(this.c);
    o.d((String)localObject, localStringBuilder.toString());
    paramu.a(new a.1(this));
    paramu.a(new a.2(this));
  }
  
  void a()
  {
    o.d(this.a, "markCurPageForeground");
    this.c = true;
  }
  
  void a(@Nullable j.a parama)
  {
    this.d = parama;
  }
  
  void a(String paramString)
  {
    ??? = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addPipRelatedKey, key: ");
    localStringBuilder.append(paramString);
    o.d((String)???, localStringBuilder.toString());
    synchronized (this.e)
    {
      this.e.remove(paramString);
      this.e.addFirst(paramString);
      return;
    }
  }
  
  void a(String paramString, int paramInt, @NonNull b paramb, @NonNull h paramh, @NonNull i.a parama, @NonNull d paramd, @NonNull c paramc)
  {
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("processPipInfo, key: ");
    localStringBuilder.append(paramString);
    o.e((String)localObject, localStringBuilder.toString());
    localObject = (a.a)this.f.get(paramString);
    if (localObject == null)
    {
      localObject = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("processPipInfo, create PipVideoSession for key: ");
      localStringBuilder.append(paramString);
      o.d((String)localObject, localStringBuilder.toString());
      this.f.put(paramString, new a.a(paramInt, paramb, paramh, parama, paramd, paramc, this.d));
      return;
    }
    paramh = this.a;
    parama = new StringBuilder();
    parama.append("processPipInfo, pipVideoSession for key: ");
    parama.append(paramString);
    parama.append(" exists");
    o.d(paramh, parama.toString());
    a.a.a((a.a)localObject, paramb);
    ((a.a)localObject).h = paramc;
  }
  
  void b()
  {
    o.d(this.a, "markCurPageBackground");
    this.c = false;
  }
  
  void b(String paramString)
  {
    ??? = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("removePipRelatedKey, key: ");
    localStringBuilder.append(paramString);
    o.d((String)???, localStringBuilder.toString());
    synchronized (this.e)
    {
      this.e.remove(paramString);
      return;
    }
  }
  
  @Nullable
  a.a c(String paramString)
  {
    return (a.a)this.f.get(paramString);
  }
  
  void c()
  {
    o.d(this.a, "markCurPageDestroy");
    synchronized (this.e)
    {
      this.e.clear();
      this.f.clear();
      return;
    }
  }
  
  boolean d()
  {
    return this.c;
  }
  
  @Nullable
  m e()
  {
    return this.b.T();
  }
  
  @Nullable
  String f()
  {
    synchronized (this.e)
    {
      if (this.e.isEmpty()) {
        return null;
      }
      String str = (String)this.e.getFirst();
      return str;
    }
  }
  
  @Nullable
  a.a g()
  {
    String str = f();
    if (str == null) {
      return null;
    }
    return (a.a)this.f.get(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.op.a
 * JD-Core Version:    0.7.0.1
 */