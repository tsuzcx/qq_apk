package com.tencent.gdtad.basics.motivebrowsing;

import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.gdtad.inject.IGdtWebViewListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingDialog$initWeb$1", "Lcom/tencent/gdtad/inject/IGdtWebViewListener;", "onPageFinished", "", "view", "Lcom/tencent/smtt/sdk/WebView;", "url", "", "onReceivedError", "errorCode", "", "description", "failingUrl", "shouldOverrideUrlLoading", "", "webview", "qqad-impl_release"}, k=1, mv={1, 1, 16})
public final class GdtMotiveBrowsingDialog$initWeb$1
  extends IGdtWebViewListener
{
  public void a(@NotNull WebView paramWebView, int paramInt, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramWebView, "view");
    Intrinsics.checkParameterIsNotNull(paramString1, "description");
    Intrinsics.checkParameterIsNotNull(paramString2, "failingUrl");
    paramWebView = new StringBuilder();
    paramWebView.append("onReceivedError url = ");
    paramWebView.append(paramInt);
    paramWebView.append(",description = ");
    paramWebView.append(paramString1);
    paramWebView.append(",failingUrl = ");
    paramWebView.append(paramString2);
    QLog.i("GdtMotiveBrowsingDialog", 1, paramWebView.toString());
    GdtMotiveBrowsingDialog.a(this.a, true);
    GdtMotiveBrowsingDialog.b(this.a, false);
    if (!GdtMotiveBrowsingDialog.b(this.a))
    {
      GdtADFlyingStreamingReportHelper.a().a(1020037L);
      GdtMotiveBrowsingDialog.c(this.a, true);
    }
  }
  
  public void a(@Nullable WebView paramWebView, @Nullable String paramString)
  {
    if (!GdtMotiveBrowsingDialog.a(this.a))
    {
      GdtMotiveBrowsingDialog.b(this.a, true);
      if (!GdtMotiveBrowsingDialog.b(this.a))
      {
        GdtADFlyingStreamingReportHelper.a().a(1020036L);
        GdtMotiveBrowsingDialog.c(this.a, true);
      }
    }
    GdtMotiveBrowsingDialog.a(this.a, false);
  }
  
  public boolean a(@NotNull WebView paramWebView, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramWebView, "webview");
    paramWebView = new StringBuilder();
    paramWebView.append("shouldOverrideUrlLoading ");
    paramWebView.append(paramString);
    QLog.i("GdtMotiveBrowsingDialog", 1, paramWebView.toString());
    return (paramString != null) && (GdtMotiveBrowsingDialog.a(this.a).a(paramString, GdtMotiveBrowsingDialog.a(this.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivebrowsing.GdtMotiveBrowsingDialog.initWeb.1
 * JD-Core Version:    0.7.0.1
 */