package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import java.io.File;
import java.util.List;

class DataCacheGenerator
  implements DataFetcher.DataCallback<Object>, DataFetcherGenerator
{
  private final List<Key> a;
  private final DecodeHelper<?> b;
  private final DataFetcherGenerator.FetcherReadyCallback c;
  private int d = -1;
  private Key e;
  private List<ModelLoader<File, ?>> f;
  private int g;
  private volatile ModelLoader.LoadData<?> h;
  private File i;
  
  DataCacheGenerator(DecodeHelper<?> paramDecodeHelper, DataFetcherGenerator.FetcherReadyCallback paramFetcherReadyCallback)
  {
    this(paramDecodeHelper.n(), paramDecodeHelper, paramFetcherReadyCallback);
  }
  
  DataCacheGenerator(List<Key> paramList, DecodeHelper<?> paramDecodeHelper, DataFetcherGenerator.FetcherReadyCallback paramFetcherReadyCallback)
  {
    this.a = paramList;
    this.b = paramDecodeHelper;
    this.c = paramFetcherReadyCallback;
  }
  
  private boolean c()
  {
    return this.g < this.f.size();
  }
  
  public void a(@NonNull Exception paramException)
  {
    this.c.a(this.e, paramException, this.h.c, DataSource.DATA_DISK_CACHE);
  }
  
  public void a(Object paramObject)
  {
    this.c.a(this.e, paramObject, this.h.c, DataSource.DATA_DISK_CACHE, this.e);
  }
  
  public boolean a()
  {
    for (;;)
    {
      Object localObject1 = this.f;
      boolean bool = false;
      if ((localObject1 != null) && (c()))
      {
        this.h = null;
        while ((!bool) && (c()))
        {
          localObject1 = this.f;
          int j = this.g;
          this.g = (j + 1);
          this.h = ((ModelLoader)((List)localObject1).get(j)).a(this.i, this.b.g(), this.b.h(), this.b.e());
          if ((this.h != null) && (this.b.a(this.h.c.a())))
          {
            this.h.c.a(this.b.d(), this);
            bool = true;
          }
        }
        return bool;
      }
      this.d += 1;
      if (this.d >= this.a.size()) {
        return false;
      }
      localObject1 = (Key)this.a.get(this.d);
      Object localObject2 = new DataCacheKey((Key)localObject1, this.b.f());
      this.i = this.b.b().a((Key)localObject2);
      localObject2 = this.i;
      if (localObject2 != null)
      {
        this.e = ((Key)localObject1);
        this.f = this.b.a((File)localObject2);
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
 * Qualified Name:     com.bumptech.glide.load.engine.DataCacheGenerator
 * JD-Core Version:    0.7.0.1
 */