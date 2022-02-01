package com.bumptech.glide.load.model.stream;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.HttpUrlFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import java.io.InputStream;

public class HttpGlideUrlLoader
  implements ModelLoader<GlideUrl, InputStream>
{
  public static final Option<Integer> a = Option.a("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", Integer.valueOf(2500));
  @Nullable
  private final ModelCache<GlideUrl, GlideUrl> b;
  
  public HttpGlideUrlLoader()
  {
    this(null);
  }
  
  public HttpGlideUrlLoader(@Nullable ModelCache<GlideUrl, GlideUrl> paramModelCache)
  {
    this.b = paramModelCache;
  }
  
  public ModelLoader.LoadData<InputStream> a(@NonNull GlideUrl paramGlideUrl, int paramInt1, int paramInt2, @NonNull Options paramOptions)
  {
    ModelCache localModelCache = this.b;
    GlideUrl localGlideUrl = paramGlideUrl;
    if (localModelCache != null)
    {
      localGlideUrl = (GlideUrl)localModelCache.a(paramGlideUrl, 0, 0);
      if (localGlideUrl == null)
      {
        this.b.a(paramGlideUrl, 0, 0, paramGlideUrl);
        localGlideUrl = paramGlideUrl;
      }
    }
    return new ModelLoader.LoadData(localGlideUrl, new HttpUrlFetcher(localGlideUrl, ((Integer)paramOptions.a(a)).intValue()));
  }
  
  public boolean a(@NonNull GlideUrl paramGlideUrl)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.stream.HttpGlideUrlLoader
 * JD-Core Version:    0.7.0.1
 */