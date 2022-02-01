package com.tencent.luggage.wxa.gj;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.RectF;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.LegacyBitmap;
import com.github.henryye.nativeiv.bitmap.c;
import com.tencent.luggage.wxa.a.h;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/magicbrush/image/BitmapDecoderMagicBrushExtension$createBitmapWrapper$1$providePictureInfo$1$produceBitmap$1", "Lcom/github/henryye/nativeiv/LegacyBitmap;", "decodeInputStreamImp", "Landroid/graphics/Bitmap;", "ins", "Ljava/io/InputStream;", "config", "Lcom/github/henryye/nativeiv/ImageDecodeConfig;", "format", "Lcom/github/henryye/nativeiv/bitmap/PictureFormat;", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 13})
public final class a$a$a$a
  extends LegacyBitmap
{
  @NotNull
  protected Bitmap a(@Nullable InputStream paramInputStream, @Nullable ImageDecodeConfig paramImageDecodeConfig, @Nullable c paramc)
  {
    int k = (int)this.a.b.b();
    int m = (int)this.a.b.c();
    if ((paramc == c.f) && (k > 0) && (k > 0))
    {
      int j = k;
      int i = m;
      if (paramImageDecodeConfig != null)
      {
        paramInputStream = a.a.a(this.a.a, paramImageDecodeConfig);
        j = k;
        i = m;
        if (((Number)paramInputStream.getFirst()).intValue() > 0)
        {
          j = k;
          i = m;
          if (((Number)paramInputStream.getSecond()).intValue() > 0)
          {
            j = ((Number)paramInputStream.getFirst()).intValue();
            i = ((Number)paramInputStream.getSecond()).intValue();
          }
        }
      }
      paramInputStream = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
      new Canvas(paramInputStream).drawPicture(this.a.b.a(), new RectF(0.0F, 0.0F, j, i));
      Intrinsics.checkExpressionValueIsNotNull(paramInputStream, "bitmap");
      return paramInputStream;
    }
    paramInputStream = super.a(paramInputStream, paramImageDecodeConfig, paramc);
    Intrinsics.checkExpressionValueIsNotNull(paramInputStream, "super.decodeInputStreamImp(ins, config, format)");
    return paramInputStream;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gj.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */