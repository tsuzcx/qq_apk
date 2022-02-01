package com.bumptech.glide.load.model.stream;

import android.net.Uri;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class HttpUriLoader
  implements ModelLoader<Uri, InputStream>
{
  private static final Set<String> a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "http", "https" })));
  private final ModelLoader<GlideUrl, InputStream> b;
  
  public HttpUriLoader(ModelLoader<GlideUrl, InputStream> paramModelLoader)
  {
    this.b = paramModelLoader;
  }
  
  public ModelLoader.LoadData<InputStream> a(@NonNull Uri paramUri, int paramInt1, int paramInt2, @NonNull Options paramOptions)
  {
    return this.b.a(new GlideUrl(paramUri.toString()), paramInt1, paramInt2, paramOptions);
  }
  
  public boolean a(@NonNull Uri paramUri)
  {
    return a.contains(paramUri.getScheme());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.stream.HttpUriLoader
 * JD-Core Version:    0.7.0.1
 */