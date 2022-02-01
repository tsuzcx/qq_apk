package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.Pools.Pool;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MultiModelLoader$MultiFetcher<Data>
  implements DataFetcher<Data>, DataFetcher.DataCallback<Data>
{
  private final List<DataFetcher<Data>> a;
  private final Pools.Pool<List<Throwable>> b;
  private int c;
  private Priority d;
  private DataFetcher.DataCallback<? super Data> e;
  @Nullable
  private List<Throwable> f;
  
  MultiModelLoader$MultiFetcher(@NonNull List<DataFetcher<Data>> paramList, @NonNull Pools.Pool<List<Throwable>> paramPool)
  {
    this.b = paramPool;
    Preconditions.a(paramList);
    this.a = paramList;
    this.c = 0;
  }
  
  private void e()
  {
    if (this.c < this.a.size() - 1)
    {
      this.c += 1;
      a(this.d, this.e);
      return;
    }
    Preconditions.a(this.f);
    this.e.a(new GlideException("Fetch failed", new ArrayList(this.f)));
  }
  
  @NonNull
  public Class<Data> a()
  {
    return ((DataFetcher)this.a.get(0)).a();
  }
  
  public void a(@NonNull Priority paramPriority, @NonNull DataFetcher.DataCallback<? super Data> paramDataCallback)
  {
    this.d = paramPriority;
    this.e = paramDataCallback;
    this.f = ((List)this.b.acquire());
    ((DataFetcher)this.a.get(this.c)).a(paramPriority, this);
  }
  
  public void a(@NonNull Exception paramException)
  {
    ((List)Preconditions.a(this.f)).add(paramException);
    e();
  }
  
  public void a(@Nullable Data paramData)
  {
    if (paramData != null)
    {
      this.e.a(paramData);
      return;
    }
    e();
  }
  
  public void b()
  {
    Object localObject = this.f;
    if (localObject != null) {
      this.b.release(localObject);
    }
    this.f = null;
    localObject = this.a.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((DataFetcher)((Iterator)localObject).next()).b();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((DataFetcher)localIterator.next()).c();
    }
  }
  
  @NonNull
  public DataSource d()
  {
    return ((DataFetcher)this.a.get(0)).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.MultiModelLoader.MultiFetcher
 * JD-Core Version:    0.7.0.1
 */