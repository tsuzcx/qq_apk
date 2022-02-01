package com.bumptech.glide.load.data;

import android.support.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

public abstract interface DataFetcher<T>
{
  @NonNull
  public abstract Class<T> a();
  
  public abstract void a(@NonNull Priority paramPriority, @NonNull DataFetcher.DataCallback<? super T> paramDataCallback);
  
  public abstract void b();
  
  public abstract void c();
  
  @NonNull
  public abstract DataSource d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.data.DataFetcher
 * JD-Core Version:    0.7.0.1
 */