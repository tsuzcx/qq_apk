package com.tencent.biz.pubaccount.ecshopassit;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;

class ShopWebViewFragment$3
  extends WebKernelCallBackProxy
{
  ShopWebViewFragment$3(ShopWebViewFragment paramShopWebViewFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public void onInitTitleBar(Bundle paramBundle)
  {
    super.onInitTitleBar(paramBundle);
    paramBundle = this.a;
    paramBundle.w = paramBundle.getSwiftTitleUI().o;
    paramBundle = this.a;
    paramBundle.s = paramBundle.getSwiftTitleUI().d;
    paramBundle = this.a;
    paramBundle.t = paramBundle.getSwiftTitleUI().e;
    paramBundle = this.a;
    paramBundle.u = paramBundle.getSwiftTitleUI().f;
    paramBundle = this.a;
    paramBundle.v = paramBundle.getSwiftTitleUI().h;
    this.a.a();
    if (ShopWebViewFragment.c(this.a))
    {
      if (ShopWebViewFragment.d(this.a) != null) {
        ShopWebViewFragment.e(this.a).setMask(false);
      }
      if (this.a.o == null)
      {
        paramBundle = this.a;
        paramBundle.o = new View(paramBundle.getActivity());
        this.a.o.setBackgroundColor(1996488704);
        paramBundle = new RelativeLayout.LayoutParams(-1, -1);
        this.a.contentView.addView(this.a.o, paramBundle);
      }
      this.a.o.bringToFront();
    }
    if ((this.a.a) && (this.a.r != null) && (this.a.v != null))
    {
      this.a.r.refreshDrawableState();
      this.a.v.refreshDrawableState();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.ShopWebViewFragment.3
 * JD-Core Version:    0.7.0.1
 */