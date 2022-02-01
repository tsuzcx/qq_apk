package com.qflutter.vistaimage;

import android.graphics.drawable.Drawable;
import android.view.Surface;

public final class RendererParams$Builder
{
  Drawable drawable;
  int fitType;
  int fulfilled = 0;
  boolean isClipped;
  double radius;
  RendererParams.ImageRepeat repeat;
  Surface surface;
  int viewHeight;
  int viewWidth;
  
  public static Builder aRendererParams()
  {
    return new Builder();
  }
  
  public RendererParams build()
  {
    if (this.fulfilled == 255)
    {
      localObject = new RendererParams(null);
      RendererParams.access$102((RendererParams)localObject, this.drawable);
      RendererParams.access$202((RendererParams)localObject, this.surface);
      RendererParams.access$302((RendererParams)localObject, this.fitType);
      RendererParams.access$402((RendererParams)localObject, this.viewHeight);
      RendererParams.access$502((RendererParams)localObject, this.isClipped);
      RendererParams.access$602((RendererParams)localObject, this.radius);
      RendererParams.access$702((RendererParams)localObject, this.viewWidth);
      RendererParams.access$802((RendererParams)localObject, this.repeat);
      return localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("not all parameters are set, fulfilled=");
    ((StringBuilder)localObject).append(this.fulfilled);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public Builder withDrawable(Drawable paramDrawable)
  {
    this.drawable = paramDrawable;
    this.fulfilled |= 0x2;
    return this;
  }
  
  public Builder withFitType(int paramInt)
  {
    this.fitType = paramInt;
    this.fulfilled |= 0x4;
    return this;
  }
  
  public Builder withIsClipped(boolean paramBoolean)
  {
    this.isClipped = paramBoolean;
    this.fulfilled |= 0x8;
    return this;
  }
  
  public Builder withRadius(double paramDouble)
  {
    this.radius = paramDouble;
    this.fulfilled |= 0x40;
    return this;
  }
  
  public Builder withRepeat(RendererParams.ImageRepeat paramImageRepeat)
  {
    this.repeat = paramImageRepeat;
    this.fulfilled |= 0x80;
    return this;
  }
  
  public Builder withSurface(Surface paramSurface)
  {
    this.surface = paramSurface;
    this.fulfilled |= 0x1;
    return this;
  }
  
  public Builder withViewHeight(int paramInt)
  {
    this.viewHeight = paramInt;
    this.fulfilled |= 0x20;
    return this;
  }
  
  public Builder withViewWidth(int paramInt)
  {
    this.viewWidth = paramInt;
    this.fulfilled |= 0x10;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.vistaimage.RendererParams.Builder
 * JD-Core Version:    0.7.0.1
 */