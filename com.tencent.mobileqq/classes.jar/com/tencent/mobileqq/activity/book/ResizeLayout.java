package com.tencent.mobileqq.activity.book;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class ResizeLayout
  extends ScrollView
{
  private boolean a = true;
  private ResizeLayout.OnResizeListener b;
  
  public ResizeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.a) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (isInEditMode()) {
      return;
    }
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt2 > paramInt4) {
      this.a = false;
    } else {
      this.a = true;
    }
    if (this.b != null) {
      new Handler(Looper.getMainLooper()).postDelayed(new ResizeLayout.1(this, paramInt1, paramInt2, paramInt3, paramInt4), 50L);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.a) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnResizeListener(ResizeLayout.OnResizeListener paramOnResizeListener)
  {
    this.b = paramOnResizeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.book.ResizeLayout
 * JD-Core Version:    0.7.0.1
 */