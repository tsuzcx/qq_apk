package com.tencent.comic.webbundle;

import com.tencent.biz.ui.TouchWebView;
import com.tencent.comic.ui.QQComicFragment;
import com.tencent.mobileqq.webview.swift.WebViewWrapper;
import com.tencent.mobileqq.webview.swift.WebViewWrapperWithActivity;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.webbundle.sdk.WebBundleClient;

public class WebBundleFragment
  extends QQComicFragment
{
  private WebBundleClient a = null;
  private String b = "";
  private String c = "";
  
  public WebViewWrapper createWebViewWrapper(boolean paramBoolean)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((WebBundleClient)localObject).getValidWebView(super.getQBaseActivity(), this.c);
      if ((localObject instanceof TouchWebView))
      {
        WebBundleReportUtils.a(this.b, true, WebBundleReportUtils.a);
        return new WebViewWrapperWithActivity(getAppRuntime(), super.getActivity(), this.webViewSurface, this.intent, (TouchWebView)localObject);
      }
      WebBundleReportUtils.a(this.b, false, WebBundleReportUtils.d);
    }
    return null;
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new WebBundleFragment.1(this, this.webViewSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.webbundle.WebBundleFragment
 * JD-Core Version:    0.7.0.1
 */