package com.tencent.android.gldrawable.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/android/gldrawable/api/IGLDrawableLoader;", "", "isLoaded", "", "()Z", "isStatic", "loaderUtils", "Lcom/tencent/android/gldrawable/api/ILoadUtils;", "getLoaderUtils", "()Lcom/tencent/android/gldrawable/api/ILoadUtils;", "getClassLoader", "Ljava/lang/ClassLoader;", "loadSync", "", "callback", "Lcom/tencent/android/gldrawable/api/ILoaderCallback;", "api_release"}, k=1, mv={1, 1, 16})
public abstract interface IGLDrawableLoader
{
  @Nullable
  public abstract ClassLoader getClassLoader();
  
  @NotNull
  public abstract ILoadUtils getLoaderUtils();
  
  public abstract boolean isLoaded();
  
  public abstract boolean isStatic();
  
  public abstract void loadSync(@NotNull ILoaderCallback paramILoaderCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.IGLDrawableLoader
 * JD-Core Version:    0.7.0.1
 */