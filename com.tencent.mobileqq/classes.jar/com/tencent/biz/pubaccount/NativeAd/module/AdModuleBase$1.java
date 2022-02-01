package com.tencent.biz.pubaccount.NativeAd.module;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.NativeAd.data.BannerInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.qroute.QRoute;

class AdModuleBase$1
  implements View.OnClickListener
{
  AdModuleBase$1(AdModuleBase paramAdModuleBase) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.b == 2)
    {
      paramView = new Intent((BaseActivity)this.a.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramView.putExtra("url", this.a.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_c_of_type_JavaLangString);
      this.a.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).doAdReport(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.jdField_c_of_type_JavaLangString, 3, 3, 0);
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.b == 1)
    {
      int i = this.a.jdField_c_of_type_Int;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            return;
          }
          ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).installApk(this.a.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo);
          ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).doAdReport(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.jdField_c_of_type_JavaLangString, 3, 4, 0);
          return;
        }
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).launchApp(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.f);
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).doAdReport(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.jdField_c_of_type_JavaLangString, 3, 1, 0);
        return;
      }
      AdModuleBase.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.module.AdModuleBase.1
 * JD-Core Version:    0.7.0.1
 */