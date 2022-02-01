package com.tencent.component.media.image.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

public class ViewForeground
{
  private Context mContext;
  private Drawable mDrawable;
  private int mDrawableHeight;
  private int mDrawableWidth;
  private boolean mForegroundBoundsChanged = false;
  private boolean mForegroundInPadding = true;
  private View mView;
  
  public ViewForeground(View paramView)
  {
    this.mContext = paramView.getContext();
    this.mView = paramView;
  }
  
  public ViewForeground(View paramView, int paramInt)
  {
    this(paramView);
    setDrawable(paramInt);
  }
  
  public ViewForeground(View paramView, Drawable paramDrawable)
  {
    this(paramView);
    setDrawable(paramDrawable);
  }
  
  private void updateDrawable(Drawable paramDrawable)
  {
    View localView = this.mView;
    Drawable localDrawable = this.mDrawable;
    if (localDrawable != null)
    {
      localDrawable.setCallback(null);
      localView.unscheduleDrawable(this.mDrawable);
    }
    this.mDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(localView);
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(localView.getDrawableState());
      }
      this.mDrawableWidth = paramDrawable.getIntrinsicWidth();
      this.mDrawableHeight = paramDrawable.getIntrinsicHeight();
      return;
    }
    this.mDrawableHeight = -1;
    this.mDrawableWidth = -1;
  }
  
  public void boundsChanged()
  {
    this.mForegroundBoundsChanged = true;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Drawable localDrawable = this.mDrawable;
    if (localDrawable != null)
    {
      View localView = this.mView;
      if (this.mForegroundBoundsChanged)
      {
        int i = 0;
        this.mForegroundBoundsChanged = false;
        int j = localView.getWidth();
        int k = localView.getHeight();
        int m;
        if (this.mForegroundInPadding)
        {
          i = localView.getPaddingLeft();
          j -= localView.getPaddingRight();
          m = localView.getPaddingTop();
          k -= localView.getPaddingBottom();
        }
        else
        {
          m = 0;
        }
        localDrawable.setBounds(i, m, j, k);
      }
      localDrawable.draw(paramCanvas);
    }
  }
  
  public void drawableStateChanged()
  {
    Drawable localDrawable = this.mDrawable;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      this.mDrawable.setState(this.mView.getDrawableState());
    }
  }
  
  public Drawable getDrawable()
  {
    return this.mDrawable;
  }
  
  public void setDrawable(int paramInt)
  {
    setDrawable(this.mContext.getResources().getDrawable(paramInt));
  }
  
  public void setDrawable(Drawable paramDrawable)
  {
    if (this.mDrawable != paramDrawable)
    {
      View localView = this.mView;
      int i = this.mDrawableWidth;
      int j = this.mDrawableHeight;
      updateDrawable(paramDrawable);
      if ((i != this.mDrawableWidth) || (j != this.mDrawableHeight)) {
        localView.requestLayout();
      }
      localView.invalidate();
    }
  }
  
  public void setForegroundInPadding(boolean paramBoolean)
  {
    if (this.mForegroundInPadding != paramBoolean)
    {
      this.mForegroundInPadding = paramBoolean;
      boundsChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.view.ViewForeground
 * JD-Core Version:    0.7.0.1
 */