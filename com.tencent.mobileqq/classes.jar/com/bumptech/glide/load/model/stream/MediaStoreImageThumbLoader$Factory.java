package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;

public class MediaStoreImageThumbLoader$Factory
  implements ModelLoaderFactory<Uri, InputStream>
{
  private final Context a;
  
  public MediaStoreImageThumbLoader$Factory(Context paramContext)
  {
    this.a = paramContext;
  }
  
  @NonNull
  public ModelLoader<Uri, InputStream> a(MultiModelLoaderFactory paramMultiModelLoaderFactory)
  {
    return new MediaStoreImageThumbLoader(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader.Factory
 * JD-Core Version:    0.7.0.1
 */