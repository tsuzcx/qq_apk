package com.tencent.component.media.image.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class ScaleDrawable$ScaleState
  extends DrawableContainer.ContainerState
{
  ScaleDrawable$ScaleState(Drawable paramDrawable, ScaleDrawable paramScaleDrawable)
  {
    super(paramDrawable, paramScaleDrawable);
  }
  
  ScaleDrawable$ScaleState(ScaleState paramScaleState, ScaleDrawable paramScaleDrawable, Resources paramResources)
  {
    super(paramScaleState, paramScaleDrawable, paramResources);
  }
  
  public Drawable newDrawable()
  {
    return new ScaleDrawable(this, null, null);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new ScaleDrawable(this, paramResources, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.ScaleDrawable.ScaleState
 * JD-Core Version:    0.7.0.1
 */