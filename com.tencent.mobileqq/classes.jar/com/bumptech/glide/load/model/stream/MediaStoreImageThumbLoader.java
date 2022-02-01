package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.data.mediastore.ThumbFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

public class MediaStoreImageThumbLoader
  implements ModelLoader<Uri, InputStream>
{
  private final Context a;
  
  public MediaStoreImageThumbLoader(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }
  
  public ModelLoader.LoadData<InputStream> a(@NonNull Uri paramUri, int paramInt1, int paramInt2, @NonNull Options paramOptions)
  {
    if (MediaStoreUtil.a(paramInt1, paramInt2)) {
      return new ModelLoader.LoadData(new ObjectKey(paramUri), ThumbFetcher.a(this.a, paramUri));
    }
    return null;
  }
  
  public boolean a(@NonNull Uri paramUri)
  {
    return MediaStoreUtil.c(paramUri);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader
 * JD-Core Version:    0.7.0.1
 */