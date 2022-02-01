package com.tencent.luggage.opensdk;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import androidx.annotation.Dimension;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jj.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"appname", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "dp2px", "", "Landroid/content/Context;", "dp", "", "iconURL", "luggage-standalone-mode-ext_release"}, k=2, mv={1, 1, 16})
public final class l
{
  private static final int b(@NotNull Context paramContext, @Dimension(unit=0) float paramFloat)
  {
    paramContext = paramContext.getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "this.resources");
    return Math.round(paramFloat * paramContext.getDisplayMetrics().density);
  }
  
  private static final String c(@NotNull d paramd)
  {
    return paramd.B().E;
  }
  
  private static final String d(@NotNull d paramd)
  {
    return paramd.B().F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.l
 * JD-Core Version:    0.7.0.1
 */