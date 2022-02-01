package com.qflutter.vistaimage;

import android.graphics.drawable.Drawable;
import android.view.Surface;

public abstract interface IRenderer
{
  public abstract void clean();
  
  public abstract void init(Surface paramSurface, Drawable paramDrawable, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3);
  
  public abstract void render();
  
  public abstract void updateDrawable(Drawable paramDrawable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.vistaimage.IRenderer
 * JD-Core Version:    0.7.0.1
 */