package com.tencent.mm.modelappbrand.image;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class AppBrandSimpleImageLoader$e
{
  private final s a;
  private final Map<String, List<AppBrandSimpleImageLoader.e.a>> b = new HashMap();
  private final Map<String, Boolean> c = new HashMap();
  
  private AppBrandSimpleImageLoader$e(s params)
  {
    this.a = params;
  }
  
  void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    this.a.a(paramRunnable);
  }
  
  void a(String paramString)
  {
    if (af.c(paramString)) {
      return;
    }
    paramString = (List)this.b.remove(paramString);
    if (af.a(paramString)) {
      return;
    }
    paramString = paramString.iterator();
    while (paramString.hasNext()) {
      ((AppBrandSimpleImageLoader.e.a)paramString.next()).a();
    }
  }
  
  void a(String paramString, AppBrandSimpleImageLoader.e.a parama)
  {
    if (!af.c(paramString))
    {
      if (parama == null) {
        return;
      }
      List localList = (List)this.b.get(paramString);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new LinkedList();
        this.b.put(paramString, localObject);
      }
      ((List)localObject).add(parama);
    }
  }
  
  void b(String paramString, AppBrandSimpleImageLoader.e.a parama)
  {
    if (!af.c(paramString))
    {
      if (parama == null) {
        return;
      }
      paramString = (List)this.b.get(paramString);
      if (paramString == null) {
        return;
      }
      paramString.remove(parama);
    }
  }
  
  boolean b(String paramString)
  {
    if (af.c(paramString)) {
      return false;
    }
    return this.c.containsKey(paramString);
  }
  
  void c(String paramString)
  {
    if (af.c(paramString)) {
      return;
    }
    this.c.put(paramString, Boolean.valueOf(true));
  }
  
  void d(String paramString)
  {
    if (af.c(paramString)) {
      return;
    }
    this.c.remove(paramString);
  }
  
  void e(String paramString)
  {
    if (af.c(paramString)) {
      return;
    }
    paramString = (List)this.b.remove(paramString);
    if (!af.a(paramString))
    {
      Iterator localIterator = paramString.iterator();
      while (localIterator.hasNext()) {
        ((AppBrandSimpleImageLoader.e.a)localIterator.next()).b();
      }
      paramString.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.e
 * JD-Core Version:    0.7.0.1
 */