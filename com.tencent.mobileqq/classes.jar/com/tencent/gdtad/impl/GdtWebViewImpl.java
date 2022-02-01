package com.tencent.gdtad.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.inject.IGdtWebView;
import com.tencent.gdtad.inject.IGdtWebViewListener;
import com.tencent.gdtad.views.videoceiling.GdtWebViewBuilder;
import com.tencent.mobileqq.webview.WebViewDirector;
import com.tencent.smtt.sdk.WebView;

public class GdtWebViewImpl
  implements IGdtWebView
{
  public GdtWebViewBuilder a;
  
  public void a()
  {
    GdtWebViewBuilder localGdtWebViewBuilder = this.a;
    if (localGdtWebViewBuilder != null) {
      localGdtWebViewBuilder.a();
    }
  }
  
  public void a(Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface, IGdtWebViewListener paramIGdtWebViewListener)
  {
    this.a = new GdtWebViewImpl.1(this, paramContext, paramActivity, paramIntent, paramAppInterface, paramIGdtWebViewListener);
  }
  
  public void a(Bundle paramBundle)
  {
    GdtWebViewBuilder localGdtWebViewBuilder = this.a;
    if (localGdtWebViewBuilder != null) {
      localGdtWebViewBuilder.a(paramBundle);
    }
  }
  
  public void a(Bundle paramBundle, AppInterface paramAppInterface, Intent paramIntent)
  {
    GdtWebViewBuilder localGdtWebViewBuilder = this.a;
    if (localGdtWebViewBuilder != null) {
      new WebViewDirector(localGdtWebViewBuilder).a(paramBundle, paramAppInterface, paramIntent);
    }
  }
  
  public void a(WebView paramWebView)
  {
    GdtWebViewBuilder localGdtWebViewBuilder = this.a;
    if (localGdtWebViewBuilder != null) {
      localGdtWebViewBuilder.a((TouchWebView)paramWebView);
    }
  }
  
  public void b()
  {
    GdtWebViewBuilder localGdtWebViewBuilder = this.a;
    if (localGdtWebViewBuilder != null) {
      localGdtWebViewBuilder.b();
    }
  }
  
  public void c()
  {
    GdtWebViewBuilder localGdtWebViewBuilder = this.a;
    if (localGdtWebViewBuilder != null) {
      localGdtWebViewBuilder.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.impl.GdtWebViewImpl
 * JD-Core Version:    0.7.0.1
 */