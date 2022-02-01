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
  private float jdField_a_of_type_Float;
  
  public SwipeBackLayout$KandianGestureDetector(SwipeBackLayout paramSwipeBackLayout, Context paramContext)
  {
    this.jdField_a_of_type_Float = (ViewConfiguration.get(paramContext).getScaledTouchSlop() * 2);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent1 != null) && (paramMotionEvent2 != null))
    {
      float f1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
      float f2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / f1);
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (SwipeBackLayout.b(this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout))
      {
        bool1 = bool2;
        if (SwipeBackLayout.c(this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout))
        {
          bool1 = bool2;
          if (!this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout.jdField_a_of_type_ComTencentMobileqqKandianBizDetailWebReadinjoyH5ElementManager.a())
          {
            bool1 = bool2;
            if (this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) {
              bool1 = this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout.a(paramMotionEvent1);
            }
          }
        }
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout.d) && (paramFloat1 >= 200.0F))
      {
        if ((f1 < 0.0F) && (f2 < 0.5F) && (SwipeBackLayout.b(this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout)) && (SwipeBackLayout.c(this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout)) && (!bool1)) {
          if ((this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout.jdField_a_of_type_AndroidContentContext instanceof Activity))
          {
            SwipeBackLayout localSwipeBackLayout = this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout;
            localSwipeBackLayout.c = true;
            localSwipeBackLayout.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.flingLToR();
            this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout.a();
          }
          else if (this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.flingLToR();
            this.jdField_a_of_type_ComTencentBizPubaccountUtilSwipeBackLayout.a();
          }
        }
        return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      }
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.SwipeBackLayout.KandianGestureDetector
 * JD-Core Version:    0.7.0.1
 */