package com.bumptech.glide.load.model.stream;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;

public class HttpGlideUrlLoader$Factory
  implements ModelLoaderFactory<GlideUrl, InputStream>
{
  private final ModelCache<GlideUrl, GlideUrl> a = new ModelCache(500L);
  
  @NonNull
  public ModelLoader<GlideUrl, InputStream> a(MultiModelLoaderFactory paramMultiModelLoaderFactory)
  {
    return new HttpGlideUrlLoader(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Factory
 * JD-Core Version:    0.7.0.1
 */