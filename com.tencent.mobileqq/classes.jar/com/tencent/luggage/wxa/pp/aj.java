package com.tencent.luggage.wxa.pp;

import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.method.MetaKeyKeyListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;

final class aj
{
  public static void a(TextView paramTextView, Layout paramLayout, int paramInt1, int paramInt2)
  {
    int i = paramTextView.getTotalPaddingLeft();
    int j = paramTextView.getTotalPaddingRight();
    int k = paramTextView.getWidth() - (i + j);
    i = paramLayout.getLineForVertical(paramInt2);
    Layout.Alignment localAlignment = paramLayout.getParagraphAlignment(i);
    i = paramLayout.getParagraphDirection(i);
    j = 0;
    if (i > 0) {
      i = 1;
    } else {
      i = 0;
    }
    int m = k + 0;
    if (m < k)
    {
      if (localAlignment == Layout.Alignment.ALIGN_CENTER) {}
      for (paramInt1 = (k - m) / 2;; paramInt1 = k - m)
      {
        paramInt1 = 0 - paramInt1;
        break;
        if ((i == 0) || (localAlignment != Layout.Alignment.ALIGN_OPPOSITE))
        {
          paramInt1 = j;
          if (i != 0) {
            break;
          }
          paramInt1 = j;
          if (localAlignment != Layout.Alignment.ALIGN_NORMAL) {
            break;
          }
        }
      }
    }
    paramInt1 = Math.max(Math.min(paramInt1, k - k), 0);
    paramTextView.scrollTo(paramInt1, paramInt2);
  }
  
  public static boolean a(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    if ((!paramTextView.canScrollVertically(-1)) && (!paramTextView.canScrollVertically(1))) {
      return false;
    }
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            return false;
          }
        }
        else
        {
          arrayOfa = (aj.a[])paramSpannable.getSpans(0, paramSpannable.length(), aj.a.class);
          if (arrayOfa.length > 0)
          {
            float f1;
            float f2;
            if (!arrayOfa[0].e)
            {
              i = ViewConfiguration.get(paramTextView.getContext()).getScaledTouchSlop();
              f1 = Math.abs(paramMotionEvent.getX() - arrayOfa[0].a);
              f2 = i;
              if ((f1 >= f2) || (Math.abs(paramMotionEvent.getY() - arrayOfa[0].b) >= f2)) {
                arrayOfa[0].e = true;
              }
            }
            if (arrayOfa[0].e)
            {
              arrayOfa[0].f = true;
              if (((paramMotionEvent.getMetaState() & 0x1) == 0) && (MetaKeyKeyListener.getMetaState(paramSpannable, 1) != 1) && (MetaKeyKeyListener.getMetaState(paramSpannable, 2048) == 0)) {
                i = 0;
              } else {
                i = 1;
              }
              float f3;
              if (i != 0)
              {
                f3 = paramMotionEvent.getX() - arrayOfa[0].a;
                f1 = paramMotionEvent.getY();
                f2 = arrayOfa[0].b;
              }
              else
              {
                f3 = arrayOfa[0].a - paramMotionEvent.getX();
                f1 = arrayOfa[0].b;
                f2 = paramMotionEvent.getY();
              }
              arrayOfa[0].a = paramMotionEvent.getX();
              arrayOfa[0].b = paramMotionEvent.getY();
              if (arrayOfa[0].h)
              {
                arrayOfa[0].h = false;
                arrayOfa[0].e = false;
                return false;
              }
              i = paramTextView.getScrollX();
              int j = (int)f3;
              int k = paramTextView.getScrollY();
              int m = (int)(f1 - f2);
              int n = paramTextView.getTotalPaddingTop();
              int i1 = paramTextView.getTotalPaddingBottom();
              paramSpannable = paramTextView.getLayout();
              k = Math.max(Math.min(k + m, paramSpannable.getHeight() - (paramTextView.getHeight() - (n + i1))), 0);
              m = paramTextView.getScrollX();
              n = paramTextView.getScrollY();
              a(paramTextView, paramSpannable, i + j, k);
              if ((m == paramTextView.getScrollX()) && (n == paramTextView.getScrollY()))
              {
                if (arrayOfa[0].g) {
                  return true;
                }
                a(paramTextView);
                return false;
              }
              paramTextView.cancelLongPress();
              arrayOfa[0].g = true;
              return true;
            }
          }
          return false;
        }
      }
      paramTextView = a(paramTextView);
      return (paramTextView != null) && (paramTextView.length > 0) && (paramTextView[0].f);
    }
    aj.a[] arrayOfa = (aj.a[])paramSpannable.getSpans(0, paramSpannable.length(), aj.a.class);
    i = 0;
    while (i < arrayOfa.length)
    {
      paramSpannable.removeSpan(arrayOfa[i]);
      i += 1;
    }
    paramSpannable.setSpan(new aj.a(paramMotionEvent.getX(), paramMotionEvent.getY(), paramTextView.getScrollX(), paramTextView.getScrollY()), 0, 0, 17);
    return true;
  }
  
  private static aj.a[] a(TextView paramTextView)
  {
    if ((paramTextView != null) && ((paramTextView.getText() instanceof Spannable)))
    {
      Spannable localSpannable = (Spannable)paramTextView.getText();
      int j = localSpannable.length();
      int i = 0;
      aj.a[] arrayOfa = (aj.a[])localSpannable.getSpans(0, j, aj.a.class);
      j = arrayOfa.length;
      for (;;)
      {
        paramTextView = arrayOfa;
        if (i >= j) {
          break;
        }
        localSpannable.removeSpan(arrayOfa[i]);
        i += 1;
      }
    }
    paramTextView = null;
    return paramTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.aj
 * JD-Core Version:    0.7.0.1
 */