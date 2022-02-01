package com.tencent.luggage.ui;

import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.Display;
import com.tencent.mm.ui.base.k.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/util/DisplayMetrics;", "<anonymous parameter 0>", "<anonymous parameter 1>", "Landroid/content/res/Configuration;", "applyScreenAdaptiveDensity"}, k=3, mv={1, 1, 16})
final class b$1
  implements k.a
{
  b$1(Display paramDisplay) {}
  
  @NotNull
  public final DisplayMetrics a(@NotNull DisplayMetrics paramDisplayMetrics, @NotNull Configuration paramConfiguration)
  {
    Intrinsics.checkParameterIsNotNull(paramDisplayMetrics, "<anonymous parameter 0>");
    Intrinsics.checkParameterIsNotNull(paramConfiguration, "<anonymous parameter 1>");
    paramDisplayMetrics = new DisplayMetrics();
    this.a.getMetrics(paramDisplayMetrics);
    return paramDisplayMetrics;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.b.1
 * JD-Core Version:    0.7.0.1
 */