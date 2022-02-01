package com.bumptech.glide.load.model.stream;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import java.io.InputStream;
import java.net.URL;

public class UrlLoader
  implements ModelLoader<URL, InputStream>
{
  private final ModelLoader<GlideUrl, InputStream> a;
  
  public UrlLoader(ModelLoader<GlideUrl, InputStream> paramModelLoader)
  {
    this.a = paramModelLoader;
  }
  
  public ModelLoader.LoadData<InputStream> a(@NonNull URL paramURL, int paramInt1, int paramInt2, @NonNull Options paramOptions)
  {
    return this.a.a(new GlideUrl(paramURL), paramInt1, paramInt2, paramOptions);
  }
  
  public boolean a(@NonNull URL paramURL)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.stream.UrlLoader
 * JD-Core Version:    0.7.0.1
 */