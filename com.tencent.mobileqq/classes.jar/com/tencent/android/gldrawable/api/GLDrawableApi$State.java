package com.tencent.android.gldrawable.api;

import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/android/gldrawable/api/GLDrawableApi$State;", "", "()V", "isDynamicReady", "", "()Z", "isStaticModel", "testApk", "Ljava/io/File;", "getTestApk", "()Ljava/io/File;", "api_release"}, k=1, mv={1, 1, 16})
public final class GLDrawableApi$State
{
  @NotNull
  public final File getTestApk()
  {
    return GLDrawableApi.INSTANCE.getLoader().getLoaderUtils().getTestApkFile();
  }
  
  public final boolean isDynamicReady()
  {
    return GLDrawableApi.access$isDynamicReady(GLDrawableApi.INSTANCE);
  }
  
  public final boolean isStaticModel()
  {
    return GLDrawableApi.INSTANCE.getLoader().isStatic();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.GLDrawableApi.State
 * JD-Core Version:    0.7.0.1
 */