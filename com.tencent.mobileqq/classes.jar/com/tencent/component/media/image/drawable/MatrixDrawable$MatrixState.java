package com.tencent.component.media.image.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class MatrixDrawable$MatrixState
  extends DrawableContainer.ContainerState
{
  MatrixDrawable$MatrixState(Drawable paramDrawable, DrawableContainer paramDrawableContainer)
  {
    super(paramDrawable, paramDrawableContainer);
  }
  
  MatrixDrawable$MatrixState(DrawableContainer.ContainerState paramContainerState, DrawableContainer paramDrawableContainer, Resources paramResources)
  {
    super(paramContainerState, paramDrawableContainer, paramResources);
  }
  
  public Drawable newDrawable()
  {
    return new MatrixDrawable(this, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.MatrixDrawable.MatrixState
 * JD-Core Version:    0.7.0.1
 */