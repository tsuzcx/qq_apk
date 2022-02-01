package com.bumptech.glide.load.model;

import android.content.res.AssetManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.signature.ObjectKey;
import java.util.List;

public class AssetUriLoader<Data>
  implements ModelLoader<Uri, Data>
{
  private static final int a = 22;
  private final AssetManager b;
  private final AssetUriLoader.AssetFetcherFactory<Data> c;
  
  public AssetUriLoader(AssetManager paramAssetManager, AssetUriLoader.AssetFetcherFactory<Data> paramAssetFetcherFactory)
  {
    this.b = paramAssetManager;
    this.c = paramAssetFetcherFactory;
  }
  
  public ModelLoader.LoadData<Data> a(@NonNull Uri paramUri, int paramInt1, int paramInt2, @NonNull Options paramOptions)
  {
    paramOptions = paramUri.toString().substring(a);
    return new ModelLoader.LoadData(new ObjectKey(paramUri), this.c.a(this.b, paramOptions));
  }
  
  public boolean a(@NonNull Uri paramUri)
  {
    boolean bool3 = "file".equals(paramUri.getScheme());
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (!paramUri.getPathSegments().isEmpty())
      {
        bool1 = bool2;
        if ("android_asset".equals(paramUri.getPathSegments().get(0))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.AssetUriLoader
 * JD-Core Version:    0.7.0.1
 */