package com.tencent.luggage.wxa.en;

import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/standalone_ext/boost/V8CodeCacheDirectory;", "", "()V", "PATH", "", "getPATH", "()Ljava/lang/String;", "PATH$delegate", "Lkotlin/Lazy;", "getAbsolutePath", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class c
{
  public static final c a = new c();
  private static final Lazy b = LazyKt.lazy((Function0)c.a.a);
  
  private final String b()
  {
    return (String)b.getValue();
  }
  
  @NotNull
  public final String a()
  {
    Object localObject = new File(b());
    ((File)localObject).mkdirs();
    localObject = ((File)localObject).getAbsolutePath();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "File(PATH).apply { mkdirs() }.absolutePath");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.en.c
 * JD-Core Version:    0.7.0.1
 */