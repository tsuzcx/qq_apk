package com.bumptech.glide.load.model;

import android.content.res.AssetManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.StreamAssetPathFetcher;
import java.io.InputStream;

public class AssetUriLoader$StreamFactory
  implements AssetUriLoader.AssetFetcherFactory<InputStream>, ModelLoaderFactory<Uri, InputStream>
{
  private final AssetManager a;
  
  public AssetUriLoader$StreamFactory(AssetManager paramAssetManager)
  {
    this.a = paramAssetManager;
  }
  
  public DataFetcher<InputStream> a(AssetManager paramAssetManager, String paramString)
  {
    return new StreamAssetPathFetcher(paramAssetManager, paramString);
  }
  
  @NonNull
  public ModelLoader<Uri, InputStream> a(MultiModelLoaderFactory paramMultiModelLoaderFactory)
  {
    return new AssetUriLoader(this.a, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.AssetUriLoader.StreamFactory
 * JD-Core Version:    0.7.0.1
 */