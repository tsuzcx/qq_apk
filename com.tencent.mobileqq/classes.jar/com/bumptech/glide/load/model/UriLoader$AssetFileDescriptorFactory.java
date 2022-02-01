package com.bumptech.glide.load.model;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.bumptech.glide.load.data.AssetFileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.data.DataFetcher;

public final class UriLoader$AssetFileDescriptorFactory
  implements ModelLoaderFactory<Uri, AssetFileDescriptor>, UriLoader.LocalUriFetcherFactory<AssetFileDescriptor>
{
  private final ContentResolver a;
  
  public UriLoader$AssetFileDescriptorFactory(ContentResolver paramContentResolver)
  {
    this.a = paramContentResolver;
  }
  
  public DataFetcher<AssetFileDescriptor> a(Uri paramUri)
  {
    return new AssetFileDescriptorLocalUriFetcher(this.a, paramUri);
  }
  
  public ModelLoader<Uri, AssetFileDescriptor> a(MultiModelLoaderFactory paramMultiModelLoaderFactory)
  {
    return new UriLoader(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.UriLoader.AssetFileDescriptorFactory
 * JD-Core Version:    0.7.0.1
 */