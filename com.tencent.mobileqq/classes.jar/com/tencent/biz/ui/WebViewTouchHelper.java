package com.tencent.biz.ui;

import com.tencent.widget.OverScroller;
import com.tencent.widget.ScrollView;

public class WebViewTouchHelper
{
  private static final String d = "WebViewTouchHelper";
  public boolean a;
  public OverScroller b;
  public int c;
  private TouchWebView e;
  private ScrollView f;
  private float g;
  
  public WebViewTouchHelper(ScrollView paramScrollView, TouchWebView paramTouchWebView)
  {
    this.e = paramTouchWebView;
    this.f = paramScrollView;
  }
  
  public void a(float paramFloat)
  {
    this.g = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
    if (this.f != null)
    {
      TouchWebView localTouchWebView = this.e;
      if (localTouchWebView == null) {
        return;
      }
      if ((this.g > 0.0F) && (!localTouchWebView.canScrollVertically(-1)) && (paramInt == 0) && (this.f.canScrollVertically(-1))) {
        this.f.fling((int)-this.g);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.ui.WebViewTouchHelper
 * JD-Core Version:    0.7.0.1
 */