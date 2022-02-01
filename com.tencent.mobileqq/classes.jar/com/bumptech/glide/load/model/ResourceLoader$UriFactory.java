package com.bumptech.glide.load.model;

import android.content.res.Resources;
import android.net.Uri;
import android.support.annotation.NonNull;

public class ResourceLoader$UriFactory
  implements ModelLoaderFactory<Integer, Uri>
{
  private final Resources a;
  
  public ResourceLoader$UriFactory(Resources paramResources)
  {
    this.a = paramResources;
  }
  
  @NonNull
  public ModelLoader<Integer, Uri> a(MultiModelLoaderFactory paramMultiModelLoaderFactory)
  {
    return new ResourceLoader(this.a, UnitModelLoader.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.ResourceLoader.UriFactory
 * JD-Core Version:    0.7.0.1
 */