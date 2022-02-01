package com.tencent.library;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.webkit.WebView;

public abstract class BaseNestScrollWebView
  extends WebView
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
    if (((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) && (this.jdField_a_of_type_ComTencentLibraryILoadingView != null) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentLibraryILoadingView.a(this);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (paramInt == 4) {
      bool = a();
    }
    if (bool) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.jdField_a_of_type_ComTencentLibraryIHeaderView != null) && (!this.jdField_a_of_type_ComTencentLibraryIHeaderView.a())) {
      this.jdField_a_of_type_ComTencentLibraryIHeaderView.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public void setLoadingView(ILoadingView paramILoadingView)
  {
    if (((paramILoadingView == null) || (!this.jdField_a_of_type_Boolean)) && (this.jdField_a_of_type_ComTencentLibraryILoadingView != null)) {
      this.jdField_a_of_type_ComTencentLibraryILoadingView.b(this);
    }
    if (this.jdField_a_of_type_ComTencentLibraryILoadingView == null) {
      this.jdField_a_of_type_ComTencentLibraryILoadingView = paramILoadingView;
    }
    if (this.jdField_a_of_type_ComTencentLibraryILoadingView != null) {
      this.jdField_a_of_type_ComTencentLibraryILoadingView.a(this);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void setPaddingTop(int paramInt)
  {
    String str = "if (document.body && document.body.style) {document.body.style.paddingTop='" + UIUtil.a(getContext(), paramInt, this.jdField_a_of_type_ComTencentLibraryIHeaderView) + "px';} void 0";
    loadUrl("javascript:" + str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.library.BaseNestScrollWebView
 * JD-Core Version:    0.7.0.1
 */