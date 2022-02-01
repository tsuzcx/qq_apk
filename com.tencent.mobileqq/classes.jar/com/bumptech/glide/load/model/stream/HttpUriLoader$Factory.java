package com.bumptech.glide.load.model.stream;

import android.net.Uri;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;

public class HttpUriLoader$Factory
  implements ModelLoaderFactory<Uri, InputStream>
{
  @NonNull
  public ModelLoader<Uri, InputStream> a(MultiModelLoaderFactory paramMultiModelLoaderFactory)
  {
    return new HttpUriLoader(paramMultiModelLoaderFactory.a(GlideUrl.class, InputStream.class));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.stream.HttpUriLoader.Factory
 * JD-Core Version:    0.7.0.1
 */