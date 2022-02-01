package com.tencent.android.gldrawable;

import android.util.Log;
import com.tencent.android.gldrawable.api.IConfigStub;
import com.tencent.android.gldrawable.api.IReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/android/gldrawable/ConfigStubImpl;", "Lcom/tencent/android/gldrawable/api/IConfigStub;", "()V", "deleteCacheFiles", "", "disable", "init", "isEnable", "", "log", "msg", "", "e", "", "setDebugGL", "isDebug", "setFpsLimit", "limit", "", "setLogger", "logger", "Lcom/tencent/android/gldrawable/api/IReporter;", "fake_release"}, k=1, mv={1, 1, 16})
public final class ConfigStubImpl
  implements IConfigStub
{
  public void deleteCacheFiles() {}
  
  public void disable() {}
  
  public void init() {}
  
  public boolean isEnable()
  {
    return false;
  }
  
  public void log(@NotNull String paramString, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "msg");
    Log.e("GLDrawable", paramString, paramThrowable);
  }
  
  public void setDebugGL(boolean paramBoolean) {}
  
  public void setFpsLimit(int paramInt) {}
  
  public void setLogger(@Nullable IReporter paramIReporter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.ConfigStubImpl
 * JD-Core Version:    0.7.0.1
 */