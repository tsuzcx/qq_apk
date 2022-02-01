package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class LocalUriFetcher<T>
  implements DataFetcher<T>
{
  private final Uri a;
  private final ContentResolver b;
  private T c;
  
  public LocalUriFetcher(ContentResolver paramContentResolver, Uri paramUri)
  {
    this.b = paramContentResolver;
    this.a = paramUri;
  }
  
  public final void a(@NonNull Priority paramPriority, @NonNull DataFetcher.DataCallback<? super T> paramDataCallback)
  {
    try
    {
      this.c = b(this.a, this.b);
      paramDataCallback.a(this.c);
      return;
    }
    catch (FileNotFoundException paramPriority)
    {
      if (Log.isLoggable("LocalUriFetcher", 3)) {
        Log.d("LocalUriFetcher", "Failed to open Uri", paramPriority);
      }
      paramDataCallback.a(paramPriority);
    }
  }
  
  protected abstract void a(T paramT);
  
  protected abstract T b(Uri paramUri, ContentResolver paramContentResolver);
  
  public void b()
  {
    Object localObject = this.c;
    if (localObject != null) {}
    try
    {
      a(localObject);
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
 * Qualified Name:     com.bumptech.glide.load.data.LocalUriFetcher
 * JD-Core Version:    0.7.0.1
 */