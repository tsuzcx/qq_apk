package com.bumptech.glide.load.model;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.FileDescriptorAssetPathFetcher;

public class AssetUriLoader$FileDescriptorFactory
  implements AssetUriLoader.AssetFetcherFactory<ParcelFileDescriptor>, ModelLoaderFactory<Uri, ParcelFileDescriptor>
{
  private final AssetManager a;
  
  public AssetUriLoader$FileDescriptorFactory(AssetManager paramAssetManager)
  {
    this.a = paramAssetManager;
  }
  
  public DataFetcher<ParcelFileDescriptor> a(AssetManager paramAssetManager, String paramString)
  {
    return new FileDescriptorAssetPathFetcher(paramAssetManager, paramString);
  }
  
  @NonNull
  public ModelLoader<Uri, ParcelFileDescriptor> a(MultiModelLoaderFactory paramMultiModelLoaderFactory)
  {
    return new AssetUriLoader(this.a, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.AssetUriLoader.FileDescriptorFactory
 * JD-Core Version:    0.7.0.1
 */