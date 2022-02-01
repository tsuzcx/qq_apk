package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import java.io.File;
import java.util.List;

class ResourceCacheGenerator
  implements DataFetcher.DataCallback<Object>, DataFetcherGenerator
{
  private final DataFetcherGenerator.FetcherReadyCallback a;
  private final DecodeHelper<?> b;
  private int c;
  private int d = -1;
  private Key e;
  private List<ModelLoader<File, ?>> f;
  private int g;
  private volatile ModelLoader.LoadData<?> h;
  private File i;
  private ResourceCacheKey j;
  
  ResourceCacheGenerator(DecodeHelper<?> paramDecodeHelper, DataFetcherGenerator.FetcherReadyCallback paramFetcherReadyCallback)
  {
    this.b = paramDecodeHelper;
    this.a = paramFetcherReadyCallback;
  }
  
  private boolean c()
  {
    return this.g < this.f.size();
  }
  
  public void a(@NonNull Exception paramException)
  {
    this.a.a(this.j, paramException, this.h.c, DataSource.RESOURCE_DISK_CACHE);
  }
  
  public void a(Object paramObject)
  {
    this.a.a(this.e, paramObject, this.h.c, DataSource.RESOURCE_DISK_CACHE, this.j);
  }
  
  public boolean a()
  {
    List localList1 = this.b.n();
    boolean bool2 = localList1.isEmpty();
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    List localList2 = this.b.k();
    if ((localList2.isEmpty()) && (File.class.equals(this.b.j()))) {
      return false;
    }
    for (;;)
    {
      if ((this.f != null) && (c()))
      {
        this.h = null;
        while ((!bool1) && (c()))
        {
          localList1 = this.f;
          int k = this.g;
          this.g = (k + 1);
          this.h = ((ModelLoader)localList1.get(k)).a(this.i, this.b.g(), this.b.h(), this.b.e());
          if ((this.h != null) && (this.b.a(this.h.c.a())))
          {
            this.h.c.a(this.b.d(), this);
            bool1 = true;
          }
        }
        return bool1;
      }
      this.d += 1;
      if (this.d >= localList2.size())
      {
        this.c += 1;
        if (this.c >= localList1.size()) {
          return false;
        }
        this.d = 0;
      }
      Key localKey = (Key)localList1.get(this.c);
      Object localObject = (Class)localList2.get(this.d);
      Transformation localTransformation = this.b.c((Class)localObject);
      this.j = new ResourceCacheKey(this.b.i(), localKey, this.b.f(), this.b.g(), this.b.h(), localTransformation, (Class)localObject, this.b.e());
      this.i = this.b.b().a(this.j);
      localObject = this.i;
      if (localObject != null)
      {
        this.e = localKey;
        this.f = this.b.a((File)localObject);
        this.g = 0;
      }
    }
  }
  
  public void b()
  {
    ModelLoader.LoadData localLoadData = this.h;
    if (localLoadData != null) {
      localLoadData.c.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.ResourceCacheGenerator
 * JD-Core Version:    0.7.0.1
 */