package com.tencent.library;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.widget.FrameLayout.LayoutParams;

public class DefaultLoadingView
  extends BaseLayout
  implements ILoadingView
{
  public DefaultLoadingView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public DefaultLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    addView(this.view);
  }
  
  public void a(WebView paramWebView)
  {
    paramWebView.addView(this, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public void b(WebView paramWebView)
  {
    paramWebView.removeView(this);
  }
  
  protected int getLayoutId()
  {
    return 2131561752;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.library.DefaultLoadingView
 * JD-Core Version:    0.7.0.1
 */