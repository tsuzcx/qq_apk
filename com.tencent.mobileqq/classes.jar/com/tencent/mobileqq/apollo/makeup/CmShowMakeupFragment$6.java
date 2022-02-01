package com.tencent.mobileqq.apollo.makeup;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.crossengine.CERenderView;
import com.tencent.mobileqq.apollo.statistics.ApolloQualityReportUtil;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.view.CmShowAESurfaceView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;

class CmShowMakeupFragment$6
  extends WebKernelCallBackProxy
{
  CmShowMakeupFragment$6(CmShowMakeupFragment paramCmShowMakeupFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public boolean interceptTouchEvent(View paramView, MotionEvent paramMotionEvent)
  {
    if (CmShowMakeupFragment.t(this.a) != null) {
      CmShowMakeupFragment.t(this.a).onTouchEvent(paramMotionEvent);
    }
    if ((CmShowMakeupFragment.q(this.a) != null) && (paramMotionEvent.getY() < CmShowMakeupFragment.e(this.a))) {
      CmShowMakeupFragment.q(this.a).onTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public void onDetectedBlankScreen(String paramString, int paramInt)
  {
    super.onDetectedBlankScreen(paramString, paramInt);
    ApolloQualityReportUtil.a("dressup_web_page_bland_screenr", String.valueOf(paramInt));
    if (CmShowMakeupFragment.j(this.a)) {
      paramInt = 1004;
    } else {
      paramInt = 1002;
    }
    TraceReportUtil.a(126, null, null, new int[] { paramInt });
  }
  
  public void onInitTitleBar(Bundle paramBundle)
  {
    super.onInitTitleBar(paramBundle);
    if (this.a.getActivity() != null) {
      ImmersiveUtils.clearCoverForStatus(this.a.getActivity().getWindow(), true);
    }
  }
  
  public void onInitUIContent(Bundle paramBundle)
  {
    super.onInitUIContent(paramBundle);
    if (CmShowMakeupFragment.l(this.a) != null)
    {
      CmShowMakeupFragment.m(this.a).setBackgroundColor(0);
      paramBundle = CmShowMakeupFragment.n(this.a).getBackground();
      if (paramBundle != null) {
        paramBundle.setAlpha(0);
      }
      if (CmShowMakeupFragment.o(this.a).getChildCount() > 0)
      {
        paramBundle = CmShowMakeupFragment.p(this.a).getChildAt(0);
        paramBundle.setBackgroundResource(0);
        paramBundle = paramBundle.getBackground();
        if (paramBundle != null) {
          paramBundle.setAlpha(0);
        }
      }
    }
    if ((this.a.getUIStyleHandler() != null) && (this.a.getUIStyleHandler().u != null))
    {
      paramBundle = this.a;
      CmShowMakeupFragment.a(paramBundle, new ImageView(paramBundle.getActivity()));
      CmShowMakeupFragment.f(this.a).setImageResource(2130839590);
      CmShowMakeupFragment.f(this.a).setScaleType(ImageView.ScaleType.CENTER);
      paramBundle = new ViewGroup.LayoutParams(-1, ViewUtils.getScreenHeight() / 2);
      this.a.getUIStyleHandler().u.addView(CmShowMakeupFragment.f(this.a), 0, paramBundle);
      if ((CmShowMakeupFragment.q(this.a) != null) && (!CmShowMakeupFragment.r(this.a))) {
        CmShowMakeupFragment.s(this.a);
      }
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    ApolloQualityReportUtil.a("dressup_web_page_finish", String.valueOf(System.currentTimeMillis() - CmShowMakeupFragment.k(this.a)));
    CmShowMakeupFragment.a(this.a, 0L);
    TraceReportUtil.a(126, 1, 0, new Object[0]);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    CmShowMakeupFragment.a(this.a, System.currentTimeMillis());
    ApolloQualityReportUtil.a("dressup_web_page_start", String.valueOf(CmShowMakeupFragment.k(this.a)));
    TraceReportUtil.a(126, 1);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    ApolloQualityReportUtil.a("dressup_web_page_error", String.valueOf(paramInt), paramString1);
  }
  
  public void onReceivedSslError(WebView paramWebView, SslError paramSslError)
  {
    super.onReceivedSslError(paramWebView, paramSslError);
    ApolloQualityReportUtil.a("dressup_web_page_ssl_error", String.valueOf(paramSslError.getPrimaryError()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowMakeupFragment.6
 * JD-Core Version:    0.7.0.1
 */