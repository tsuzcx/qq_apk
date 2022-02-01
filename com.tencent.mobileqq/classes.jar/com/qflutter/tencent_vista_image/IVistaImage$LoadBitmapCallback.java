package com.qflutter.tencent_vista_image;

import android.graphics.Bitmap;

public abstract interface IVistaImage$LoadBitmapCallback
{
  public abstract void onFailed(String paramString1, int paramInt, String paramString2);
  
  public abstract void onLoaded(String paramString, Bitmap paramBitmap, boolean paramBoolean, IRenderer paramIRenderer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.tencent_vista_image.IVistaImage.LoadBitmapCallback
 * JD-Core Version:    0.7.0.1
 */