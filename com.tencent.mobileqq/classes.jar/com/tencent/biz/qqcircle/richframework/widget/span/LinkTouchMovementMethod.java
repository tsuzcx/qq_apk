package com.tencent.biz.qqcircle.richframework.widget.span;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;

public class LinkTouchMovementMethod
  extends LinkMovementMethod
{
  private TouchableSpan a;
  
  private TouchableSpan a(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = paramTextView.getTotalPaddingLeft();
    int m = paramTextView.getTotalPaddingTop();
    int n = paramTextView.getScrollX();
    int i1 = paramTextView.getScrollY();
    paramTextView = paramTextView.getLayout();
    i = paramTextView.getOffsetForHorizontal(paramTextView.getLineForVertical(j - m + i1), i - k + n);
    paramTextView = (TouchableSpan[])paramSpannable.getSpans(i, i, TouchableSpan.class);
    if (paramTextView.length > 0) {
      return paramTextView[0];
    }
    return null;
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.a = a(paramTextView, paramSpannable, paramMotionEvent);
      paramTextView = this.a;
      if (paramTextView != null)
      {
        paramTextView.a(true);
        Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(this.a), paramSpannable.getSpanEnd(this.a));
        return true;
      }
    }
    else if (paramMotionEvent.getAction() == 2)
    {
      paramTextView = a(paramTextView, paramSpannable, paramMotionEvent);
      paramMotionEvent = this.a;
      if ((paramMotionEvent != null) && (paramTextView != paramMotionEvent))
      {
        paramMotionEvent.a(false);
        this.a = null;
        Selection.removeSelection(paramSpannable);
        return true;
      }
    }
    else
    {
      TouchableSpan localTouchableSpan = this.a;
      if (localTouchableSpan != null)
      {
        localTouchableSpan.a(false);
        super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
      }
      this.a = null;
      Selection.removeSelection(paramSpannable);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.span.LinkTouchMovementMethod
 * JD-Core Version:    0.7.0.1
 */