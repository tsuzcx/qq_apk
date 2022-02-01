package com.github.henryye.nativeiv;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.github.henryye.nativeiv.api.IImageDecodeService.a;
import com.github.henryye.nativeiv.api.IImageDecodeService.b;
import com.github.henryye.nativeiv.api.IImageDecodeService.b.a;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.tencent.luggage.wxa.d.d.a;
import java.io.InputStream;

public class a
  implements IImageDecodeService.a
{
  private static final String a = "DefaultBitmapDecoder";
  private int b = 2048;
  private int c = 2048;
  private b d = new b();
  private BitmapType e;
  private IImageDecodeService.b f;
  
  public a()
  {
    this.d.a(BitmapType.Native, new com.github.henryye.nativeiv.comm.b());
  }
  
  private com.github.henryye.nativeiv.bitmap.d a(@NonNull c paramc, @Nullable InputStream paramInputStream)
  {
    return paramc.a(paramInputStream);
  }
  
  public IBitmap a(String paramString, Object paramObject, com.tencent.luggage.wxa.d.d paramd, ImageDecodeConfig paramImageDecodeConfig)
  {
    com.github.henryye.nativeiv.api.a locala = new com.github.henryye.nativeiv.api.a();
    locala.a(this.b, this.c);
    locala.b(paramString);
    locala.a(paramd.a());
    paramObject = paramd.a(paramObject, paramImageDecodeConfig);
    if ((paramObject.a != null) && (TextUtils.isEmpty(paramObject.b)))
    {
      paramObject = paramObject.a;
      paramd = a(this.d, locala);
      paramd.a(this.e);
      paramd.a(this.f);
      com.github.henryye.nativeiv.bitmap.d locald = a(paramd, paramObject);
      if (locald == null)
      {
        this.f.a(paramString, IImageDecodeService.b.a.c, locala);
        return null;
      }
      if (locald.a == com.github.henryye.nativeiv.bitmap.c.g)
      {
        this.f.a(paramString, IImageDecodeService.b.a.e, locala);
        return null;
      }
      a(paramd, paramString, paramObject, paramImageDecodeConfig, locald);
      if ((locald.b <= this.b) && (locald.c <= this.c)) {
        return paramd.a();
      }
      this.f.a(paramString, IImageDecodeService.b.a.f, locala);
      return null;
    }
    locala.c(paramObject.b);
    this.f.a(paramString, IImageDecodeService.b.a.b, locala);
    return null;
  }
  
  protected c a(@NonNull b paramb, @NonNull com.github.henryye.nativeiv.api.a parama)
  {
    return new c(paramb, parama);
  }
  
  public void a()
  {
    this.d.a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public void a(IImageDecodeService.b paramb)
  {
    this.f = paramb;
  }
  
  public void a(BitmapType paramBitmapType)
  {
    this.e = paramBitmapType;
  }
  
  protected void a(@NonNull c paramc, String paramString, InputStream paramInputStream, ImageDecodeConfig paramImageDecodeConfig, com.github.henryye.nativeiv.bitmap.d paramd)
  {
    paramc.a(paramString, paramInputStream, paramImageDecodeConfig, paramd.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.github.henryye.nativeiv.a
 * JD-Core Version:    0.7.0.1
 */