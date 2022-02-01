package com.bumptech.glide.load.model;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import java.io.File;
import java.io.FileNotFoundException;

class MediaStoreFileLoader$FilePathFetcher
  implements DataFetcher<File>
{
  private static final String[] a = { "_data" };
  private final Context b;
  private final Uri c;
  
  MediaStoreFileLoader$FilePathFetcher(Context paramContext, Uri paramUri)
  {
    this.b = paramContext;
    this.c = paramUri;
  }
  
  @NonNull
  public Class<File> a()
  {
    return File.class;
  }
  
  public void a(@NonNull Priority paramPriority, @NonNull DataFetcher.DataCallback<? super File> paramDataCallback)
  {
    Cursor localCursor = this.b.getContentResolver().query(this.c, a, null, null, null);
    paramPriority = null;
    Object localObject = null;
    if (localCursor != null) {
      paramPriority = localObject;
    }
    try
    {
      if (localCursor.moveToFirst()) {
        paramPriority = localCursor.getString(localCursor.getColumnIndexOrThrow("_data"));
      }
      localCursor.close();
    }
    finally
    {
      localCursor.close();
    }
    paramPriority = new StringBuilder();
    paramPriority.append("Failed to find file path for: ");
    paramPriority.append(this.c);
    paramDataCallback.a(new FileNotFoundException(paramPriority.toString()));
    return;
    paramDataCallback.a(new File(paramPriority));
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
 * Qualified Name:     com.bumptech.glide.load.model.MediaStoreFileLoader.FilePathFetcher
 * JD-Core Version:    0.7.0.1
 */