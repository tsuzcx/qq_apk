package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

public class QQBrowserSwipeLayout$QQBrowserGestureDetector
  extends GestureDetector.SimpleOnGestureListener
{
  private float b;
  
  public QQBrowserSwipeLayout$QQBrowserGestureDetector(QQBrowserSwipeLayout paramQQBrowserSwipeLayout, Context paramContext)
  {
    this.b = (ViewConfiguration.get(paramContext).getScaledTouchSlop() * 2);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent1 != null) && (paramMotionEvent2 != null))
    {
      float f1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
      float f2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / f1);
      boolean bool = false;
      if (QQBrowserSwipeLayout.d(this.a) != null) {
        bool = QQBrowserSwipeLayout.a(this.a, paramMotionEvent1);
      }
      if ((QQBrowserSwipeLayout.e(this.a)) && (paramFloat1 >= 200.0F))
      {
        if ((f1 < 0.0F) && (f2 < 0.5F) && (!bool)) {
          if ((QQBrowserSwipeLayout.f(this.a) instanceof Activity))
          {
            QQBrowserSwipeLayout.a(this.a, true);
            if (QQBrowserSwipeLayout.g(this.a) != null)
            {
              QQBrowserSwipeLayout.h(this.a).flingLToR();
              QQBrowserSwipeLayout.i(this.a);
            }
          }
          else if (QQBrowserSwipeLayout.j(this.a) != null)
          {
            QQBrowserSwipeLayout.k(this.a).flingLToR();
            QQBrowserSwipeLayout.l(this.a);
          }
        }
        return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      }
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBrowserSwipeLayout.QQBrowserGestureDetector
 * JD-Core Version:    0.7.0.1
 */