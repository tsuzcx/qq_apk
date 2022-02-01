package com.tencent.crossengine.log;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/crossengine/log/LogDelegate;", "", "printLog", "", "level", "Lcom/tencent/crossengine/log/LogDelegate$Level;", "tag", "", "message", "throwable", "", "Level", "library_release"}, k=1, mv={1, 1, 16})
public abstract interface LogDelegate
{
  public abstract void a(@NotNull LogDelegate.Level paramLevel, @NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.crossengine.log.LogDelegate
 * JD-Core Version:    0.7.0.1
 */