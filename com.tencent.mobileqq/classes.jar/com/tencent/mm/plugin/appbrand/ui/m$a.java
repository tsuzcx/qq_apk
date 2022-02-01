package com.tencent.mm.plugin.appbrand.ui;

import android.content.res.Configuration;
import android.util.DisplayMetrics;
import com.tencent.mm.ui.base.k.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/util/DisplayMetrics;", "originalMetrics", "<anonymous parameter 1>", "Landroid/content/res/Configuration;", "applyScreenAdaptiveDensity"}, k=3, mv={1, 1, 16})
final class m$a
  implements k.a
{
  public static final a a = new a();
  
  @NotNull
  public final DisplayMetrics a(@NotNull DisplayMetrics paramDisplayMetrics, @NotNull Configuration paramConfiguration)
  {
    Intrinsics.checkParameterIsNotNull(paramDisplayMetrics, "originalMetrics");
    Intrinsics.checkParameterIsNotNull(paramConfiguration, "<anonymous parameter 1>");
    return paramDisplayMetrics;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.m.a
 * JD-Core Version:    0.7.0.1
 */