package com.tencent.android.gldrawable;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.android.gldrawable.api.IFactoryStub;
import com.tencent.android.gldrawable.api.IGLDrawable;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/android/gldrawable/FactoryStubImpl;", "Lcom/tencent/android/gldrawable/api/IFactoryStub;", "()V", "fromBundle", "Lcom/tencent/android/gldrawable/api/IGLDrawable;", "bundle", "Landroid/os/Bundle;", "fromFile", "file", "Ljava/io/File;", "setWorkHandler", "handler", "Landroid/os/Handler;", "useCache", "b", "", "fake_release"}, k=1, mv={1, 1, 16})
public final class FactoryStubImpl
  implements IFactoryStub
{
  @Nullable
  public IGLDrawable fromBundle(@NotNull Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "bundle");
    return null;
  }
  
  @Nullable
  public IGLDrawable fromFile(@NotNull File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "file");
    return null;
  }
  
  @NotNull
  public IFactoryStub setWorkHandler(@Nullable Handler paramHandler)
  {
    return (IFactoryStub)this;
  }
  
  @NotNull
  public IFactoryStub useCache(boolean paramBoolean)
  {
    return (IFactoryStub)this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.FactoryStubImpl
 * JD-Core Version:    0.7.0.1
 */