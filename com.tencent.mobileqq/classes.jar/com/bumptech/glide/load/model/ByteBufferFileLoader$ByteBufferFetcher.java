package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

final class ByteBufferFileLoader$ByteBufferFetcher
  implements DataFetcher<ByteBuffer>
{
  private final File a;
  
  ByteBufferFileLoader$ByteBufferFetcher(File paramFile)
  {
    this.a = paramFile;
  }
  
  @NonNull
  public Class<ByteBuffer> a()
  {
    return ByteBuffer.class;
  }
  
  public void a(@NonNull Priority paramPriority, @NonNull DataFetcher.DataCallback<? super ByteBuffer> paramDataCallback)
  {
    try
    {
      paramPriority = ByteBufferUtil.a(this.a);
      paramDataCallback.a(paramPriority);
      return;
    }
    catch (IOException paramPriority)
    {
      if (Log.isLoggable("ByteBufferFileLoader", 3)) {
        Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", paramPriority);
      }
      paramDataCallback.a(paramPriority);
    }
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
 * Qualified Name:     com.bumptech.glide.load.model.ByteBufferFileLoader.ByteBufferFetcher
 * JD-Core Version:    0.7.0.1
 */