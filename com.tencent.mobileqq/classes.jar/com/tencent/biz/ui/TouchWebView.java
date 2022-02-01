package com.tencent.biz.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebViewCallbackClient;
import java.util.ArrayList;
import java.util.Iterator;

public class TouchWebView
  extends CustomWebView
  implements WebViewCallbackClient
{
  protected WebViewTouchHelper helper;
  TouchWebView.OnOverScrollHandler l;
  GestureDetector mGesture;
  public float mLastYUp = 0.0F;
  GestureDetector.OnGestureListener mOnGesture = new TouchWebView.1(this);
  private ArrayList<TouchWebView.OnScrollChangedListener> mScrollChangedListenerArrayList = new ArrayList();
  private TouchWebView.OnScrollChangedListener mScrollListenerForBiz;
  public int mTotalYoffset = 0;
  protected boolean overscroll;
  boolean overscrolling = false;
  TouchWebView.OnScrollChangedListener t;
  
  public TouchWebView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public TouchWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  @SuppressLint({"InlinedApi"})
  private void init()
  {
    this.mGesture = new GestureDetector(getContext(), this.mOnGesture);
    setWebViewCallbackClient(this);
    setFadingEdgeLength(0);
    if (getX5WebViewExtension() == null) {
      getSettings().setMixedContentMode(0);
    }
  }
  
  public void addScrollChangedListener(TouchWebView.OnScrollChangedListener paramOnScrollChangedListener)
  {
    if ((paramOnScrollChangedListener != null) && (!this.mScrollChangedListenerArrayList.contains(paramOnScrollChangedListener))) {
      this.mScrollChangedListenerArrayList.add(paramOnScrollChangedListener);
    }
  }
  
  public void computeScroll(View paramView)
  {
    super.super_computeScroll();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    this.mGesture.onTouchEvent(paramMotionEvent);
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
    {
      if ((this.l != null) && (this.overscrolling))
      {
        this.l.onBack();
        this.overscrolling = false;
        this.overscroll = false;
      }
      this.mLastYUp = paramMotionEvent.getY();
    }
    if (this.overscrolling)
    {
      if (paramMotionEvent.getAction() == 0)
      {
        if (this.l != null)
        {
          this.l.onBack();
          this.overscrolling = false;
          this.overscroll = false;
        }
        return true;
      }
      return false;
    }
    return super.super_dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean inOverScroll()
  {
    return this.overscroll;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    return super.super_onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    if (paramInt2 <= 0) {}
    for (this.overscroll = true;; this.overscroll = false)
    {
      super.super_onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      return;
    }
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    super.super_onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mTotalYoffset += paramInt2 - paramInt4;
    if (this.t != null) {
      this.t.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    }
    if (this.helper != null) {
      this.helper.a(paramInt2);
    }
    if (this.mScrollListenerForBiz != null) {
      this.mScrollListenerForBiz.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    }
    if (this.mScrollChangedListenerArrayList != null)
    {
      Iterator localIterator = this.mScrollChangedListenerArrayList.iterator();
      while (localIterator.hasNext()) {
        ((TouchWebView.OnScrollChangedListener)localIterator.next()).onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    if (((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) && (this.overscrolling)) {}
    while ((this.helper != null) && (this.helper.a) && (paramMotionEvent.getAction() == 2)) {
      return true;
    }
    return super.super_onTouchEvent(paramMotionEvent);
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    return super.super_overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
  }
  
  public void removeScrollChangedListener(TouchWebView.OnScrollChangedListener paramOnScrollChangedListener)
  {
    this.mScrollChangedListenerArrayList.remove(paramOnScrollChangedListener);
  }
  
  public void resetForReuse()
  {
    setOnOverScrollHandler(null);
    setOnScrollChangedListener(null);
    super.resetForReuse();
  }
  
  public void setOnOverScrollHandler(TouchWebView.OnOverScrollHandler paramOnOverScrollHandler)
  {
    this.l = paramOnOverScrollHandler;
  }
  
  public void setOnScrollChangedListener(TouchWebView.OnScrollChangedListener paramOnScrollChangedListener)
  {
    this.t = paramOnScrollChangedListener;
  }
  
  public void setOnScrollChangedListenerForBiz(TouchWebView.OnScrollChangedListener paramOnScrollChangedListener)
  {
    this.mScrollListenerForBiz = paramOnScrollChangedListener;
  }
  
  public void setWebViewHelper(WebViewTouchHelper paramWebViewTouchHelper)
  {
    this.helper = paramWebViewTouchHelper;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.ui.TouchWebView
 * JD-Core Version:    0.7.0.1
 */