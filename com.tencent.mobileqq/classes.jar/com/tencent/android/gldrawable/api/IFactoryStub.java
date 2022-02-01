package com.tencent.android.gldrawable.api;

import android.os.Bundle;
import android.os.Handler;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/android/gldrawable/api/IFactoryStub;", "", "fromBundle", "Lcom/tencent/android/gldrawable/api/IGLDrawable;", "bundle", "Landroid/os/Bundle;", "fromFile", "file", "Ljava/io/File;", "setWorkHandler", "handler", "Landroid/os/Handler;", "useCache", "b", "", "api_release"}, k=1, mv={1, 1, 16})
public abstract interface IFactoryStub
{
  @Nullable
  public abstract IGLDrawable fromBundle(@NotNull Bundle paramBundle);
  
  @Nullable
  public abstract IGLDrawable fromFile(@NotNull File paramFile);
  
  @NotNull
  public abstract IFactoryStub setWorkHandler(@Nullable Handler paramHandler);
  
  @NotNull
  public abstract IFactoryStub useCache(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.IFactoryStub
 * JD-Core Version:    0.7.0.1
 */