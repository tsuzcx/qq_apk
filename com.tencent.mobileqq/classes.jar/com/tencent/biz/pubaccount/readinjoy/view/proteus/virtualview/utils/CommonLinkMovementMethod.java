package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.os.SystemClock;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;

public class CommonLinkMovementMethod
  extends LinkMovementMethod
{
  private static LinkMovementMethod a;
  private long b;
  
  public static MovementMethod a()
  {
    if (a == null) {
      a = new CommonLinkMovementMethod();
    }
    return a;
  }
  
  private static boolean a(long paramLong1, long paramLong2)
  {
    return paramLong1 - paramLong2 < ViewConfiguration.getLongPressTimeout();
  }
  
  private static ClickableSpan[] a(TextView paramTextView, Spanned paramSpanned, MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = paramTextView.getTotalPaddingLeft();
    int m = paramTextView.getTotalPaddingTop();
    int n = paramTextView.getScrollX();
    int i1 = paramTextView.getScrollY();
    paramTextView = paramTextView.getLayout();
    i = paramTextView.getOffsetForHorizontal(paramTextView.getLineForVertical(j - m + i1), i - k + n);
    return (ClickableSpan[])paramSpanned.getSpans(i, i, ClickableSpan.class);
  }
  
  private static long b()
  {
    return SystemClock.uptimeMillis();
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0) {
      this.b = b();
    }
    if (i == 1)
    {
      ClickableSpan[] arrayOfClickableSpan = a(paramTextView, paramSpannable, paramMotionEvent);
      Selection.removeSelection(paramSpannable);
      if (arrayOfClickableSpan.length != 0)
      {
        boolean bool = false;
        paramSpannable = arrayOfClickableSpan[0];
        if (a(b(), this.b))
        {
          paramSpannable.onClick(paramTextView);
          bool = true;
        }
        return bool;
      }
    }
    return super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.CommonLinkMovementMethod
 * JD-Core Version:    0.7.0.1
 */