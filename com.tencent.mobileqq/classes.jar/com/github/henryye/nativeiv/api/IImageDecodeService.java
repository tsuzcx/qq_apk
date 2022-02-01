package com.github.henryye.nativeiv.api;

import android.graphics.Bitmap;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.tencent.luggage.wxa.c.c.a;
import com.tencent.luggage.wxa.c.c.b;
import com.tencent.luggage.wxa.d.d;

public abstract interface IImageDecodeService
{
  @Keep
  public abstract void addDecodeEventListener(@NonNull IImageDecodeService.b paramb);
  
  @Keep
  public abstract void addImageStreamFetcher(@NonNull d paramd, boolean paramBoolean);
  
  @Keep
  public abstract String encodeToBase64(Bitmap paramBitmap, int paramInt, float paramFloat);
  
  @Keep
  public abstract byte[] encodeToBuffer(Bitmap paramBitmap, int paramInt, float paramFloat);
  
  @Keep
  public abstract void forceSetUseType(BitmapType paramBitmapType);
  
  @Keep
  public abstract Bitmap getBitmap(int paramInt1, int paramInt2);
  
  @Keep
  public abstract void init();
  
  @Keep
  public abstract void loadBitmapAsync(Object paramObject, ImageDecodeConfig paramImageDecodeConfig);
  
  @Keep
  public abstract void loadBitmapAsync(String paramString);
  
  @Keep
  public abstract void loadBitmapAsync(String paramString, ImageDecodeConfig paramImageDecodeConfig);
  
  @Keep
  public abstract IBitmap loadBitmapSync(Object paramObject, ImageDecodeConfig paramImageDecodeConfig);
  
  @Keep
  public abstract IBitmap loadBitmapSync(String paramString);
  
  @Keep
  public abstract IBitmap loadBitmapSync(String paramString, ImageDecodeConfig paramImageDecodeConfig);
  
  @Keep
  public abstract void release();
  
  @Keep
  public abstract void releaseBitmap(Bitmap paramBitmap);
  
  @Keep
  public abstract void removeDecodeEventListener(@NonNull IImageDecodeService.b paramb);
  
  @Keep
  public abstract void removeImageStreamFetcher(@NonNull d paramd, boolean paramBoolean);
  
  @Keep
  public abstract void setBitmapDecodeSlave(IImageDecodeService.a parama);
  
  @Keep
  public abstract void setIdKeyReportDelegate(c.a parama);
  
  @Keep
  public abstract void setKvReportDelegate(c.b paramb);
  
  @Keep
  public abstract void setMaxDecodeDimension(int paramInt1, int paramInt2);
  
  @Keep
  public abstract void setNetworkTimeout(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.github.henryye.nativeiv.api.IImageDecodeService
 * JD-Core Version:    0.7.0.1
 */