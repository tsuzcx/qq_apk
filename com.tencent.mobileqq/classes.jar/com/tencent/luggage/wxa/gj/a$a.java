package com.tencent.luggage.wxa.gj;

import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.d;
import com.tencent.luggage.wxa.a.h;
import com.tencent.luggage.wxa.a.k;
import com.tencent.luggage.wxa.gi.c.c;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/magicbrush/image/BitmapDecoderMagicBrushExtension$createBitmapWrapper$1", "Lcom/github/henryye/nativeiv/BitmapWrapper;", "getPreferredSizeByConfig", "Lkotlin/Pair;", "", "config", "Lcom/github/henryye/nativeiv/ImageDecodeConfig;", "providePictureInfo", "Lcom/github/henryye/nativeiv/bitmap/PictureInfo;", "ins", "Ljava/io/InputStream;", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 13})
public final class a$a
  extends com.github.henryye.nativeiv.c
{
  a$a(com.github.henryye.nativeiv.b paramb1, com.github.henryye.nativeiv.api.a parama1, com.github.henryye.nativeiv.b paramb2, com.github.henryye.nativeiv.api.a parama2)
  {
    super(parama2, locala);
  }
  
  private final Pair<Integer, Integer> a(ImageDecodeConfig paramImageDecodeConfig)
  {
    String str = a.a(this.a);
    int j = paramImageDecodeConfig.mPreferredWidth;
    int i = 0;
    c.c.a(str, "hy: image config width %d, height %d, scale %f", new Object[] { Integer.valueOf(j), Integer.valueOf(paramImageDecodeConfig.mPreferredHeight), Double.valueOf(paramImageDecodeConfig.mPreferredScale) });
    if ((paramImageDecodeConfig.mPreferredWidth > 0) && (paramImageDecodeConfig.mPreferredHeight > 0))
    {
      i = paramImageDecodeConfig.mPreferredWidth;
      j = paramImageDecodeConfig.mPreferredHeight;
    }
    else
    {
      double d2 = paramImageDecodeConfig.mPreferredScale;
      double d1 = 0;
      if (d2 > d1)
      {
        d2 = paramImageDecodeConfig.mPreferredScale;
        Double.isNaN(d1);
        i = (int)(d2 * d1);
        d2 = paramImageDecodeConfig.mPreferredScale;
        Double.isNaN(d1);
        j = (int)(d1 * d2);
      }
      else
      {
        j = 0;
      }
    }
    return new Pair(Integer.valueOf(i), Integer.valueOf(j));
  }
  
  @NotNull
  protected d b(@NotNull InputStream paramInputStream)
  {
    Intrinsics.checkParameterIsNotNull(paramInputStream, "ins");
    d locald = super.b(paramInputStream);
    if (locald.a == com.github.henryye.nativeiv.bitmap.c.g)
    {
      com.tencent.luggage.wxa.c.b.c(a.a(this.a), "hy: unknown type. judge svg", new Object[0]);
      try
      {
        paramInputStream = h.a(paramInputStream);
        if (paramInputStream != null)
        {
          locald.a = com.github.henryye.nativeiv.bitmap.c.f;
          a(BitmapType.Legacy);
          a((com.github.henryye.nativeiv.bitmap.b)new a.a.a(this, paramInputStream));
        }
      }
      catch (k paramInputStream)
      {
        com.tencent.luggage.wxa.c.b.a(a.a(this.a), (Throwable)paramInputStream, "hy: not svg image. return as failed", new Object[0]);
        locald.a = com.github.henryye.nativeiv.bitmap.c.g;
      }
    }
    Intrinsics.checkExpressionValueIsNotNull(locald, "info");
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gj.a.a
 * JD-Core Version:    0.7.0.1
 */