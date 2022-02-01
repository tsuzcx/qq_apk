package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;

public final class StringLoader$AssetFileDescriptorFactory
  implements ModelLoaderFactory<String, AssetFileDescriptor>
{
  public ModelLoader<String, AssetFileDescriptor> a(MultiModelLoaderFactory paramMultiModelLoaderFactory)
  {
    return new StringLoader(paramMultiModelLoaderFactory.a(Uri.class, AssetFileDescriptor.class));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.StringLoader.AssetFileDescriptorFactory
 * JD-Core Version:    0.7.0.1
 */