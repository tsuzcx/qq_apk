package com.bumptech.glide.load.engine;

import android.support.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;

public abstract interface DataFetcherGenerator$FetcherReadyCallback
{
  public abstract void a(Key paramKey, Exception paramException, DataFetcher<?> paramDataFetcher, DataSource paramDataSource);
  
  public abstract void a(Key paramKey1, @Nullable Object paramObject, DataFetcher<?> paramDataFetcher, DataSource paramDataSource, Key paramKey2);
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
 * JD-Core Version:    0.7.0.1
 */