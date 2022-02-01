package com.tencent.luggage.util;

import android.content.Context;
import com.tencent.mm.ui.a;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/util/UIUtilsCompat;", "Lcom/tencent/luggage/util/UIUtilsInterface;", "()V", "interfaceImpl", "getInterfaceImpl", "()Lcom/tencent/luggage/util/UIUtilsInterface;", "setInterfaceImpl", "(Lcom/tencent/luggage/util/UIUtilsInterface;)V", "getCutOutHeight", "", "context", "Landroid/content/Context;", "getDarkModeColor", "originalColor", "getStableStatusBarHeight", "hasCutOut", "", "huaweiSpecial", "isDarkMode", "isHuaweiFold", "wechat-ui-sdk_release"}, k=1, mv={1, 1, 16})
public final class k
  implements l
{
  public static final k a = new k();
  @Nullable
  private static l b;
  
  public int a(int paramInt)
  {
    l locall = b;
    int i = paramInt;
    if (locall != null) {
      i = locall.a(paramInt);
    }
    return i;
  }
  
  public int a(@Nullable Context paramContext)
  {
    if (paramContext != null)
    {
      l locall = b;
      if (locall != null) {
        return locall.a(paramContext);
      }
      return ((Number)((Function0)new k.a(paramContext)).invoke()).intValue();
    }
    return 0;
  }
  
  public boolean a()
  {
    l locall = b;
    if (locall != null) {
      return locall.a();
    }
    return false;
  }
  
  public boolean b()
  {
    l locall = b;
    if (locall != null) {
      return locall.b();
    }
    return false;
  }
  
  public boolean b(@Nullable Context paramContext)
  {
    if (paramContext != null)
    {
      l locall = b;
      if (locall != null) {
        return locall.b(paramContext);
      }
      return ((Boolean)((Function0)new k.b(paramContext)).invoke()).booleanValue();
    }
    return false;
  }
  
  public int c(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    l locall = b;
    if (locall != null) {
      return locall.c(paramContext);
    }
    return a.a(paramContext, 0);
  }
  
  public boolean c()
  {
    l locall = b;
    if (locall != null) {
      return locall.c();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.util.k
 * JD-Core Version:    0.7.0.1
 */