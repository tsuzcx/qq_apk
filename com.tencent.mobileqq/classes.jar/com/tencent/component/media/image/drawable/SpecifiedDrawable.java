package com.tencent.component.media.image.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.annotation.Public;

@Public
public class SpecifiedDrawable
  extends DrawableContainer
{
  private SpecifiedDrawable.SpecificState mState;
  
  @Public
  public SpecifiedDrawable(Drawable paramDrawable)
  {
    this(paramDrawable, -1, -1);
  }
  
  @Public
  public SpecifiedDrawable(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    this.mState = new SpecifiedDrawable.SpecificState(paramDrawable, this);
    this.mState.mWidth = paramInt1;
    this.mState.mHeight = paramInt2;
    setConstantState(this.mState);
  }
  
  private SpecifiedDrawable(SpecifiedDrawable.SpecificState paramSpecificState, Resources paramResources)
  {
    this.mState = new SpecifiedDrawable.SpecificState(paramSpecificState, this, paramResources);
    setConstantState(this.mState);
  }
  
  public int getIntrinsicHeight()
  {
    int i = this.mState.mHeight;
    if (i > 0) {
      return i;
    }
    return super.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    int i = this.mState.mWidth;
    if (i > 0) {
      return i;
    }
    return super.getIntrinsicWidth();
  }
  
  public int getOrginalWidth()
  {
    return super.getIntrinsicWidth();
  }
  
  public int getOriginalHeight()
  {
    return super.getIntrinsicHeight();
  }
  
  @Public
  public void resize(int paramInt1, int paramInt2)
  {
    if ((this.mState.mWidth != paramInt1) || (this.mState.mHeight != paramInt2))
    {
      this.mState.mWidth = paramInt1;
      this.mState.mHeight = paramInt2;
      invalidateSelf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.SpecifiedDrawable
 * JD-Core Version:    0.7.0.1
 */