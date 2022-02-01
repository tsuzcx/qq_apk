package com.tencent.luggage.wxa.gk;

import android.os.SystemClock;
import com.tencent.luggage.wxa.c.b;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/utils/Util;", "", "()V", "TAG", "", "currentTicks", "", "format", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "isNullOrNil", "", "str", "loadLibrary", "", "libName", "loader", "Ljava/lang/ClassLoader;", "nullAsNil", "qualityClose", "c", "Ljava/io/Closeable;", "quietlyClose", "closeable", "ticksToNow", "tick", "forEachCopyOnWrite", "T", "", "action", "Lkotlin/Function1;", "lock", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 13})
public final class h
{
  public static final h a = new h();
  
  @JvmStatic
  public static final long a()
  {
    return SystemClock.elapsedRealtime();
  }
  
  @JvmStatic
  public static final long a(long paramLong)
  {
    return SystemClock.elapsedRealtime() - paramLong;
  }
  
  @JvmStatic
  public static final void a(@NotNull String paramString, @Nullable ClassLoader paramClassLoader)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "libName");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("System.loadLibrary ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(' ');
    localStringBuilder.append(paramClassLoader);
    b.a("MagicBrush.Util", localStringBuilder.toString(), new Object[0]);
    System.loadLibrary(paramString);
  }
  
  @JvmStatic
  public static final boolean a(@Nullable String paramString)
  {
    return (paramString == null) || (Intrinsics.areEqual("", paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gk.h
 * JD-Core Version:    0.7.0.1
 */