package com.bumptech.glide.load.model;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;

public final class MediaStoreFileLoader
  implements ModelLoader<Uri, File>
{
  private final Context a;
  
  public MediaStoreFileLoader(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public ModelLoader.LoadData<File> a(@NonNull Uri paramUri, int paramInt1, int paramInt2, @NonNull Options paramOptions)
  {
    return new ModelLoader.LoadData(new ObjectKey(paramUri), new MediaStoreFileLoader.FilePathFetcher(this.a, paramUri));
  }
  
  public boolean a(@NonNull Uri paramUri)
  {
    return MediaStoreUtil.a(paramUri);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.MediaStoreFileLoader
 * JD-Core Version:    0.7.0.1
 */