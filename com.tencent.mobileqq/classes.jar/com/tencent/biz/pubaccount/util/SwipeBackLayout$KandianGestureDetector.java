package com.tencent.biz.pubaccount.util;

import android.app.Activity;
import android.content.Context;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

public class SwipeBackLayout$KandianGestureDetector
  extends GestureDetector.SimpleOnGestureListener
{
  private float jdField_a_of_type_Float;
  
  public SwipeBackLayout$KandianGestureDetector(SwipeBackLayout paramSwipeBackLayout, Context paramContext)
  {
    this.jdField_a_of_type_Float = (ViewConfiguration.get(paramContext).getScaledTouchSlop() * 2);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    float f1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
    float f2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / f1);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (SwipeBackLayout.c(this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout))
    {
      bool1 = bool2;
      if (SwipeBackLayout.d(this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout))
      {
        bool1 = bool2;
        if (!SwipeBackLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout).a())
        {
          bool1 = bool2;
          if (SwipeBackLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout) != null) {
            bool1 = SwipeBackLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout, paramMotionEvent1);
          }
        }
      }
    }
    if ((!SwipeBackLayout.e(this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout)) || (paramFloat1 < 200.0F)) {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    if ((f1 < 0.0F) && (f2 < 0.5F) && (SwipeBackLayout.c(this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout)) && (SwipeBackLayout.d(this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout)) && (!bool1))
    {
      if (!(SwipeBackLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout) instanceof Activity)) {
        break label234;
      }
      SwipeBackLayout.b(this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout, true);
      SwipeBackLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout).A();
      SwipeBackLayout.b(this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout);
    }
    for (;;)
    {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      label234:
      if (SwipeBackLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout) != null)
      {
        SwipeBackLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout).A();
        SwipeBackLayout.b(this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.SwipeBackLayout.KandianGestureDetector
 * JD-Core Version:    0.7.0.1
 */