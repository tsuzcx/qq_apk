package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.data.mediastore.ThumbFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

public class MediaStoreVideoThumbLoader
  implements ModelLoader<Uri, InputStream>
{
  private final Context a;
  
  public MediaStoreVideoThumbLoader(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }
  
  private boolean a(Options paramOptions)
  {
    paramOptions = (Long)paramOptions.a(VideoDecoder.a);
    return (paramOptions != null) && (paramOptions.longValue() == -1L);
  }
  
  @Nullable
  public ModelLoader.LoadData<InputStream> a(@NonNull Uri paramUri, int paramInt1, int paramInt2, @NonNull Options paramOptions)
  {
    if ((MediaStoreUtil.a(paramInt1, paramInt2)) && (a(paramOptions))) {
      return new ModelLoader.LoadData(new ObjectKey(paramUri), ThumbFetcher.b(this.a, paramUri));
    }
    return null;
  }
  
  public boolean a(@NonNull Uri paramUri)
  {
    return MediaStoreUtil.b(paramUri);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader
 * JD-Core Version:    0.7.0.1
 */