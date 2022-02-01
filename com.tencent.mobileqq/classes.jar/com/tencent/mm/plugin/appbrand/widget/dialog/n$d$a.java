package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.luggage.wxa.qx.a;
import com.tencent.luggage.wxa.qz.b;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ViewHolder$applyData$1", "Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$IBitmapTransformation;", "key", "", "transform", "Landroid/graphics/Bitmap;", "bitmap", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class n$d$a
  implements AppBrandSimpleImageLoader.h
{
  @NotNull
  public Bitmap a(@NotNull Bitmap paramBitmap)
  {
    Intrinsics.checkParameterIsNotNull(paramBitmap, "bitmap");
    paramBitmap = b.a(paramBitmap, false, a.e(this.a.a().getContext(), 4) * 1.0F, false);
    Intrinsics.checkExpressionValueIsNotNull(paramBitmap, "BitmapUtil.getRoundedCor…ontext, 4) * 1.0f, false)");
    return paramBitmap;
  }
  
  @NotNull
  public String a()
  {
    return "appbrand_user_avatar";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.n.d.a
 * JD-Core Version:    0.7.0.1
 */