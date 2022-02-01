package com.tencent.luggage.wxa.fu;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.luggage.wxa.fq.k;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.r.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/content/res/AssetManager;", "manager", "kotlin.jvm.PlatformType", "onHandle"}, k=3, mv={1, 1, 16})
final class h$a
  implements r.a
{
  public static final a a = new a();
  
  @NotNull
  public final AssetManager a(AssetManager paramAssetManager)
  {
    k localk = k.a;
    Context localContext = r.a();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "MMApplicationContext.getContext()");
    Intrinsics.checkExpressionValueIsNotNull(paramAssetManager, "manager");
    return localk.a(localContext, paramAssetManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fu.h.a
 * JD-Core Version:    0.7.0.1
 */