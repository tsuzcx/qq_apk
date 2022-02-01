package com.tencent.luggage.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.cv.c;
import com.tencent.luggage.wxa.cv.i;
import com.tencent.luggage.wxa.pc.m;
import com.tencent.luggage.wxa.pc.m.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mm.ui.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.u;
import com.tencent.xweb.w;
import com.tencent.xweb.y;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/ui/WxaSimpleWebViewActivity;", "Lcom/tencent/mm/ui/BaseActivity;", "()V", "urlCheckCallback", "Lkotlin/Function2;", "", "", "Lcom/tencent/luggage/jsapi/webview/model/ReplaceWebViewUrlCallback;", "urlCheckLogic", "Lcom/tencent/luggage/jsapi/webview/model/HTMLWebViewUrlCheckLogic;", "webViewController", "Lcom/tencent/luggage/jsapi/webview/model/WebViewController;", "webview", "Lcom/tencent/xweb/WebView;", "getLayoutId", "", "mayInterceptLoadUrl", "", "url", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onPostCreate", "onResume", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class WxaSimpleWebViewActivity
  extends BaseActivity
{
  public static final WxaSimpleWebViewActivity.a a = new WxaSimpleWebViewActivity.a(null);
  private WebView b;
  private i c;
  private c d;
  private Function2<? super String, ? super String, Unit> e;
  
  static
  {
    WebView.initWebviewCore(r.a(), WebView.c.b, "main", null);
  }
  
  private final boolean a(String paramString)
  {
    c localc = this.d;
    if (localc == null) {
      Intrinsics.throwUninitializedPropertyAccessException("urlCheckLogic");
    }
    if (localc.a(paramString)) {
      return false;
    }
    localc = this.d;
    if (localc == null) {
      Intrinsics.throwUninitializedPropertyAccessException("urlCheckLogic");
    }
    Function2 localFunction2 = this.e;
    if (localFunction2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("urlCheckCallback");
    }
    localc.a(paramString, localFunction2);
    return true;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected int getLayoutId()
  {
    return 2131624049;
  }
  
  public void onBackPressed()
  {
    WebView localWebView = this.b;
    if (localWebView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("webview");
    }
    if (localWebView.canGoBack())
    {
      localWebView = this.b;
      if (localWebView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("webview");
      }
      localWebView.goBack();
      return;
    }
    finish();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    setTheme(2131952519);
    super.onCreate(paramBundle);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (((WxaSimpleWebViewActivity)this).b != null)
    {
      WebView localWebView = this.b;
      if (localWebView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("webview");
      }
      localWebView.destroy();
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    if (((WxaSimpleWebViewActivity)this).b != null)
    {
      WebView localWebView = this.b;
      if (localWebView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("webview");
      }
      localWebView.onPause();
      localWebView = this.b;
      if (localWebView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("webview");
      }
      localWebView.onHide();
    }
  }
  
  protected void onPostCreate(@Nullable Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle != null) {
      paramBundle = paramBundle.getStringExtra("KEY_URL");
    } else {
      paramBundle = null;
    }
    if (TextUtils.isEmpty((CharSequence)paramBundle))
    {
      o.b("Luggage.WxaSimpleWebViewActivity", "onPostCreate invalid url");
      finish();
      return;
    }
    WebView.reinitToXWeb();
    Object localObject1 = new WxaSimpleWebViewActivity.b(this, (Context)this);
    Object localObject2 = ((WxaSimpleWebViewActivity.b)localObject1).getSettings();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "settings");
    ((w)localObject2).j(true);
    localObject2 = ((WxaSimpleWebViewActivity.b)localObject1).getSettings();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "settings");
    ((w)localObject2).g(true);
    localObject2 = ((WxaSimpleWebViewActivity.b)localObject1).getSettings();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "settings");
    ((w)localObject2).a(false);
    localObject2 = ((WxaSimpleWebViewActivity.b)localObject1).getSettings();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "settings");
    ((w)localObject2).c(0);
    localObject2 = ((WxaSimpleWebViewActivity.b)localObject1).getSettings();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "settings");
    Context localContext = ((WxaSimpleWebViewActivity.b)localObject1).getContext();
    w localw = ((WxaSimpleWebViewActivity.b)localObject1).getSettings();
    Intrinsics.checkExpressionValueIsNotNull(localw, "settings");
    ((w)localObject2).b(m.a(localContext, localw.a(), (m.a)e.a(m.a.class)));
    localObject2 = ((WxaSimpleWebViewActivity.b)localObject1).getSettings();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "settings");
    ((w)localObject2).b(100);
    this.b = ((WebView)localObject1);
    localObject1 = (FrameLayout)findViewById(2131450092);
    localObject2 = this.b;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("webview");
    }
    ((FrameLayout)localObject1).addView((View)localObject2, -1, -1);
    this.c = ((i)new WxaSimpleWebViewActivity.c(this));
    this.e = ((Function2)new WxaSimpleWebViewActivity.d(this));
    localObject1 = this.c;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("webViewController");
    }
    this.d = new c((i)localObject1);
    localObject1 = this.b;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("webview");
    }
    ((WebView)localObject1).setWebChromeClient((u)new WxaSimpleWebViewActivity.e(this));
    localObject1 = this.b;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("webview");
    }
    ((WebView)localObject1).setWebViewClient((y)new WxaSimpleWebViewActivity.f(this));
    localObject1 = this.b;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("webview");
    }
    ((WebView)localObject1).loadUrl(paramBundle);
    setBackBtn((MenuItem.OnMenuItemClickListener)new WxaSimpleWebViewActivity.g(this));
  }
  
  protected void onResume()
  {
    super.onResume();
    if (((WxaSimpleWebViewActivity)this).b != null)
    {
      WebView localWebView = this.b;
      if (localWebView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("webview");
      }
      localWebView.onResume();
      localWebView = this.b;
      if (localWebView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("webview");
      }
      localWebView.onShow();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WxaSimpleWebViewActivity
 * JD-Core Version:    0.7.0.1
 */