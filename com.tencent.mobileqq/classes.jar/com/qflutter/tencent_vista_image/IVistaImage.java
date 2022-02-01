package com.qflutter.tencent_vista_image;

public abstract interface IVistaImage
{
  public abstract void loadBitmap(String paramString, int paramInt1, int paramInt2, int paramInt3, IVistaImage.LoadBitmapCallback paramLoadBitmapCallback);
  
  public abstract void releaseBitmap(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.tencent_vista_image.IVistaImage
 * JD-Core Version:    0.7.0.1
 */