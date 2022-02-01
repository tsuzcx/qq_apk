package com.github.henryye.nativeiv;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.github.henryye.nativeiv.api.IImageDecodeService.b;
import com.github.henryye.nativeiv.api.IImageDecodeService.b.a;
import com.github.henryye.nativeiv.api.a;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import java.io.IOException;
import java.io.InputStream;

public class c
{
  private static final Object a = new Object();
  private BitmapType b = null;
  private IBitmap c = new c.a();
  private IImageDecodeService.b d;
  private a e;
  private b f;
  
  public c(b paramb, a parama)
  {
    this.f = paramb;
    this.e = parama;
  }
  
  private void a(BitmapType paramBitmapType, com.github.henryye.nativeiv.bitmap.b paramb)
  {
    synchronized (a)
    {
      if (this.c.getType() == paramBitmapType) {
        b();
      }
      this.f.a(hashCode(), paramBitmapType, paramb);
      return;
    }
  }
  
  private void a(InputStream paramInputStream, ImageDecodeConfig paramImageDecodeConfig, com.github.henryye.nativeiv.bitmap.c paramc)
  {
    if (this.b != null)
    {
      this.c = this.f.a(hashCode(), this.b);
      return;
    }
    this.c = this.f.a(hashCode(), paramInputStream, paramImageDecodeConfig.mConfig, paramc);
  }
  
  public IBitmap a()
  {
    return this.c;
  }
  
  public com.github.henryye.nativeiv.bitmap.d a(@Nullable InputStream paramInputStream)
  {
    b();
    if (paramInputStream != null) {
      return b(paramInputStream);
    }
    return null;
  }
  
  public void a(IImageDecodeService.b paramb)
  {
    this.d = paramb;
  }
  
  public void a(BitmapType paramBitmapType)
  {
    this.b = paramBitmapType;
  }
  
  public void a(@NonNull com.github.henryye.nativeiv.bitmap.b<Bitmap> paramb)
  {
    a(BitmapType.Legacy, paramb);
  }
  
  public void a(String paramString, @Nullable InputStream paramInputStream, @Nullable ImageDecodeConfig paramImageDecodeConfig, com.github.henryye.nativeiv.bitmap.c paramc)
  {
    if (paramInputStream != null)
    {
      a(paramInputStream, paramImageDecodeConfig, paramc);
      int j = 1;
      int i = 1;
      try
      {
        this.c.decodeInputStream(paramInputStream, paramImageDecodeConfig, paramc);
        Object localObject = this.c.provide();
        if (localObject == null) {
          i = 0;
        }
        k = 0;
        j = i;
      }
      catch (Throwable localThrowable)
      {
        com.tencent.luggage.wxa.c.b.a("Ni.BitmapWrapper", localThrowable, "hy: decode image exception", new Object[0]);
        this.d.a(paramString, IImageDecodeService.b.a.k, this.e);
        i = 0;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        com.tencent.luggage.wxa.c.b.a("Ni.BitmapWrapper", localOutOfMemoryError, "hy: decodeInputStream", new Object[0]);
        this.d.a(paramString, IImageDecodeService.b.a.h, this.e);
        i = j;
      }
      catch (IOException localIOException1)
      {
        com.tencent.luggage.wxa.c.b.a("Ni.BitmapWrapper", localIOException1, "hy: decodeInputStream", new Object[0]);
        this.d.a(paramString, IImageDecodeService.b.a.g, this.e);
        i = j;
      }
      j = 0;
      int k = i;
      if (k != 0)
      {
        com.tencent.luggage.wxa.e.b.a(paramInputStream);
        return;
      }
      long l = 0L;
      try
      {
        i = paramInputStream.available();
        l = i;
      }
      catch (IllegalStateException localIllegalStateException) {}catch (IOException localIOException2) {}
      com.tencent.luggage.wxa.c.b.a("Ni.BitmapWrapper", localIOException2, "hy: get stream len failed!", new Object[0]);
      if ((j == 0) && (this.c.getType() == BitmapType.Native))
      {
        com.tencent.luggage.wxa.c.b.b("Ni.BitmapWrapper", "hy: decode switch to legacy mode!", new Object[0]);
        this.c = this.f.b();
        try
        {
          this.c.decodeInputStream(paramInputStream, paramImageDecodeConfig, paramc);
        }
        catch (Throwable paramImageDecodeConfig)
        {
          com.tencent.luggage.wxa.c.b.a("Ni.BitmapWrapper", paramImageDecodeConfig, "hy: decode image exception", new Object[0]);
          this.d.a(paramString, IImageDecodeService.b.a.k, this.e);
        }
        catch (OutOfMemoryError paramImageDecodeConfig)
        {
          com.tencent.luggage.wxa.c.b.a("Ni.BitmapWrapper", paramImageDecodeConfig, "hy: decodeInputStream", new Object[0]);
          this.d.a(paramString, IImageDecodeService.b.a.h, this.e);
        }
        catch (IOException paramImageDecodeConfig)
        {
          com.tencent.luggage.wxa.c.b.a("Ni.BitmapWrapper", paramImageDecodeConfig, "hy: IOException when use legacy", new Object[0]);
          this.d.a(paramString, IImageDecodeService.b.a.g, this.e);
        }
      }
      this.e.a(l);
      this.e.b(this.c.getDecodeTime());
      this.d.a(paramString, IImageDecodeService.b.a.a, this.e);
      if (this.c.getType() == BitmapType.Legacy) {
        this.d.a(paramString, IImageDecodeService.b.a.i, this.e);
      }
      if (this.c.provide() == null)
      {
        this.c.recycle();
        this.c = null;
      }
      com.tencent.luggage.wxa.e.b.a(paramInputStream);
    }
  }
  
  protected com.github.henryye.nativeiv.bitmap.d b(@NonNull InputStream paramInputStream)
  {
    return com.tencent.luggage.wxa.e.d.a(paramInputStream);
  }
  
  public void b()
  {
    IBitmap localIBitmap = this.c;
    if (localIBitmap != null) {
      localIBitmap.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.github.henryye.nativeiv.c
 * JD-Core Version:    0.7.0.1
 */