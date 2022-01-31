package com.tencent.component.media.image.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

abstract class DrawableContainer$ContainerState
  extends Drawable.ConstantState
{
  private boolean mCanConstantState;
  int mChangingConfigurations;
  private boolean mCheckedConstantState;
  Drawable mDrawable;
  
  DrawableContainer$ContainerState(Drawable paramDrawable, DrawableContainer paramDrawableContainer)
  {
    this.mDrawable = paramDrawable;
    this.mDrawable.setCallback(paramDrawableContainer);
  }
  
  DrawableContainer$ContainerState(ContainerState paramContainerState, DrawableContainer paramDrawableContainer, Resources paramResources)
  {
    if ((paramContainerState != null) && (paramContainerState.mDrawable != null) && (paramContainerState.mDrawable.getConstantState() != null)) {
      if (paramResources == null) {
        break label63;
      }
    }
    label63:
    for (this.mDrawable = paramContainerState.mDrawable.getConstantState().newDrawable(paramResources);; this.mDrawable = paramContainerState.mDrawable.getConstantState().newDrawable())
    {
      this.mDrawable.setCallback(paramDrawableContainer);
      this.mCanConstantState = true;
      this.mCheckedConstantState = true;
      return;
    }
  }
  
  boolean canConstantState()
  {
    if (!this.mCheckedConstantState) {
      if (this.mDrawable.getConstantState() == null) {
        break label34;
      }
    }
    label34:
    for (boolean bool = true;; bool = false)
    {
      this.mCanConstantState = bool;
      this.mCheckedConstantState = true;
      return this.mCanConstantState;
    }
  }
  
  public int getChangingConfigurations()
  {
    return this.mChangingConfigurations;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.DrawableContainer.ContainerState
 * JD-Core Version:    0.7.0.1
 */