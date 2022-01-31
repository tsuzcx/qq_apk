package com.tencent.mobileqq.activity.qwallet.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.widget.ScrollView;

public class QwScrollView
  extends ScrollView
{
  private boolean isTouchMove;
  private QwScrollView.OnQwScrollListener listener;
  
  public QwScrollView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QwScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QwScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.listener != null) {
      this.listener.onScrollChanged(Boolean.valueOf(this.isTouchMove), this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.listener != null) {
      this.listener.onTouch(this, paramMotionEvent);
    }
    if (paramMotionEvent.getAction() == 2) {
      this.isTouchMove = true;
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      if (paramMotionEvent.getAction() == 1) {
        this.isTouchMove = false;
      }
    }
  }
  
  public void setOnQwScrollListener(QwScrollView.OnQwScrollListener paramOnQwScrollListener)
  {
    this.listener = paramOnQwScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.QwScrollView
 * JD-Core Version:    0.7.0.1
 */