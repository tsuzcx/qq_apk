package com.tencent.component.media.image.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.component.media.annotation.Public;

@Public
public abstract class DrawableContainer
  extends Drawable
  implements Drawable.Callback
{
  private boolean mMutated;
  private DrawableContainer.ContainerState mState;
  
  public void draw(Canvas paramCanvas)
  {
    this.mState.mDrawable.draw(paramCanvas);
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.mState.mChangingConfigurations | this.mState.mDrawable.getChangingConfigurations();
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if (this.mState.canConstantState())
    {
      this.mState.mChangingConfigurations = getChangingConfigurations();
      return this.mState;
    }
    return null;
  }
  
  public Drawable getDrawable()
  {
    return this.mState.mDrawable;
  }
  
  public int getIntrinsicHeight()
  {
    return this.mState.mDrawable.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return this.mState.mDrawable.getIntrinsicWidth();
  }
  
  public int getMinimumHeight()
  {
    if (this.mState.mDrawable != null) {
      return this.mState.mDrawable.getMinimumHeight();
    }
    return 0;
  }
  
  public int getMinimumWidth()
  {
    if (this.mState.mDrawable != null) {
      return this.mState.mDrawable.getMinimumWidth();
    }
    return 0;
  }
  
  public int getOpacity()
  {
    return this.mState.mDrawable.getOpacity();
  }
  
  public boolean getPadding(Rect paramRect)
  {
    return this.mState.mDrawable.getPadding(paramRect);
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidateSelf();
  }
  
  public boolean isStateful()
  {
    return this.mState.mDrawable.isStateful();
  }
  
  public Drawable mutate()
  {
    if ((!this.mMutated) && (super.mutate() == this))
    {
      this.mState.mDrawable.mutate();
      this.mMutated = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.mState.mDrawable.setBounds(paramRect);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    this.mState.mDrawable.setLevel(paramInt);
    invalidateSelf();
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool = this.mState.mDrawable.setState(paramArrayOfInt);
    onBoundsChange(getBounds());
    return bool;
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    this.mState.mDrawable.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mState.mDrawable.setColorFilter(paramColorFilter);
  }
  
  @Public
  protected void setConstantState(DrawableContainer.ContainerState paramContainerState)
  {
    this.mState = paramContainerState;
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mState.mDrawable.setDither(paramBoolean);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    this.mState.mDrawable.setVisible(paramBoolean1, paramBoolean2);
    return bool;
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    unscheduleSelf(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.DrawableContainer
 * JD-Core Version:    0.7.0.1
 */