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
  private WebBundleClient jdField_a_of_type_ComTencentWebbundleSdkWebBundleClient = null;
  private String jdField_a_of_type_JavaLangString = "";
  private String b = "";
  
  public WebViewWrapper createWebViewWrapper(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentWebbundleSdkWebBundleClient;
    if (localObject != null)
    {
      localObject = ((WebBundleClient)localObject).getValidWebView(super.getQBaseActivity(), this.b);
      if ((localObject instanceof TouchWebView))
      {
        WebBundleReportUtils.a(this.jdField_a_of_type_JavaLangString, true, WebBundleReportUtils.jdField_a_of_type_JavaLangString);
        return new WebViewWrapperWithActivity(getAppRuntime(), super.getActivity(), this.webViewSurface, this.intent, (TouchWebView)localObject);
      }
      WebBundleReportUtils.a(this.jdField_a_of_type_JavaLangString, false, WebBundleReportUtils.d);
    }
    return null;
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new WebBundleFragment.1(this, this.webViewSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.webbundle.WebBundleFragment
 * JD-Core Version:    0.7.0.1
 */