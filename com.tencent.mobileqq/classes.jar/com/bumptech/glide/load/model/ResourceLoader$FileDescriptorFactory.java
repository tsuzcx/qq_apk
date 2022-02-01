package com.bumptech.glide.load.model;

import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;

public class ResourceLoader$FileDescriptorFactory
  implements ModelLoaderFactory<Integer, ParcelFileDescriptor>
{
  private final Resources a;
  
  public ResourceLoader$FileDescriptorFactory(Resources paramResources)
  {
    this.a = paramResources;
  }
  
  @NonNull
  public ModelLoader<Integer, ParcelFileDescriptor> a(MultiModelLoaderFactory paramMultiModelLoaderFactory)
  {
    return new ResourceLoader(this.a, paramMultiModelLoaderFactory.a(Uri.class, ParcelFileDescriptor.class));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.ResourceLoader.FileDescriptorFactory
 * JD-Core Version:    0.7.0.1
 */