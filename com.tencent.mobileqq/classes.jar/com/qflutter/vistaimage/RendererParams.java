package com.qflutter.vistaimage;

import android.graphics.drawable.Drawable;
import android.view.Surface;

public class RendererParams
{
  private Drawable drawable;
  private int fitType;
  private boolean isClipped;
  private double radius;
  private RendererParams.ImageRepeat repeat = RendererParams.ImageRepeat.NO_REPEAT;
  private Surface surface;
  private int viewHeight;
  private int viewWidth;
  
  public Drawable getDrawable()
  {
    return this.drawable;
  }
  
  public int getFitType()
  {
    return this.fitType;
  }
  
  public double getRadius()
  {
    return this.radius;
  }
  
  public RendererParams.ImageRepeat getRepeat()
  {
    return this.repeat;
  }
  
  public Surface getSurface()
  {
    return this.surface;
  }
  
  public int getViewHeight()
  {
    return this.viewHeight;
  }
  
  public int getViewWidth()
  {
    return this.viewWidth;
  }
  
  public boolean isClipped()
  {
    return this.isClipped;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.vistaimage.RendererParams
 * JD-Core Version:    0.7.0.1
 */