package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCache.Writer;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.util.LogTime;
import java.util.Collections;
import java.util.List;

class SourceGenerator
  implements DataFetcher.DataCallback<Object>, DataFetcherGenerator, DataFetcherGenerator.FetcherReadyCallback
{
  private final DecodeHelper<?> a;
  private final DataFetcherGenerator.FetcherReadyCallback b;
  private int c;
  private DataCacheGenerator d;
  private Object e;
  private volatile ModelLoader.LoadData<?> f;
  private DataCacheKey g;
  
  SourceGenerator(DecodeHelper<?> paramDecodeHelper, DataFetcherGenerator.FetcherReadyCallback paramFetcherReadyCallback)
  {
    this.a = paramDecodeHelper;
    this.b = paramFetcherReadyCallback;
  }
  
  private void b(Object paramObject)
  {
    long l = LogTime.a();
    try
    {
      Encoder localEncoder = this.a.a(paramObject);
      Object localObject = new DataCacheWriter(localEncoder, paramObject, this.a.e());
      this.g = new DataCacheKey(this.f.a, this.a.f());
      this.a.b().a(this.g, (DiskCache.Writer)localObject);
      if (Log.isLoggable("SourceGenerator", 2))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Finished encoding source to cache, key: ");
        ((StringBuilder)localObject).append(this.g);
        ((StringBuilder)localObject).append(", data: ");
        ((StringBuilder)localObject).append(paramObject);
        ((StringBuilder)localObject).append(", encoder: ");
        ((StringBuilder)localObject).append(localEncoder);
        ((StringBuilder)localObject).append(", duration: ");
        ((StringBuilder)localObject).append(LogTime.a(l));
        Log.v("SourceGenerator", ((StringBuilder)localObject).toString());
      }
      this.f.c.b();
      this.d = new DataCacheGenerator(Collections.singletonList(this.f.a), this.a, this);
      return;
    }
    finally
    {
      this.f.c.b();
    }
  }
  
  private boolean d()
  {
    return this.c < this.a.m().size();
  }
  
  public void a(Key paramKey, Exception paramException, DataFetcher<?> paramDataFetcher, DataSource paramDataSource)
  {
    this.b.a(paramKey, paramException, paramDataFetcher, this.f.c.d());
  }
  
  public void a(Key paramKey1, Object paramObject, DataFetcher<?> paramDataFetcher, DataSource paramDataSource, Key paramKey2)
  {
    this.b.a(paramKey1, paramObject, paramDataFetcher, this.f.c.d(), paramKey1);
  }
  
  public void a(@NonNull Exception paramException)
  {
    this.b.a(this.g, paramException, this.f.c, this.f.c.d());
  }
  
  public void a(Object paramObject)
  {
    DiskCacheStrategy localDiskCacheStrategy = this.a.c();
    if ((paramObject != null) && (localDiskCacheStrategy.a(this.f.c.d())))
    {
      this.e = paramObject;
      this.b.c();
      return;
    }
    this.b.a(this.f.a, paramObject, this.f.c, this.f.c.d(), this.g);
  }
  
  public boolean a()
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      this.e = null;
      b(localObject);
    }
    localObject = this.d;
    if ((localObject != null) && (((DataCacheGenerator)localObject).a())) {
      return true;
    }
    this.d = null;
    this.f = null;
    for (boolean bool = false; (!bool) && (d()); bool = true)
    {
      label49:
      localObject = this.a.m();
      int i = this.c;
      this.c = (i + 1);
      this.f = ((ModelLoader.LoadData)((List)localObject).get(i));
      if ((this.f == null) || ((!this.a.c().a(this.f.c.d())) && (!this.a.a(this.f.c.a())))) {
        break label49;
      }
      this.f.c.a(this.a.d(), this);
    }
    return bool;
  }
  
  public void b()
  {
    ModelLoader.LoadData localLoadData = this.f;
    if (localLoadData != null) {
      localLoadData.c.c();
    }
  }
  
  public void c()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.SourceGenerator
 * JD-Core Version:    0.7.0.1
 */