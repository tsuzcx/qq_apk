package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import java.io.IOException;

final class DataUrlLoader$DataUriFetcher<Data>
  implements DataFetcher<Data>
{
  private final String a;
  private final DataUrlLoader.DataDecoder<Data> b;
  private Data c;
  
  DataUrlLoader$DataUriFetcher(String paramString, DataUrlLoader.DataDecoder<Data> paramDataDecoder)
  {
    this.a = paramString;
    this.b = paramDataDecoder;
  }
  
  @NonNull
  public Class<Data> a()
  {
    return this.b.a();
  }
  
  public void a(@NonNull Priority paramPriority, @NonNull DataFetcher.DataCallback<? super Data> paramDataCallback)
  {
    try
    {
      this.c = this.b.a(this.a);
      paramDataCallback.a(this.c);
      return;
    }
    catch (IllegalArgumentException paramPriority)
    {
      paramDataCallback.a(paramPriority);
    }
  }
  
  public void b()
  {
    try
    {
      this.b.a(this.c);
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public void c() {}
  
  @NonNull
  public DataSource d()
  {
    return DataSource.LOCAL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.DataUrlLoader.DataUriFetcher
 * JD-Core Version:    0.7.0.1
 */