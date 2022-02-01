package com.tencent.biz.pubaccount.util;

import android.app.Activity;
import android.content.Context;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.kandian.biz.detail.web.ReadinjoyH5ElementManager;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

public class SwipeBackLayout$KandianGestureDetector
  extends GestureDetector.SimpleOnGestureListener
{
  private float b;
  
  public SwipeBackLayout$KandianGestureDetector(SwipeBackLayout paramSwipeBackLayout, Context paramContext)
  {
    this.b = (ViewConfiguration.get(paramContext).getScaledTouchSlop() * 2);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent1 != null) && (paramMotionEvent2 != null))
    {
      float f1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
      float f2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / f1);
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (SwipeBackLayout.b(this.a))
      {
        bool1 = bool2;
        if (SwipeBackLayout.c(this.a))
        {
          bool1 = bool2;
          if (!this.a.m.a())
          {
            bool1 = bool2;
            if (this.a.l != null) {
              bool1 = this.a.a(paramMotionEvent1);
            }
          }
        }
      }
      if ((this.a.n) && (paramFloat1 >= 200.0F))
      {
        if ((f1 < 0.0F) && (f2 < 0.5F) && (SwipeBackLayout.b(this.a)) && (SwipeBackLayout.c(this.a)) && (!bool1)) {
          if ((this.a.j instanceof Activity))
          {
            SwipeBackLayout localSwipeBackLayout = this.a;
            localSwipeBackLayout.k = true;
            localSwipeBackLayout.l.flingLToR();
            this.a.a();
          }
          else if (this.a.l != null)
          {
            this.a.l.flingLToR();
            this.a.a();
          }
        }
        return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      }
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.SwipeBackLayout.KandianGestureDetector
 * JD-Core Version:    0.7.0.1
 */