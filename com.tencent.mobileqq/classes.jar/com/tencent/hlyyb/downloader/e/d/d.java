package com.tencent.hlyyb.downloader.e.d;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class d
{
  List<a> a;
  List<a> b;
  a c;
  a d;
  boolean e = false;
  boolean f = false;
  private String g;
  private List<a> h;
  private List<a> i;
  private List<a> j;
  
  public d(c paramc, String paramString)
  {
    this.g = paramString;
  }
  
  private static void a(StringBuilder paramStringBuilder, List<a> paramList)
  {
    if (paramList != null)
    {
      if (paramList != null) {}
      try
      {
        if (paramList.size() > 0)
        {
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext())
          {
            a locala = (a)localIterator.next();
            if (locala != null)
            {
              paramStringBuilder.append(locala);
              paramStringBuilder.append(",");
            }
          }
        }
        return;
      }
      finally {}
    }
  }
  
  private List<a> b(int paramInt)
  {
    if (paramInt == b.c) {
      return this.h;
    }
    if (paramInt == b.e) {
      return this.i;
    }
    if (paramInt == b.f) {
      return this.a;
    }
    if (paramInt == b.j) {
      return this.b;
    }
    if (paramInt == b.h) {
      return this.j;
    }
    return null;
  }
  
  public final a a(int paramInt)
  {
    try
    {
      Object localObject1;
      if (paramInt == b.d)
      {
        localObject1 = this.c;
        return localObject1;
      }
      if (paramInt == b.i)
      {
        localObject1 = this.d;
        return localObject1;
      }
      if (a.b(paramInt))
      {
        localObject1 = b(paramInt);
        if (localObject1 != null)
        {
          localObject1 = (a)((List)localObject1).get(0);
          return localObject1;
        }
      }
      return null;
    }
    finally {}
  }
  
  public final a a(a parama)
  {
    if (parama == null) {
      return null;
    }
    try
    {
      List localList = b(parama.b);
      if (localList != null)
      {
        int m = 0;
        while (m < localList.size())
        {
          if (parama == localList.get(m))
          {
            int n = localList.size();
            if (m == n - 1) {
              return null;
            }
            parama = (a)localList.get(m + 1);
            return parama;
          }
          m += 1;
        }
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw parama;
    }
  }
  
  public final List<a> a()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.k.a);
      List localList = this.h;
      if ((localList != null) && (localList.size() > 0)) {
        localArrayList.addAll(localList);
      }
      localList = this.i;
      if ((localList != null) && (localList.size() > 0)) {
        localArrayList.addAll(localList);
      }
      localList = this.a;
      if ((localList != null) && (localList.size() > 0)) {
        localArrayList.addAll(localList);
      }
      localList = this.b;
      if ((localList != null) && (localList.size() > 0)) {
        localArrayList.addAll(localList);
      }
      if (this.c != null) {
        localArrayList.add(this.c);
      }
      localList = this.j;
      if ((localList != null) && (localList.size() > 0)) {
        localArrayList.addAll(localList);
      }
      if (this.d != null) {
        localArrayList.add(this.d);
      }
      if (this.k.b != null) {
        localArrayList.add(this.k.b);
      }
      return localArrayList;
    }
    finally {}
  }
  
  public final void a(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return;
      }
      if (this.c == null)
      {
        this.c = new a(paramString, b.d);
        this.c.c = c.e(this.k).getAndIncrement();
      }
      return;
    }
    finally {}
  }
  
  public final void a(String paramString, int paramInt)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return;
      }
      List localList;
      if (paramInt == b.c)
      {
        if (this.h == null) {
          this.h = new ArrayList();
        }
        localList = this.h;
      }
      else if (paramInt == b.e)
      {
        if (this.i == null) {
          this.i = new ArrayList();
        }
        localList = this.i;
      }
      else if (paramInt == b.f)
      {
        if (this.a == null) {
          this.a = new ArrayList();
        }
        localList = this.a;
      }
      else if (paramInt == b.j)
      {
        if (this.b == null) {
          this.b = new ArrayList();
        }
        localList = this.b;
      }
      else
      {
        if (paramInt != b.h) {
          break label261;
        }
        if (this.j == null) {
          this.j = new ArrayList();
        }
        localList = this.j;
      }
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        bool = paramString.equalsIgnoreCase(((a)localIterator.next()).a);
        if (bool) {
          return;
        }
      }
      paramString = new a(paramString, paramInt);
      paramString.c = c.e(this.k).getAndIncrement();
      localList.add(paramString);
      return;
      label261:
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public final void b(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return;
      }
      if (this.d == null)
      {
        this.d = new a(paramString, b.i);
        this.d.c = c.e(this.k).getAndIncrement();
      }
      return;
    }
    finally {}
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.tencent.hlyyb.common.b.b.b(this.g));
    localStringBuilder.append(",");
    a(localStringBuilder, this.h);
    a(localStringBuilder, this.i);
    a(localStringBuilder, this.a);
    a(localStringBuilder, this.b);
    a locala = this.c;
    if (locala != null)
    {
      localStringBuilder.append(locala);
      localStringBuilder.append(",");
    }
    a(localStringBuilder, this.j);
    locala = this.d;
    if (locala != null) {
      localStringBuilder.append(locala);
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.d.d
 * JD-Core Version:    0.7.0.1
 */