package com.tencent.component.media.image.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class SpecifiedDrawable$SpecificState
  extends DrawableContainer.ContainerState
{
  int mHeight;
  int mWidth;
  
  SpecifiedDrawable$SpecificState(Drawable paramDrawable, DrawableContainer paramDrawableContainer)
  {
    super(paramDrawable, paramDrawableContainer);
  }
  
  SpecifiedDrawable$SpecificState(SpecificState paramSpecificState, DrawableContainer paramDrawableContainer, Resources paramResources)
  {
    super(paramSpecificState, paramDrawableContainer, paramResources);
    this.mWidth = paramSpecificState.mWidth;
    this.mHeight = paramSpecificState.mHeight;
  }
  
  public Drawable newDrawable()
  {
    return new SpecifiedDrawable(this, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.SpecifiedDrawable.SpecificState
 * JD-Core Version:    0.7.0.1
 */