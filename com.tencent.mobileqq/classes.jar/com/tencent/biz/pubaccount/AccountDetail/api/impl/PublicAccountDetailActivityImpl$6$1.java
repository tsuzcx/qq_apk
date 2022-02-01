package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.now.NowQQLiveConstant;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.qphone.base.util.QLog;

class PublicAccountDetailActivityImpl$6$1
  implements Runnable
{
  PublicAccountDetailActivityImpl$6$1(PublicAccountDetailActivityImpl.6 param6, boolean paramBoolean) {}
  
  public void run()
  {
    this.b.this$0.updateBottomContainer();
    if (TextUtils.equals(AppConstants.WEISHI_UIN, this.b.this$0.uin))
    {
      PublicAccountDetailActivityImpl.access$000(this.b.this$0);
      return;
    }
    if (((IMiniAppService)QRoute.api(IMiniAppService.class)).shouldOpenWebFragment(this.b.this$0.uin))
    {
      PublicAccountDetailActivityImpl.access$100(this.b.this$0);
      return;
    }
    if (TextUtils.equals(NowQQLiveConstant.a, this.b.this$0.uin))
    {
      PublicAccountDetailActivityImpl.access$200(this.b.this$0);
      return;
    }
    if ((((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).isWeatherPA(this.b.this$0.uin)) && (((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).startNewWeatherWebPageActivity(this.b.this$0, this.b.this$0.app)))
    {
      QLog.i("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 1, "updateFollowInfo startNewWeatherWebPageActivity");
      return;
    }
    if ((this.a) && (!this.b.this$0.isSubscriptAccount)) {
      this.b.this$0.open(this.b.this$0.uin, 1008, this.b.this$0.accountDetail.name, ChatActivity.class, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.6.1
 * JD-Core Version:    0.7.0.1
 */