package com.tencent.luggage.wxa.an;

import android.os.ConditionVariable;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public final class l
  implements a
{
  private final File a;
  private final f b;
  private final HashMap<String, g> c;
  private final j d;
  private final HashMap<String, ArrayList<a.b>> e;
  private long f = 0L;
  private a.a g;
  
  public l(File paramFile, f paramf)
  {
    this(paramFile, paramf, null, false);
  }
  
  l(File paramFile, f paramf, j paramj)
  {
    this.a = paramFile;
    this.b = paramf;
    this.c = new HashMap();
    this.d = paramj;
    this.e = new HashMap();
    paramFile = new ConditionVariable();
    new l.1(this, "SimpleCache.initialize()", paramFile).start();
    paramFile.block();
  }
  
  public l(File paramFile, f paramf, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    this(paramFile, paramf, new j(paramFile, paramArrayOfByte, paramBoolean));
  }
  
  private void a(g paramg, boolean paramBoolean)
  {
    i locali = this.d.b(paramg.a);
    if (locali != null)
    {
      if (!locali.a(paramg)) {
        return;
      }
      this.f -= paramg.c;
      if (paramBoolean) {}
      try
      {
        if (locali.c())
        {
          this.d.d(locali.b);
          this.d.b();
        }
      }
      finally
      {
        c(paramg);
      }
    }
  }
  
  private void a(m paramm)
  {
    this.d.a(paramm.a).a(paramm);
    this.f += paramm.c;
    b(paramm);
  }
  
  private void a(m paramm, g paramg)
  {
    ArrayList localArrayList = (ArrayList)this.e.get(paramm.a);
    if (localArrayList != null)
    {
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        ((a.b)localArrayList.get(i)).a(this, paramm, paramg);
        i -= 1;
      }
    }
    this.b.a(this, paramm, paramg);
  }
  
  private void b()
  {
    if (!this.a.exists())
    {
      this.a.mkdirs();
      return;
    }
    this.d.a();
    File[] arrayOfFile = this.a.listFiles();
    if (arrayOfFile == null) {
      return;
    }
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      File localFile = arrayOfFile[i];
      if (!localFile.getName().equals("cached_content_index.exi"))
      {
        m localm;
        if (localFile.length() > 0L) {
          localm = m.a(localFile, this.d);
        } else {
          localm = null;
        }
        if (localm != null) {
          a(localm);
        } else {
          localFile.delete();
        }
      }
      i += 1;
    }
    this.d.d();
    this.d.b();
  }
  
  private void b(m paramm)
  {
    ArrayList localArrayList = (ArrayList)this.e.get(paramm.a);
    if (localArrayList != null)
    {
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        ((a.b)localArrayList.get(i)).a(this, paramm);
        i -= 1;
      }
    }
    this.b.a(this, paramm);
  }
  
  private void c()
  {
    Object localObject = new LinkedList();
    Iterator localIterator1 = this.d.c().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((i)localIterator1.next()).b().iterator();
      while (localIterator2.hasNext())
      {
        g localg = (g)localIterator2.next();
        if (!localg.e.exists()) {
          ((LinkedList)localObject).add(localg);
        }
      }
    }
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      a((g)((Iterator)localObject).next(), false);
    }
    this.d.d();
    this.d.b();
  }
  
  private void c(g paramg)
  {
    ArrayList localArrayList = (ArrayList)this.e.get(paramg.a);
    if (localArrayList != null)
    {
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        ((a.b)localArrayList.get(i)).b(this, paramg);
        i -= 1;
      }
    }
    this.b.b(this, paramg);
  }
  
  private m f(String paramString, long paramLong)
  {
    i locali = this.d.b(paramString);
    if (locali == null) {
      return m.b(paramString, paramLong);
    }
    for (;;)
    {
      paramString = locali.b(paramLong);
      if ((!paramString.d) || (paramString.e.exists())) {
        break;
      }
      c();
    }
    return paramString;
  }
  
  public long a()
  {
    try
    {
      long l = this.f;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long a(String paramString)
  {
    try
    {
      long l = this.d.e(paramString);
      return l;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public File a(String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      com.tencent.luggage.wxa.ao.a.b(this.c.containsKey(paramString));
      if (!this.a.exists())
      {
        c();
        this.a.mkdirs();
      }
      this.b.a(this, paramString, paramLong1, paramLong2);
      paramString = m.a(this.a, this.d.c(paramString), paramLong1, System.currentTimeMillis());
      return paramString;
    }
    finally {}
  }
  
  public void a(g paramg)
  {
    for (;;)
    {
      try
      {
        if (paramg == this.c.remove(paramg.a))
        {
          bool = true;
          com.tencent.luggage.wxa.ao.a.b(bool);
          notifyAll();
          return;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public void a(File paramFile)
  {
    for (;;)
    {
      try
      {
        m localm = m.a(paramFile, this.d);
        boolean bool2 = true;
        if (localm != null)
        {
          bool1 = true;
          com.tencent.luggage.wxa.ao.a.b(bool1);
          com.tencent.luggage.wxa.ao.a.b(this.c.containsKey(localm.a));
          bool1 = paramFile.exists();
          if (!bool1) {
            return;
          }
          if (paramFile.length() == 0L)
          {
            paramFile.delete();
            return;
          }
          paramFile = Long.valueOf(a(localm.a));
          if (paramFile.longValue() != -1L)
          {
            if (localm.b + localm.c > paramFile.longValue()) {
              break label154;
            }
            bool1 = bool2;
            com.tencent.luggage.wxa.ao.a.b(bool1);
          }
          a(localm);
          this.d.b();
          notifyAll();
          return;
        }
      }
      finally {}
      boolean bool1 = false;
      continue;
      label154:
      bool1 = false;
    }
  }
  
  public long b(String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      paramString = this.d.b(paramString);
      if (paramString != null) {
        paramLong1 = paramString.a(paramLong1, paramLong2);
      } else {
        paramLong1 = -paramLong2;
      }
      return paramLong1;
    }
    finally {}
  }
  
  public void b(g paramg)
  {
    try
    {
      a(paramg, true);
      return;
    }
    finally
    {
      paramg = finally;
      throw paramg;
    }
  }
  
  public void c(String paramString, long paramLong)
  {
    try
    {
      this.d.a(paramString, paramLong);
      this.d.b();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public m d(String paramString, long paramLong)
  {
    try
    {
      for (;;)
      {
        m localm = e(paramString, paramLong);
        if (localm != null) {
          return localm;
        }
        wait();
      }
      throw paramString;
    }
    finally {}
    for (;;) {}
  }
  
  public m e(String paramString, long paramLong)
  {
    try
    {
      if (this.g == null)
      {
        m localm = f(paramString, paramLong);
        if (localm.d)
        {
          paramString = this.d.b(paramString).b(localm);
          a(localm, paramString);
          return paramString;
        }
        if (!this.c.containsKey(paramString))
        {
          this.c.put(paramString, localm);
          return localm;
        }
        return null;
      }
      throw this.g;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.an.l
 * JD-Core Version:    0.7.0.1
 */