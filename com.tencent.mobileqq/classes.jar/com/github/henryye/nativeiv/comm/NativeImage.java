package com.github.henryye.nativeiv.comm;

import android.graphics.Rect;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.github.henryye.nativeiv.bitmap.c;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

@Keep
class NativeImage
  implements IBitmap<NativeBitmapStruct>
{
  private static final String TAG = "Ni.NativeImage";
  private b factory;
  private NativeImageJni jni;
  private long lastDecodeUsing = -1L;
  private NativeBitmapStruct mNativeBitmapStruct = null;
  
  public NativeImage(NativeImageJni paramNativeImageJni, b paramb)
  {
    this.jni = paramNativeImageJni;
    this.factory = paramb;
    try
    {
      paramb.a(this);
      return;
    }
    finally {}
  }
  
  public void decodeInputStream(InputStream paramInputStream, ImageDecodeConfig paramImageDecodeConfig, c paramc)
  {
    long l;
    try
    {
      paramc = this.factory;
      if (paramc == null) {
        return;
      }
      l = com.tencent.luggage.wxa.e.b.a();
      if (paramInputStream == null)
      {
        com.tencent.luggage.wxa.c.b.c("Ni.NativeImage", "hy: non stream, mark as request clear", new Object[0]);
        recycle();
      }
      paramInputStream = com.tencent.luggage.wxa.e.a.a(paramInputStream, false);
      int i = a.a(paramImageDecodeConfig.mConfig);
      if (paramInputStream != null) {}
      try
      {
        paramImageDecodeConfig = this.jni.a(paramInputStream, i, paramImageDecodeConfig.mPremultiplyAlpha);
        if (paramImageDecodeConfig != null) {
          this.mNativeBitmapStruct = paramImageDecodeConfig.convertToCommonStruct();
        } else {
          com.tencent.luggage.wxa.c.b.d("Ni.NativeImage", "hy: decode failed!!", new Object[0]);
        }
        paramInputStream.clear();
        this.lastDecodeUsing = com.tencent.luggage.wxa.e.b.a(l);
        return;
      }
      finally
      {
        this.lastDecodeUsing = com.tencent.luggage.wxa.e.b.a(l);
      }
      com.tencent.luggage.wxa.c.b.c("Ni.NativeImage", "hy: decode error!", new Object[0]);
      recycle();
      throw new IOException("decode error!");
    }
    finally {}
  }
  
  public void decodeInputStreamRegion(InputStream paramInputStream, Rect paramRect, ImageDecodeConfig paramImageDecodeConfig, c paramc)
  {
    throw new IOException("Stub!");
  }
  
  @NonNull
  public com.github.henryye.nativeiv.bitmap.a<Integer> dump()
  {
    try
    {
      com.github.henryye.nativeiv.bitmap.a locala = new com.github.henryye.nativeiv.bitmap.a();
      if (this.mNativeBitmapStruct != null)
      {
        locala.a = this.mNativeBitmapStruct.width;
        locala.b = this.mNativeBitmapStruct.height;
        locala.c = true;
        locala.d = Integer.valueOf(this.mNativeBitmapStruct.glFormat);
        locala.e = this.lastDecodeUsing;
      }
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void forceSet(NativeBitmapStruct paramNativeBitmapStruct)
  {
    this.mNativeBitmapStruct = paramNativeBitmapStruct;
  }
  
  public long getDecodeTime()
  {
    return this.lastDecodeUsing;
  }
  
  @Keep
  public BitmapType getType()
  {
    return BitmapType.Native;
  }
  
  @Keep
  @Nullable
  public NativeBitmapStruct provide()
  {
    return this.mNativeBitmapStruct;
  }
  
  @Keep
  public void recycle()
  {
    try
    {
      if ((this.mNativeBitmapStruct != null) && (this.mNativeBitmapStruct.ptr != -1L))
      {
        this.jni.a(this.mNativeBitmapStruct.ptr);
        this.mNativeBitmapStruct = null;
      }
      if (this.factory != null)
      {
        this.factory.b(this);
        this.factory = null;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.github.henryye.nativeiv.comm.NativeImage
 * JD-Core Version:    0.7.0.1
 */