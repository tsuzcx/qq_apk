package com.bumptech.glide.load.model;

import android.net.Uri;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.Options;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UrlUriLoader<Data>
  implements ModelLoader<Uri, Data>
{
  private static final Set<String> a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "http", "https" })));
  private final ModelLoader<GlideUrl, Data> b;
  
  public UrlUriLoader(ModelLoader<GlideUrl, Data> paramModelLoader)
  {
    this.b = paramModelLoader;
  }
  
  public ModelLoader.LoadData<Data> a(@NonNull Uri paramUri, int paramInt1, int paramInt2, @NonNull Options paramOptions)
  {
    paramUri = new GlideUrl(paramUri.toString());
    return this.b.a(paramUri, paramInt1, paramInt2, paramOptions);
  }
  
  public boolean a(@NonNull Uri paramUri)
  {
    return a.contains(paramUri.getScheme());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.UrlUriLoader
 * JD-Core Version:    0.7.0.1
 */