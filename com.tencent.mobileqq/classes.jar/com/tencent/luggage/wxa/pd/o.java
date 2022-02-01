package com.tencent.luggage.wxa.pd;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/utils/LuggageLargeScreenUtil;", "", "()V", "isLargeScreenWindow", "", "ctx", "Landroid/content/Context;", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public final class o
{
  public static final o a = new o();
  
  @JvmStatic
  public static final boolean a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "ctx");
    Object localObject = paramContext.getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ctx.resources");
    localObject = ((Resources)localObject).getDisplayMetrics();
    double d = Math.sqrt(Math.pow(((DisplayMetrics)localObject).widthPixels / ((DisplayMetrics)localObject).xdpi, 2.0D) + Math.pow(((DisplayMetrics)localObject).heightPixels / ((DisplayMetrics)localObject).ydpi, 2.0D));
    paramContext = paramContext.getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "ctx.resources");
    return ((paramContext.getConfiguration().screenLayout & 0xF) >= 3) && (d >= 7.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pd.o
 * JD-Core Version:    0.7.0.1
 */