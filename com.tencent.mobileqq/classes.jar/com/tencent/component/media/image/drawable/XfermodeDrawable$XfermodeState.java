package com.tencent.component.media.image.drawable;

import android.content.res.Resources;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;

class XfermodeDrawable$XfermodeState
  extends DrawableContainer.ContainerState
{
  Xfermode mXfermode;
  
  XfermodeDrawable$XfermodeState(Drawable paramDrawable, DrawableContainer paramDrawableContainer, Xfermode paramXfermode)
  {
    super(paramDrawable, paramDrawableContainer);
    this.mXfermode = paramXfermode;
  }
  
  XfermodeDrawable$XfermodeState(XfermodeState paramXfermodeState, DrawableContainer paramDrawableContainer, Resources paramResources)
  {
    super(paramXfermodeState, paramDrawableContainer, paramResources);
    this.mXfermode = paramXfermodeState.mXfermode;
  }
  
  public Drawable newDrawable()
  {
    return new XfermodeDrawable(this, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.XfermodeDrawable.XfermodeState
 * JD-Core Version:    0.7.0.1
 */