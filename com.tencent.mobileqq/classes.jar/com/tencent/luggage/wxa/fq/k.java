package com.tencent.luggage.wxa.fq;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/WxaAssetsHandleImpl;", "", "()V", "TAG", "", "mAssetManagerHashCode", "", "onHandle", "Landroid/content/res/AssetManager;", "context", "Landroid/content/Context;", "assetManager", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class k
{
  public static final k a = new k();
  private static int b;
  
  @NotNull
  public final AssetManager a(@NotNull Context paramContext, @NotNull AssetManager paramAssetManager)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramAssetManager, "assetManager");
    int i = paramAssetManager.hashCode();
    if (i != b)
    {
      o.d("Luggage.WxaAssetsHandleImpl", "pre init assetsmanager");
      b = i;
      d.a.a(paramContext);
    }
    paramContext = paramContext.getAssets();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context.assets");
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.k
 * JD-Core Version:    0.7.0.1
 */