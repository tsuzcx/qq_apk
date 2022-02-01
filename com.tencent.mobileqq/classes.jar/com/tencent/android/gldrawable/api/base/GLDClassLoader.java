package com.tencent.android.gldrawable.api.base;

import dalvik.system.DexClassLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/android/gldrawable/api/base/GLDClassLoader;", "Ldalvik/system/DexClassLoader;", "dexPath", "", "optimizedDirectory", "libraryPath", "parent", "Ljava/lang/ClassLoader;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V", "loadClass", "Ljava/lang/Class;", "className", "resolve", "", "Companion", "api_release"}, k=1, mv={1, 1, 16})
public final class GLDClassLoader
  extends DexClassLoader
{
  public static final GLDClassLoader.Companion Companion = new GLDClassLoader.Companion(null);
  private static final String HOST_CLASS_START = "com.tencent.android.gldrawable.api.";
  private static final String KTX_CLASS_START = "kotlinx.";
  private static final String MY_CLASS_START = "com.tencent.android.gldrawable.";
  
  public GLDClassLoader(@NotNull String paramString1, @NotNull String paramString2, @Nullable String paramString3, @NotNull ClassLoader paramClassLoader)
  {
    super(paramString1, paramString2, paramString3, paramClassLoader);
  }
  
  @NotNull
  protected Class<?> loadClass(@NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "className");
    if ((!StringsKt.startsWith$default(paramString, "com.tencent.android.gldrawable.", false, 2, null)) && (!StringsKt.startsWith$default(paramString, "kotlinx.", false, 2, null)))
    {
      paramString = super.loadClass(paramString, paramBoolean);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "super.loadClass(className, resolve)");
      return paramString;
    }
    if (StringsKt.startsWith$default(paramString, "com.tencent.android.gldrawable.api.", false, 2, null))
    {
      paramString = super.loadClass(paramString, paramBoolean);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "super.loadClass(className, resolve)");
      return paramString;
    }
    try
    {
      Class localClass = findClass(paramString);
      Intrinsics.checkExpressionValueIsNotNull(localClass, "findClass(className)");
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label86:
      break label86;
    }
    paramString = super.loadClass(paramString, paramBoolean);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "super.loadClass(className, resolve)");
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.base.GLDClassLoader
 * JD-Core Version:    0.7.0.1
 */