package com.bumptech.glide.load.model;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;

public class StringLoader$FileDescriptorFactory
  implements ModelLoaderFactory<String, ParcelFileDescriptor>
{
  @NonNull
  public ModelLoader<String, ParcelFileDescriptor> a(MultiModelLoaderFactory paramMultiModelLoaderFactory)
  {
    return new StringLoader(paramMultiModelLoaderFactory.a(Uri.class, ParcelFileDescriptor.class));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.StringLoader.FileDescriptorFactory
 * JD-Core Version:    0.7.0.1
 */