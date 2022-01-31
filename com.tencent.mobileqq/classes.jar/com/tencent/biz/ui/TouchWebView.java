package com.tencent.biz.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.smtt.sdk.WebViewCallbackClient;
import pad;

public class TouchWebView
  extends CustomWebView
  implements WebViewCallbackClient
{
  GestureDetector.OnGestureListener jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener = new pad(this);
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  public TouchWebView.OnOverScrollHandler a;
  TouchWebView.OnScrollChangedListener jdField_a_of_type_ComTencentBizUiTouchWebView$OnScrollChangedListener;
  public int b;
  public boolean f;
  public boolean g = false;
  
  public TouchWebView(Context paramContext)
  {
    super(paramContext);
    e();
  }
  
  public TouchWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e();
  }
  
  @SuppressLint({"InlinedApi"})
  private void e()
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener);
    setWebViewCallbackClient(this);
    setFadingEdgeLength(0);
  }
  
  public void a()
  {
    setOnOverScrollHandler(null);
    setOnScrollChangedListener(null);
    super.a();
  }
  
  public boolean a()
  {
    return this.f;
  }
  
  public void computeScroll(View paramView)
  {
    super.super_computeScroll();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    if (((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) && (this.jdField_a_of_type_ComTencentBizUiTouchWebView$OnOverScrollHandler != null) && (this.g))
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView$OnOverScrollHandler.a();
      this.g = false;
      this.f = false;
    }
    if (this.g)
    {
      if (paramMotionEvent.getAction() == 0)
      {
        if (this.jdField_a_of_type_ComTencentBizUiTouchWebView$OnOverScrollHandler != null)
        {
          this.jdField_a_of_type_ComTencentBizUiTouchWebView$OnOverScrollHandler.a();
          this.g = false;
          this.f = false;
        }
        return true;
      }
      return false;
    }
    return super.super_dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return super.super_onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    if (paramInt2 <= 0) {}
    for (this.f = true;; this.f = false)
    {
      super.super_onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      return;
    }
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    super.super_onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.b += paramInt2 - paramInt4;
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView$OnScrollChangedListener != null) {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView$OnScrollChangedListener.a(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    if (((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) && (this.g)) {
      return true;
    }
    return super.super_onTouchEvent(paramMotionEvent);
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    return super.super_overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
  }
  
  public void setOnOverScrollHandler(TouchWebView.OnOverScrollHandler paramOnOverScrollHandler)
  {
    this.jdField_a_of_type_ComTencentBizUiTouchWebView$OnOverScrollHandler = paramOnOverScrollHandler;
  }
  
  public void setOnScrollChangedListener(TouchWebView.OnScrollChangedListener paramOnScrollChangedListener)
  {
    this.jdField_a_of_type_ComTencentBizUiTouchWebView$OnScrollChangedListener = paramOnScrollChangedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.ui.TouchWebView
 * JD-Core Version:    0.7.0.1
 */