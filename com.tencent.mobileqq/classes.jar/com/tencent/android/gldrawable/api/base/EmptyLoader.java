package com.tencent.android.gldrawable.api.base;

import com.tencent.android.gldrawable.api.IGLDrawableLoader;
import com.tencent.android.gldrawable.api.ILoaderCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/android/gldrawable/api/base/EmptyLoader;", "Lcom/tencent/android/gldrawable/api/IGLDrawableLoader;", "()V", "isLoaded", "", "()Z", "isStatic", "loaderUtils", "Lcom/tencent/android/gldrawable/api/base/EmptyLoadUtils;", "getLoaderUtils", "()Lcom/tencent/android/gldrawable/api/base/EmptyLoadUtils;", "getClassLoader", "", "loadSync", "", "callback", "Lcom/tencent/android/gldrawable/api/ILoaderCallback;", "api_release"}, k=1, mv={1, 1, 16})
public final class EmptyLoader
  implements IGLDrawableLoader
{
  private final boolean isLoaded;
  private final boolean isStatic = true;
  @NotNull
  private final EmptyLoadUtils loaderUtils = new EmptyLoadUtils();
  
  @Nullable
  public Void getClassLoader()
  {
    return null;
  }
  
  @NotNull
  public EmptyLoadUtils getLoaderUtils()
  {
    return this.loaderUtils;
  }
  
  public boolean isLoaded()
  {
    return this.isLoaded;
  }
  
  public boolean isStatic()
  {
    return this.isStatic;
  }
  
  public void loadSync(@NotNull ILoaderCallback paramILoaderCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramILoaderCallback, "callback");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.base.EmptyLoader
 * JD-Core Version:    0.7.0.1
 */