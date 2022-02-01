package com.tencent.ditto.area;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;

public abstract interface DittoElement
{
  public abstract boolean dispatchTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract void draw(Canvas paramCanvas);
  
  public abstract float getAlpha();
  
  public abstract int getBottom();
  
  public abstract int getContentHeight();
  
  public abstract int getContentWidth();
  
  public abstract Context getContext();
  
  public abstract int getGravity();
  
  public abstract int getHeight();
  
  public abstract int getLeft();
  
  public abstract int getMarginBottom();
  
  public abstract int getMarginLeft();
  
  public abstract int getMarginRight();
  
  public abstract int getMarginTop();
  
  public abstract int getMeasuredHeight();
  
  public abstract int getMeasuredWidth();
  
  public abstract int getPaddingBottom();
  
  public abstract int getPaddingLeft();
  
  public abstract int getPaddingRight();
  
  public abstract int getPaddingTop();
  
  public abstract int getRight();
  
  public abstract int getTop();
  
  public abstract int getVisibility();
  
  public abstract int getWidth();
  
  public abstract void invalidate();
  
  public abstract void invalidateDelayed(long paramLong);
  
  public abstract void layout(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void measure(int paramInt1, int paramInt2);
  
  public abstract void requestLayout();
  
  public abstract void setAlpha(float paramFloat);
  
  public abstract void setGravity(int paramInt);
  
  public abstract void setMargin(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void setPxMargin(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void setShadowSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void setVisibility(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ditto.area.DittoElement
 * JD-Core Version:    0.7.0.1
 */