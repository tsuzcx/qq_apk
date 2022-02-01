package com.bumptech.glide.load.model;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.FileDescriptorLocalUriFetcher;

public class UriLoader$FileDescriptorFactory
  implements ModelLoaderFactory<Uri, ParcelFileDescriptor>, UriLoader.LocalUriFetcherFactory<ParcelFileDescriptor>
{
  private final ContentResolver a;
  
  public UriLoader$FileDescriptorFactory(ContentResolver paramContentResolver)
  {
    this.a = paramContentResolver;
  }
  
  public DataFetcher<ParcelFileDescriptor> a(Uri paramUri)
  {
    return new FileDescriptorLocalUriFetcher(this.a, paramUri);
  }
  
  @NonNull
  public ModelLoader<Uri, ParcelFileDescriptor> a(MultiModelLoaderFactory paramMultiModelLoaderFactory)
  {
    return new UriLoader(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.UriLoader.FileDescriptorFactory
 * JD-Core Version:    0.7.0.1
 */