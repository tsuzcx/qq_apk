package com.github.henryye.nativeiv.api;

import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.tencent.luggage.wxa.d.d;

public abstract interface IImageDecodeService$a
{
  public abstract IBitmap a(String paramString, Object paramObject, d paramd, ImageDecodeConfig paramImageDecodeConfig);
  
  public abstract void a();
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(IImageDecodeService.b paramb);
  
  public abstract void a(BitmapType paramBitmapType);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.github.henryye.nativeiv.api.IImageDecodeService.a
 * JD-Core Version:    0.7.0.1
 */