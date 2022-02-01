package com.tencent.biz.subscribe.widget.span;

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
      if (this.a != null)
      {
        this.a.a(true);
        Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(this.a), paramSpannable.getSpanEnd(this.a));
      }
    }
    do
    {
      return true;
      if (paramMotionEvent.getAction() != 2) {
        break;
      }
      paramTextView = a(paramTextView, paramSpannable, paramMotionEvent);
    } while ((this.a == null) || (paramTextView == this.a));
    this.a.a(false);
    this.a = null;
    Selection.removeSelection(paramSpannable);
    return true;
    if (this.a != null)
    {
      this.a.a(false);
      super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
    }
    this.a = null;
    Selection.removeSelection(paramSpannable);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.span.LinkTouchMovementMethod
 * JD-Core Version:    0.7.0.1
 */