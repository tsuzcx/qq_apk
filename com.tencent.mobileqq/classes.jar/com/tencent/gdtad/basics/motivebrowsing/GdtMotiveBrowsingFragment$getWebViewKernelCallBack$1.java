package com.tencent.gdtad.basics.motivebrowsing;

import android.os.Bundle;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingFragment$getWebViewKernelCallBack$1", "Lcom/tencent/mobileqq/webview/swift/proxy/WebKernelCallBackProxy;", "onFinalState", "", "extraData", "Landroid/os/Bundle;", "onPageFinished", "view", "Lcom/tencent/smtt/sdk/WebView;", "url", "", "onReceivedError", "errorCode", "", "description", "failingUrl", "shouldOverrideUrlLoading", "", "qqad-impl_release"}, k=1, mv={1, 1, 16})
public final class GdtMotiveBrowsingFragment$getWebViewKernelCallBack$1
  extends WebKernelCallBackProxy
{
  GdtMotiveBrowsingFragment$getWebViewKernelCallBack$1(WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(localWebViewKernelCallBack);
  }
  
  public void onFinalState(@Nullable Bundle paramBundle)
  {
    super.onFinalState(paramBundle);
    GdtMotiveBrowsingFragment.a(this.a);
  }
  
  public void onPageFinished(@Nullable WebView paramWebView, @Nullable String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if (!GdtMotiveBrowsingFragment.a(this.a))
    {
      GdtMotiveBrowsingFragment.b(this.a, true);
      if (!GdtMotiveBrowsingFragment.b(this.a))
      {
        GdtADFlyingStreamingReportHelper.a().a(1020036L);
        GdtMotiveBrowsingFragment.c(this.a, true);
      }
    }
    GdtMotiveBrowsingFragment.a(this.a, false);
  }
  
  public void onReceivedError(@Nullable WebView paramWebView, int paramInt, @Nullable String paramString1, @Nullable String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    GdtMotiveBrowsingFragment.a(this.a, true);
    GdtMotiveBrowsingFragment.b(this.a, false);
    if (!GdtMotiveBrowsingFragment.b(this.a))
    {
      GdtADFlyingStreamingReportHelper.a().a(1020037L);
      GdtMotiveBrowsingFragment.c(this.a, true);
    }
  }
  
  public boolean shouldOverrideUrlLoading(@Nullable WebView paramWebView, @Nullable String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("shouldOverrideUrlLoading ");
      localStringBuilder.append(paramString);
      QLog.d("GdtMotiveBrowsingFragment", 2, localStringBuilder.toString());
    }
    if (!GdtMotiveBrowsingFragment.c(this.a))
    {
      if (GdtMotiveBrowsingFragment.a(this.a) == null) {
        return true;
      }
      if ((paramString != null) && (!GdtMotiveBrowsingFragment.a(this.a).a(paramString, GdtMotiveBrowsingFragment.a(this.a)))) {
        return super.shouldOverrideUrlLoading(paramWebView, paramString);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivebrowsing.GdtMotiveBrowsingFragment.getWebViewKernelCallBack.1
 * JD-Core Version:    0.7.0.1
 */