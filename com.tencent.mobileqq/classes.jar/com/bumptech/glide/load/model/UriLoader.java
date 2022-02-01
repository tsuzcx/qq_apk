package com.bumptech.glide.load.model;

import android.net.Uri;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.signature.ObjectKey;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UriLoader<Data>
  implements ModelLoader<Uri, Data>
{
  private static final Set<String> a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "file", "android.resource", "content" })));
  private final UriLoader.LocalUriFetcherFactory<Data> b;
  
  public UriLoader(UriLoader.LocalUriFetcherFactory<Data> paramLocalUriFetcherFactory)
  {
    this.b = paramLocalUriFetcherFactory;
  }
  
  public ModelLoader.LoadData<Data> a(@NonNull Uri paramUri, int paramInt1, int paramInt2, @NonNull Options paramOptions)
  {
    return new ModelLoader.LoadData(new ObjectKey(paramUri), this.b.a(paramUri));
  }
  
  public boolean a(@NonNull Uri paramUri)
  {
    return a.contains(paramUri.getScheme());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.UriLoader
 * JD-Core Version:    0.7.0.1
 */