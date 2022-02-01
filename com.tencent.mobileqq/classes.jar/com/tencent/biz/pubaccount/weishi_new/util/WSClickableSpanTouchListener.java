package com.tencent.biz.pubaccount.weishi_new.util;

import android.text.Layout;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class WSClickableSpanTouchListener
  implements View.OnTouchListener
{
  public static int a(TextView paramTextView, MotionEvent paramMotionEvent)
  {
    if (paramTextView != null)
    {
      if (paramMotionEvent == null) {
        return -1;
      }
      int i = (int)paramMotionEvent.getX();
      int m = (int)paramMotionEvent.getY();
      int j = paramTextView.getTotalPaddingLeft();
      int n = paramTextView.getTotalPaddingTop();
      int k = paramTextView.getScrollX();
      n = m - n + paramTextView.getScrollY();
      paramMotionEvent = paramTextView.getLayout();
      m = paramMotionEvent.getLineForVertical(n);
      float f = i - j + k;
      if ((f >= paramMotionEvent.getLineLeft(m)) && (f <= paramMotionEvent.getLineRight(m)) && (n >= paramMotionEvent.getLineTop(m)))
      {
        if (n > paramMotionEvent.getLineBottom(m)) {
          return -1;
        }
        j = paramMotionEvent.getOffsetForHorizontal(m, f);
        if (j > paramTextView.getText().length() - paramMotionEvent.getEllipsisCount(m)) {
          return -1;
        }
        i = j;
        if (paramMotionEvent.getPrimaryHorizontal(j) > f) {
          i = j - 1;
        }
        return i;
      }
    }
    return -1;
  }
  
  public static ClickableSpan a(TextView paramTextView, int paramInt)
  {
    if (paramTextView != null)
    {
      if (paramInt < 0) {
        return null;
      }
      paramTextView = paramTextView.getText();
      if (!(paramTextView instanceof Spanned)) {
        return null;
      }
      paramTextView = (ClickableSpan[])((Spanned)paramTextView).getSpans(paramInt, paramInt + 1, ClickableSpan.class);
      if ((paramTextView != null) && (paramTextView.length > 0)) {
        return paramTextView[0];
      }
    }
    return null;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!(paramView instanceof TextView)) {
      return false;
    }
    paramView = (TextView)paramView;
    if (!(paramView.getText() instanceof Spanned)) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 1) || (i == 0))
    {
      paramMotionEvent = a(paramView, a(paramView, paramMotionEvent));
      if (paramMotionEvent != null)
      {
        if (i == 1) {
          paramMotionEvent.onClick(paramView);
        }
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSClickableSpanTouchListener
 * JD-Core Version:    0.7.0.1
 */