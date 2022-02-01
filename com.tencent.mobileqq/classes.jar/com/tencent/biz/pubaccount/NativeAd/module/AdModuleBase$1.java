package com.tencent.biz.pubaccount.NativeAd.module;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.NativeAd.data.BannerInfo;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AdModuleBase$1
  implements View.OnClickListener
{
  AdModuleBase$1(AdModuleBase paramAdModuleBase) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.b == 2)
    {
      Intent localIntent = new Intent((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", this.a.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_c_of_type_JavaLangString);
      this.a.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      NativeAdUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.jdField_c_of_type_JavaLangString, 3, 3, 0);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.b == 1) {
        switch (this.a.jdField_c_of_type_Int)
        {
        case 3: 
        default: 
          break;
        case 0: 
          AdModuleBase.a(this.a);
          break;
        case 1: 
          NativeAdUtils.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.f);
          NativeAdUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.jdField_c_of_type_JavaLangString, 3, 1, 0);
          break;
        case 2: 
          NativeAdUtils.a(this.a.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo);
          NativeAdUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.jdField_c_of_type_JavaLangString, 3, 4, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.module.AdModuleBase.1
 * JD-Core Version:    0.7.0.1
 */