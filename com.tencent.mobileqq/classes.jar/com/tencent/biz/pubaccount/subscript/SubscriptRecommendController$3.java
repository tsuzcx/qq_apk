package com.tencent.biz.pubaccount.subscript;

import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.qroute.QRoute;

class SubscriptRecommendController$3
  implements Runnable
{
  SubscriptRecommendController$3(SubscriptRecommendController paramSubscriptRecommendController) {}
  
  public void run()
  {
    SubscriptRecommendController localSubscriptRecommendController = this.this$0;
    localSubscriptRecommendController.jdField_a_of_type_Boolean = SubscriptRecommendController.a(localSubscriptRecommendController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).showPubAccUin(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      this.this$0.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptRecommendController.3
 * JD-Core Version:    0.7.0.1
 */