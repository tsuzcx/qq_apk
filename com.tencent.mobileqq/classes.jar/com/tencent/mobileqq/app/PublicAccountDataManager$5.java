package com.tencent.mobileqq.app;

import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class PublicAccountDataManager$5
  implements Runnable
{
  PublicAccountDataManager$5(PublicAccountDataManager paramPublicAccountDataManager) {}
  
  public void run()
  {
    QLog.d("Q.contacttab.pub", 2, "preGetKandianSubscribe account info!");
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getPublicAccountDetailRequest(this.this$0.a, BaseApplication.getContext(), null, AppConstants.KANDIAN_SUBSCRIBE_UIN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.PublicAccountDataManager.5
 * JD-Core Version:    0.7.0.1
 */