package com.tencent.crossengine.log;

import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/crossengine/log/Logger;", "", "()V", "<set-?>", "Lcom/tencent/crossengine/log/LogDelegate;", "delegate", "getDelegate", "()Lcom/tencent/crossengine/log/LogDelegate;", "d", "", "tag", "", "message", "throwable", "", "e", "i", "init", "v", "w", "library_release"}, k=1, mv={1, 1, 16})
public final class Logger
{
  public static final Logger a = new Logger();
  @NotNull
  private static LogDelegate b;
  
  @JvmStatic
  @JvmOverloads
  public static final void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    a(paramString1, paramString2, null, 4, null);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void a(@NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "message");
    LogDelegate localLogDelegate = b;
    if (localLogDelegate == null) {
      Intrinsics.throwUninitializedPropertyAccessException("delegate");
    }
    localLogDelegate.a(LogDelegate.Level.DEBUG, paramString1, paramString2, paramThrowable);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void b(@NotNull String paramString1, @NotNull String paramString2)
  {
    b(paramString1, paramString2, null, 4, null);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void b(@NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "message");
    LogDelegate localLogDelegate = b;
    if (localLogDelegate == null) {
      Intrinsics.throwUninitializedPropertyAccessException("delegate");
    }
    localLogDelegate.a(LogDelegate.Level.INFO, paramString1, paramString2, paramThrowable);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void c(@NotNull String paramString1, @NotNull String paramString2)
  {
    c(paramString1, paramString2, null, 4, null);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void c(@NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "message");
    LogDelegate localLogDelegate = b;
    if (localLogDelegate == null) {
      Intrinsics.throwUninitializedPropertyAccessException("delegate");
    }
    localLogDelegate.a(LogDelegate.Level.WARN, paramString1, paramString2, paramThrowable);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void d(@NotNull String paramString1, @NotNull String paramString2)
  {
    d(paramString1, paramString2, null, 4, null);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void d(@NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "message");
    LogDelegate localLogDelegate = b;
    if (localLogDelegate == null) {
      Intrinsics.throwUninitializedPropertyAccessException("delegate");
    }
    localLogDelegate.a(LogDelegate.Level.ERROR, paramString1, paramString2, paramThrowable);
  }
  
  public final void a(@NotNull LogDelegate paramLogDelegate)
  {
    Intrinsics.checkParameterIsNotNull(paramLogDelegate, "delegate");
    b = paramLogDelegate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.crossengine.log.Logger
 * JD-Core Version:    0.7.0.1
 */