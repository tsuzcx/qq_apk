package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.item.PAWeatherItemBuilder;
import com.tencent.mobileqq.activity.weather.webpage.WeatherWebPageHelperKt;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.now.NowQQLiveConstant;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class PublicAccountDetailActivityImpl$6$1
  implements Runnable
{
  PublicAccountDetailActivityImpl$6$1(PublicAccountDetailActivityImpl.6 param6, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl$6.this$0.updateBottomContainer();
    if (TextUtils.equals(AppConstants.WEISHI_UIN, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl$6.this$0.uin)) {
      PublicAccountDetailActivityImpl.access$000(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl$6.this$0);
    }
    do
    {
      return;
      if (((IMiniAppService)QRoute.api(IMiniAppService.class)).shouldOpenWebFragment(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl$6.this$0.uin))
      {
        PublicAccountDetailActivityImpl.access$100(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl$6.this$0);
        return;
      }
      if (TextUtils.equals(NowQQLiveConstant.a, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl$6.this$0.uin))
      {
        PublicAccountDetailActivityImpl.access$200(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl$6.this$0);
        return;
      }
      if ((PAWeatherItemBuilder.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl$6.this$0.uin)) && (WeatherWebPageHelperKt.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl$6.this$0, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl$6.this$0.app)))
      {
        QLog.i("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 1, "updateFollowInfo startNewWeatherWebPageActivity");
        return;
      }
    } while ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl$6.this$0.isSubscriptAccount));
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl$6.this$0.open(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl$6.this$0.uin, 1008, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplPublicAccountDetailActivityImpl$6.this$0.accountDetail.name, ChatActivity.class, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.PublicAccountDetailActivityImpl.6.1
 * JD-Core Version:    0.7.0.1
 */