package com.bumptech.glide.load.model;

import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

final class FileLoader$FileFetcher<Data>
  implements DataFetcher<Data>
{
  private final File a;
  private final FileLoader.FileOpener<Data> b;
  private Data c;
  
  FileLoader$FileFetcher(File paramFile, FileLoader.FileOpener<Data> paramFileOpener)
  {
    this.a = paramFile;
    this.b = paramFileOpener;
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
      this.c = this.b.b(this.a);
      paramDataCallback.a(this.c);
      return;
    }
    catch (FileNotFoundException paramPriority)
    {
      if (Log.isLoggable("FileLoader", 3)) {
        Log.d("FileLoader", "Failed to open file", paramPriority);
      }
      paramDataCallback.a(paramPriority);
    }
  }
  
  public void b()
  {
    Object localObject = this.c;
    if (localObject != null) {}
    try
    {
      this.b.a(localObject);
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
 * Qualified Name:     com.bumptech.glide.load.model.FileLoader.FileFetcher
 * JD-Core Version:    0.7.0.1
 */