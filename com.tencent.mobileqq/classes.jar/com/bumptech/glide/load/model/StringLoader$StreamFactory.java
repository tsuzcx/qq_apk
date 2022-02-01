package com.bumptech.glide.load.model;

import android.net.Uri;
import android.support.annotation.NonNull;
import java.io.InputStream;

public class StringLoader$StreamFactory
  implements ModelLoaderFactory<String, InputStream>
{
  @NonNull
  public ModelLoader<String, InputStream> a(MultiModelLoaderFactory paramMultiModelLoaderFactory)
  {
    return new StringLoader(paramMultiModelLoaderFactory.a(Uri.class, InputStream.class));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.StringLoader.StreamFactory
 * JD-Core Version:    0.7.0.1
 */