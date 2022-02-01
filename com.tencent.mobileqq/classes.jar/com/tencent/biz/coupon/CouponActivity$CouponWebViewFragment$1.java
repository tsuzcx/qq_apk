package com.tencent.biz.coupon;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;

class CouponActivity$CouponWebViewFragment$1
  extends WebKernelCallBackProxy
{
  CouponActivity$CouponWebViewFragment$1(CouponActivity.CouponWebViewFragment paramCouponWebViewFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public String getUAMark()
  {
    if (CouponActivity.CouponWebViewFragment.a(this.a).hasExtra("source")) {
      return "PA MyCoupon";
    }
    return "PA Coupon";
  }
  
  public void onFinalState(Bundle paramBundle)
  {
    super.onFinalState(paramBundle);
    if (!CouponActivity.CouponWebViewFragment.c(this.a).hasExtra("source"))
    {
      this.a.getSwiftTitleUI().a.setVisibility(8);
      this.a.getSwiftTitleUI().c.setVisibility(0);
      this.a.getSwiftTitleUI().c.setText(2131696088);
      this.a.getSwiftTitleUI().c.setOnClickListener(this.a);
      return;
    }
    CouponActivity.CouponWebViewFragment.d(this.a).removeExtra("source");
    this.a.getSwiftTitleUI().a.setVisibility(8);
    this.a.getSwiftTitleUI().c.setVisibility(8);
  }
  
  public void onInitTitleBar(Bundle paramBundle)
  {
    super.onInitTitleBar(paramBundle);
    if (!CouponActivity.CouponWebViewFragment.b(this.a).hasExtra("source"))
    {
      this.a.getSwiftTitleUI().a.setVisibility(8);
      this.a.getSwiftTitleUI().c.setVisibility(0);
      this.a.getSwiftTitleUI().c.setText(2131696088);
      this.a.getSwiftTitleUI().c.setClickable(false);
      return;
    }
    this.a.getSwiftTitleUI().a.setVisibility(8);
    this.a.getSwiftTitleUI().c.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.coupon.CouponActivity.CouponWebViewFragment.1
 * JD-Core Version:    0.7.0.1
 */