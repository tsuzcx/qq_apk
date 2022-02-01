package com.tencent.biz.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;

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
      paramMotionEvent1 = this.this$0.l;
      double d = paramFloat2;
      Double.isNaN(d);
      paramMotionEvent1.onOverScroll((int)(d / 1.5D));
      this.this$0.overscrolling = true;
    }
    if ((this.this$0.getParent() instanceof RefreshView))
    {
      paramMotionEvent1 = (RefreshView)this.this$0.getParent();
      if ((paramMotionEvent1.getScrollY() >= 0) && (this.this$0.l != null) && (this.this$0.overscrolling))
      {
        if (QLog.isColorLevel())
        {
          paramMotionEvent2 = new StringBuilder();
          paramMotionEvent2.append("RefreshView scrollY: ");
          paramMotionEvent2.append(paramMotionEvent1.getScrollY());
          QLog.i("CustomWebView", 2, paramMotionEvent2.toString());
        }
        this.this$0.l.onBack();
        paramMotionEvent1 = this.this$0;
        paramMotionEvent1.overscrolling = false;
        paramMotionEvent1.overscroll = false;
      }
    }
    return false;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.ui.TouchWebView.1
 * JD-Core Version:    0.7.0.1
 */