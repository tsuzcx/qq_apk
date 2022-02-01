package com.qflutter.vistaimage;

import android.graphics.drawable.Drawable;

public abstract interface IRenderer
{
  public abstract void clean();
  
  public abstract void init(RendererParams paramRendererParams);
  
  public abstract void render();
  
  public abstract void updateDrawable(Drawable paramDrawable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.vistaimage.IRenderer
 * JD-Core Version:    0.7.0.1
 */