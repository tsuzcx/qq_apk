package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;

public final class ResourceLoader$AssetFileDescriptorFactory
  implements ModelLoaderFactory<Integer, AssetFileDescriptor>
{
  private final Resources a;
  
  public ResourceLoader$AssetFileDescriptorFactory(Resources paramResources)
  {
    this.a = paramResources;
  }
  
  public ModelLoader<Integer, AssetFileDescriptor> a(MultiModelLoaderFactory paramMultiModelLoaderFactory)
  {
    return new ResourceLoader(this.a, paramMultiModelLoaderFactory.a(Uri.class, AssetFileDescriptor.class));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.ResourceLoader.AssetFileDescriptorFactory
 * JD-Core Version:    0.7.0.1
 */