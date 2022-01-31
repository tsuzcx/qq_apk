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
    if (this.mDrawable != null)
    {
      this.mDrawable.setCallback(null);
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
    int j = 0;
    Drawable localDrawable = this.mDrawable;
    int k;
    int i;
    int m;
    if (localDrawable != null)
    {
      View localView = this.mView;
      if (this.mForegroundBoundsChanged)
      {
        this.mForegroundBoundsChanged = false;
        k = localView.getWidth();
        i = localView.getHeight();
        if (!this.mForegroundInPadding) {
          break label100;
        }
        m = localView.getPaddingLeft();
        k -= localView.getPaddingRight();
        j = localView.getPaddingTop();
        i -= localView.getPaddingBottom();
      }
    }
    for (;;)
    {
      localDrawable.setBounds(m, j, k, i);
      localDrawable.draw(paramCanvas);
      return;
      label100:
      m = 0;
    }
  }
  
  public void drawableStateChanged()
  {
    if ((this.mDrawable != null) && (this.mDrawable.isStateful())) {
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