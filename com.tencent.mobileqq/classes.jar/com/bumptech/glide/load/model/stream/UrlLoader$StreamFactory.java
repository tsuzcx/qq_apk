package com.bumptech.glide.load.model.stream;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;
import java.net.URL;

public class UrlLoader$StreamFactory
  implements ModelLoaderFactory<URL, InputStream>
{
  @NonNull
  public ModelLoader<URL, InputStream> a(MultiModelLoaderFactory paramMultiModelLoaderFactory)
  {
    return new UrlLoader(paramMultiModelLoaderFactory.a(GlideUrl.class, InputStream.class));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.stream.UrlLoader.StreamFactory
 * JD-Core Version:    0.7.0.1
 */