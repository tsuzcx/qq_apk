package com.tencent.biz.pubaccount.readinjoy.common;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/common/RIJNumericUtils;", "", "()V", "getIntValue", "", "str", "", "defaultValue", "putIntToBundleIfNotEmpty", "", "bundle", "Landroid/os/Bundle;", "key", "intStr", "putLongToBundleIfNotEmpty", "longStr", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJNumericUtils
{
  public static final RIJNumericUtils a = new RIJNumericUtils();
  
  @JvmStatic
  public static final int a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "str");
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString) {}
    return paramInt;
  }
  
  @JvmStatic
  public static final void a(@NotNull Bundle paramBundle, @NotNull String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "bundle");
    Intrinsics.checkParameterIsNotNull(paramString1, "key");
    CharSequence localCharSequence = (CharSequence)paramString2;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        paramBundle.putLong(paramString1, Long.parseLong(paramString2));
      }
      return;
    }
  }
  
  @JvmStatic
  public static final void b(@NotNull Bundle paramBundle, @NotNull String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "bundle");
    Intrinsics.checkParameterIsNotNull(paramString1, "key");
    CharSequence localCharSequence = (CharSequence)paramString2;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        paramBundle.putInt(paramString1, Integer.parseInt(paramString2));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.RIJNumericUtils
 * JD-Core Version:    0.7.0.1
 */