package com.bumptech.glide.load.data.mediastore;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.data.ExifOrientationStream;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ThumbFetcher
  implements DataFetcher<InputStream>
{
  private final Uri a;
  private final ThumbnailStreamOpener b;
  private InputStream c;
  
  @VisibleForTesting
  ThumbFetcher(Uri paramUri, ThumbnailStreamOpener paramThumbnailStreamOpener)
  {
    this.a = paramUri;
    this.b = paramThumbnailStreamOpener;
  }
  
  public static ThumbFetcher a(Context paramContext, Uri paramUri)
  {
    return a(paramContext, paramUri, new ThumbFetcher.ImageThumbnailQuery(paramContext.getContentResolver()));
  }
  
  private static ThumbFetcher a(Context paramContext, Uri paramUri, ThumbnailQuery paramThumbnailQuery)
  {
    ArrayPool localArrayPool = Glide.a(paramContext).b();
    return new ThumbFetcher(paramUri, new ThumbnailStreamOpener(Glide.a(paramContext).h().a(), paramThumbnailQuery, localArrayPool, paramContext.getContentResolver()));
  }
  
  public static ThumbFetcher b(Context paramContext, Uri paramUri)
  {
    return a(paramContext, paramUri, new ThumbFetcher.VideoThumbnailQuery(paramContext.getContentResolver()));
  }
  
  private InputStream e()
  {
    InputStream localInputStream = this.b.b(this.a);
    int i;
    if (localInputStream != null) {
      i = this.b.a(this.a);
    } else {
      i = -1;
    }
    Object localObject = localInputStream;
    if (i != -1) {
      localObject = new ExifOrientationStream(localInputStream, i);
    }
    return localObject;
  }
  
  @NonNull
  public Class<InputStream> a()
  {
    return InputStream.class;
  }
  
  public void a(@NonNull Priority paramPriority, @NonNull DataFetcher.DataCallback<? super InputStream> paramDataCallback)
  {
    try
    {
      this.c = e();
      paramDataCallback.a(this.c);
      return;
    }
    catch (FileNotFoundException paramPriority)
    {
      if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
        Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", paramPriority);
      }
      paramDataCallback.a(paramPriority);
    }
  }
  
  public void b()
  {
    InputStream localInputStream = this.c;
    if (localInputStream != null) {}
    try
    {
      localInputStream.close();
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
 * Qualified Name:     com.bumptech.glide.load.data.mediastore.ThumbFetcher
 * JD-Core Version:    0.7.0.1
 */