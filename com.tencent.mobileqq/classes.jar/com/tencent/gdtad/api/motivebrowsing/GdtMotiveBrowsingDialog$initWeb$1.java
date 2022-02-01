package com.tencent.gdtad.api.motivebrowsing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.api.motivevideo.GdtADFlyingStreamingReportHelper;
import com.tencent.gdtad.views.videoceiling.GdtWebViewBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/gdtad/api/motivebrowsing/GdtMotiveBrowsingDialog$initWeb$1", "Lcom/tencent/gdtad/views/videoceiling/GdtWebViewBuilder;", "onPageFinished", "", "view", "Lcom/tencent/smtt/sdk/WebView;", "url", "", "onReceivedError", "errorCode", "", "description", "failingUrl", "shouldOverrideUrlLoading", "", "webview", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class GdtMotiveBrowsingDialog$initWeb$1
  extends GdtWebViewBuilder
{
  GdtMotiveBrowsingDialog$initWeb$1(AppInterface paramAppInterface1, Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface2)
  {
    super(paramActivity, paramIntent, paramAppInterface2, localAppInterface);
  }
  
  public void onPageFinished(@Nullable WebView paramWebView, @Nullable String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if (!GdtMotiveBrowsingDialog.a(this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingDialog))
    {
      GdtMotiveBrowsingDialog.b(this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingDialog, true);
      if (!GdtMotiveBrowsingDialog.b(this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingDialog))
      {
        GdtADFlyingStreamingReportHelper.a().a(1020036L);
        GdtMotiveBrowsingDialog.c(this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingDialog, true);
      }
    }
    GdtMotiveBrowsingDialog.a(this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingDialog, false);
  }
  
  public void onReceivedError(@NotNull WebView paramWebView, int paramInt, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramWebView, "view");
    Intrinsics.checkParameterIsNotNull(paramString1, "description");
    Intrinsics.checkParameterIsNotNull(paramString2, "failingUrl");
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    QLog.i("AbsWebView", 1, "onReceivedError url = " + paramInt + ",description = " + paramString1 + ",failingUrl = " + paramString2);
    GdtMotiveBrowsingDialog.a(this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingDialog, true);
    GdtMotiveBrowsingDialog.b(this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingDialog, false);
    if (!GdtMotiveBrowsingDialog.b(this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingDialog))
    {
      GdtADFlyingStreamingReportHelper.a().a(1020037L);
      GdtMotiveBrowsingDialog.c(this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingDialog, true);
    }
  }
  
  public boolean shouldOverrideUrlLoading(@NotNull WebView paramWebView, @Nullable String paramString)
  {
    boolean bool = true;
    Intrinsics.checkParameterIsNotNull(paramWebView, "webview");
    QLog.i("AbsWebView", 1, "shouldOverrideUrlLoading " + paramString);
    if (paramString != null)
    {
      if (!GdtMotiveBrowsingDialog.a(this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingDialog).a(paramString, GdtMotiveBrowsingDialog.a(this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingDialog))) {
        bool = a(paramWebView, paramString);
      }
    }
    else {
      return bool;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivebrowsing.GdtMotiveBrowsingDialog.initWeb.1
 * JD-Core Version:    0.7.0.1
 */