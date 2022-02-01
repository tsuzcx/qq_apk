package com.tencent.library;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.webkit.WebView;
import com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtWebView;

public abstract class BaseNestScrollWebView
  extends DtWebView
{
  public int a;
  public boolean b = true;
  private IHeaderView c;
  private ILoadingView d;
  
  public BaseNestScrollWebView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public BaseNestScrollWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  protected void a() {}
  
  public boolean b()
  {
    if (canGoBack())
    {
      goBack();
      return true;
    }
    return false;
  }
  
  public void loadUrl(String paramString)
  {
    super.loadUrl(paramString);
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      paramString = this.d;
      if ((paramString != null) && (this.b)) {
        paramString.a(this);
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    if (paramInt == 4) {
      bool = b();
    } else {
      bool = false;
    }
    if (bool) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    IHeaderView localIHeaderView = this.c;
    if ((localIHeaderView != null) && (!localIHeaderView.a())) {
      this.c.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    this.a = paramInt2;
  }
  
  public void setLoadingView(ILoadingView paramILoadingView)
  {
    if ((paramILoadingView == null) || (!this.b))
    {
      ILoadingView localILoadingView = this.d;
      if (localILoadingView != null) {
        localILoadingView.b(this);
      }
    }
    if (this.d == null) {
      this.d = paramILoadingView;
    }
    paramILoadingView = this.d;
    if (paramILoadingView != null) {
      paramILoadingView.a(this);
    }
    this.b = false;
  }
  
  public void setPaddingTop(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("if (document.body && document.body.style) {document.body.style.paddingTop='");
    ((StringBuilder)localObject).append(UIUtil.a(getContext(), paramInt, this.c));
    ((StringBuilder)localObject).append("px';} void 0");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("javascript:");
    localStringBuilder.append((String)localObject);
    loadUrl(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.library.BaseNestScrollWebView
 * JD-Core Version:    0.7.0.1
 */