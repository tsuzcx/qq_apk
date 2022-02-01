package com.github.henryye.nativeiv;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import androidx.annotation.Keep;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.c;
import java.io.InputStream;

public class LegacyBitmap
  implements IBitmap<Bitmap>
{
  private Bitmap a = null;
  private long b = -1L;
  
  private BitmapFactory.Options a(ImageDecodeConfig paramImageDecodeConfig)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = paramImageDecodeConfig.mConfig;
    localOptions.inPremultiplied = paramImageDecodeConfig.mPremultiplyAlpha;
    return localOptions;
  }
  
  protected Bitmap a(InputStream paramInputStream, ImageDecodeConfig paramImageDecodeConfig, c paramc)
  {
    paramImageDecodeConfig = BitmapFactory.decodeStream(paramInputStream, null, a(paramImageDecodeConfig));
    paramInputStream = paramImageDecodeConfig;
    if (paramImageDecodeConfig != null)
    {
      paramInputStream = paramImageDecodeConfig;
      if (paramImageDecodeConfig.getConfig() != Bitmap.Config.ARGB_8888)
      {
        com.tencent.luggage.wxa.c.b.c("Ni.LegacyBitmap", "hy: config not argb-8888", new Object[0]);
        paramInputStream = Bitmap.createBitmap(paramImageDecodeConfig.getWidth(), paramImageDecodeConfig.getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(paramInputStream).drawBitmap(paramImageDecodeConfig, 0.0F, 0.0F, null);
        paramImageDecodeConfig.recycle();
      }
    }
    return paramInputStream;
  }
  
  public void decodeInputStream(InputStream paramInputStream, ImageDecodeConfig paramImageDecodeConfig, c paramc)
  {
    long l = com.tencent.luggage.wxa.e.b.a();
    this.a = a(paramInputStream, paramImageDecodeConfig, paramc);
    this.b = com.tencent.luggage.wxa.e.b.a(l);
  }
  
  public long getDecodeTime()
  {
    return this.b;
  }
  
  @Keep
  public BitmapType getType()
  {
    return BitmapType.Legacy;
  }
  
  @Keep
  public Bitmap provide()
  {
    return this.a;
  }
  
  @Keep
  public void recycle()
  {
    Bitmap localBitmap = this.a;
    if (localBitmap != null) {
      localBitmap.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.github.henryye.nativeiv.LegacyBitmap
 * JD-Core Version:    0.7.0.1
 */