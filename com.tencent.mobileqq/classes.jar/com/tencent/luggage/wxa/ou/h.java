package com.tencent.luggage.wxa.ou;

import android.content.Context;
import com.tencent.luggage.wxa.lx.f;
import com.tencent.luggage.wxa.lx.f.c;
import com.tencent.luggage.wxa.qz.r;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/report/ReportUtilKt;", "", "()V", "getNetworkTypeForReport", "", "context", "Landroid/content/Context;", "ReportNetworkTypeStrDef", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class h
{
  public static final h a = new h();
  
  @JvmStatic
  @JvmOverloads
  @NotNull
  public static final String a()
  {
    return a(null, 1, null);
  }
  
  @JvmStatic
  @JvmOverloads
  @NotNull
  public static final String a(@Nullable Context paramContext)
  {
    if (paramContext == null) {
      paramContext = r.a();
    }
    paramContext = f.a(paramContext);
    if (i.a[paramContext.ordinal()] != 1)
    {
      paramContext = paramContext.h;
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "type.value");
      return paramContext;
    }
    return h.a.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ou.h
 * JD-Core Version:    0.7.0.1
 */