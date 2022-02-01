package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.IOException;

public abstract class AssetPathFetcher<T>
  implements DataFetcher<T>
{
  private final String a;
  private final AssetManager b;
  private T c;
  
  public AssetPathFetcher(AssetManager paramAssetManager, String paramString)
  {
    this.b = paramAssetManager;
    this.a = paramString;
  }
  
  protected abstract T a(AssetManager paramAssetManager, String paramString);
  
  public void a(@NonNull Priority paramPriority, @NonNull DataFetcher.DataCallback<? super T> paramDataCallback)
  {
    try
    {
      this.c = a(this.b, this.a);
      paramDataCallback.a(this.c);
      return;
    }
    catch (IOException paramPriority)
    {
      if (Log.isLoggable("AssetPathFetcher", 3)) {
        Log.d("AssetPathFetcher", "Failed to load data from asset manager", paramPriority);
      }
      paramDataCallback.a(paramPriority);
    }
  }
  
  protected abstract void a(T paramT);
  
  public void b()
  {
    Object localObject = this.c;
    if (localObject == null) {
      return;
    }
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
 * Qualified Name:     com.bumptech.glide.load.data.AssetPathFetcher
 * JD-Core Version:    0.7.0.1
 */