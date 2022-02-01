package com.tencent.android.gldrawable.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/android/gldrawable/api/IConfigStub;", "", "deleteCacheFiles", "", "disable", "init", "isEnable", "", "log", "msg", "", "e", "", "setDebugGL", "isDebug", "setFpsLimit", "limit", "", "setLogger", "logger", "Lcom/tencent/android/gldrawable/api/IReporter;", "api_release"}, k=1, mv={1, 1, 16})
public abstract interface IConfigStub
{
  public abstract void deleteCacheFiles();
  
  public abstract void disable();
  
  public abstract void init();
  
  public abstract boolean isEnable();
  
  public abstract void log(@NotNull String paramString, @Nullable Throwable paramThrowable);
  
  public abstract void setDebugGL(boolean paramBoolean);
  
  public abstract void setFpsLimit(int paramInt);
  
  public abstract void setLogger(@Nullable IReporter paramIReporter);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.IConfigStub
 * JD-Core Version:    0.7.0.1
 */