package com.bumptech.glide.load.model;

import android.content.res.Resources;
import android.net.Uri;
import android.support.annotation.NonNull;
import java.io.InputStream;

public class ResourceLoader$StreamFactory
  implements ModelLoaderFactory<Integer, InputStream>
{
  private final Resources a;
  
  public ResourceLoader$StreamFactory(Resources paramResources)
  {
    this.a = paramResources;
  }
  
  @NonNull
  public ModelLoader<Integer, InputStream> a(MultiModelLoaderFactory paramMultiModelLoaderFactory)
  {
    return new ResourceLoader(this.a, paramMultiModelLoaderFactory.a(Uri.class, InputStream.class));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.ResourceLoader.StreamFactory
 * JD-Core Version:    0.7.0.1
 */