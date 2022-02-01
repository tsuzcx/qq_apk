package com.tencent.luggage.ui;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.luggage.wxa.cv.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/ui/WxaSimpleWebViewActivity$onPostCreate$6", "Lcom/tencent/xweb/WebViewClient;", "onPageCommitVisible", "", "view", "Lcom/tencent/xweb/WebView;", "url", "", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "shouldInterceptRequest", "Lcom/tencent/xweb/WebResourceResponse;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "bundle", "Landroid/os/Bundle;", "shouldOverrideUrlLoading", "", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class WxaSimpleWebViewActivity$f
  extends y
{
  @Nullable
  public WebResourceResponse a(@NotNull WebView paramWebView, @Nullable WebResourceRequest paramWebResourceRequest, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramWebView, "view");
    if (paramBundle != null) {
      paramBundle = Integer.valueOf(paramBundle.getInt("resourceType"));
    } else {
      paramBundle = null;
    }
    if ((paramBundle == null) || (paramBundle.intValue() != 1))
    {
      if (paramBundle == null) {
        return null;
      }
      if (paramBundle.intValue() != 7) {}
    }
    else
    {
      paramBundle = WxaSimpleWebViewActivity.b(this.a);
      if (paramWebResourceRequest != null)
      {
        paramWebResourceRequest = paramWebResourceRequest.a();
        if (paramWebResourceRequest != null)
        {
          paramWebResourceRequest = paramWebResourceRequest.toString();
          break label91;
        }
      }
      paramWebResourceRequest = null;
      label91:
      paramBundle.c(paramWebView, paramWebResourceRequest, WxaSimpleWebViewActivity.c(this.a));
    }
    return null;
  }
  
  public void a(@NotNull WebView paramWebView, @Nullable String paramString, @Nullable Bitmap paramBitmap)
  {
    Intrinsics.checkParameterIsNotNull(paramWebView, "view");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPageStarted hash:");
    localStringBuilder.append(WxaSimpleWebViewActivity.a(this.a).hashCode());
    localStringBuilder.append(", url:");
    localStringBuilder.append(paramString);
    o.d("Luggage.WxaSimpleWebViewActivity", localStringBuilder.toString());
    super.a(paramWebView, paramString, paramBitmap);
    WxaSimpleWebViewActivity.b(this.a).a(paramWebView, paramString, WxaSimpleWebViewActivity.c(this.a));
  }
  
  public boolean a(@NotNull WebView paramWebView, @Nullable WebResourceRequest paramWebResourceRequest)
  {
    Intrinsics.checkParameterIsNotNull(paramWebView, "view");
    c localc = WxaSimpleWebViewActivity.b(this.a);
    if (paramWebResourceRequest != null)
    {
      localObject = paramWebResourceRequest.a();
      if (localObject != null)
      {
        localObject = ((Uri)localObject).toString();
        break label40;
      }
    }
    Object localObject = null;
    label40:
    if (localc.b(paramWebView, (String)localObject, WxaSimpleWebViewActivity.c(this.a))) {
      return true;
    }
    return super.a(paramWebView, paramWebResourceRequest);
  }
  
  public boolean b(@NotNull WebView paramWebView, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramWebView, "view");
    if (WxaSimpleWebViewActivity.b(this.a).b(paramWebView, paramString, WxaSimpleWebViewActivity.c(this.a))) {
      return true;
    }
    return super.b(paramWebView, paramString);
  }
  
  public void c(@NotNull WebView paramWebView, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramWebView, "view");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPageFinished hash:");
    localStringBuilder.append(WxaSimpleWebViewActivity.a(this.a).hashCode());
    localStringBuilder.append(", url:");
    localStringBuilder.append(paramString);
    o.d("Luggage.WxaSimpleWebViewActivity", localStringBuilder.toString());
    super.c(paramWebView, paramString);
    WxaSimpleWebViewActivity.b(this.a).a(paramWebView, paramString);
  }
  
  public void d(@NotNull WebView paramWebView, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramWebView, "view");
    super.d(paramWebView, paramString);
    WxaSimpleWebViewActivity.b(this.a).b(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WxaSimpleWebViewActivity.f
 * JD-Core Version:    0.7.0.1
 */