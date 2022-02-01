package com.bumptech.glide.load.model;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import java.io.File;

public final class MediaStoreFileLoader$Factory
  implements ModelLoaderFactory<Uri, File>
{
  private final Context a;
  
  public MediaStoreFileLoader$Factory(Context paramContext)
  {
    this.a = paramContext;
  }
  
  @NonNull
  public ModelLoader<Uri, File> a(MultiModelLoaderFactory paramMultiModelLoaderFactory)
  {
    return new MediaStoreFileLoader(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.MediaStoreFileLoader.Factory
 * JD-Core Version:    0.7.0.1
 */