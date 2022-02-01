package com.bumptech.glide.load.model;

import android.net.Uri;
import android.support.annotation.NonNull;
import java.io.InputStream;

public class UrlUriLoader$StreamFactory
  implements ModelLoaderFactory<Uri, InputStream>
{
  @NonNull
  public ModelLoader<Uri, InputStream> a(MultiModelLoaderFactory paramMultiModelLoaderFactory)
  {
    return new UrlUriLoader(paramMultiModelLoaderFactory.a(GlideUrl.class, InputStream.class));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.UrlUriLoader.StreamFactory
 * JD-Core Version:    0.7.0.1
 */