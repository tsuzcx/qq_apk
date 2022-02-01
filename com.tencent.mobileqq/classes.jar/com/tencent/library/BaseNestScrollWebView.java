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
  private IHeaderView jdField_a_of_type_ComTencentLibraryIHeaderView;
  private ILoadingView jdField_a_of_type_ComTencentLibraryILoadingView;
  public boolean a;
  
  public BaseNestScrollWebView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    a();
  }
  
  public BaseNestScrollWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    a();
  }
  
  protected void a() {}
  
  public boolean a()
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
      paramString = this.jdField_a_of_type_ComTencentLibraryILoadingView;
      if ((paramString != null) && (this.jdField_a_of_type_Boolean)) {
        paramString.a(this);
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    if (paramInt == 4) {
      bool = a();
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
    IHeaderView localIHeaderView = this.jdField_a_of_type_ComTencentLibraryIHeaderView;
    if ((localIHeaderView != null) && (!localIHeaderView.a())) {
      this.jdField_a_of_type_ComTencentLibraryIHeaderView.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public void setLoadingView(ILoadingView paramILoadingView)
  {
    if ((paramILoadingView == null) || (!this.jdField_a_of_type_Boolean))
    {
      ILoadingView localILoadingView = this.jdField_a_of_type_ComTencentLibraryILoadingView;
      if (localILoadingView != null) {
        localILoadingView.b(this);
      }
    }
    if (this.jdField_a_of_type_ComTencentLibraryILoadingView == null) {
      this.jdField_a_of_type_ComTencentLibraryILoadingView = paramILoadingView;
    }
    paramILoadingView = this.jdField_a_of_type_ComTencentLibraryILoadingView;
    if (paramILoadingView != null) {
      paramILoadingView.a(this);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void setPaddingTop(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("if (document.body && document.body.style) {document.body.style.paddingTop='");
    ((StringBuilder)localObject).append(UIUtil.a(getContext(), paramInt, this.jdField_a_of_type_ComTencentLibraryIHeaderView));
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