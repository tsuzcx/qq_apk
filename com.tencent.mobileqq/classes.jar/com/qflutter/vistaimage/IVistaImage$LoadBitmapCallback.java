package com.qflutter.vistaimage;

import android.graphics.drawable.Drawable;

public abstract interface IVistaImage$LoadBitmapCallback
{
  public abstract void onFailed(String paramString1, int paramInt, String paramString2);
  
  public abstract void onLoaded(String paramString, Drawable paramDrawable, boolean paramBoolean, IRenderer paramIRenderer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.vistaimage.IVistaImage.LoadBitmapCallback
 * JD-Core Version:    0.7.0.1
 */