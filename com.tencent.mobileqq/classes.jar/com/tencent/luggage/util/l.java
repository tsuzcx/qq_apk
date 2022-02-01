package com.tencent.luggage.util;

import android.content.Context;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/util/UIUtilsInterface;", "", "getCutOutHeight", "", "context", "Landroid/content/Context;", "getDarkModeColor", "originalColor", "getStableStatusBarHeight", "hasCutOut", "", "huaweiSpecial", "isDarkMode", "isHuaweiFold", "wechat-ui-sdk_release"}, k=1, mv={1, 1, 16})
public abstract interface l
{
  public abstract int a(int paramInt);
  
  public abstract int a(@Nullable Context paramContext);
  
  public abstract boolean a();
  
  public abstract boolean b();
  
  public abstract boolean b(@Nullable Context paramContext);
  
  public abstract int c(@NotNull Context paramContext);
  
  public abstract boolean c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.util.l
 * JD-Core Version:    0.7.0.1
 */