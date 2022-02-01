package com.tencent.biz.pubaccount.subscript;

import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.qroute.QRoute;

class SubscriptFeedsActivity$5
  implements Runnable
{
  SubscriptFeedsActivity$5(SubscriptFeedsActivity paramSubscriptFeedsActivity) {}
  
  public void run()
  {
    SubscriptFeedsActivity localSubscriptFeedsActivity = this.this$0;
    SubscriptFeedsActivity.a(localSubscriptFeedsActivity, SubscriptRecommendController.b(localSubscriptFeedsActivity.app));
    if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).showPubAccUin(this.this$0.app)) {
      SubscriptFeedsActivity.a(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.5
 * JD-Core Version:    0.7.0.1
 */