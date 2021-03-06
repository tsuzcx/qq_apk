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
    if (paramContainerState != null)
    {
      Drawable localDrawable = paramContainerState.mDrawable;
      if ((localDrawable != null) && (localDrawable.getConstantState() != null))
      {
        if (paramResources != null) {
          this.mDrawable = paramContainerState.mDrawable.getConstantState().newDrawable(paramResources);
        } else {
          this.mDrawable = paramContainerState.mDrawable.getConstantState().newDrawable();
        }
        this.mDrawable.setCallback(paramDrawableContainer);
        this.mCanConstantState = true;
        this.mCheckedConstantState = true;
      }
    }
  }
  
  boolean canConstantState()
  {
    if (!this.mCheckedConstantState)
    {
      boolean bool;
      if (this.mDrawable.getConstantState() != null) {
        bool = true;
      } else {
        bool = false;
      }
      this.mCanConstantState = bool;
      this.mCheckedConstantState = true;
    }
    return this.mCanConstantState;
  }
  
  public int getChangingConfigurations()
  {
    return this.mChangingConfigurations;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.DrawableContainer.ContainerState
 * JD-Core Version:    0.7.0.1
 */