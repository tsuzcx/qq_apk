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
    paramBundle.jdField_a_of_type_AndroidViewViewGroup = paramBundle.getSwiftTitleUI().jdField_a_of_type_AndroidViewViewGroup;
    paramBundle = this.a;
    paramBundle.jdField_b_of_type_AndroidWidgetTextView = paramBundle.getSwiftTitleUI().jdField_a_of_type_AndroidWidgetTextView;
    paramBundle = this.a;
    paramBundle.jdField_c_of_type_AndroidWidgetTextView = paramBundle.getSwiftTitleUI().jdField_b_of_type_AndroidWidgetTextView;
    paramBundle = this.a;
    paramBundle.d = paramBundle.getSwiftTitleUI().jdField_c_of_type_AndroidWidgetTextView;
    paramBundle = this.a;
    paramBundle.jdField_c_of_type_AndroidWidgetImageView = paramBundle.getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView;
    this.a.a();
    if (ShopWebViewFragment.a(this.a))
    {
      if (ShopWebViewFragment.c(this.a) != null) {
        ShopWebViewFragment.d(this.a).setMask(false);
      }
      if (this.a.jdField_a_of_type_AndroidViewView == null)
      {
        paramBundle = this.a;
        paramBundle.jdField_a_of_type_AndroidViewView = new View(paramBundle.getActivity());
        this.a.jdField_a_of_type_AndroidViewView.setBackgroundColor(1996488704);
        paramBundle = new RelativeLayout.LayoutParams(-1, -1);
        this.a.contentView.addView(this.a.jdField_a_of_type_AndroidViewView, paramBundle);
      }
      this.a.jdField_a_of_type_AndroidViewView.bringToFront();
    }
    if ((this.a.jdField_a_of_type_Boolean) && (this.a.jdField_b_of_type_AndroidWidgetImageView != null) && (this.a.jdField_c_of_type_AndroidWidgetImageView != null))
    {
      this.a.jdField_b_of_type_AndroidWidgetImageView.refreshDrawableState();
      this.a.jdField_c_of_type_AndroidWidgetImageView.refreshDrawableState();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.ShopWebViewFragment.3
 * JD-Core Version:    0.7.0.1
 */