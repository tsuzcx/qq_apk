package com.qflutter.tencent_vista_image;

import android.graphics.Bitmap;
import android.view.Surface;

public abstract interface IRenderer
{
  public abstract void clean();
  
  public abstract void init(Surface paramSurface, Bitmap paramBitmap, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3);
  
  public abstract void render();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.tencent_vista_image.IRenderer
 * JD-Core Version:    0.7.0.1
 */