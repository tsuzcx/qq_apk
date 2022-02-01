package com.tencent.hippy.qq.view.tkd.listview;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;

public class TintDrawableWrapper
  extends DrawableWrapper
{
  private int mCurrentColor;
  private int mTint;
  private final PorterDuff.Mode mTintMode;
  private final ColorStateList mTintStateList;
  
  public TintDrawableWrapper(Drawable paramDrawable, int paramInt)
  {
    super(paramDrawable);
    this.mTint = paramInt;
    this.mTintStateList = null;
    this.mTintMode = PorterDuff.Mode.SRC_ATOP;
    super.setColorFilter(this.mTint, this.mTintMode);
  }
  
  public TintDrawableWrapper(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    this(paramDrawable, paramColorStateList, PorterDuff.Mode.SRC_ATOP);
  }
  
  public TintDrawableWrapper(Drawable paramDrawable, ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    super(paramDrawable);
    this.mTintStateList = paramColorStateList;
    this.mTintMode = paramMode;
  }
  
  private boolean updateTint(int[] paramArrayOfInt)
  {
    ColorStateList localColorStateList = this.mTintStateList;
    if (localColorStateList != null)
    {
      int i = localColorStateList.getColorForState(paramArrayOfInt, this.mCurrentColor);
      if (i != this.mCurrentColor)
      {
        if (i != 0) {
          setColorFilter(i, this.mTintMode);
        } else {
          clearColorFilter();
        }
        this.mCurrentColor = i;
        return true;
      }
    }
    return this.mTint != 0;
  }
  
  public void clearColorFilter()
  {
    int i = this.mTint;
    if (i != 0) {
      super.setColorFilter(i, this.mTintMode);
    }
  }
  
  public boolean isStateful()
  {
    ColorStateList localColorStateList = this.mTintStateList;
    return ((localColorStateList != null) && (localColorStateList.isStateful())) || (super.isStateful());
  }
  
  public void setColorFilter(int paramInt, PorterDuff.Mode paramMode)
  {
    int i = paramInt;
    if (this.mTint != 0)
    {
      i = paramInt;
      if (paramMode == PorterDuff.Mode.SRC_ATOP)
      {
        float f1 = Color.alpha(this.mTint) / 255.0F;
        float f2 = Color.alpha(paramInt) / 255.0F;
        i = (int)(Color.red(paramInt) + Color.red(this.mTint) * (1.0F - Color.alpha(paramInt) / 255.0F));
        int j = (int)(Color.green(paramInt) + Color.green(this.mTint) * (1.0F - Color.alpha(paramInt) / 255.0F));
        paramInt = (int)(Color.blue(paramInt) + Color.blue(this.mTint) * (1.0F - Color.alpha(paramInt) / 255.0F));
        i = Color.argb((int)((1.0F - (1.0F - f1) * (1.0F - f2)) * 255.0F), i, j, paramInt);
      }
    }
    super.setColorFilter(i, paramMode);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (paramColorFilter == null)
    {
      int i = this.mTint;
      if (i != 0)
      {
        super.setColorFilter(i, this.mTintMode);
        return;
      }
    }
    super.setColorFilter(paramColorFilter);
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    boolean bool = super.setState(paramArrayOfInt);
    return (updateTint(paramArrayOfInt)) || (bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.TintDrawableWrapper
 * JD-Core Version:    0.7.0.1
 */