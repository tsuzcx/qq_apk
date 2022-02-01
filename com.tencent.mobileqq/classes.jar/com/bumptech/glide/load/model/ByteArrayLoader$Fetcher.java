package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;

class ByteArrayLoader$Fetcher<Data>
  implements DataFetcher<Data>
{
  private final byte[] a;
  private final ByteArrayLoader.Converter<Data> b;
  
  ByteArrayLoader$Fetcher(byte[] paramArrayOfByte, ByteArrayLoader.Converter<Data> paramConverter)
  {
    this.a = paramArrayOfByte;
    this.b = paramConverter;
  }
  
  @NonNull
  public Class<Data> a()
  {
    return this.b.a();
  }
  
  public void a(@NonNull Priority paramPriority, @NonNull DataFetcher.DataCallback<? super Data> paramDataCallback)
  {
    paramDataCallback.a(this.b.b(this.a));
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
 * Qualified Name:     com.bumptech.glide.load.model.ByteArrayLoader.Fetcher
 * JD-Core Version:    0.7.0.1
 */