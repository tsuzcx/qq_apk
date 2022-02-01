package com.bumptech.glide.load.engine;

import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.load.resource.UnitTransformation;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class DecodeHelper<Transcode>
{
  private final List<ModelLoader.LoadData<?>> a = new ArrayList();
  private final List<Key> b = new ArrayList();
  private GlideContext c;
  private Object d;
  private int e;
  private int f;
  private Class<?> g;
  private DecodeJob.DiskCacheProvider h;
  private Options i;
  private Map<Class<?>, Transformation<?>> j;
  private Class<Transcode> k;
  private boolean l;
  private boolean m;
  private Key n;
  private Priority o;
  private DiskCacheStrategy p;
  private boolean q;
  private boolean r;
  
  <X> Encoder<X> a(X paramX)
  {
    return this.c.c().a(paramX);
  }
  
  List<ModelLoader<File, ?>> a(File paramFile)
  {
    return this.c.c().c(paramFile);
  }
  
  void a()
  {
    this.c = null;
    this.d = null;
    this.n = null;
    this.g = null;
    this.k = null;
    this.i = null;
    this.o = null;
    this.j = null;
    this.p = null;
    this.a.clear();
    this.l = false;
    this.b.clear();
    this.m = false;
  }
  
  <R> void a(GlideContext paramGlideContext, Object paramObject, Key paramKey, int paramInt1, int paramInt2, DiskCacheStrategy paramDiskCacheStrategy, Class<?> paramClass, Class<R> paramClass1, Priority paramPriority, Options paramOptions, Map<Class<?>, Transformation<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, DecodeJob.DiskCacheProvider paramDiskCacheProvider)
  {
    this.c = paramGlideContext;
    this.d = paramObject;
    this.n = paramKey;
    this.e = paramInt1;
    this.f = paramInt2;
    this.p = paramDiskCacheStrategy;
    this.g = paramClass;
    this.h = paramDiskCacheProvider;
    this.k = paramClass1;
    this.o = paramPriority;
    this.i = paramOptions;
    this.j = paramMap;
    this.q = paramBoolean1;
    this.r = paramBoolean2;
  }
  
  boolean a(Key paramKey)
  {
    List localList = m();
    int i2 = localList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (((ModelLoader.LoadData)localList.get(i1)).a.equals(paramKey)) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  boolean a(Resource<?> paramResource)
  {
    return this.c.c().a(paramResource);
  }
  
  boolean a(Class<?> paramClass)
  {
    return b(paramClass) != null;
  }
  
  <Z> ResourceEncoder<Z> b(Resource<Z> paramResource)
  {
    return this.c.c().b(paramResource);
  }
  
  <Data> LoadPath<Data, ?, Transcode> b(Class<Data> paramClass)
  {
    return this.c.c().a(paramClass, this.g, this.k);
  }
  
  DiskCache b()
  {
    return this.h.a();
  }
  
  <Z> Transformation<Z> c(Class<Z> paramClass)
  {
    Transformation localTransformation = (Transformation)this.j.get(paramClass);
    Object localObject = localTransformation;
    if (localTransformation == null)
    {
      Iterator localIterator = this.j.entrySet().iterator();
      do
      {
        localObject = localTransformation;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
      } while (!((Class)((Map.Entry)localObject).getKey()).isAssignableFrom(paramClass));
      localObject = (Transformation)((Map.Entry)localObject).getValue();
    }
    if (localObject == null)
    {
      if ((this.j.isEmpty()) && (this.q))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Missing transformation for ");
        ((StringBuilder)localObject).append(paramClass);
        ((StringBuilder)localObject).append(". If you wish to ignore unknown resource types, use the optional transformation methods.");
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
      return UnitTransformation.a();
    }
    return localObject;
  }
  
  DiskCacheStrategy c()
  {
    return this.p;
  }
  
  Priority d()
  {
    return this.o;
  }
  
  Options e()
  {
    return this.i;
  }
  
  Key f()
  {
    return this.n;
  }
  
  int g()
  {
    return this.e;
  }
  
  int h()
  {
    return this.f;
  }
  
  ArrayPool i()
  {
    return this.c.e();
  }
  
  Class<?> j()
  {
    return this.k;
  }
  
  List<Class<?>> k()
  {
    return this.c.c().b(this.d.getClass(), this.g, this.k);
  }
  
  boolean l()
  {
    return this.r;
  }
  
  List<ModelLoader.LoadData<?>> m()
  {
    if (!this.l)
    {
      this.l = true;
      this.a.clear();
      List localList = this.c.c().c(this.d);
      int i1 = 0;
      int i2 = localList.size();
      while (i1 < i2)
      {
        ModelLoader.LoadData localLoadData = ((ModelLoader)localList.get(i1)).a(this.d, this.e, this.f, this.i);
        if (localLoadData != null) {
          this.a.add(localLoadData);
        }
        i1 += 1;
      }
    }
    return this.a;
  }
  
  List<Key> n()
  {
    if (!this.m)
    {
      this.m = true;
      this.b.clear();
      List localList = m();
      int i3 = localList.size();
      int i1 = 0;
      while (i1 < i3)
      {
        ModelLoader.LoadData localLoadData = (ModelLoader.LoadData)localList.get(i1);
        if (!this.b.contains(localLoadData.a)) {
          this.b.add(localLoadData.a);
        }
        int i2 = 0;
        while (i2 < localLoadData.b.size())
        {
          if (!this.b.contains(localLoadData.b.get(i2))) {
            this.b.add(localLoadData.b.get(i2));
          }
          i2 += 1;
        }
        i1 += 1;
      }
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.DecodeHelper
 * JD-Core Version:    0.7.0.1
 */