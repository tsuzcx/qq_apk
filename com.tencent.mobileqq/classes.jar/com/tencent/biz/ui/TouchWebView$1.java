package com.tencent.biz.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;
import wpk;

class TouchWebView$1
  extends GestureDetector.SimpleOnGestureListener
{
  TouchWebView$1(TouchWebView paramTouchWebView) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.this$0.helper != null) {
      this.this$0.helper.a(paramFloat2);
    }
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (((this.this$0.overscroll) && (paramFloat2 < 0.0F)) || ((this.this$0.overscrolling) && (this.this$0.l != null)))
    {
      this.this$0.l.onOverScroll((int)(paramFloat2 / 1.5D));
      this.this$0.overscrolling = true;
    }
    if ((this.this$0.getParent() instanceof RefreshView))
    {
      paramMotionEvent1 = (RefreshView)this.this$0.getParent();
      if ((paramMotionEvent1.getScrollY() >= 0) && (this.this$0.l != null) && (this.this$0.overscrolling))
      {
        if (QLog.isColorLevel()) {
          QLog.i("CustomWebView", 2, "RefreshView scrollY: " + paramMotionEvent1.getScrollY());
        }
        this.this$0.l.onBack();
        this.this$0.overscrolling = false;
        this.this$0.overscroll = false;
      }
    }
    return false;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.ui.TouchWebView.1
 * JD-Core Version:    0.7.0.1
 */