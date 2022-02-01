package com.bumptech.glide.load.model;

import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.StreamLocalUriFetcher;
import java.io.InputStream;

public class UriLoader$StreamFactory
  implements ModelLoaderFactory<Uri, InputStream>, UriLoader.LocalUriFetcherFactory<InputStream>
{
  private final ContentResolver a;
  
  public UriLoader$StreamFactory(ContentResolver paramContentResolver)
  {
    this.a = paramContentResolver;
  }
  
  public DataFetcher<InputStream> a(Uri paramUri)
  {
    return new StreamLocalUriFetcher(this.a, paramUri);
  }
  
  @NonNull
  public ModelLoader<Uri, InputStream> a(MultiModelLoaderFactory paramMultiModelLoaderFactory)
  {
    return new UriLoader(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.UriLoader.StreamFactory
 * JD-Core Version:    0.7.0.1
 */