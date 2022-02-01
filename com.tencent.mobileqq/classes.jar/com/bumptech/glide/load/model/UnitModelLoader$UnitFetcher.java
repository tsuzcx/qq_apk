package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;

class UnitModelLoader$UnitFetcher<Model>
  implements DataFetcher<Model>
{
  private final Model a;
  
  UnitModelLoader$UnitFetcher(Model paramModel)
  {
    this.a = paramModel;
  }
  
  @NonNull
  public Class<Model> a()
  {
    return this.a.getClass();
  }
  
  public void a(@NonNull Priority paramPriority, @NonNull DataFetcher.DataCallback<? super Model> paramDataCallback)
  {
    paramDataCallback.a(this.a);
  }
  
  public void b() {}
  
  public void c() {}
  
  @NonNull
  public DataSource d()
  {
    return DataSource.LOCAL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.UnitModelLoader.UnitFetcher
 * JD-Core Version:    0.7.0.1
 */