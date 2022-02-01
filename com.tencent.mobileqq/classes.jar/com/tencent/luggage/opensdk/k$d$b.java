package com.tencent.luggage.opensdk;

import android.graphics.Bitmap;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/opensdk/QRCodeDisplayDialog$ShareAppMessageLayoutFactory$ThumbImageTransformation;", "Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$IBitmapTransformation;", "()V", "key", "", "transform", "Landroid/graphics/Bitmap;", "bitmap", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class k$d$b
  implements AppBrandSimpleImageLoader.h
{
  public static final b a = new b();
  
  @NotNull
  public Bitmap a(@NotNull Bitmap paramBitmap)
  {
    Intrinsics.checkParameterIsNotNull(paramBitmap, "bitmap");
    int i = Math.min(paramBitmap.getWidth(), paramBitmap.getHeight());
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, i);
    if ((Intrinsics.areEqual(localBitmap, paramBitmap) ^ true)) {}
    try
    {
      paramBitmap.recycle();
      label41:
      Intrinsics.checkExpressionValueIsNotNull(localBitmap, "Bitmap.createBitmap(bitm…      }\n                }");
      return localBitmap;
    }
    catch (Exception paramBitmap)
    {
      break label41;
    }
  }
  
  @NotNull
  public String a()
  {
    return "QRCodeDisplayDialog.ShareAppMessageLayoutFactory.ThumbImageTransformation";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.k.d.b
 * JD-Core Version:    0.7.0.1
 */